/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.paintGame;

import java.awt.Graphics;

import Word.World;

/**
 *
 * @author witold
 */
public class PanelLegend extends Paint {

    public PanelLegend(Size Win, World Home) {
        super(Win, Home);
    }

    public void paintOrganism(Graphics g) {
        int x = -1;
        int y = 1;
        paintWolf(g, x, y);
        g.drawString("- Wilk(W)", x * this.scale + 70, y * 2 * this.scale + 15);
        paintSheep(g, x, y + 1);
        g.drawString("- Owca(S)", x * this.scale + 70, y * 2 * this.scale + this.scale + 15);
        paintAntelope(g, x, y + 2);
        g.drawString("- Antylopa(A)", x * this.scale + 70, y * 2 * this.scale + 2 * this.scale + 15);
        paintTurtle(g, x, y + 3);
        g.drawString("- Zolw(T)", x * this.scale + 70, y * 2 * this.scale + 3 * this.scale + 15);
        paintFox(g, x, y + 4);
        g.drawString("- Lis(F)", x * this.scale + 70, y * 2 * this.scale + 4 * this.scale + 15);
        paintHuman(g, x, y + 5);
        g.drawString("- Czlowiek()", x * this.scale + 70, y * 2 * this.scale + 5 * this.scale + 15);
        paintGuarana(g, x, y + 6);
        g.drawString("- Guarana(g)", x * this.scale + 70, y * 2 * this.scale + 6 * this.scale + 15);
        paintGrass(g, x, y + 7);
        g.drawString("- Trawa(t)", x * this.scale + 70, y * 2 * this.scale + 7 * this.scale + 15);
        paintSowThistle(g, x, y + 8);
        g.drawString("- Mlecz(m)", x * this.scale + 70, y * 2 * this.scale + 8 * this.scale + 15);
        paintWolfBerries(g, x, y + 9);
        g.drawString("- Wilcze jagody(j)", x * this.scale + 70, y * 2 * this.scale + 9 * this.scale + 15);
    }

    @Override
    public void paint(Graphics g) {
        paintOrganism(g);
    }

}
