package com.room.pavelfedor.roomexample.polaris.contract

import android.os.Bundle


interface PolarisContract {

    val presenter: PolarisPresenter<*>

    val view: PolarisView

    val uiEventDispatcher: UiEventDispatcher

    val polarisViewState: Bundle

    interface PolarisPresenter<in View : PolarisView> {

        fun attachView(view: View)

        fun detachView()

        fun subscribeOnUiEvents()
    }

    interface PolarisView {

        val eventDispatcher: UiEventDispatcher?

        fun getEventKey(): Any
    }

    interface UiEventDispatcher {

        fun <E : Event> registerEvents(event: List<Class<E>>)

        fun <E : Event> dispatchEvent(event: E)

        fun <E : Event> subscribeOnEvent(event: Class<out E>, action: (E) -> Unit): Subscriber<E>

        abstract class Event {

            final override fun equals(other: Any?) = javaClass == other?.javaClass

            final override fun hashCode() = javaClass.canonicalName.hashCode()
        }
    }

    class Subscriber<in E : UiEventDispatcher.Event>(
            private val position: Int,
            private var subscriptions: MutableList<out Subscriber<*>>? = null,
            private val eventAction: (E) -> Unit
    ) {
        fun invoke(ev: E) {
            eventAction.invoke(ev)
        }

        fun unsubscribe() {
            subscriptions?.removeAt(position)
            subscriptions = null
        }

        override fun equals(other: Any?) = (other as? Subscriber<*>)?.position == position

        override fun hashCode() = position
    }

    companion object {
        val DISPATCHER = UiEventDispatcher::class.java.canonicalName
    }
}
