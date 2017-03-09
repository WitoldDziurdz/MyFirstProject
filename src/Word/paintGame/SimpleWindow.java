/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.paintGame;

/**
 *
 * @author witold
 */
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

import Word.controlGame.Control;
import Word.controlGame.ControlButton1;
import Word.controlGame.ControlButton2;
import Word.controlGame.ControlButton3;
import Word.controlGame.MouseControl;
import Word.World;
import Word.controlGame.ControlButton4;

public class SimpleWindow {

    //возможно понадобиться ссылка на контейнер или мир 
    private Paint Graf;
    private PaintHex GrafHex;
    private Size Win;
    private JFrame Window;
    private World Home;
    /*private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton Button;*/
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private JList list;
    private JTextArea Text;

    public SimpleWindow(char[][] field, int scale, int width, int higth, World Home) {
        this.Window = new JFrame();
        this.Window.setLayout(null);
        this.Home = Home;
        this.Win = new Size(field, scale, width, higth);
        int widthWin = this.Win.getScale() * this.Win.getWidth() + 2 * this.Win.getScale() + 20;
        int higthWin = this.Win.getScale() * this.Win.getHigth() + 2 * this.Win.getScale();

        this.Text = new JTextArea(11, 1);
        this.Text.setBounds(widthWin + 200, 10, 160, higthWin / 2);
        this.Window.add(Text);

        this.Graf = new Paint(this.Win, Home);
        this.Graf.setBounds(0, 0, higthWin, widthWin);
        this.Window.add(Graf);

        this.Button1 = new JButton("Next turn");
        this.Button1.setBounds(widthWin, 6 * this.Win.getScale(), 140, this.Win.getScale());
        this.Button1.addActionListener(new ControlButton1(this, this.Home));
        this.Button1.addKeyListener(new Control(Home));

        this.Button2 = new JButton("Save Game");
        this.Button2.setBounds(widthWin, 7 * this.Win.getScale(), 140, this.Win.getScale());
        this.Button2.addActionListener(new ControlButton2(this, this.Home));
        this.Button2.addKeyListener(new Control(Home));

        this.Button3 = new JButton("Load Game");
        this.Button3.setBounds(widthWin, 8 * this.Win.getScale(), 140, this.Win.getScale());
        this.Button3.addActionListener(new ControlButton3(this, this.Home));
        this.Button3.addKeyListener(new Control(Home));

        this.Button4 = new JButton("HexGame");
        this.Button4.setBounds(widthWin, 9 * this.Win.getScale(), 140, this.Win.getScale());
        this.Button4.addActionListener(new ControlButton4(this, this.Home));
        this.Button4.addKeyListener(new Control(Home));

        /*this.Button = new JButton("Dodaj Organizm");
        this.Button.setBounds(widthWin, 7 * this.Win.getScale(), 140, 60);
        this.Button.addActionListener(new ControlButton(this));
        this.Button.addKeyListener(new Control(Home));*/
 /*JLabel A1 = new JLabel("Wspolrzedne X:");
        A1.setBounds(widthWin, 0, 140, 60);
        this.textField1 = new JTextField(10);
        this.textField1.setBounds(widthWin, 1 * this.Win.getScale() + this.Win.getScale() / 2, 140, 20);

        JLabel A2 = new JLabel("Wspolrzedne Y:");
        A2.setBounds(widthWin, 2 * this.Win.getScale(), 140, 60);
        this.textField2 = new JTextField(10);
        this.textField2.setBounds(widthWin, 3 * this.Win.getScale() + this.Win.getScale() / 2, 140, 20);

        JLabel A3 = new JLabel("Nazwa organizmu:");
        A3.setBounds(widthWin, 4 * this.Win.getScale(), 140, 60);
        this.textField3 = new JTextField(10);
        this.textField3.setBounds(widthWin, 5 * this.Win.getScale() + this.Win.getScale() / 2, 140, 20);*/
        PanelLegend Legend = new PanelLegend(this.Win, Home);
        Legend.setBounds(widthWin, 8 * this.Win.getScale(), 200, 400);

        this.Window.addMouseListener(new MouseControl(this, Win, Home));

        this.Window.add(Legend);
        /*this.Window.add(A1);
        this.Window.add(A2);
        this.Window.add(A3)
        this.Window.add(Button);
        this.Window.add(textField1);
        this.Window.add(textField2);
        this.Window.add(textField3);*/
        this.Window.add(Button1);
        this.Window.add(Button2);
        this.Window.add(Button3);
        this.Window.add(Button4);
        this.Window.addKeyListener(new Control(Home));
        String[] data = {"Wilk", "Owca", "Antylopa", "Zolw", "Lis",
            "Guarana", "Trawa", "Mlecz", "Wilcze jagody",};
        list = new JList(data);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBounds(widthWin, 10, 140, 160);
        list.addKeyListener(new Control(Home));
        this.Window.add(list);
    }

