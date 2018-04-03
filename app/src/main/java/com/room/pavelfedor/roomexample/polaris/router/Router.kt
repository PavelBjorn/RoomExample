package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.contract.Presenter

interface Router <T:Presenter> {

    fun routeTo(tag:T)

    fun isForTag(tag: T) = geTagClass() == tag::class.java

    fun geTagClass():Class<out T>

    fun compare(router:Router<*>): Boolean
}
