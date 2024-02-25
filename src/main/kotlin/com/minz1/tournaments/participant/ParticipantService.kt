package com.minz1.tournaments.participant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ParticipantService(@Autowired private val participantRepository: ParticipantRepository) {
    private fun participantDtoToDao(dto: ParticipantDto) = ParticipantDao(dto.name, dto.seed, null)

    private fun participantDaoToDto(dao: ParticipantDao) = ParticipantDto(dao.getName(), dao.getSeed())

    fun addParticipant(dto: ParticipantDto) = participantDaoToDto(participantRepository.save(participantDtoToDao(dto)))

    fun getAllParticipants() = participantRepository.findAll().map { participantDaoToDto(it) }

    fun getParticipantById(id: Long) = participantDaoToDto(participantRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) })

    fun deleteParticipantById(id: Long) = participantRepository.deleteById(id)
}