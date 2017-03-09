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
public abstract class Animal extends Organism {

    public Animal(int positionX, int positionY, World Worlds) {
        super(positionX, positionY, Worlds);
    }

    public abstract String textBorn();

    public abstract String textDead();

    @Override
    public boolean moveGood(int b, int a) {
        char[][] Tab = this.Worlds.getTabWorld();
        if (Tab[a][b] == '|' || Tab[a][b] == '-') {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void collision(int x, int y) {
        this.Worlds.colision(this, x, y);
    }

    public void move() {  // przemieszczenei 
        int x = this.getPositionX();
        int y = this.getPositionY();
        int random = 0;
        int quit = 1;
        while (quit == 1) {
            random = (int) (Math.random() * 4);
            if (random == 0) {
                if (moveGood(this.positionX + 1, this.positionY)) {
                    this.collision(x + 1, y);
                    if (this.turn == true) {
                        this.positionX = this.positionX + 1;
                    }
                    quit = 0;
                }
            } else if (random == 1) { //x-1
                if (moveGood(this.positionX - 1, this.positionY)) {
                    this.collision(x - 1, y);
                    if (this.turn == true) {
                        this.positionX = this.positionX - 1;
                    }
                    quit = 0;
                }
            } else if (random == 2) {
                if (moveGood(this.positionX, this.positionY + 1)) {
                    this.collision(x, y + 1);
                    if (this.turn == true) {
                        this.positionY = this.positionY + 1;
                    }
                    quit = 0;
                }
            } else if (random == 3) {
                if (moveGood(this.positionX, this.positionY - 1)) {
                    this.collision(x, y - 1);
                    if (this.turn == true) {
                        this.positionY = this.positionY - 1;
                    }
                    quit = 0;
                }
            }
        }
    }

    public void moveHex() {  // przemieszczenei 
        int x = this.getPositionX();
        int y = this.getPositionY();
        int random = 0;
        int quit = 1;
        while (quit == 1) {
            random = (int) (Math.random() * 6);

            if (y % 2 != 0) {
                if (random == 0) {
                    if (moveGood(this.positionX, this.positionY - 1)) {
                        this.collision(x, y - 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 1) { //x-1
                    if (moveGood(this.positionX + 1, this.positionY - 1)) {
                        this.collision(x + 1, y - 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (moveGood(this.positionX + 1, this.positionY)) {
                        this.collision(x + 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (moveGood(this.positionX + 1, this.positionY + 1)) {
                        this.collision(x + 1, y + 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (moveGood(this.positionX, this.positionY + 1)) {
                        this.collision(x, y + 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (moveGood(this.positionX - 1, this.positionY)) {
                        this.collision(x - 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                        }
                        quit = 0;
                    }
                }
            } else if (y % 2 == 0) {
                if (random == 0) {
                    if (moveGood(this.positionX - 1, this.positionY - 1)) {
                        this.collision(x - 1, y - 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 1) { //x-1
                    if (moveGood(this.positionX, this.positionY - 1)) {
                        this.collision(x, y - 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (moveGood(this.positionX + 1, this.positionY)) {
                        this.collision(x + 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (moveGood(this.positionX, this.positionY + 1)) {
                        this.collision(x, y + 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (moveGood(this.positionX - 1, this.positionY + 1)) {
                        this.collision(x - 1, y + 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (moveGood(this.positionX - 1, this.positionY)) {
                        this.collision(x - 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                        }
                        quit = 0;
                    }
                }
            }
        }
    }

    @Override
    public void action() {  // akcja - kontrol przenieszczynia 
        if (this.Worlds.getHexWorld() == true) {
            this.moveHex();
        } else {
            this.move();
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
