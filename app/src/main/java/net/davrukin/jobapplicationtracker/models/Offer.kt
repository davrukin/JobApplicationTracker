package net.davrukin.jobapplicationtracker.models

data class Offer(var given: Boolean) { // given is primary constructor, add others later
    var time: Int = 0 // full-time, part-time
    var payFrequency: Int = 0 // hourly, salary
    var hoursPerWeek: Int = 0
    var pay: Long = 0
    var benefits: String = ""
    var counterOffer: Boolean = false
}

