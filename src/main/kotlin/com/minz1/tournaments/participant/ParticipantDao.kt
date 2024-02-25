package com.minz1.tournaments.participant

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "participants")
class ParticipantDao (
    @Column(nullable = false)
    private val name: String,
    @Column(nullable = false, unique = true)
    private val seed: Int,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int?,
) {
    fun getName() = name
    fun getSeed() = seed
}