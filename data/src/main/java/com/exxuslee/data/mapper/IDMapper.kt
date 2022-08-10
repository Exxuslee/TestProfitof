package com.exxuslee.data.mapper

import com.exxuslee.data.local.entities.IDEntity
import com.exxuslee.data.remote.response.IDResponse
import com.exxuslee.domain.models.ID
import com.google.gson.Gson
import org.json.JSONObject


class IDMapper : BaseMapper.TripleMapper<ID, IDEntity, IDResponse> {

    override fun remoteToDomain(type: IDResponse): ID {
        val payload = JSONObject(Gson().toJson(type.payload))
        return when (type.type) {
            "text" -> ID(type = type.type!!, content = payload.getString("text"))
            "webpage" -> ID(type = type.type!!, content = payload.getString("url"))
            else -> {
                ID(type = "text", content = "new type")
            }
        }
    }

    override fun localToDomain(type: IDEntity): ID {
        return ID(type = type.type, content = type.content)
    }


    override fun remoteToLocal(type: IDResponse, xxx: Int): IDEntity {
        val payload = JSONObject(Gson().toJson(type.payload))
        return when (type.type) {
            "text" -> IDEntity(xxx = xxx, type = type.type!!, content = payload.getString("text"))
            "webpage" -> IDEntity(xxx = xxx, type = type.type!!, content = payload.getString("url"))
            else -> {
                IDEntity(xxx = xxx, type = "text", content = type.type!!)
            }
        }
    }
}