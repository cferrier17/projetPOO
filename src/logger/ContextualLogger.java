package logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextualLogger implements Logger{
    private String callerClass;
    private Logger delegateLogger;

    public ContextualLogger(String className, Logger log) {
        this.callerClass= className;
        this.delegateLogger= log;
    }

    @Override
    public void info(String categorie, String message){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");

        this.delegateLogger.info(categorie,DATE_FORMAT.format(new Date()) + " " + this.callerClass + " " + message);
    }

    @Override
    public void error(String category, String message) {

    }


}
