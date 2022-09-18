package ru.gb.makulin.core.domainmodel

data class Synonym(
    val text: String
) {
    override fun toString(): String {
        return text
    }
}
