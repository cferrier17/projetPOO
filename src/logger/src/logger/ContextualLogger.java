package logger.src.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextualLogger implements Logger{
    private Logger delegateLogger;

    public ContextualLogger(Logger log) {
        this.delegateLogger= log;
    }

    @Override
    public void info(String categorie, String message){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");

        this.delegateLogger.info(categorie,DATE_FORMAT.format(new Date()) + " "  + message);
    }

    @Override
    public void error(String category, String message) {

    }


}
