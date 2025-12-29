package notification;

public abstract class Event {

    private final String message;
    protected Event(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
