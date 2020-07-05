package com.minz

import com.minz.tournaments.Participant
import com.minz.tournaments.TournamentTree
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.content.TextContent
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.json
import io.ktor.serialization.serialization
import io.ktor.server.netty.EngineMain
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

fun main(args: Array<String>): Unit = EngineMain.main(args)

@OptIn(ExperimentalStdlibApi::class, UnstableDefault::class)
@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "tournamentapi"
    val numDummyParticipants = 32
    val testParticipants = HashMap<Int, Participant>(numDummyParticipants)

    for (i in 0 until numDummyParticipants) {
        testParticipants[i] = Participant("P$i")
    }

    val tournament = TournamentTree(testParticipants)

    if (testing) {
        print("TESTING MODE ACTIVE")
    }

    install(ContentNegotiation) {
        json()
    }

    routing {
        get("$apiRoot/tournamentlo") {
            call.respond(tournament.getRoundsFlat())
        }

        get("$apiRoot/participants") {
            call.respond(tournament.participants.values.toList())
        }

        post("$apiRoot/register") {
            // TODO: Implement this
        }
    }
}