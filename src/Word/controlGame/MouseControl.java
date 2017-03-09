/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.controlGame;

import Word.paintGame.SimpleWindow;
import Word.paintGame.Size;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import Word.World;

/**
 *
 * @author witold
 */
public class MouseControl extends JPanel implements MouseListener {

    int clickedPosX;
    int clickedPosY;
    World Home;
    private SimpleWindow A;
    private Size Win;

    public MouseControl(SimpleWindow A, Size Win, World Home) {
        addMouseListener(this);
        this.A = A;
        this.Win = Win;
        this.Home = Home;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int scale1 = 5 * this.Win.getScale() / 9;
        if (this.Home.getHexWorld()) {
            clickedPosY = (2 * e.getY() / (3 * scale1)) - 1;
            if (clickedPosY % 2 == 0) {
                clickedPosX = (e.getX() / (2 * scale1));
            } else {
                clickedPosX = (((e.getX() / scale1) - 1) / 2);
            }
        } else {
            clickedPosX = (e.getX() / this.Win.getScale()) - 1;
            clickedPosY = (e.getY() / this.Win.getScale()) - 2;
        }
        A.addOrganismMouse(clickedPosX, clickedPosY);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
