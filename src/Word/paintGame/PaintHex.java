/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.paintGame;

import java.awt.Graphics;
import java.awt.Polygon;
import Word.World;

/**
 *
 * @author witold
 */
public class PaintHex extends Paint {

    public PaintHex(Size Win, World Home) {
        super(Win, Home);
    }

    public void paintAnimal(Graphics g, int x, int y) {
        int x1 = x;
        int x2 = x;
        int scale1 = 5 * this.scale / 9;
        int x3 = scale1 + x;
        int x4 = 2 * scale1 + x;
        int x5 = 2 * scale1 + x;
        int x6 = scale1 + x;
        int y1 = scale1 / 2 + y;
        int y2 = 3 * scale1 / 2 + y;
        int y3 = 2 * scale1 + y;
        int y4 = 3 * scale1 / 2 + y;
        int y5 = scale1 / 2 + y;
        int y6 = y;
        int xPoly[] = {x1, x2, x3, x4, x5, x6};
        int yPoly[] = {y1, y2, y3, y4, y5, y6};
        Polygon poly = new Polygon(xPoly, yPoly, 6);
        g.fillPolygon(poly);
    }

    public void paintPlant(Graphics g, int x, int y) {
        paintAnimal(g, x, y);
    }

    public void paintOrganism(Graphics g) {
        int I = 0;
        int J = 0;
        int scale1 = 5 * this.scale / 9;
        for (int i = 0; i < this.Win.getHigth(); i++) {
            for (int j = 0; j < this.Win.getWidth(); j++) {
                if (j % 2 == 0) {
                    I = i * 2 * scale1;
                    J = j * 3 * scale1 / 2;
                } else {
                    I = i * 2 * scale1 + scale1;
                    J = j * 3 * scale1 / 2;
                }
                if (this.Win.getChar(i, j) == 'W') {
                    paintWolf(g, I, J);
                } else if (this.Win.getChar(i, j) == 'S') {
                    paintSheep(g, I, J);
                } else if (this.Win.getChar(i, j) == 'A') {
                    paintAntelope(g, I, J);
                } else if (this.Win.getChar(i, j) == 'T') {
                    paintTurtle(g, I, J);
                } else if (this.Win.getChar(i, j) == 'F') {
                    paintFox(g, I, J);
                } else if (this.Win.getChar(i, j) == 'H') {
                    paintHuman(g, I, J);
                } else if (this.Win.getChar(i, j) == 'g') {
                    paintGuarana(g, I, J);
                } else if (this.Win.getChar(i, j) == 't') {
                    paintGrass(g, I, J);
                } else if (this.Win.getChar(i, j) == 'm') {
                    paintSowThistle(g, I, J);
                } else if (this.Win.getChar(i, j) == 'j') {
                    paintWolfBerries(g, I, J);
                } else if (this.Win.getChar(i, j) == '|') {
                    paintBorder(g, I, J);
                } else if (this.Win.getChar(i, j) == '-') {
                    paintBorder(g, I, J);
                }
            }
        }
    }

    public void paintField(Graphics g) {

        g.setColor(this.color(111, 111, 100));
        g.fillRect(0, 0, this.width * this.scale + 2 * this.scale, this.higth * this.scale * 29 / 35);
    }

}
