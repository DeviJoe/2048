package GUI;

import Game.Constants;
import Game.GameField;
import Game.Tile;

import java.awt.*;

/**
 * Класс занимается отрисовкой отдельных элементов игры - самих плиток.
 *
 */
public class GameUI {

    /** Размер одного рисунка в px */
    private static final int SIZE = 90;
    private int x;
    private int y;
    private GameField gameField;
    private int[][] field;

    /** Конструктор обновления */
    public GameUI(GameField gameField, Tile tile) {
        tile.newBlock();
        tile.newBlock();
        this.gameField = gameField;
        this.x = gameField.getX();
        this.y = gameField.getY();
    }

    /**
     * Метод отрисовывает клетки, считывая индекс ячейки и по нему находя на палетке нужный
     * тайл с картинкой, которая выводится на экран через модуль графики
     *
     */
    public void GamePaint(Graphics g) {
        this.field = gameField.getMap();
        // Метод считывания и отрисовки 图
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {

                int gameIndex = field[i][j];

                if (gameIndex != 0) {

                    int dx1 = this.x + i * SIZE;
                    int dy1 = this.y + j * SIZE;

                    int dx2 = this.x + i * SIZE + SIZE;
                    int dy2 = this.y + j * SIZE + SIZE;

                    int sx1 = 0 + (gameIndex - 1) * SIZE;
                    int sy1 = 0;

                    int sx2 = SIZE + (gameIndex - 1) * SIZE;
                    int sy2 = SIZE;

                    //Неиспользуемый блок (был нужен для отладки чтобы проверять корректность найденного куска)
//					System.out.println("i = " + i + ", j = " + j);
//					System.out.println("dx1=" + dx1 + ",dy1=" + dy1 + ",dx2=" + dx2 + ",dy2=" + dy2);
//					System.out.println("sx1=" + sx1 + ",sy1=" + sy1 + ",sx2=" + sx2 + ",sy2=" + sy2);

                    g.drawImage(Images.img_tiles, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
                }
            }
        }
    }
}
