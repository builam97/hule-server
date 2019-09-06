package com.example.demo.rabbit;
import com.rabbitmq.client.*;

public class ReceiveLogsDirect {
    private static final String EXCHANGE_NAME = "topic_logs";
    private static final String QUEUE_NAME = "waiting";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("abc.... "+ queueName);
        channel.queueBind(queueName, EXCHANGE_NAME, QUEUE_NAME);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" +
                    delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}