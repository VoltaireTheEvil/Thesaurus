package ru.gb.makulin.core.utils

import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.domainmodel.MainModel
import ru.gb.makulin.core.domainmodel.Sense

fun parseDataModelToMainModel(dataModel: DataModel): MainModel {
    val result = dataModel.results[0]
    val word = result.word
    val pronunciation = result.lexicalEntries[0].entries[0].pronunciations[0]
    val senses = mutableListOf<Sense>()
    result.lexicalEntries.forEach { lexicalEntry ->
        lexicalEntry.entries.forEach { entry ->
            senses.addAll(entry.senses)
        }
    }
    return MainModel(
        word = word,
        pronunciation = pronunciation,
        senses = senses
    )
}

fun DataModel.toMainModel(): MainModel {
    return parseDataModelToMainModel(this)
}