package pl.pw.mini.minispace.powiadomienia.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private String NOTIFICATION_EXCHANGE = "notifications";
    private String NOTIFICATION_CMD_QUEUE = "notification-cmd-queue";
    private String NOTIFICATION_EVT_QUEUE = "notification-evt-queue";

    private String NOTIFICATION_CMD_ROUTING_KEY = "notification-cmd";
    private String NOTIFICATION_EVT_ROUTING_KEY = "notification-evt";

    private String RABBIT_USERNAME = "guest";
    private String RABBIT_PASSWORD = "guest";
    private String RABBIT_URL = "localhost";
    private Integer RABBIT_PORT = 5672;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(RABBIT_USERNAME);
        connectionFactory.setPassword(RABBIT_PASSWORD);
        connectionFactory.setPort(RABBIT_PORT);
        connectionFactory.setHost("localhost");

        return connectionFactory;
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
