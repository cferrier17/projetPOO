package logger;

public class CompositeLogger implements Logger {
    private Logger firstLogger;
    private Logger secondLogger;

    public CompositeLogger(Logger firstLogger, Logger secondLogger) {
        this.firstLogger = firstLogger;
        this.secondLogger = secondLogger;
    }

    @Override
    public void info(String category, String message) {
        this.secondLogger.info(category, message);
        this.firstLogger.info(category, message);
    }

    @Override
    public void error(String category, String message) {
        this.secondLogger.error(category, message);
        this.firstLogger.error(category, message);
    }
}
