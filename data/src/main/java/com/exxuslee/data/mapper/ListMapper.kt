package com.exxuslee.data.mapper

import com.exxuslee.data.remote.response.ListResponse
import com.exxuslee.domain.models.IDs


class ListMapper : BaseMapper<IDs, ListResponse> {

    override fun remoteToDomain(type: ListResponse) = IDs(type.list)

}