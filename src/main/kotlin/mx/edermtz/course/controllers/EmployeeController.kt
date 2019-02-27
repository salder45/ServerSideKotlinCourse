package mx.edermtz.course.controllers

import mx.edermtz.course.models.Employee
import mx.edermtz.course.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController{

    @Autowired
    lateinit var employeeService: EmployeeService

    @PostMapping("/employee")
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<Employee>{
        employeeService.createEmployee(employee)
        return ResponseEntity<Employee>(HttpStatus.CREATED)
    }

    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: Int) = employeeService.getEmployee(id)
}