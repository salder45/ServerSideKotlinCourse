package mx.edermtz.course.config

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration

class CassandraConfiguration: AbstractCassandraConfiguration (){

    override fun getKeyspaceName(): String = "hr"

    override fun getContactPoints(): String = "localhost"

    override fun getEntityBasePackages(): Array<String> = arrayOf<String>("mx.edermtz.course.models")

}