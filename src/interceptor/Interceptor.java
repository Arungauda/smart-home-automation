package interceptor;

public interface Interceptor {

    void preHandle(String request);
    void postHandler(String response);
}
