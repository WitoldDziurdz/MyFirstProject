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
public class Antelope extends Animal {

    public Antelope(int positionX, int positionY, World Worlds) {
        super(positionX, positionY, Worlds);
        this.strength = 4;
        this.initiative = 4;
        this.sign = 'A';
        this.specialColiz = true;
    }

    public void move() {  // przemieszczenei 
        int x = this.getPositionX();
        int y = this.getPositionY();
        int random = 0;
        int quit = 1;
        while (quit == 1) {
            random = (int) (Math.random() * 4);
            if (random == 0) {
                if (moveGood(this.positionX + 1, this.positionY) && moveGood(this.positionX + 2, this.positionY)) {
                    this.collision(x + 2, y);
                    if (this.turn == true) {
                        this.positionX = this.positionX + 2;
                    }
                    quit = 0;
                }
            } else if (random == 1) {
                if (moveGood(this.positionX - 1, this.positionY) && moveGood(this.positionX - 2, this.positionY)) {
                    this.collision(x - 2, y);
                    if (this.turn == true) {
                        this.positionX = this.positionX - 2;
                    }
                    quit = 0;
                }
            } else if (random == 2) {
                if (moveGood(this.positionX, this.positionY + 1) && moveGood(this.positionX, this.positionY + 2)) {
                    this.collision(x, y + 2);
                    if (this.turn == true) {
                        this.positionY = this.positionY + 2;
                    }
                    quit = 0;
                }
            } else if (random == 3) {
                if (moveGood(this.positionX, this.positionY - 1) && moveGood(this.positionX, this.positionY - 2)) {
                    this.collision(x, y - 2);
                    if (this.turn == true) {
                        this.positionY = this.positionY - 2;
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
                    if (moveGood(this.positionX, this.positionY - 1) && moveGood(this.positionX, this.positionY - 2)) {
                        this.collision(x, y - 2);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 2;
                        }
                        quit = 0;
                    }
                } else if (random == 1) {
                    if (moveGood(this.positionX + 1, this.positionY - 1) && moveGood(this.positionX + 2, this.positionY - 2)) {
                        this.collision(x + 2, y - 2);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 2;
                            this.positionY = this.positionY - 2;
                        }
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (moveGood(this.positionX + 1, this.positionY) && moveGood(this.positionX + 2, this.positionY)) {
                        this.collision(x + 2, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 2;
                        }
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (moveGood(this.positionX + 1, this.positionY + 1) && moveGood(this.positionX + 2, this.positionY + 2)) {
                        this.collision(x + 2, y + 2);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 2;
                            this.positionY = this.positionY + 2;
                        }
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (moveGood(this.positionX, this.positionY + 1) && moveGood(this.positionX, this.positionY + 2)) {
                        this.collision(x, y + 2);
                        if (this.turn == true) {
                            this.positionY = this.positionY + 2;
                        }
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (moveGood(this.positionX - 1, this.positionY) && moveGood(this.positionX - 2, this.positionY)) {
                        this.collision(x - 2, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 2;
                        }
                        quit = 0;
                    }
                }
            } else if (y % 2 == 0) {
                if (random == 0) {
                    if (moveGood(this.positionX - 1, this.positionY - 1) && moveGood(this.positionX - 2, this.positionY - 2)) {
                        this.collision(x - 2, y - 2);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 2;
                            this.positionX = this.positionX - 2;
                        }
                        quit = 0;
                    }
                } else if (random == 1) {
                    if (moveGood(this.positionX, this.positionY - 1) && moveGood(this.positionX, this.positionY - 2)) {
                        this.collision(x, y - 2);
                        if (this.turn == true) {
                            this.positionY = this.positionY - 2;
                        }
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (moveGood(this.positionX + 1, this.positionY) && moveGood(this.positionX + 2, this.positionY)) {
                        this.collision(x + 2, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX + 2;
                        }
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (moveGood(this.positionX, this.positionY + 1) && moveGood(this.positionX, this.positionY + 2)) {
                        this.collision(x, y + 2);
                        if (this.turn == true) {
                            this.positionY = this.positionY + 2;
                        }
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (moveGood(this.positionX - 1, this.positionY + 1) && moveGood(this.positionX - 2, this.positionY + 2)) {
                        this.collision(x - 2, y + 2);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 2;
                            this.positionY = this.positionY + 2;
                        }
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (moveGood(this.positionX - 1, this.positionY) && moveGood(this.positionX - 2, this.positionY)) {
                        this.collision(x - 2, y);
                        if (this.turn == true) {
                            this.positionX = this.positionX - 2;
                        }
                        quit = 0;
                    }
                }
            }
        }
    }

    public void SpecialColiz(Organism First) {
        int random = 0;
        random = (int) (Math.random() * 2);
        if (random == 1) {
            if (this.Worlds.getHexWorld() == true) {
                super.moveHex();
            } else {
                super.move();
            }
            First.setTurn(false);
        }
    }

    public String textBorn() {
        String Born = new String("Urodzila sie nowa Antylopa\n");
        return Born;
    }

    public String textDead() {
        String Dead = new String("Umarla Antylopa\n");
        return Dead;
    }
}
