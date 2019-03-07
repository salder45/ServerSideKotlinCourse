package mx.edermtz.course.services

import mx.edermtz.course.models.Employee
import mx.edermtz.course.models.EmployeeUpdateReq
import mx.edermtz.course.repository.EmployeeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
class EmployeeService{


    @Autowired
    lateinit var employeeDB: EmployeeRepo


    fun createEmployee(employee: Employee) = employeeDB.save(employee)

    fun getEmployee(id: String) = employeeDB.findById(id)

    fun getAllEmployees(minAge: Int? = null,minSalary: Double? = null)
            = employeeDB.findAll()
        .filter{ it.age >= minAge ?: Int.MIN_VALUE}
        .filter{ it.salary >= minSalary ?: Double.MIN_VALUE}


    fun updateEmployee(id: String, updateEmployee: EmployeeUpdateReq) =
        employeeDB.findById(id).flatMap{
            it.department = updateEmployee.department ?: it.department
            it.salary = updateEmployee.salary ?: it.salary
            employeeDB.save(it)
        }



    fun deleteEmployee(id: String) = employeeDB.deleteById(id)

}