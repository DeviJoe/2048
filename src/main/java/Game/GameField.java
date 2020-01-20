package Game;

/**
 * Класс описывает игровое поле
 */
public class GameField {

    /** Подсчет очков (Кол-во закрытых ячеек) */
    private int num = 0;
    private int x;
    private int y;
    /** Игровое поле */
    private int[][] field = new int[Constants.FIELD_SIZE][Constants.FIELD_SIZE];

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int[][] getMap() {
        return field;
    }

    public void setMap(int[][] map) {
        this.field = map;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    };
}
