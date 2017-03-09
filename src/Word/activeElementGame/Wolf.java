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
public class Wolf extends Animal{
    public Wolf(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.strength = 9;
	this.initiative = 5;
	this.sign = 'W';
    }
    
       @Override
    public String textBorn() {
        String Born = new String("Urodzil sie nowy Wilk\n"); 
        return Born; 
    }
    
     @Override
    public String textDead() {
        String Dead = new String("Umarl Wilk\n"); 
        return Dead; 
    }
}
