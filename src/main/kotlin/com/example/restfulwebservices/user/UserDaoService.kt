package com.example.restfulwebservices.user

import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDaoService {

    companion object {
        var users = arrayListOf<User>()
        var usersCount = 3

        init {
            users.add(User(1, "Adam", Date()))
            users.add(User(2, "Eve", Date()))
            users.add(User(3, "Jack", Date()))
        }
    }

    fun findAll() = users

    fun save(_user: User): User {
        val user = _user.copy()
        if (user.id == null) {
            user.id = ++usersCount
        }
        users.add(user)
        return user
    }

    fun findOne(id: Int) = users.firstOrNull { it.id == id }

    fun deleteById(id: Int): User? {
        val iterator = users.iterator()

        while (iterator.hasNext()) {
            val user = iterator.next()

            if (user.id == id) {
                iterator.remove()
                return user
            }
        }

        return null
    }
}
