package mx.edermtz.course.models

data class Employee(
    val id: Int,
    val name: String,
    val age: Int,
    var department: String,
    var salary: Double)

data class EmployeeUpdateReq(val department: String?, val salary: Double?)