public class Publisher {
    private MessageBroker broker;

    public Publisher(MessageBroker broker) {
        this.broker = broker;
    }

    public void publish(String topic, String content) {
        Message message = new Message(topic, content);
        broker.publish(message);
    }
}
