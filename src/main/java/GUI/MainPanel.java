package GUI;

import GUI.Score.Score;
import GUI.Score.ScoreNum;
import Game.GameField;
import Game.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * Используется для отрисовки модуля графики
 */
public class MainPanel extends JPanel {

    private MainUpdate mainUpdate;
    private Score score;
    private ScoreNum scoreNum;
    private GameUI gameUI;
    private GameField gameField;

    public MainPanel(GameField gameField, Tile tile){
        this.gameField = gameField;
        this.mainUpdate = new MainUpdate(gameField);
        this.score = new Score();
        this.gameUI = new GameUI(gameField, tile);
    }


    @Override
    protected void paintComponent(Graphics g) {

        //Отрисовать от суперкласса Graphics экземпляр g
        super.paintComponent(g);

        //Инициализация
        this.scoreNum = new ScoreNum(gameField);

        //Отрисовать фон
        g.drawImage(Images.bg_bg, 0, 0, null);

        // 设Перерисовка поля
        this.mainUpdate.drawWin(g);

        //Отрисовать таблицу со счетом
        this.score.drawScore(g);

        //Отрисовать число счета
        this.scoreNum.drawNum(g);

        //Перерисовать интерфейс игры
        this.gameUI.GamePaint(g);

    }
}
