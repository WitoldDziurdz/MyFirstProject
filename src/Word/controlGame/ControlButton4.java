/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.controlGame;

import Word.paintGame.SimpleWindow;
import java.awt.event.ActionEvent;

import Word.World;

/**
 *
 * @author witold
 */
public class ControlButton4 extends ControlButton1 {

    public ControlButton4(SimpleWindow A, World Home) {
        super(A, Home);
    }

    public void actionPerformed(ActionEvent e) {
        if (this.Home.getHexWorld()) {
            this.Home.setHexWorld(false);
            this.A.setNormalWorld();
        } else {
            this.Home.setHexWorld(true);
             this.A.setHexWorld();
        }
    }
}
