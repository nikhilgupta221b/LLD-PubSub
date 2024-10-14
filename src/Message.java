public class Message {
    private String topic;
    private String content;

    // Constructor
    public Message(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    // Getters
    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }
}
