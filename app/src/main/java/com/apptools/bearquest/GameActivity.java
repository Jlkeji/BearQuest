package com.apptools.bearquest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private GameEngine gameEngine;
    private TextView scoreTextView;
    private TextView targetTextView;
    private TextView resultTextView;
    private Button bear1Btn, bear2Btn, bear3Btn, bear4Btn, bear5Btn;
    private Button resetBtn;
    private Button backBtn;
    private Handler gameHandler;
    private Runnable gameUpdateRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameEngine = new GameEngine();
        gameHandler = new Handler(Looper.getMainLooper());

        scoreTextView = findViewById(R.id.tv_score);
        targetTextView = findViewById(R.id.tv_target);
        resultTextView = findViewById(R.id.tv_result);
        bear1Btn = findViewById(R.id.btn_bear_1);
        bear2Btn = findViewById(R.id.btn_bear_2);
        bear3Btn = findViewById(R.id.btn_bear_3);
        bear4Btn = findViewById(R.id.btn_bear_4);
        bear5Btn = findViewById(R.id.btn_bear_5);
        resetBtn = findViewById(R.id.btn_reset);
        backBtn = findViewById(R.id.btn_back);

        setupBearButtons();
        setupResetButton();
        setupBackButton();

        startGame();
    }

    private void setupBearButtons() {
        Button[] buttons = {bear1Btn, bear2Btn, bear3Btn, bear4Btn, bear5Btn};
        for (int i = 0; i < buttons.length; i++) {
            final int bearNumber = i + 1;
            buttons[i].setOnClickListener(v -> {
                if (gameEngine.isGameActive()) {
                    boolean won = gameEngine.onBearTapped(bearNumber);
                    updateUI();
                    if (won) {
                        showWinMessage();
                    }
                }
            });
        }
    }

    private void setupResetButton() {
        resetBtn.setOnClickListener(v -> {
            gameEngine.resetGame();
            resultTextView.setText("");
            startGame();
        });
    }

    private void setupBackButton() {
        backBtn.setOnClickListener(v -> onBackPressed());
    }

    private void startGame() {
        gameEngine.startGame();
        resultTextView.setText("");
        updateUI();
        startGameUpdate();
    }

    private void updateUI() {
        scoreTextView.setText(GameUI.formatScore(gameEngine.getScore()));
        targetTextView.setText(GameUI.formatTarget(gameEngine.getTargetBear()));
    }

    private void startGameUpdate() {
        gameUpdateRunnable = () -> {
            if (gameEngine.isGameActive()) {
                updateUI();
                gameHandler.postDelayed(gameUpdateRunnable, 100);
            }
        };
        gameHandler.post(gameUpdateRunnable);
    }

    private void showWinMessage() {
        gameEngine.endGame();
        resultTextView.setText("🎉 You Won! 🎉\nTap Reset to play again!");
        resultTextView.setTextColor(GameUI.COLOR_SUCCESS);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (gameUpdateRunnable != null) {
            gameHandler.removeCallbacks(gameUpdateRunnable);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (gameEngine.isGameActive()) {
            startGameUpdate();
        }
    }

    @Override
    public void onBackPressed() {
        if (gameUpdateRunnable != null) {
            gameHandler.removeCallbacks(gameUpdateRunnable);
        }
        super.onBackPressed();
    }
}