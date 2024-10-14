public class PubSubDemo {
    public static void main(String[] args) {
        // Create a message broker
        MessageBroker broker = new MessageBroker();

        // Create subscribers
        SubscriberImpl subscriber1 = new SubscriberImpl("S1");
        SubscriberImpl subscriber2 = new SubscriberImpl("S2");

        // Subscribers subscribe to topics
        subscriber1.subscribe("sports");
        subscriber2.subscribe("news");

        // Broker registers subscribers for topics
        broker.subscribe("sports", subscriber1);
        broker.subscribe("news", subscriber2);

        // Create a publisher
        Publisher publisher = new Publisher(broker);

        // Publisher publishes messages to topics
        publisher.publish("sports", "Latest sports updates!");
        publisher.publish("news", "Breaking news headlines!");

        // Optionally, subscribers can unsubscribe
        broker.unsubscribe("sports", subscriber1);
    }
}
