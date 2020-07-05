package com.minz.tournaments

class Match constructor(val contestant1: Participant, val contestant2: Participant) {
    var score1 = 0
    var score2 = 0

    var isComplete = false
}