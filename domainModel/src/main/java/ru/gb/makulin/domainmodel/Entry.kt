package ru.gb.makulin.domainmodel

data class Entry(
    val pronunciations: List<Pronunciation>,
    val senses: List<Sense>
)
