package com.apptools.bearquest;

public class GameUI {
    public static final int COLOR_SUCCESS = 0xFF4CAF50;
    public static final int COLOR_ERROR = 0xFFF44336;
    public static final int COLOR_PRIMARY = 0xFF8B4513;
    public static final int COLOR_SECONDARY = 0xFFDEB887;

    public static String formatScore(int score) {
        return "Score: " + score + "/10";
    }

    public static String formatTarget(int bearNumber) {
        return "Tap Bear #" + bearNumber;
    }

    public static int getButtonColor(boolean isTarget) {
        return isTarget ? COLOR_PRIMARY : COLOR_SECONDARY;
    }
}