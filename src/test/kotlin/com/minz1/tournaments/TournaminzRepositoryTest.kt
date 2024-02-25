package com.minz1.tournaments

import com.minz1.tournaments.participant.ParticipantDao
import com.minz1.tournaments.participant.ParticipantRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TournaminzRepositoryTest(@Autowired private val participantRepository: ParticipantRepository) {
    @Test
    fun saveParticipant() {
        participantRepository.save(ParticipantDao("emrizzle", 4, null))

        val participantDaos = participantRepository.findAll().toList()

        assertEquals(participantDaos.size, 1)
    }
}
