package com.pavel.likholap.lesson15.homework

class Concert(
    private val band: String, private val location: String,
    private val ticketCost: Float, private val hallCapacity: Int,
    private val ticketsCount: Int

) {
    private var soldTickets: Int = 0

    private fun getConcertInformation(){
        println("""
            band: $band
            location: $location
            ticket price: $ticketCost
            hall capacity: $hallCapacity
        """.trimIndent())
    }

    private fun buyTicket(): Any {
        if (soldTickets < ticketsCount) {
            soldTickets += 1
            return "Ticket has purchased" }
        else {
            return "Sold out" }
    }
}