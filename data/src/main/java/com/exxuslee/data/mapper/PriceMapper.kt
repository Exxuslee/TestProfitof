package com.exxuslee.data.mapper

import com.exxuslee.data.local.entities.PriceEntity
import com.exxuslee.data.remote.response.IDResponse
import com.exxuslee.domain.models.Price


class PriceMapper : BaseMapper<Price, PriceEntity, IDResponse> {

    override fun remoteToLocal(type: IDResponse) = PriceEntity(
        base = type.base,
        rates = type.rates,
        date = type.date
    )

    override fun remoteToDomain(type: IDResponse) = Price(
        type.base,
        type.date,
        type.rates
    )

    override fun domainToLocal(type: Price) = PriceEntity(
        base = type.base,
        date = type.date,
        rates = type.rates
    )

    override fun localToDomain(type: PriceEntity) = Price(
        type.base ?: "",
        type.date ?: "",
        type.rates
    )
}