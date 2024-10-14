# Pub/Sub Model Implementation

## Overview
This project implements a simple Pub/Sub (Publisher/Subscriber) messaging model, where:
- **Publishers** produce messages and send them to a message broker.
- **Subscribers** express interest in certain topics and receive messages relevant to those topics.
- **Message Broker** mediates between publishers and subscribers, managing subscriptions and delivering messages.

The key classes in this project are `Message`, `Subscriber`, `SubscriberImpl`, `Publisher`, and `MessageBroker`.

---

## Classes

### 1. **Message**
**Purpose**: Represents the data being communicated between publishers and subscribers.

**Attributes**:
- `topic`: A string indicating the subject or category of the message.
- `content`: The actual information or payload of the message.

**Methods**:
- Getters for `topic` and `content`.

### 2. **Subscriber (Interface)**
**Purpose**: Defines the contract for any subscriber in the system.

**Why Use an Interface**:
- **Flexibility**: Allows for different implementations of subscribers (e.g., email subscribers, SMS subscribers) without changing the broker or publisher code.
- **Extensibility**: New subscriber types can be added easily, adhering to the **Open/Closed Principle**.

**Methods**:
- `update(Message message)`: Called by the broker to deliver a message to the subscriber.
- `getId()`: Returns a unique identifier for the subscriber.
- `getSubscribedTopics()`: Returns a list of topics the subscriber is interested in.

### 3. **SubscriberImpl**
**Purpose**: A concrete implementation of the `Subscriber` interface.

**Attributes**:
- `id`: A unique identifier for the subscriber.
- `subscribedTopics`: A list of topics the subscriber has subscribed to.

**Methods**:
- Implements all methods from the `Subscriber` interface.
- `subscribe(String topic)`: Adds a topic to the subscriber's list.
- `unsubscribe(String topic)`: Removes a topic from the subscriber's list.

### 4. **Publisher**
**Purpose**: Sends messages to the broker for distribution to subscribers.

**Attributes**:
- `broker`: A reference to the `MessageBroker` to publish messages to.

**Methods**:
- `publish(String topic, String content)`: Creates a message and sends it to the broker.

### 5. **Message Broker**
**Purpose**: Manages subscriptions and routes messages from publishers to the correct subscribers.

**Attributes**:
- `topicSubscribers`: A thread-safe map that associates topics with lists of subscribers interested in them.

**Methods**:
- `subscribe(String topic, Subscriber subscriber)`: Registers a subscriber to a topic.
- `unsubscribe(String topic, Subscriber subscriber)`: Deregisters a subscriber from a topic.
- `publish(Message message)`: Sends the message to all subscribers interested in the message's topic.

---
