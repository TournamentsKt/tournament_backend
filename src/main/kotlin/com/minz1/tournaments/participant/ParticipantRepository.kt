package com.minz1.tournaments.participant

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipantRepository : CrudRepository<ParticipantDao, Long>