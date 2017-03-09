/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.controlGame;

import Word.paintGame.SimpleWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author witold
 */
public class ControlButton implements ActionListener {

    protected SimpleWindow A;

    public ControlButton(SimpleWindow A) {
        super();
        this.A = A;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.A.addOrganism(); 
    }
}
