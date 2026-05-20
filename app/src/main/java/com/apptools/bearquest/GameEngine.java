package com.apptools.bearquest;

import java.util.Random;

public class GameEngine {
    private int score;
    private int targetBear;
    private boolean isGameActive;
    private Random random;
    private static final int MAX_SCORE = 10;

    public GameEngine() {
        this.random = new Random();
        this.score = 0;
        this.isGameActive = false;
        this.targetBear = 0;
    }

    public void startGame() {
        this.score = 0;
        this.isGameActive = true;
        generateTarget();
    }

    public void endGame() {
        this.isGameActive = false;
    }

    public void resetGame() {
        this.score = 0;
        this.targetBear = 0;
        this.isGameActive = false;
    }

    public boolean onBearTapped(int bearNumber) {
        if (!isGameActive) {
            return false;
        }

        if (bearNumber == targetBear) {
            score++;
            if (score >= MAX_SCORE) {
                endGame();
                return true;
            }
            generateTarget();
        }
        return false;
    }

    private void generateTarget() {
        targetBear = random.nextInt(5) + 1;
    }

    public int getScore() {
        return score;
    }

    public int getTargetBear() {
        return targetBear;
    }

    public boolean isGameActive() {
        return isGameActive;
    }
}