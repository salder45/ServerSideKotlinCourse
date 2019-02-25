package mx.edermtz.course.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller{

    @GetMapping("/{name}")
    fun getName(@PathVariable("name") name: String): String{
        return "Name: $name"
    }

}