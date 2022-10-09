package ru.gb.makulin.core.domainmodel

data class MainModel(
    val word: String,
    val pronunciation: Pronunciation?,
    val senses: List<Sense>
)
