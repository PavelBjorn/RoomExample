package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract

class DefaultRouterFactory : RouterFactory {

    private val routers = mutableSetOf<Router<in PolarisContract>>()

    override fun registerRouter(router: Router<in PolarisContract>) {
        routers.removeAll { it.compare(router) }
    }

    override fun <T : PolarisContract> makeRouter(contrac: PolarisContract): Router<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
