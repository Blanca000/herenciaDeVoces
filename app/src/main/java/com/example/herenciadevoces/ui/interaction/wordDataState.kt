package com.example.herenciadevoces.ui.interaction

import com.example.herenciadevoces.domain.SpanishWordData.model.SpanishWordData

data class wordDataState(
    val wordData: List<SpanishWordData> = emptyList()
)