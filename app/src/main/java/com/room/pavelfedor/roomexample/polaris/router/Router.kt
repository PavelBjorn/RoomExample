package com.room.pavelfedor.roomexample.polaris.router

import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract

interface Router<T : PolarisContract> {

    fun routeTo(tag: T)

    fun geTagClass(): Class<out T>

    fun compare(router: Router<*>): Boolean
}
