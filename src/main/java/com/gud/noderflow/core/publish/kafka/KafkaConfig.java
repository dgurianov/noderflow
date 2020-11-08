package com.gud.noderflow.core.publish.kafka;
//TODO: move values externally
public interface KafkaConfig {
    public static String KAFKA_BROKERS = "192.168.99.100:9092";

    public static Integer MESSAGE_COUNT = 1000;

    public static String CLIENT_ID = "client1";

    public static String TOPIC_NAME = "myTop";

    public static String GROUP_ID_CONFIG = "consumerGroup1";

    public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;

    public static String OFFSET_RESET_LATEST = "latest";

    public static String OFFSET_RESET_EARLIER = "earliest";

    public static Integer MAX_POLL_RECORDS = 1;

}
