package com.exxuslee.data.mapper

import com.exxuslee.domain.models.IDs


class ListMapper : BaseMapper<IDs, List<Int>> {

    override fun remoteToDomain(type: List<Int>): IDs {
        return IDs(list = arrayListOf(1,2,3))
    }

}