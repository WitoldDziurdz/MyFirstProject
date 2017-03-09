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
public class SowThistle extends Plant{
    
    public SowThistle(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.sign = 'm';
    }    
    
    public void action() {
	int random = 0;
	int t = 3;
	int x = this.getPositionX();
	int y = this.getPositionY();
	if (this.turn == true) {
	    for(int i = 0; i < t; i++) {
		random = (int)(Math.random()*50);
		if (random == 49) {
		    addPlantAction(x, y); //здесь передаю копию так что могут быть проблемы с распостронением растений!!!!!!!!!!!!!
		}
	    }
	}
	this.turn = false;
    }
        @Override
    public String textBorn() {
        String Born = new String("Zasiany nowy mlecz\n"); 
        return Born; 
    }
    
     @Override
    public String textDead() {
        String Dead = new String("Zostal zjedzony mlecz\n"); 
        return Dead; 
    }
}
