package interceptor;

import loggers.AppLogger;

public class LoggingInterceptor implements Interceptor{

    private final AppLogger logger = AppLogger.getInstance();


    @Override
    public void preHandle(String request) {
        AppLogger.info(request);
    }

    @Override
    public void postHandler(String response) {
        AppLogger.debug(response);  }
}
