/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.activeElementGame;

import Word.World;

/**
 *
 * @author witold
 */
public class Grass extends Plant{
    
    public Grass(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.sign = 't';
    }    
    
      @Override
    public String textBorn() {
        String Born = new String("Zasiana nowa trawa\n"); 
        return Born; 
    }
    
     @Override
    public String textDead() {
        String Dead = new String("Zostala zjedzona trawa\n"); 
        return Dead; 
    }
    
}
