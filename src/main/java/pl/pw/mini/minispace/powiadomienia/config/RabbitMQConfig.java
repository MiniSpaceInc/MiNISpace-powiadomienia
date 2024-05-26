package pl.pw.mini.minispace.powiadomienia.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.exchange.notification}")
    private String NOTIFICATION_EXCHANGE;
    @Value("${spring.rabbitmq.queue.notification.cmd}")
    private String NOTIFICATION_CMD_QUEUE;
    @Value("${spring.rabbitmq.queue.notification.evt}")
    private String NOTIFICATION_EVT_QUEUE;
    @Value("${spring.rabbitmq.routing-key.notification.cmd}")
    private String NOTIFICATION_CMD_ROUTING_KEY;
    @Value("${spring.rabbitmq.routing-key.notification.evt}")
    private String NOTIFICATION_EVT_ROUTING_KEY;
    @Value("${spring.rabbitmq.username}")
    private String RABBIT_USERNAME;
    @Value("${spring.rabbitmq.password}")
    private String RABBIT_PASSWORD;
    @Value("${spring.rabbitmq.host}")
    private String RABBIT_URL;
    @Value("${spring.rabbitmq.port}")
    private Integer RABBIT_PORT;

    /**
     * Creates connection to RabbitMQ Broker
     * @return ConnectionFactory
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(RABBIT_USERNAME);
        connectionFactory.setPassword(RABBIT_PASSWORD);
        connectionFactory.setPort(RABBIT_PORT);
        connectionFactory.setHost(RABBIT_URL);
        return connectionFactory;
    }

    /**
     * Sets up rabbitTemplate required to send messages to RabbitMQ Broker
     * @param connectionFactory
     * @return RabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    /**
     * Sets up message converter to serialize/deserialize messages sent and received from RabbitMQ Broker
     * @return MessageConverter
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Notifications' exchanges definitions
     */

    /**
     * Creates RabbitMQ Exchanges for notifications
     * @return TopicExchange
     */
    @Bean
    public DirectExchange notificationExchange() {
        return new DirectExchange(NOTIFICATION_EXCHANGE);
    }

    /**
     * Notifications' queues definitions
     */

    /**
     * Creates queue for notification commands
     * @return Queue
     */
    @Bean
    public Queue cmdQueue() {
        return new Queue(NOTIFICATION_CMD_QUEUE, true);
    }

    /**
     * Create queue for notification events
     * @return Queue
     */
    @Bean
    public Queue evtQueue() {
        return new Queue(NOTIFICATION_EVT_QUEUE, true);
    }

    /**
     * Definitions of queue bindings
     */

    /**
     * Binds cmdQueue to notificationExchange with given routing key for commands
     * @param cmdQueue
     * @param directExchange
     * @return Binding
     */
    @Bean
    public Binding cmdQueueBinding(Queue cmdQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(cmdQueue).to(directExchange).with(NOTIFICATION_CMD_ROUTING_KEY);
    }

    /**
     * Binds evtQueue to notificationExchange with given routing key for events
     * @param evtQueue
     * @param directExchange
     * @return Binding
     */
    @Bean
    public Binding evtQueueBinding(Queue evtQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(evtQueue).to(directExchange).with(NOTIFICATION_EVT_ROUTING_KEY);
    }
}
