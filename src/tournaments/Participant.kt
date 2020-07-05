package com.minz.tournaments

import kotlinx.serialization.Serializable

@Serializable
data class Participant(val name: String = "") {
    val isEmpty: Boolean
        get() = name.isBlank()
}