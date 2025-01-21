package com.example.demo.config.rabbit


import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class RabbitMQConfig {

    @Value("\${rabbitmq.queue.name}")
    lateinit var queue: String

    @Value("\${rabbitmq.exchange.name}")
    lateinit var exchange: String

    @Value("\${rabbitmq.routing.key}")
    lateinit var routingKey:String

    @Bean
    fun queue(): Queue {
        return Queue(queue)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchange)
    }

    @Bean
    fun binding():  Binding{
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey)
    }
}