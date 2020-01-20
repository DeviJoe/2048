import GUI.MainFrame;
import GUI.MainPanel;
import Game.GameField;
import Game.Tile;
import Keyboard.KeyboardControl;

/**
 * Игра 2048 - TASK 13 by VSU
 * (Дисциплина "Введение в программирование", лектор - ст.п. Соломатин Д.И., практикант - асс. Нужных А.В.)
 *
 * Автор выражает благодарность автору статьи http://grafika.me/node/285 и авторам учебного пособия http://www.lib.unn.ru/students/src/graphics-java.pdf
 * Благодаря им я чуть-чуть разобрался в отрисовке графики в JAVA
 * Также спасибо автору статьи с примероми графики http://spec-zone.ru/RU/Java/Tutorials/2d/basic2d/index.html и http://crypto.pp.ua/2013/07/rabota-s-grafikoj-na-java/
 * Пусть много чего не пригодилось, но это помогло осознать, как работает графика.
 *
 * @version 1.0
 * @author Devijoe (Github: <href a></href>)
 */
public class Run {

    public static void main (String[] args) {

        // Создание игрового поля
        GameField gameField = new GameField();

        // Создание экземпляра логики игры
        Tile tile = new Tile(gameField);

        // Создание формы SWING
        MainFrame mainFrame = new MainFrame();

        // Создание Swing панели для отрисовки графики
        MainPanel mainPanel = new MainPanel(gameField, tile);

        // Создание считывателя нажатий клавиатуры
        KeyboardControl gameControl = new KeyboardControl(mainPanel, tile);

        // Форма - видимая
        mainFrame.setVisible(true);

        // Назначение слушателя нажатий
        mainFrame.addKeyListener(gameControl);

        //Отображение панели
        mainFrame.setContentPane(mainPanel);
    }

}
