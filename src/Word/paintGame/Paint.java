/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.paintGame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import Word.World;

/**
 *
 * @author witold
 */
public class Paint extends JPanel {

    protected int scale;
    protected int width;
    protected int higth;
    protected Size Win;
    protected World Home;

    public Paint(Size Win, World Home) {
        this.Home = Home;
        this.Win = Win;
        this.scale = this.Win.getScale();
        this.width = this.Win.getWidth();
        this.higth = this.Win.getHigth();
        /*this.Key = new Control(Home); 
        this.addKeyListener(new Control(Home));*/
    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public void setWorld(World Home) {
        this.Home = Home;
    }

    public void paintAnimal(Graphics g, int x, int y) {
        g.fillRect(x * this.scale + this.scale, y * this.scale + this.scale, this.scale, this.scale);
    }

    public void paintPlant(Graphics g, int x, int y) {
        g.fillOval(x * this.scale + this.scale, y * this.scale + this.scale, this.scale, this.scale);
    }

    public void paintWolf(Graphics g, int x, int y) {
        g.setColor(this.color(47, 79, 79));
        paintAnimal(g, x, y);
    }

    public void paintSheep(Graphics g, int x, int y) {
        g.setColor(this.color(25, 25, 112));
        paintAnimal(g, x, y);
    }

    public void paintAntelope(Graphics g, int x, int y) {
        g.setColor(this.color(139, 69, 19));
        paintAnimal(g, x, y);
    }

    public void paintTurtle(Graphics g, int x, int y) {
        g.setColor(this.color(160, 32, 240));
        paintAnimal(g, x, y);
    }

    public void paintFox(Graphics g, int x, int y) {
        g.setColor(this.color(255, 215, 0));
        paintAnimal(g, x, y);
    }

    public void paintGrass(Graphics g, int x, int y) {
        g.setColor(this.color(0, 100, 0));
        paintPlant(g, x, y);
    }

    public void paintSowThistle(Graphics g, int x, int y) {
        g.setColor(this.color(124, 252, 0));
        paintPlant(g, x, y);
    }

    public void paintGuarana(Graphics g, int x, int y) {
        g.setColor(this.color(240, 255, 240));
        paintPlant(g, x, y);
    }

    public void paintWolfBerries(Graphics g, int x, int y) {
        g.setColor(this.color(238, 130, 238));
        paintPlant(g, x, y);
    }

    public void paintBorder(Graphics g, int x, int y) {
        g.setColor(this.color(45, 15, 15));
        paintAnimal(g, x, y);
    }

    public void paintHuman(Graphics g, int x, int y) {
        g.setColor(this.color(0, 15, 15));
        paintAnimal(g, x, y);
    }

    public void paintOrganism(Graphics g) {
        for (int i = 0; i < this.Win.getHigth(); i++) {
            for (int j = 0; j < this.Win.getWidth(); j++) {
                if (this.Win.getChar(i, j) == 'W') {
                    paintWolf(g, i, j);
                } else if (this.Win.getChar(i, j) == 'S') {
                    paintSheep(g, i, j);
                } else if (this.Win.getChar(i, j) == 'A') {
                    paintAntelope(g, i, j);
                } else if (this.Win.getChar(i, j) == 'T') {
                    paintTurtle(g, i, j);
                } else if (this.Win.getChar(i, j) == 'F') {
                    paintFox(g, i, j);
                } else if (this.Win.getChar(i, j) == 'H') {
                    paintHuman(g, i, j);
                } else if (this.Win.getChar(i, j) == 'g') {
                    paintGuarana(g, i, j);
                } else if (this.Win.getChar(i, j) == 't') {
                    paintGrass(g, i, j);
                } else if (this.Win.getChar(i, j) == 'm') {
                    paintSowThistle(g, i, j);
                } else if (this.Win.getChar(i, j) == 'j') {
                    paintWolfBerries(g, i, j);
                } else if (this.Win.getChar(i, j) == '|') {
                    paintBorder(g, i, j);
                } else if (this.Win.getChar(i, j) == '-') {
                    paintBorder(g, i, j);
                }
            }
        }
    }

    public void paintField(Graphics g) {
        g.setColor(this.color(75, 15, 15));
        g.fillRect(0, 0, this.width * this.scale + 2 * this.scale, this.higth * this.scale + 2 * this.scale);
        g.setColor(this.color(150, 15, 15));
        g.fillRect(scale, scale, this.width * this.scale + 1, this.higth * this.scale + 1);
        g.setColor(this.color(45, 15, 15));
        for (int x = scale; x <= this.width * this.scale + this.scale; x += this.scale) {
            g.drawLine(x, scale, x, this.higth * this.scale + this.scale);
        }
        for (int y = scale; y <= this.higth * this.scale + this.scale; y += this.scale) {
            g.drawLine(scale, y, this.width * this.scale + this.scale, y);
        }
    }

    @Override
    public void paint(Graphics g) {
        paintField(g);
        paintOrganism(g);

    }
}
