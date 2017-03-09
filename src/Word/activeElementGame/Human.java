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
public class Human extends Animal {

    private boolean skillGd;
    private boolean skill;
    private int skillTurn;

    public Human(int positionX, int positionY, World Worlds) {
        super(positionX, positionY, Worlds);
        this.skillGd = true;
        this.strength = 5;
        this.initiative = 5;
        this.sign = 'H';
        this.skill = false;
        this.skillTurn = 0;
    }

    public boolean getSkillGd() {
        return this.skillGd;
    }

    public boolean getSkill() {
        return this.skill;
    }

    public int getSkillTurn() {
        return this.skillTurn;
    }

    public void setSkillGd(boolean skillGd) {
        this.skillGd = skillGd;
    }

    public void setSkill(boolean skill) {
        this.skill = skill;
    }

    public void setSkillTurn(int skillTurn) {
        this.skillTurn = skillTurn;
    }

    public boolean skillGood() {
        if (this.skillGd) {
            return true;
        } else {
            return false;
        }
    }

    public void massDead() {
        int x = this.positionX;
        int y = this.positionY;
        if (this.moveGood(x + 1, y) && this.Worlds.checkPosition1(this, x + 1, y)) {
            this.Worlds.killOrganismInWorld(x + 1, y);
        }
        if (this.moveGood(x - 1, y) && this.Worlds.checkPosition1(this, x - 1, y)) {
            this.Worlds.killOrganismInWorld(x - 1, y);
        }
        if (this.moveGood(x + 1, y + 1) && this.Worlds.checkPosition1(this, x + 1, y + 1)) {
            this.Worlds.killOrganismInWorld(x + 1, y + 1);
        }
        if (this.moveGood(x + 1, y - 1) && this.Worlds.checkPosition1(this, x + 1, y - 1)) {
            this.Worlds.killOrganismInWorld(x + 1, y - 1);
        }
        if (this.moveGood(x - 1, y - 1) && this.Worlds.checkPosition1(this, x - 1, y - 1)) {
            this.Worlds.killOrganismInWorld(x - 1, y - 1);
        }
        if (this.moveGood(x - 1, y + 1) && this.Worlds.checkPosition1(this, x - 1, y + 1)) {
            this.Worlds.killOrganismInWorld(x - 1, y + 1);
        }
        if (this.moveGood(x, y + 1) && this.Worlds.checkPosition1(this, x, y + 1)) {
            this.Worlds.killOrganismInWorld(x, y + 1);
        }
        if (this.moveGood(x, y - 1) && this.Worlds.checkPosition1(this, x, y - 1)) {
            this.Worlds.killOrganismInWorld(x, y - 1);
        }
    }

    public void massDeadHex() {
        int x = this.positionX;
        int y = this.positionY;
        if (y % 2 != 0) {
            if (this.moveGood(x, y - 1) && this.Worlds.checkPosition1(this, x, y - 1)) {
                this.Worlds.killOrganismInWorld(x, y - 1);
            }
            if (this.moveGood(x + 1, y - 1) && this.Worlds.checkPosition1(this, x + 1, y - 1)) {
                this.Worlds.killOrganismInWorld(x + 1, y - 1);
            }
            if (this.moveGood(x + 1, y) && this.Worlds.checkPosition1(this, x + 1, y)) {
                this.Worlds.killOrganismInWorld(x + 1, y);
            }
            if (this.moveGood(x + 1, y + 1) && this.Worlds.checkPosition1(this, x + 1, y + 1)) {
                this.Worlds.killOrganismInWorld(x + 1, y + 1);
            }
            if (this.moveGood(x, y + 1) && this.Worlds.checkPosition1(this, x, y + 1)) {
                this.Worlds.killOrganismInWorld(x, y + 1);
            }
            if (this.moveGood(x - 1, y) && this.Worlds.checkPosition1(this, x - 1, y)) {
                this.Worlds.killOrganismInWorld(x - 1, y);
            }
        } else if (y % 2 == 0) {
            if (this.moveGood(x - 1, y - 1) && this.Worlds.checkPosition1(this, x - 1, y - 1)) {
                this.Worlds.killOrganismInWorld(x - 1, y - 1);
            }
            if (this.moveGood(x, y - 1) && this.Worlds.checkPosition1(this, x, y - 1)) {
                this.Worlds.killOrganismInWorld(x, y - 1);
            }
            if (this.moveGood(x + 1, y) && this.Worlds.checkPosition1(this, x + 1, y)) {
                this.Worlds.killOrganismInWorld(x + 1, y);
            }
            if (this.moveGood(x, y + 1) && this.Worlds.checkPosition1(this, x, y + 1)) {
                this.Worlds.killOrganismInWorld(x, y + 1);
            }
            if (this.moveGood(x - 1, y + 1) && this.Worlds.checkPosition1(this, x - 1, y + 1)) {
                this.Worlds.killOrganismInWorld(x - 1, y + 1);
            }
            if (this.moveGood(x - 1, y) && this.Worlds.checkPosition1(this, x - 1, y)) {
                this.Worlds.killOrganismInWorld(x - 1, y);
            }
        }
    }

