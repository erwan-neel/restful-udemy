package com.example.restfulwebservices.helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hello-world")
    fun helloWorld() = "Hello World"

    @GetMapping("/hello-world-bean")
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("Hello World Bean")
    }

    @GetMapping("/hello-world/path-variable/{name}")
    fun helloWorldBean(@PathVariable name: String) = HelloWorldBean("Hello World, $name")
}