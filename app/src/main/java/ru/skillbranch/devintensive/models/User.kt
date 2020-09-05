package ru.skillbranch.devintensive.models

import android.text.BoringLayout
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {


    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println("It's Alive !!! ${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}")
    }

    fun printMe() = println(
        """
                 id: $id
                 firstName: $firstName
                 lastName: $lastName
                 avatar: $avatar
                 rating: $rating
                 respect: $respect
                 lastVisit: $lastVisit
                 isOnline: $isOnline
        """.trimIndent()
    )

    companion object Factory {
        private var lastId = -1

        fun makeUser(fullName: String?): User {
            lastId++

            var firstName:String? ="Ошибка"
            var lastName: String? ="Ошибка"
            val parts: List<String>?
            if (!fullName.isNullOrEmpty() ) {
                parts = fullName.split(" ")
                firstName = parts.getOrNull(0)
                lastName = parts.getOrNull(1)
            }
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }
}
