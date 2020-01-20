package Keyboard;

import GUI.MainPanel;
import GUI.Score.Score;
import Game.Tile;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Класс реализует управление на стрелках посредством  значений {@code KeyAdapter}
 * @author Devijoe
 */
public class KeyboardControl extends KeyAdapter {
    private MainPanel mainPanel;
    private Tile tile;

    /** Конструктор класса */
    public KeyboardControl(MainPanel mainPanel, Tile tile) {
        this.mainPanel = mainPanel;
        this.tile = tile;
    }


    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        switch (e.getKeyCode()) {
            /** Движение влево (стрелка "влево" нажата) */
            case 37: {
                int ismov = tile.moveLeft();
                int isremove = tile.removeLeft();
                if (ismov == 1 || isremove == 1) {
                    // new block
                    tile.newBlock();
                }
            }
            break;
            /** Движение вверх (стрелка "вверх" нажата) */
            case 38: {
                int ismov = tile.moveUp();
                int isremove = tile.removeUp();
                if (ismov == 1 || isremove == 1) {
                    // new block
                    tile.newBlock();
                }
            }
            break;
            /** Движение вправо (стрелка "вправо" нажата) */
            case 39: {
                int ismov = tile.moveRight();
                int isremove = tile.removeRight();
                if (ismov == 1 || isremove == 1) {
                    // new block
                    tile.newBlock();
                }
            }
            break;
            /** Движение вниз (стрелка "вниз" нажата) */
            case 40: {
                int ismov = tile.moveDown();
                int isremove = tile.removeDown();
                if (ismov == 1 || isremove == 1) {
                    // new block
                    tile.newBlock();
                }
            }
            break;
        }

        /** Переотрисрвка главной панели */
        this.mainPanel.repaint();

        /** События окончания игры */
        tile.isGameOver();
    }
}
