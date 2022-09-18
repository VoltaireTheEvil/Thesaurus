package ru.gb.makulin.core.domainmodel

data class Example(
    val text: String
) {
    override fun toString(): String {
        return text
    }
}
