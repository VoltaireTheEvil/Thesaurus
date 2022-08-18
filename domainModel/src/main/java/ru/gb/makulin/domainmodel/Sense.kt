package ru.gb.makulin.domainmodel

data class Sense(
    val definitions: List<String>,
    val examples: List<Example>,
    val synonyms: List<Synonym>
)
