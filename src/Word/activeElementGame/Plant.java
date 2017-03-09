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
public abstract class Plant extends Organism {

    public Plant(int positionX, int positionY, World Worlds) {
        super(positionX, positionY, Worlds);
        this.strength = 0;
        this.initiative = 0;
    }

    public abstract String textBorn();

    public abstract String textDead();

    @Override
    public boolean moveGood(int b, int a) {
        return true;
    }

    @Override
    public void collision(int x, int y) {
    }

    @Override
    public void move() {
    }

    public void addPlantAction(int x, int y) {
        this.Worlds.addPlant(this, x, y);
    }

    public void action() {
        int random = 0;
        int x = this.getPositionX();
        int y = this.getPositionY();
        if (this.turn == true) {
            random = (int) (Math.random() * 50);
            if (random == 49) { // tylko 2% procenty bo bardzo szybko sie mnoza przy wiekszych 
                addPlantAction(x, y); // dodawanie
            }
        }
        this.turn = false;
    }

    @Override
    public void SpecialColiz(Organism First) {
    }

    @Override
    public void draw() {
        this.Worlds.setTabWorld(this.positionX, this.positionY, this.sign);
    }

}
