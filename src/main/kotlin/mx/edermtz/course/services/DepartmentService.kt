package mx.edermtz.course.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DepartmentService{

    @Autowired
    lateinit var employeeService: EmployeeService

    fun getAllDepartments()
            = employeeService.getAllEmployees(null,null)
        .map { it.department }
        .distinct()


}