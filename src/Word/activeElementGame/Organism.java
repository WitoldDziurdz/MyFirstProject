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
public abstract class Organism {
    protected boolean specialColiz;
    protected boolean turn;
    protected World Worlds;
    protected char sign;
    protected int age;
    protected int strength;
    protected int initiative;
    protected int positionX;
    protected int positionY;
    
    public Organism(int positionX, int positionY, World Worlds) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.Worlds = Worlds;
        this.age = 0;
        this.turn = true;
	this.specialColiz = false;
    }
    
    public abstract void move(); 
    public abstract boolean moveGood(int a, int b); 
    public abstract void SpecialColiz(Organism First);
    public abstract void action(); 
    public abstract void collision(int x, int y);
    public abstract void draw(); 
    public abstract String textBorn(); 
    public abstract String textDead(); 
    
    public char getSign(){ 
	return this.sign;
    }
    
    public int getAge(){
	return this.age;
    }
    
    public int getInitiative() {
	return this.initiative;
    }
    
    public int getStrength(){
	return this.strength;
    }
    
    public int getPositionX(){
	return this.positionX;
    }
    
    public int getPositionY() {
	return this.positionY;
    }
    
    public boolean getSpecialColiz() {
	return this.specialColiz;
    }
    
    
    public void setPositionX(int positionX) {
	this.positionX = positionX;
    }
    
    public void setPositionY(int positionY) {
	this.positionY = positionY;
    }
    
    public void setAge(int age) {
	this.age = age;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public boolean getTurn() {
	return this.turn;
    }
    
    public void setTurn(boolean turn) {
	this.turn = turn;
    }
}
