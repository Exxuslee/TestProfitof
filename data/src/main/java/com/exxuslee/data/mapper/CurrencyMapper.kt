package com.exxuslee.data.mapper

import com.exxuslee.data.local.entities.IDEntity
import com.exxuslee.data.remote.response.ListResponse
import com.exxuslee.domain.models.Symbols


class CurrencyMapper : BaseMapper<Symbols, List<IDEntity>, ListResponse> {

    override fun domainToLocal(type: Symbols): List<IDEntity> {
        val asd: ArrayList<IDEntity> = arrayListOf()
        type.symbol.map { Symbol ->
            asd.add(IDEntity(
                xxx = Symbol.xxx,
                name = Symbol.name,
                base = Symbol.base,
                check = Symbol.check
            ))
        }
        return asd
    }

    override fun localToDomain(type: List<IDEntity>): Symbols {
        val asd: ArrayList<Symbols.Symbol> = arrayListOf()
        type.map { CurrencyEntity ->
            asd.add(Symbols.Symbol(
                xxx = CurrencyEntity.xxx,
                name = CurrencyEntity.name,
                base = CurrencyEntity.base,
                check = CurrencyEntity.check
            ))
        }
        return Symbols(asd)
    }

    override fun remoteToLocal(type: ListResponse): List<IDEntity> {
        val asd: ArrayList<IDEntity> = ArrayList()
        type.symbols.map { (xxx, name) ->
            asd.add(IDEntity(
                xxx = xxx,
                name = name,
                base = xxx == "EUR",
                check = xxx == "BTC" || xxx == "UAH" || xxx == "USD"
            ))
        }
        return asd
    }

    override fun remoteToDomain(type: ListResponse): Symbols {
        val asd: ArrayList<Symbols.Symbol> = arrayListOf()
        type.symbols.map {
            asd.add(Symbols.Symbol(
                xxx = it.key,
                name = it.value,
                base = it.key == "EUR",
                check = it.key == "BTC" || it.key == "UAH" || it.key == "USD"
            ))
        }
        return Symbols(asd)
    }
}