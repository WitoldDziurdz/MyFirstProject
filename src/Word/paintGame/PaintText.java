/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.paintGame;

import java.awt.Graphics;
import Word.World;

/**
 *
 * @author witold
 */
public class PaintText extends Paint {
    private String Text; 
    private int x; 
    private int y;
    public PaintText(Size Win, World Home) {
       super(Win,Home);
       x = 0; 
       y = 0; 
    }
    
    
    
    public void setText(String Text){
        this.Text = Text; 
    }
    
    public void setX(int x){
        this.x = x; 
    }
    
     public void setY(int y){
        this.y = y; 
    }
    
    public void paintField(Graphics g) {
        g.drawString(Text, this.x, this.y);
    }

    @Override
    public void paint(Graphics g) {
        paintField(g);
    }
   
}
