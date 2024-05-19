package pl.pw.mini.minispace.powiadomienia.jms.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.pw.mini.minispace.powiadomienia.dto.RegisterNotificationResponse;
import pl.pw.mini.minispace.powiadomienia.dto.command.RegisterNotificationCommand;
import pl.pw.mini.minispace.powiadomienia.jms.handler.RegisterNotificationCommandHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class NotificationExchangeListener {

    private final String NOTIFICATION_CMD_QUEUE = "notification-cmd-queue";

    @Value("${spring.rabbitmq.exchange.notification}")
    private String NOTIFICATION_EXCHANGE;

    @Value("${spring.rabbitmq.routing-key.notification.evt}")
    private String NOTIFICATION_ROUTING_KEY_EVT;

    private final RegisterNotificationCommandHandler registerNotificationCommandHandler;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = NOTIFICATION_CMD_QUEUE)
    public void handleRegisterNotificationCommand(RegisterNotificationCommand cmd) {
        log.info("RegisterNotificationCommand received with title: {}", cmd.getTitle());
        RegisterNotificationResponse response = registerNotificationCommandHandler.handleRegisterNotificationCommand(cmd);
        rabbitTemplate.convertAndSend(NOTIFICATION_EXCHANGE, NOTIFICATION_ROUTING_KEY_EVT, response);
    }
}
