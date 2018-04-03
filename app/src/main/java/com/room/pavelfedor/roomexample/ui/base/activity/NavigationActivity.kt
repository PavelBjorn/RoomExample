package com.room.pavelfedor.roomexample.ui.base.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.room.pavelfedor.roomexample.R
import com.room.pavelfedor.roomexample.ui.base.stack.BackStack
import com.room.pavelfedor.roomexample.ui.base.stack.BackStackContextWrapper
import com.room.pavelfedor.roomexample.ui.base.stack.StackItem
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private val backStack = BackStack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        backStack.navigateTo(navContainer, StackItem(R.layout.tab_view))
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(BackStackContextWrapper(backStack, newBase))
    }

    override fun onBackPressed() {
        if (!backStack.navigateBack(navContainer)) {
            super.onBackPressed()
        }
    }
}
