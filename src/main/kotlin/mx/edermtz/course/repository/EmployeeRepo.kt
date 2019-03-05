package mx.edermtz.course.repository

import mx.edermtz.course.models.Employee
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepo: ReactiveCassandraRepository<Employee, Int>