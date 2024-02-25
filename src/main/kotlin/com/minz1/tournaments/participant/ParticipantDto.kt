package com.minz1.tournaments.participant

import kotlinx.serialization.Serializable

@Serializable
data class ParticipantDto(val name: String, val seed: Int)