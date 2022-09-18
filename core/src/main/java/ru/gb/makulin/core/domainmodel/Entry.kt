package ru.gb.makulin.core.domainmodel

data class Entry(
    val pronunciations: List<Pronunciation>,
    val senses: List<Sense>
)
