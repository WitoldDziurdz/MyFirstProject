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
public class ControlButton2 extends ControlButton1{
    public ControlButton2(SimpleWindow A, World Home) {
        super(A, Home);
    }
     public void actionPerformed(ActionEvent e) {
        this.Home.saveFile();
    }
}
