package GUI;

import Game.GameField;

import java.awt.*;

public class MainUpdate {

    private int x = 45;
    private int y = 95;

    /** Обновляет при вызове координаты поля */
    public MainUpdate(GameField gameField) {
        gameField.setX(x);
        gameField.setY(y);
    }

    /** Отрисовка поля */
    public void drawWin(Graphics g) {
        g.drawImage(Images.bg_field, x, y, null);
    }
}
