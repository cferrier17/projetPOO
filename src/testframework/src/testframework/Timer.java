package testframework.src.testframework;

public class Timer {

    private static long duration = 0;


    public long start() {
        return System.currentTimeMillis();
    }

    public long stop(long beginning) {
        duration = duration + (System.currentTimeMillis()-beginning);
        return System.currentTimeMillis()-beginning;
    }

    public long getDuration() {
        return duration;
    }
}