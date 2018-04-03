package com.room.pavelfedor.roomexample.ui.base.dispatcher

import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract.*

class DefaultEventDispatcher private constructor(
        private val eventsMap: MutableMap<Class<out UiEventDispatcher.Event>, MutableList<Subscriber<*>>>
) : UiEventDispatcher {

    override fun <E : UiEventDispatcher.Event> registerEvents(event: List<Class<E>>) {
        eventsMap.putAll(event.map { it to mutableListOf<Subscriber<*>>() }.toMap().toMutableMap())
    }

    override fun <E : UiEventDispatcher.Event> dispatchEvent(event: E) {
        eventsMap[event::class.java]?.forEach {
            @Suppress("UNCHECKED_CAST")
            (it as Subscriber<E>).invoke(event)
        }
    }

    override fun <E : UiEventDispatcher.Event> subscribeOnEvent(event: Class<out E>, action: (E) -> Unit) = eventsMap[event]?.let {
        Subscriber(it.size, it, action).apply {
            it.add(this)
        }
    } ?: throw IllegalArgumentException("Event $event isn't in register")


    companion object {
        infix fun <E : UiEventDispatcher.Event> with(events: List<Class<E>>) = DefaultEventDispatcher(
                events.map { it to mutableListOf<Subscriber<*>>() }.toMap().toMutableMap()
        )
    }
}
