package logger;

public class LoggerFactory implements Logger {
    public void info(String category, String message){

    }

    public void error(String category, String message){

    }


    public static Logger getLogger(String name){
        return new ConsoleLogger();
    }
}
