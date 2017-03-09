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
public class WolfBerries extends Plant{
    
    public WolfBerries(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.sign = 'j';
        this.specialColiz = true;
    }    
    
    public void SpecialColiz(Organism First){
	this.Worlds.killOrganismInWorld(First);
	this.Worlds.killOrganismInWorld(this);
	this.turn = false;
    }
    
    public String textBorn() {
        String Born = new String("Zasiane wilcze jagody\n"); 
        return Born; 
    }
    
    public String textDead() {
        String Dead = new String("Zjedzone wilcze jagody\n"); 
        return Dead; 
    }
}