    public void resSkill() {

        if (this.skill == true) {
            if (this.Worlds.getHexWorld() == true) {
                this.massDeadHex();
            } else {
                this.massDead();
            }
            this.setSkillTurn(this.getSkillTurn() - 1);
        }
        if (this.getSkillTurn() <= 0) {
            this.skill = false;
        }
        if (this.skillGd == false && this.skill == false) {
            this.setSkillTurn(this.getSkillTurn() + 1);
        }
        if (this.getSkillTurn() >= 5) {
            this.skillGd = true;
        }
    }

    public void move() {
        int x = this.positionX;
        int y = this.positionY;
        int a = this.Worlds.getHumanTurn();
        if (moveGood(x + 1, y) && (a == 'd' || a == 77)) {
            this.collision(x + 1, y);
            if (this.turn == true) {
                this.positionX = this.positionX + 1;
            }
        } else if (moveGood(x - 1, y) && (a == 'a' || a == 75)) {
            this.collision(x - 1, y);
            if (this.turn == true) {
                this.positionX = this.positionX - 1;
            }
        } else if (moveGood(x, y + 1) && (a == 's' || a == 80)) {
            this.collision(x, y + 1);
            if (this.turn == true) {
                this.positionY = this.positionY + 1;
            }
        } else if (moveGood(x, y - 1) && (a == 'w' || a == 72)) {
            this.collision(x, y - 1);
            if (this.turn == true) {
                this.positionY = this.positionY - 1;
            }
        } else if (moveGood(x, y) && a == 81 && skillGood()) {
            this.skill = true;
            this.skillGd = false;
            this.setSkillTurn(5);
            this.turn = false;
        } else {
            this.turn = false;
        }
        this.Worlds.setHumanTurn(0);
    }

    public void moveHex() {
        int x = this.positionX;
        int y = this.positionY;
        int a = this.Worlds.getHumanTurn();
        if (y % 2 != 0) {
            if (moveGood(x, y - 1) && (a == 0)) {
                this.collision(x, y - 1);
                if (this.turn == true) {
                    this.positionY = this.positionY - 1;
                }
            } else if (moveGood(x + 1, y - 1) && (a == 1)) {
                this.collision(x + 1, y - 1);
                if (this.turn == true) {
                    this.positionX = this.positionX + 1;
                    this.positionY = this.positionY - 1;
                }
            } else if (moveGood(x + 1, y) && (a == 2)) {
                this.collision(x + 1, y);
                if (this.turn == true) {
                    this.positionX = this.positionX + 1;
                }
            } else if (moveGood(x + 1, y + 1) && (a == 3)) {
                this.collision(x + 1, y + 1);
                if (this.turn == true) {
                    this.positionX = this.positionX + 1;
                    this.positionY = this.positionY + 1;
                }
            } else if (moveGood(x, y + 1) && (a == 4)) {
                this.collision(x, y + 1);
                if (this.turn == true) {
                    this.positionY = this.positionY + 1;
                }
            } else if (moveGood(x - 1, y) && (a == 5)) {
                this.collision(x - 1, y);
                if (this.turn == true) {
                    this.positionX = this.positionX - 1;
                }
            } else if (moveGood(x, y) && a == 81 && skillGood()) {
                this.skill = true;
                this.skillGd = false;
                this.setSkillTurn(5);
                this.turn = false;
            } else {
                this.turn = false;
            }
        }
        if (y % 2 == 0) {
            if (moveGood(x - 1, y - 1) && (a == 0)) {
                this.collision(x - 1, y - 1);
                if (this.turn == true) {
                    this.positionY = this.positionY - 1;
                    this.positionX = this.positionX - 1;
                }
            } else if (moveGood(x, y - 1) && (a == 1)) {
                this.collision(x, y - 1);
                if (this.turn == true) {
                    this.positionY = this.positionY - 1;
                }
            } else if (moveGood(x + 1, y) && (a == 2)) {
                this.collision(x + 1, y);
                if (this.turn == true) {
                    this.positionX = this.positionX + 1;
                }
            } else if (moveGood(x, y + 1) && (a == 3)) {
                this.collision(x, y + 1);
                if (this.turn == true) {
                    this.positionY = this.positionY + 1;
                }
            } else if (moveGood(x - 1, y + 1) && (a == 4)) {
                this.collision(x - 1, y + 1);
                if (this.turn == true) {
                    this.positionY = this.positionY + 1;
                    this.positionX = this.positionX - 1;
                }
            } else if (moveGood(x - 1, y) && (a == 5)) {
                this.collision(x - 1, y);
                if (this.turn == true) {
                    this.positionX = this.positionX - 1;
                }
            } else if (moveGood(x, y) && a == 81 && skillGood()) {
                this.skill = true;
                this.skillGd = false;
                this.setSkillTurn(5);
                this.turn = false;
            } else {
                this.turn = false;
            }

        }
        this.Worlds.setHumanTurn(100);
    }

    public void action() {
        if (this.Worlds.getHexWorld() == true) {
            this.moveHex();
        } else {
            this.move();
        }
        this.resSkill();
        this.turn = false;
    }

    public String textBorn() {
        String Born = new String("Urodzil sie nowy Czlowiek\n");
        return Born;
    }

    @Override
    public String textDead() {
        String Dead = new String("Umarl Czlowiek\n");
        return Dead;
    }
}
