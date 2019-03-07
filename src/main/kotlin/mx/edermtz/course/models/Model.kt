package mx.edermtz.course.models

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Table
data class Employee(
    @PrimaryKey val id: String,
    val name: String,
    val age: Int,
    var department: String,
    var salary: Double)

data class EmployeeDTO(@get:NotBlank val name: String,
                       @get:Positive val age: Int,
                       @get:NotBlank var department: String,
                       @get:Positive var salary: Double){
    companion object {
        fun newEmployee(employeeDTO: EmployeeDTO)=
            Employee(UUID.randomUUID().toString(), employeeDTO.name, employeeDTO.age,employeeDTO.department, employeeDTO.salary)

        fun toDTO(employee:  Employee) =
                EmployeeDTO(employee.name,employee.age,employee.department, employee.salary)
    }
}

data class EmployeeUpdateReq(val department: String?, val salary: Double?)