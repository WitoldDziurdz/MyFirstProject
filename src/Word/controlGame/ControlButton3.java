/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.controlGame;

import Word.paintGame.SimpleWindow;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import Word.MyException;
import Word.World;

/**
 *
 * @author witold
 */
public class ControlButton3 extends ControlButton1{
    public ControlButton3(SimpleWindow A, World Home) {
        super(A, Home);
    }
     public void actionPerformed(ActionEvent e) {
          try {
            this.Home.loadFile();
        } catch (FileNotFoundException ex) {
        }
           catch (MyException ex) {
               System.out.print(ex.toString()); 
        }
    }
}