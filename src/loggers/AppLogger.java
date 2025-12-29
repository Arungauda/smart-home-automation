package loggers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppLogger {

    public static final Logger LOG = Logger.getLogger("SmartHome");
    private static AppLogger instance;

    private AppLogger(){}

    public static synchronized AppLogger getInstance() {
        if (instance == null) {
            instance = new AppLogger();
        }
        return instance;
    }

    public static void info(String msg, Object... args)  {
        LOG.log(Level.INFO,  format(msg, args));
    }
    public static void warn(String msg, Object... args)  {
        LOG.log(Level.WARNING, format(msg, args));
    }
    public static void error(String msg, Object... args) {
        LOG.log(Level.SEVERE, format(msg, args));
    }
    public static void error(String msg, Throwable t)    {
        LOG.log(Level.SEVERE, msg, t);
    }
    public static void debug(String msg, Object... args) {
        LOG.log(Level.FINE,  format(msg, args));
    }


    private static String format(String msg, Object... args) {
        return args == null || args.length == 0 ? msg : String.format(msg, args);
    }

}
