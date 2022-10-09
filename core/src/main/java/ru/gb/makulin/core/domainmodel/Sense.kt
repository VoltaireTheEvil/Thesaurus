package ru.gb.makulin.core.domainmodel

data class Sense(
    val definitions: List<String>,
    val examples: List<Example>?,
    val synonyms: List<Synonym>?
)
