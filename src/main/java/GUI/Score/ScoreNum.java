package GUI.Score;

import GUI.Images;
import Game.GameField;

import java.awt.*;

/**
 * Класс реализует отрисовку счета через модуль Graphics
 * последовательно отрезая от палетки необходимый кусок для вывода на панель графики
 */
public class ScoreNum extends Score {
    /** Длина 1 цифры в px */
    private static final int SIZE_NUM = 21;
    /** Длина картинки со счетом */
    private static final int SIZE_SCORE = 80;

    /** Координата точки для источника */
    private int x;

    private GameField gameField;

    public ScoreNum(GameField gameField) {
        this.gameField = gameField;
    }

    public void drawNum(Graphics g){
        String gameNumString = Integer.toString(gameField.getNum());
        for (int i = 0; i < gameNumString.length(); i++) {
            int NumBit = gameNumString.charAt(i)-'0';
            this.x = NumBit*SIZE_NUM;

            // Координаты 1 диагональной точки
            int dx1 = this.s_x + SIZE_SCORE + i * SIZE_NUM;
            int dy1 = this.s_y;
            // Координаты 2 диагональной точки
            int dx2 = this.s_x + 2 + SIZE_SCORE + SIZE_NUM + i * SIZE_NUM;
            int dy2 = this.s_y + 2+  SIZE_NUM;

            g.drawImage(Images.bg_num, dx1, dy1, dx2, dy2, x, 0, SIZE_NUM + x, SIZE_NUM, null);
        }
    }
}