    public void setText(String Text) {
        this.Text.append(Text);
    }

    public void clearText() {
        this.Text.setText(null);
    }

    public void addOrganism() {
        /*
        String a1 = textField1.getText();
        int x = Integer.parseInt(a1);
        textField1.setText(null);
        String a2 = textField2.getText();
        int y = Integer.parseInt(a2);
        textField2.setText(null);
        String a3 = textField3.getText();
        char sign = a3.charAt(0);
        textField3.setText(null);
        this.Home.addOrganism(sign, x, y);*/
    }

    private char cheakOrganism(String A) {
        char a = 0;
        if ("[Wilk]".equals(A)) {
            a = 'W';
        } else if ("[Owca]".equals(A)) {
            a = 'S';
        } else if ("[Antylopa]".equals(A)) {
            a = 'A';
        } else if ("[Zolw]".equals(A)) {
            a = 'T';
        } else if ("[Lis]".equals(A)) {
            a = 'F';
        } else if ("[Guarana]".equals(A)) {
            a = 'g';
        } else if ("[Trawa]".equals(A)) {
            a = 't';
        } else if ("[Mlecz]".equals(A)) {
            a = 'm';
        } else if ("[Wilcze jagody]".equals(A)) {
            a = 'j';
        }
        return a;
    }

    public void setHexWorld() {
        int widthWin = this.Win.getScale() * this.Win.getWidth() + 2 * this.Win.getScale() + 20;
        int higthWin = this.Win.getScale() * this.Win.getHigth() + 2 * this.Win.getScale();
        this.Window.remove(Graf);
        this.GrafHex = new PaintHex(this.Win, Home);
        this.GrafHex.setBounds(0, 0, higthWin, widthWin);
        this.Window.add(GrafHex);
    }

    public void setNormalWorld() {
        int widthWin = this.Win.getScale() * this.Win.getWidth() + 2 * this.Win.getScale() + 20;
        int higthWin = this.Win.getScale() * this.Win.getHigth() + 2 * this.Win.getScale();
        this.Window.remove(GrafHex);
        this.Graf = new Paint(this.Win, Home);
        this.Graf.setBounds(0, 0, higthWin, widthWin);
        this.Window.add(Graf);
    }

    public void addOrganismMouse(int x, int y) {
        char sign = 0;
        List element = this.list.getSelectedValuesList();
        String A = element.toString();
        sign = cheakOrganism(A);
        if (sign != 0) {
            if (this.Home.getCharGood(x, y)) {
                this.Home.addOrganism(sign, x, y);
            }
        }
        this.list.clearSelection();
    }

    public void setField(char[][] field) {
        this.Win.setField(field);
    }

    public void visiable() {
        int widthWin = this.Win.getScale() * this.Win.getWidth() + 2 * this.Win.getScale() + 200 + 200;
        int higthWin = this.Win.getScale() * this.Win.getHigth() + 2 * this.Win.getScale();
        this.Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.Window.setResizable(false);
        this.Window.setSize(widthWin, higthWin);
        this.Window.setLocationRelativeTo(null);
        this.Window.setVisible(true);
        this.Window.setFocusable(true);
    }
}
