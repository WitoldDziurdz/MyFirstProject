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
public class Turtle extends Animal{
    
    public Turtle(int positionX, int positionY, World Worlds){
	super(positionX, positionY, Worlds);
	this.strength = 2;
	this.initiative = 1;
	this.sign = 'T';
        this.specialColiz = true;
    }
    
    public boolean moveTrue(){
        int a = (int)(Math.random()*4);
	if (a == 3) return true;
	else return false;
    }
    
    public void action(){ // проверить что мне эта функция не нравится!!!!!
        if (moveTrue()) {
	    super.action();
        }
	this.turn = false;
    }
    
    public void SpecialColiz(Organism First){
        if(First.getStrength()<5){
            First.setTurn(false);
        }
    }
    
         @Override
    public String textBorn() {
        String Born = new String("Urodzil sie nowy Zolw\n"); 
        return Born; 
    }
    
     @Override
    public String textDead() {
        String Dead = new String("Umarl Zolw\n"); 
        return Dead; 
    }
    
}
