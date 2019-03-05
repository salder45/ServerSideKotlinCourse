package mx.edermtz.course.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories
class CassandraConfiguration: AbstractCassandraConfiguration (){

    override fun getKeyspaceName(): String = "hr"

    override fun getContactPoints(): String = "localhost"

    override fun getEntityBasePackages(): Array<String> = arrayOf("mx.edermtz.course.models")

    override fun getMetricsEnabled(): Boolean {
        return false
    }

}