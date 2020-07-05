package com.minz.tournaments

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Participant(val name: String = "") {
    val isEmpty: Boolean
        get() = name.isBlank()
}