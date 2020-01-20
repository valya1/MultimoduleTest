package ru.napoleonit.network.service

import retrofit2.http.GET
import ru.napoleonit.network.domain.entity.CatalogResponse

interface ApiService {

    @GET("v1/catalog")
    suspend fun getCatalog(): CatalogResponse

}