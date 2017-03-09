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
public class Guarana extends Plant{
    
    public Guarana(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.sign = 'g';
        this.specialColiz = true;
    }    
    
    public void SpecialColiz(Organism First){
	First.setStrength(3 + First.getStrength());
    }
    
        @Override
    public String textBorn() {
        String Born = new String("Zasiana nowa guarana\n"); 
        return Born; 
    }
    
     @Override
    public String textDead() {
        String Dead = new String("Zostala zjedzona guarana\n"); 
        return Dead; 
    }
}
