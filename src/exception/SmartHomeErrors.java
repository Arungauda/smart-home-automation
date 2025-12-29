package exception;

import loggers.AppLogger;

public final class SmartHomeErrors {

    /** Domain-specific runtime error. */
    public static final class SmartHomeException extends RuntimeException {
        public SmartHomeException(String msg)                 { super(msg); }
        public SmartHomeException(String msg, Throwable cause){ super(msg, cause); }
    }

    private SmartHomeErrors() {}

    public static void handle(Throwable t) {
        if (t instanceof SmartHomeException) {
            AppLogger.error("Smart-Home error: {}", t.getMessage());
        } else if(t instanceof  OutOfMemoryError) {
            AppLogger.error("JVM is out of memory - shutting down", t);
            System.exit(1);
        } else {
            AppLogger.error("Unexpected error", t);
        }
    }

    public static void installAsDefaultHandler() {
        Thread.setDefaultUncaughtExceptionHandler(
                (thread, throwable) -> SmartHomeErrors.handle(throwable)
        );
    }


}
