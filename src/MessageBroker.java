import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageBroker {
    private Map<String, List<Subscriber>> topicSubscribers;

    public MessageBroker() {
        this.topicSubscribers = new ConcurrentHashMap<>();
    }

    public void subscribe(String topic, Subscriber subscriber) {
        topicSubscribers.putIfAbsent(topic, new CopyOnWriteArrayList<>());
        topicSubscribers.get(topic).add(subscriber);
    }

    public void unsubscribe(String topic, Subscriber subscriber) {
        List<Subscriber> subscribers = topicSubscribers.get(topic);
        if (subscribers != null) {
            subscribers.remove(subscriber);
            if (subscribers.isEmpty()) {
                topicSubscribers.remove(topic);
            }
        }
    }

    public void publish(Message message) {
        List<Subscriber> subscribers = topicSubscribers.get(message.getTopic());
        if (subscribers != null) {
            for (Subscriber subscriber : subscribers) {
                subscriber.update(message);
            }
        }
    }
}
