package mx.edermtz.course.controllers

import mx.edermtz.course.models.Employee
import mx.edermtz.course.models.EmployeeUpdateReq
import mx.edermtz.course.services.DepartmentService
import mx.edermtz.course.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController{

    @Autowired
    lateinit var employeeService: EmployeeService

    @Autowired
    lateinit var departmentService: DepartmentService

    @PostMapping("/employee")
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<Employee>{
        employeeService.createEmployee(employee)
        return ResponseEntity<Employee>(HttpStatus.CREATED)
    }

    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: Int) = employeeService.getEmployee(id)

    @GetMapping("/employee")
    fun getEmployees(@RequestParam("minAge", required = false) minAge: Int?,@RequestParam("minSalary", required = false) minSalary: Double?) = employeeService.getAllEmployees(minAge, minSalary)

    @GetMapping("/departments")
    fun getAllDepartments()= departmentService.getAllDepartments()

    @PutMapping("employee/{id}")
    fun updateEmployee(@PathVariable id: Int, @RequestBody updateEmployee: EmployeeUpdateReq){
        employeeService.updateEmployee(id,updateEmployee)
    }
}