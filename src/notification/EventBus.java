package notification;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private static EventBus instance;

    private final List<Subscriber> subscriberList = new ArrayList<>();

    private EventBus(){}

    public static synchronized  EventBus getInstance(){
        if(instance ==  null){
            instance = new EventBus();
        }
        return instance;
    }


    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void publish(Event event) {
        for (Subscriber subscriber : subscriberList) {
            subscriber.update(event);
        }
    }
}
