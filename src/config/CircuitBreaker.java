package config;

public class CircuitBreaker {

    private boolean open = false;

    public void check(){
        if(open){
            throw new RuntimeException("Circuit is open , service is temporialry unavailable .");
        }
    }

    public void trip(){
        open = true;
    }

    public void reset(){
        open = false;
    }

    public boolean isOpen(){
        return open;
    }

}
