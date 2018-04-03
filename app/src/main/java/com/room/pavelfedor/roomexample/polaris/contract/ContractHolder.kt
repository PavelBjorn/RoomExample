package com.room.pavelfedor.roomexample.polaris.contract

import android.view.ViewGroup
import com.room.pavelfedor.roomexample.polaris.router.RouterFactory
import com.room.pavelfedor.roomexample.polaris.stack.Stack


interface ContractHolder {

    val stack: Stack

    val routerFactory: RouterFactory

    fun getContentContainer(): ViewGroup

    fun navigateTo(contract: PolarisContract) {
        routerFactory
    }
}
