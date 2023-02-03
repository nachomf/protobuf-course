package main

import com.example.tutorial.protos.AddressBook
import com.example.tutorial.protos.Person
import com.example.tutorial.protos.Person.PhoneNumber
import com.example.tutorial.protos.Person.PhoneType
import com.google.protobuf.Timestamp
import com.google.protobuf.util.JsonFormat

/*fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}*/

fun main() {
    var addressBook = AddressBook.newBuilder().build()

    println("Address book: ${addressBook.toJSON()}")

    addressBook = addressBook.addPerson(
        createPerson(
            name = "pepe",
            id = 1,
            email = "pepe@pepe.com",
            phoneNumbers = listOf(
                createPhoneNumber(
                    number = "1234",
                    phoneType = PhoneType.HOME
                ),
                createPhoneNumber(
                    number = "56789",
                    phoneType = PhoneType.WORK //MOBILE not show on print because is default value, it need a special configuration
                )
            ),
            lastUpdated = Timestamp.newBuilder().setNanos(100).setSeconds(10).build()
        )
    )

    println("Address book: ${addressBook.toJSON()}")

    println("Address book people: ${addressBook.peopleList}")
}

fun createPhoneNumber(
    number: String,
    phoneType: PhoneType,
): PhoneNumber = PhoneNumber
    .newBuilder()
    .setNumber(number)
    .setType(phoneType)
    .build()

fun createPerson(
    name: String,
    id: Int,
    email: String,
    phoneNumbers: List<PhoneNumber>,
    lastUpdated: Timestamp,
): Person = Person
    .newBuilder()
    .setName(name)
    .setId(id)
    .setEmail(email)
    .addAllPhones(phoneNumbers)
    .setLastUpdated(lastUpdated)
    .build()

private fun AddressBook.toJSON() = JsonFormat
    .printer()
    .includingDefaultValueFields()
    .omittingInsignificantWhitespace()
    .print(this)

private fun AddressBook.addPerson(person: Person) = AddressBook
    .newBuilder(this)
    .addPeople(person)
    .build()