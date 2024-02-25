package com.minz1.tournaments.participant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/participants")
@RestController
class ParticipantEndpoint(@Autowired private val participantService: ParticipantService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private fun addParticipant(@RequestBody participant: ParticipantDto) = participantService.addParticipant(participant)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private fun getParticipants() = participantService.getAllParticipants()

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    private fun getParticipantById(@PathVariable id: Long) = participantService.getParticipantById(id)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private fun deleteParticipantById(@PathVariable id: Long) = participantService.deleteParticipantById(id)
}