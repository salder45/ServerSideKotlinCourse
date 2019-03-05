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
    fun createEmployee(@RequestBody employee: Employee)= employeeService.createEmployee(employee)
        .map{ _ -> ResponseEntity.status(HttpStatus.CREATED).build<String>() }


    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: Int) = employeeService.getEmployee(id)

    @GetMapping("/employee")
    fun getEmployees(@RequestParam("minAge", required = false) minAge: Int?,@RequestParam("minSalary", required = false) minSalary: Double?) = employeeService.getAllEmployees(minAge, minSalary)

    @GetMapping("/departments")
    fun getAllDepartments()= departmentService.getAllDepartments()

    @PutMapping("employee/{id}")
    fun updateEmployee(@PathVariable id: Int, @RequestBody updateEmployee: EmployeeUpdateReq) =
        employeeService.updateEmployee(id,updateEmployee)
            .map { _ -> ResponseEntity.status(HttpStatus.OK).build<String>()}


    @DeleteMapping("/employee/{id}")
    fun deleteEmployee(@PathVariable id: Int) = employeeService.deleteEmployee(id)
        .map {_ -> ResponseEntity.status(HttpStatus.NOT_FOUND).build<String>() }

}

