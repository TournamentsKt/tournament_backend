package com.minz

import com.minz.tournaments.Participant
import com.minz.tournaments.TournamentTree
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>): Unit = EngineMain.main(args)

@OptIn(ExperimentalStdlibApi::class)
@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {
    val apiRoot = "tournamentapi"
    val numDummyParticipants = 32
    val testParticipants = HashMap<Int, Participant>(numDummyParticipants)

    // json stuff
    val type = Types.newParameterizedType(List::class.java, Participant::class.java)
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val adapter: JsonAdapter<List<Participant>> = moshi.adapter(type)

    for (i in 0 until numDummyParticipants) {
        testParticipants[i] = Participant("P$i")
    }

    val tournament = TournamentTree(testParticipants)

    if (testing) {
        print("TESTING MODE ACTIVE")
    }

    routing {
        get("$apiRoot/tournamentlo") {
            call.respond(TextContent(adapter.toJson(tournament.getRoundsFlat()), ContentType.Application.Json))
        }

        get("$apiRoot/participants") {
            call.respond(TextContent(adapter.toJson(tournament.participants.values.toList()), ContentType.Application.Json))
        }

        post("$apiRoot/register") {
            // TODO: Implement this
        }
    }
}