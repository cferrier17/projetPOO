package logger;

public class ConsoleLogger implements Logger{

    public void info(String category, String message){
        if("OUTPUT".equals(category))
            System.out.println(message);
    }

    public void error(String category, String message){
        if("OUTPUT".equals(category))
            System.out.println("ERROR : "+message);
    }
}

