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
public class ControlButton1 extends ControlButton {
    protected World Home; 
    public ControlButton1(SimpleWindow A, World Home) {
        super(A);
        this.Home = Home; 
    }
    
     public void actionPerformed(ActionEvent e) {
       this.Home.nextRound();
    }
}
