package com.room.pavelfedor.roomexample.ui.base.stack

import android.content.Context
import android.content.ContextWrapper
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

class BackStack {
    
}

interface  Stack {
   
}

class BackStackContextWrapper(val backStack: BackStack, context: Context) : ContextWrapper(context)
