package org.example.aplikaceproskolu;

public class TimeFormat {
    public static String formatTime(double minutes) {
        double totalSeconds = minutes * 60;
        int hours = (int) totalSeconds / 3600;
        int minutesLeft = (int) (totalSeconds % 3600) / 60;
        int seconds = (int) totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutesLeft, seconds);
    }
}
