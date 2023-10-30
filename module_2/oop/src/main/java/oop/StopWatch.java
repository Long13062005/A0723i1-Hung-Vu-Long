package main.java.oop;

public class StopWatch {
    private long startTime, endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTime();
    }

    public void stop() {
        this.stopTime = System.currentTime();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;

    }

    public static void sortArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
