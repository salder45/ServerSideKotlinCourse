package mx.edermtz.course.services

import mx.edermtz.course.models.Employee
import mx.edermtz.course.models.EmployeeUpdateReq
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
class EmployeeService{

    val employeeMap = hashMapOf(1 to "Alberto", 2 to "Peter", 3 to "John")

    fun findEmployee(id: Int): String = employeeMap[id] ?: "Not_Found"


    companion object {
        val employeeDB  = mutableMapOf(1 to Employee(1,"John Long",20,"Engineering", 500.00),
        2 to Employee(1,"Peter Pan",35,"HR",300.00)
        )

    }

    fun createEmployee(employee: Employee) = employeeDB.put(employee.id,employee)

    fun getEmployee(id: Int) = employeeDB[1]?.toMono<Employee>()

    fun getAllEmployees(minAge: Int? = null,minSalary: Double? = null)
            = employeeDB.values.toFlux()
        .filter{ it.age >= minAge ?: Int.MIN_VALUE}
        .filter{ it.salary >= minSalary ?: Double.MIN_VALUE}


    fun updateEmployee(id: Int, updateEmployee: EmployeeUpdateReq){
        val employeeOnDB = employeeDB[id]!!
        employeeDB[id] = Employee(employeeOnDB.id
        ,employeeOnDB.name,employeeOnDB.age,updateEmployee.department ?: employeeOnDB.department
        ,updateEmployee.salary ?: employeeOnDB.salary)
    }

    fun deleteEmployee(id: Int) = employeeDB.remove(id)

}