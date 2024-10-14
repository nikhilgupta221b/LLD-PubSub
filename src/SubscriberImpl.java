import java.util.ArrayList;
import java.util.List;

public class SubscriberImpl implements Subscriber {
    private String id;
    private List<String> subscribedTopics;

    public SubscriberImpl(String id) {
        this.id = id;
        this.subscribedTopics = new ArrayList<>();
    }

    @Override
    public void update(Message message) {
        System.out.println("Subscriber " + id + " received message on topic '"
                + message.getTopic() + "': " + message.getContent());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<String> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void subscribe(String topic) {
        if (!subscribedTopics.contains(topic)) {
            subscribedTopics.add(topic);
        }
    }

    public void unsubscribe(String topic) {
        subscribedTopics.remove(topic);
    }
}
