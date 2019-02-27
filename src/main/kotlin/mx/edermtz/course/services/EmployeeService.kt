package mx.edermtz.course.services

import mx.edermtz.course.models.Employee
import org.springframework.stereotype.Service

@Service
class EmployeeService{

    val employeeMap = hashMapOf(1 to "Alberto", 2 to "Peter", 3 to "John")

    fun findEmployee(id: Int): String = employeeMap[id] ?: "Not_Found"


    companion object {
        val employeeDB  = mutableMapOf(1 to Employee(1,"John Long","Engineering", 500.00),
        2 to Employee(1,"Peter Pan","HR",300.00)
        )

    }

    fun createEmployee(employee: Employee) = employeeDB.put(employee.id,employee)

}