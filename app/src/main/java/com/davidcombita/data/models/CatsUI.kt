package com.davidcombita.data.models

data class CatsUI (
        val loading: Boolean = false,
        val catsInfo: List<Cat> = emptyList(),
        val error: Boolean = false
)