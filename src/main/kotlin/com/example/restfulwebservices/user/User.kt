package com.example.restfulwebservices.user

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@ApiModel(description = "All details about the user")
data class User(
        @JsonIgnore
        var id: Int? = null,

        @get:Size(min=2, message = "Name should have at least 2 characters")
        @ApiModelProperty(notes = "Name should have at least 2 characters")
        var name: String,

        @ApiModelProperty(notes = "Birth date should be in the past")
        @get:Past
        var birthday: Date
)