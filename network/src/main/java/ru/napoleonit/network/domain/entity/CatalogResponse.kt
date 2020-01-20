package ru.napoleonit.network.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatalogResponse(@SerialName("test") val stub: String) {
}