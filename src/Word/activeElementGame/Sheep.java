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
public class Sheep extends Animal{
    public Sheep(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.strength = 4;
	this.initiative = 4;
	this.sign = 'S';
    }
    
    public String textBorn() {
        String Born = new String("Urodzila sie nowa owca\n"); 
        return Born; 
    }
    
     @Override
    public String textDead() {
        String Dead = new String("Umarla owca\n"); 
        return Dead; 
    }
}
