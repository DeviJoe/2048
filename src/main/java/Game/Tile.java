package Game;

import javax.swing.*;
import java.util.Random;

/**
 * Класс, реализующий игровую логику программы
 */
public class Tile {

    private int num;
    private Random random;
    private GameField gameField;
    private int[][] field;


    /** Конструктор класса игровой логики */
    public Tile(GameField gameField) {
        this.random = new Random();
        this.gameField = gameField;
        this.field = gameField.getMap();
        this.num = gameField.getNum();
    }

    /** Генератор случайного значения измерения поля (X or Y)标*/
    public int getMapId() {
        int x = random.nextInt(Constants.FIELD_SIZE);
        return x;
    }

    /** Генератор случайных числел (2 или 4) */
    public int getGameNum() {
        int x = random.nextInt(2) + 1;
        return x;
    }

    /** Генерация нового блока в начале раунда */
    public void newBlock() {
        int x = getMapId();
        int y = getMapId();
        while (field[x][y] != 0) {
            x = getMapId();
            y = getMapId();
        }
        // После случайного определения ячейки идет присвоение ему случайного значения и обновление матицы
        field[x][y] = getGameNum();
        this.gameField.setMap(field);
    }

    /** Проверяет, полностью ли заполнено поле */
    public boolean isFull() {
        int index = 0;
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                if (field[i][j] != 0) {
                    index++;
                }
            }
        }
        if (index == Constants.FIELD_SIZE*Constants.FIELD_SIZE && !canRemove()) {
            return true;
        } else {
            return false;
        }
    }

    /** Проверяет возможность совмещения и удаления ячеек */
    public boolean canRemove() {
        boolean canRemove = false;
        for (int i = 0; i < Constants.FIELD_SIZE-1; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE-1; j++) {
                if (field[i][j] == field[i + 1][j]
                        || field[i][j] == field[i][j + 1]) {
                    canRemove = true;
                }
            }
        }
        return canRemove;
    }

    /** Событие окончания ввода */
    public void isGameOver() {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "Игра Окончена! Ваш счет: " + this.gameField.getNum());
        } else if (is2048()) {
            JOptionPane.showMessageDialog(null, "ВЫ ВЫИГРЫЛИ! 2048! Раскройте секрет, как вам удалось?");
        }
    }

    // 判断是不是成功
    public boolean is2048() {
        boolean isOk = false;
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE; j++) {
                if (field[i][j] == 11) {
                    isOk = true;
                }
            }
        }
        return isOk;
    }

    /** Сдвиг ячеек влево */
    public int moveLeft() {
        int isMove = 0;
        for (int j = 0; j < Constants.FIELD_SIZE; j++) {
            for (int i = 1; i < Constants.FIELD_SIZE; i++) {
                int mov_i = i;
                int mov_j = j;
                while (field[mov_i][mov_j] != 0
                        && field[mov_i - 1][mov_j] == 0) {
                    field[mov_i - 1][mov_j] = field[mov_i][mov_j];
                    field[mov_i][mov_j] = 0;
                    if (mov_i > 1) {
                        mov_i--;
                    }
                    isMove = 1;
                }
            }
        }
        return isMove;
    }

    /** Сдвиг ячеек вправо */
    public int moveRight() {
        int isMove = 0;
        for (int j = 0; j < Constants.FIELD_SIZE; j++) {
            for (int i = 2; i >= 0; i--) {
                int mov_i = i;
                int mov_j = j;
                while (field[mov_i][mov_j] != 0
                        && field[mov_i + 1][mov_j] == 0) {
                    field[mov_i + 1][mov_j] = field[mov_i][mov_j];
                    field[mov_i][mov_j] = 0;
                    if (mov_i < 2) {
                        mov_i++;
                    }
                    isMove = 1;
                }
            }
        }
        return isMove;
    }

    /** Сдвиг ячеек вниз */
    public int moveDown() {
        int isMove = 0;
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 2; j >= 0; j--) {
                int mov_i = i;
                int mov_j = j;
                while (field[mov_i][mov_j] != 0
                        && field[mov_i][mov_j + 1] == 0) {
                    field[mov_i][mov_j + 1] = field[mov_i][mov_j];
                    field[mov_i][mov_j] = 0;
                    if (mov_j < 2) {
                        mov_j++;
                    }
                    isMove = 1;
                }
            }
        }
        return isMove;
    }

    /** Сдвиг ячеек вверх */
    public int moveUp() {
        int isMove = 0;
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 1; j < Constants.FIELD_SIZE; j++) {
                int mov_i = i;
                int mov_j = j;
                while (field[mov_i][mov_j] != 0
                        && field[mov_i][mov_j - 1] == 0) {
                    field[mov_i][mov_j - 1] = field[mov_i][mov_j];
                    field[mov_i][mov_j] = 0;
                    if (mov_j > 1) {
                        mov_j--;
                    }
                    isMove = 1;
                }
            }
        }
        return isMove;
    }


    public int removeLeft() {
        int isRemove = 0;
        for (int j = 0; j < Constants.FIELD_SIZE; j++) {
            for (int i = 0; i < Constants.FIELD_SIZE-1; i++) {
                while (field[i][j] == field[i + 1][j]
                        && field[i][j] != 11 && field[i][j] != 0) {
                    field[i][j] = field[i + 1][j] + 1;
                    field[i + 1][j] = 0;
                    // Обновление счета
                    this.num++;
                    this.gameField.setNum(num);
                    isRemove = 1;
                }
            }
        }
        moveLeft();
        return isRemove;
    }


    public int removeRight() {
        int isRemove = 0;
        for (int j = 0; j < Constants.FIELD_SIZE; j++) {
            for (int i = Constants.FIELD_SIZE-1; i > 0; i--) {
                while (field[i][j] == field[i - 1][j]
                        && field[i][j] != 11 && field[i][j] != 0) {
                    field[i][j] = field[i - 1][j] + 1;
                    field[i - 1][j] = 0;
                    // Обновление счета
                    this.num++;
                    this.gameField.setNum(num);
                    isRemove = 1;
                }
            }
        }
        moveRight();
        return isRemove;
    }


    public int removeUp() {
        int isRemove = 0;
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = 0; j < Constants.FIELD_SIZE-1; j++) {
                while (field[i][j] == field[i][j + 1]
                        && field[i][j] != 11 && field[i][j] != 0) {
                    field[i][j] = field[i][j + 1] + 1;
                    field[i][j + 1] = 0;
                    // Обновление счета
                    this.num++;
                    this.gameField.setNum(num);
                    isRemove = 1;
                }
            }
        }
        moveUp();
        return isRemove;
    }


    public int removeDown() {
        int isRemove = 0;
        for (int i = 0; i < Constants.FIELD_SIZE; i++) {
            for (int j = Constants.FIELD_SIZE-1; j > 0; j--) {
                while (field[i][j] == field[i][j - 1] && field[i][j] != 11 && field[i][j] != 0) {
                    field[i][j] = field[i][j - 1] + 1;
                    field[i][j - 1] = 0;
                    // Обновление счета
                    this.num++;
                    this.gameField.setNum(num);
                    isRemove = 1;
                }
            }
        }
        moveDown();
        return isRemove;
    }
}
