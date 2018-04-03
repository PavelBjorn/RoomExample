package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract

interface RouterFactory {

    fun registerRouter(router: Router<in PolarisContract>)

    fun <T : PolarisContract> makeRouter(contract: PolarisContract): Router<T>
}
