package ru.gb.makulin.domainmodel

data class Result(
    val lexicalEntries: List<LexicalEntry>,
    val word: String
)
