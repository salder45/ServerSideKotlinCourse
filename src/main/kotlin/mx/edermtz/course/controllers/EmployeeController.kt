package mx.edermtz.course.controllers

import mx.edermtz.course.models.Employee
import mx.edermtz.course.models.EmployeeDTO
import mx.edermtz.course.models.EmployeeUpdateReq
import mx.edermtz.course.services.DepartmentService
import mx.edermtz.course.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class EmployeeController{

    @Autowired
    lateinit var employeeService: EmployeeService

    @Autowired
    lateinit var departmentService: DepartmentService

    @PostMapping("/employee")
    fun createEmployee(@Valid @RequestBody employeeDTO: EmployeeDTO)= employeeService.createEmployee(EmployeeDTO.newEmployee(employeeDTO))
        .map{ newEmployee -> ResponseEntity.status(HttpStatus.CREATED).body(newEmployee)}


    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: String) = employeeService.getEmployee(id)

    @GetMapping("/employee")
    fun getEmployees(@RequestParam("minAge", required = false) minAge: Int?,@RequestParam("minSalary", required = false) minSalary: Double?) = employeeService.getAllEmployees(minAge, minSalary)

    @GetMapping("/departments")
    fun getAllDepartments()= departmentService.getAllDepartments()

    @PutMapping("employee/{id}")
    fun updateEmployee(@PathVariable id: String, @RequestBody updateEmployee: EmployeeUpdateReq) =
        employeeService.updateEmployee(id,updateEmployee)
            .map { _ -> ResponseEntity.ok()}


    @DeleteMapping("/employee/{id}")
    fun deleteEmployee(@PathVariable id: String) = employeeService.deleteEmployee(id)
        .map {_ -> ResponseEntity.noContent() }

}

