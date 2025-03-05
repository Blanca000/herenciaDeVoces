package com.example.herenciadevoces.domain.SemanticField.model

import com.example.herenciadevoces.data.local.model.semanticFieldEntity

data class SemanticField(
    val idSemanticField: Int,
    val semanticFieldName: String,
    val pathName: String
)

fun semanticFieldEntity.toSemanticField(): SemanticField {
    return SemanticField(
        idSemanticField = idSemanticField,
        semanticFieldName = semanticFieldName,
        pathName = pathName
    )
}

fun SemanticField.toSemanticFieldEntity(): semanticFieldEntity {
    return semanticFieldEntity(
        idSemanticField = idSemanticField,
        semanticFieldName = semanticFieldName,
        pathName = pathName
    )
}

