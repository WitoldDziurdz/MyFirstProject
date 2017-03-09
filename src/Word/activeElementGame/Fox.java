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
public class Fox extends Animal {

    public Fox(int positionX, int positionY, World Worlds) {
        super(positionX, positionY, Worlds);
        this.strength = 4;
        this.initiative = 4;
        this.sign = 'A';
        this.specialColiz = true;
    }

    public boolean moveOk(int x, int y) {
        if (this.Worlds.checkPosition1(this, x, y)) {
            return this.Worlds.seeStrength(this, x, y);
        } else {
            return true;
        }
    }

    public void move() {  // przemieszczenei 
        int x = this.getPositionX();
        int y = this.getPositionY();
        int random = 0;
        int quit = 1;
        while (quit == 1) {
            random = (int) (Math.random() * 4);
            if (random == 0) {
                if (moveGood(x + 1, y) && moveOk(x + 1, y)) {
                    this.collision(x + 1, y);
                    if (this.turn == true) {
                        this.positionX = this.positionX + 1;
                    }
                    quit = 0;
                }
            } else if (random == 1) {
                if (moveGood(x - 1, y) && moveOk(x - 1, y)) {
                    this.collision(x - 1, y);
                    if (this.turn == true) {
                        this.positionX = this.positionX - 1;
                    }
                    quit = 0;
                }
            } else if (random == 2) {
                if (moveGood(x, y + 1) && moveOk(x, y + 1)) {
                    this.collision(x, y + 1);
                    if (this.turn == true) {
                        this.positionY = this.positionY + 1;
                    }
                    quit = 0;
                }
            } else if (random == 3) {
                if (moveGood(this.positionX, this.positionY - 1) && moveOk(this.positionX, this.positionY - 1)) {
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
                    if (moveGood(x, y - 1) && moveOk(x, y - 1)) {
                        this.collision(x, y - 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 1) { //x-1
                    if (moveGood(x + 1, y - 1) && moveOk(x + 1, y - 1)) {
                        this.collision(x + 1, y - 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (moveGood(x + 1, y) && moveOk(x + 1, y)) {
                        this.collision(x + 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (moveGood(x + 1, y + 1) && moveOk(x + 1, y + 1)) {
                        this.collision(x + 1, y + 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (moveGood(x, y + 1) && moveOk(x, y + 1)) {
                        this.collision(x, y + 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (moveGood(x - 1, y) && moveOk(x - 1, y)) {
                        this.collision(x - 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                        }
                        quit = 0;
                    }
                }
            } else if (y % 2 == 0) {
                if (random == 0) {
                    if (moveGood(x - 1, y - 1) && moveOk(x - 1, y - 1)) {
                        this.collision(x - 1, y - 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 1) { //x-1
                    if (moveGood(x, y - 1) && moveOk(x, y - 1)) {
                        this.collision(x, y - 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 1;
                        }
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (moveGood(x + 1, y) && moveOk(x + 1, y)) {
                        this.collision(x + 1, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (moveGood(x, y + 1) && moveOk(x, y + 1)) {
                        this.collision(x, y + 1);
                        if (this.turn == true) {
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (moveGood(x - 1, y + 1) && moveOk(x - 1, y + 1)) {
                        this.collision(x - 1, y + 1);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 1;
                            this.positionY = this.positionY + 1;
                        }
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (moveGood(x - 1, y) && moveOk(x - 1, y)) {
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
    public String textBorn() {
        String Born = new String("Urodzil sie nowy Lis\n");
        return Born;
    }

    @Override
    public String textDead() {
        String Dead = new String("Umarl Lis\n");
        return Dead;
    }
}
