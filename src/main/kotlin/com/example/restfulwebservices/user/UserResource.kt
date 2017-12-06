package com.example.restfulwebservices.user

import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
class UserResource(
        val service: UserDaoService
) {

    @GetMapping("/users")
    fun getAllUsers() = service.findAll()

    @GetMapping("users/{id}")
    fun getUserById(@PathVariable id: Int): Resource<User> {
        val user = service.findOne(id) ?:
                throw UserNotFoundException("id-$id")

        //"all-users", SERVER_PATH + "/users"
        val resource = Resource<User>(user)
        val linkTo = linkTo(methodOn(this.javaClass).getAllUsers())
        resource.add(linkTo.withRel("all-users"))

        return resource
    }

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<Any> {
        val newUser = service.save(user)
        val location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.id)
                .toUri()

        return ResponseEntity.created(location).build()
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int) {
        service.deleteById(id) ?: throw UserNotFoundException("id-$id")
    }

}

