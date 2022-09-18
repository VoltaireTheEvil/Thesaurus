package ru.gb.makulin.core.domainmodel

data class Result(
    val lexicalEntries: List<LexicalEntry>,
    val word: String
)
