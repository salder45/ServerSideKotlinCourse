package mx.edermtz.course.repository

import mx.edermtz.course.models.Employee
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository

interface EmployeeRepo: ReactiveCassandraRepository<Int, Employee>