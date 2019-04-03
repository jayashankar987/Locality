package com.jay.locality.feature.register

open class CreateNewUserAction {

    private var email: String? = null
    private var password: String? = null

    private constructor(builder: Builder) {

        if (!builder.emailId.isNullOrEmpty()) {
            email = builder.emailId
        } else {
            throw IllegalArgumentException("email Id cannot be empty")
        }

        if (!builder.password.isNullOrEmpty()) {
            password = builder.password
        } else {
            throw IllegalArgumentException("password Id cannot be empty")
        }
    }

    companion object {
        class Builder {
            var emailId: String? = null
            var password: String? = null


            fun email(emailId: String): Builder {
                this.emailId = emailId;
                return this
            }

            fun password(password: String): Builder {
                this.password = password;
                return this
            }
        }
    }
}