package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.tag.Tag

class DefaultRouterFactory : RouterFactory {

    private val routers = mutableSetOf<Router<in Tag>>()

    override fun registerRouter(router: Router<in Tag>) {
        routers.removeAll { it.compare(router) }
    }

    override fun <T : Tag> makeRouter(tag: Tag): Router<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}