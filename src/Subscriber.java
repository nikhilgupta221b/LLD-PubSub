import java.util.List;

public interface Subscriber {
    void update(Message message);
    String getId();
    List<String> getSubscribedTopics();
}
