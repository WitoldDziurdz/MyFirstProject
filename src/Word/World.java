/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word;

import Word.paintGame.SimpleWindow;
import Word.activeElementGame.Organism;
import Word.activeElementGame.Human;

import java.io.FileNotFoundException;

/**
 *
 * @author witold
 */
public class World {

    private int sizeX;
    private int sizeY;
    private int scale;
    private int quantityOrganism;
    private char[][] tabWorld;
    private Contener ContOrganism;
    private SimpleWindow Window;
    private int humanTurn;
    private boolean hexWorld;

    public World(int sizeX, int sizeY, int scale) {
        this.hexWorld = false;
        this.quantityOrganism = 0;
        this.scale = scale;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tabWorld = new char[this.sizeY][this.sizeX];
        for (int i = 0; i < this.sizeY; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                tabWorld[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.sizeY; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                this.tabWorld[0][j] = '-';
                this.tabWorld[this.sizeY - 1][j] = '-';
                this.tabWorld[i][0] = '|';
                this.tabWorld[i][this.sizeX - 1] = '|';
            }
        }
        this.Window = new SimpleWindow(this.tabWorld, this.scale, this.sizeX, this.sizeY, this);
    }

    public SimpleWindow getSimpleWindow() {
        return this.Window;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public int getQuanityOrganism() {
        return this.quantityOrganism;
    }

    public char[][] getTabWorld() {
        return this.tabWorld;
    }

    public int getHumanTurn() {
        return this.humanTurn;
    }

    public boolean getCharGood(int x, int y) {
        char a = this.tabWorld[y][x];
        if (x < sizeX && y < sizeY) {
            if (a == ' ') {
                return true;
            }
            return false;
        }
        return false;
    }

    public void setHexWorld(boolean hexWorld) {
        this.hexWorld = hexWorld;
    }

    public boolean getHexWorld() {
        return this.hexWorld;
    }

    public void setTabWorld(int x, int y, char sing) {
        this.tabWorld[y][x] = sing;
    }

    public void setFieldWorld() {
        this.Window.setField(this.tabWorld);
    }

    public void setQuantityOrganism(int quantityOrganism) {   // set na ilosc organizmow 
        this.quantityOrganism = quantityOrganism;
    }

    public void setHumanTurn(int turn) {
        this.humanTurn = turn;
    }

    public void conectionContener(Contener a) {
        this.ContOrganism = a;
    }

    public void clearWorld() {
        for (int i = 0; i < this.sizeY; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                this.tabWorld[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.sizeY - 1; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                tabWorld[0][j] = '-';
                tabWorld[this.sizeY - 1][j] = '-';
                tabWorld[i][0] = '|';
                tabWorld[i][this.sizeX - 1] = '|';
            }
        }
    }

    public void nextRound() {
        this.Window.clearText();
        this.clearWorld();
        this.ContOrganism.nextRound();
        this.visiable();
    }

    public void killOrganismInWorld(Organism First) {
        this.ContOrganism.killOrganism(First);
    }

    public void killOrganismInWorld(int x, int y) {
        Organism Second = this.ContOrganism.seachOrgnismPosition(x, y);
        this.ContOrganism.killOrganism(Second);
    }

    public void battleOrganism(Organism First, Organism Second) {
        if (First.getTurn()) {
            if (First.getStrength() >= Second.getStrength()) {
                this.ContOrganism.killOrganism(Second);
            } else {
                this.ContOrganism.killOrganism(First);
            }
        }
    }

    public void addPlant(Organism Second, int x, int y) {
        if (this.hexWorld == true) {
            this.ContOrganism.addOrganismHex(Second, x, y);
        } else {
            this.ContOrganism.addOrganismHex(Second, x, y);
        }
    }

    public void colision(Organism First, int x, int y) {
        int x1, y1;
        x1 = First.getPositionX();
        y1 = First.getPositionY();
        if (this.ContOrganism.seachOrgnismPosition(x, y) != null) {
            Organism Second = this.ContOrganism.seachOrgnismPosition(x, y);
            if (First.getClass() == Second.getClass() && First.getClass() != Human.class) {
                if (this.getHexWorld() == true) {
                    this.ContOrganism.addOrganismHex(Second);
                } else {
                    this.ContOrganism.addOrganism(Second);
                }
                Second.setTurn(false);
                First.setTurn(false);
            } else {
                Second.SpecialColiz(First);
                if (this.ContOrganism.seachOrgnismPosition(x1, y1) != null && First.getTurn() == true) {
                    this.battleOrganism(First, Second);
                }
            }
        }
    }

    public boolean seeStrength(Organism First, int x, int y) {
        Organism Second = this.ContOrganism.seachOrgnismPosition(x, y);
        if (Second.getStrength() > First.getStrength()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkPosition1(Organism First, int x, int y) { // sprawdzania  czy jest na pozycji organizm przydatne dla fox
        if (this.ContOrganism.seachOrgnismPosition(x, y) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void visiable() {
        this.setFieldWorld();
        this.Window.visiable();
    }

    public void saveFile() {
        this.ContOrganism.saveFile();
        this.humanTurn = 0;
    }

    public void loadFile() throws FileNotFoundException, MyException {
        this.ContOrganism.loadFile();
        this.humanTurn = 0;
    }

    public void addOrganism(char sign, int x, int y) {
        this.ContOrganism.addOrganizm1(sign, x, y);
    }

    public void setText(String text) {
        this.Window.setText(text);
    }
}
