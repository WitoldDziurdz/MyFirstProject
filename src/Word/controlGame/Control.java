/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.controlGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Word.World;

/**
 *
 * @author witold
 */
public class Control implements KeyListener {

    private World Home;

    public Control(World Home) {
        super();
        this.Home = Home;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.Home.getHexWorld() == false) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.Home.setHumanTurn(72);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                this.Home.setHumanTurn(75);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.Home.setHumanTurn(77);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                this.Home.setHumanTurn(80);
            }
        } else if (this.Home.getHexWorld() == true) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                this.Home.setHumanTurn(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_E) {
                this.Home.setHumanTurn(1);
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                this.Home.setHumanTurn(2);
            }
            if (e.getKeyCode() == KeyEvent.VK_C) {
                this.Home.setHumanTurn(3);
            }
            if (e.getKeyCode() == KeyEvent.VK_X) {
                this.Home.setHumanTurn(4);
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                this.Home.setHumanTurn(5);
            }

        }
        /*if (e.getKeyCode() == KeyEvent.VK_G) {
              this.Home.saveFile();
        }  if (e.getKeyCode() == KeyEvent.VK_H) {
            try {
                this.Home.loadFile();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        if (e.getKeyCode() == KeyEvent.VK_F) {
            this.Home.setHumanTurn(81);
        }
        if (!(e.getKeyCode() == KeyEvent.VK_G || e.getKeyCode() == KeyEvent.VK_H)) {
            this.Home.nextRound();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
