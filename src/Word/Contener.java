/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word;

import Word.activeElementGame.Organism;
import Word.activeElementGame.Grass;
import Word.activeElementGame.Guarana;
import Word.activeElementGame.Turtle;
import Word.activeElementGame.SowThistle;
import Word.activeElementGame.WolfBerries;
import Word.activeElementGame.Wolf;
import Word.activeElementGame.Human;
import Word.activeElementGame.Sheep;
import Word.activeElementGame.Fox;
import Word.activeElementGame.Antelope;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author witold
 */
public class Contener {

    private World WorldHome;
    private int maxOrganizm;
    private String nameFile;
    private ArrayList<Organism> dataOrganism;

    public Contener(World WorldHome) {
        this.WorldHome = WorldHome;
        this.dataOrganism = new ArrayList<Organism>();
        this.nameFile = "plik.txt";
        this.maxOrganizm = (this.WorldHome.getSizeX() - 2) * (this.WorldHome.getSizeY() - 2);
        this.dataOrganism.add(new Wolf(5, 5, this.WorldHome));
        this.dataOrganism.add(new Wolf(18, 17, this.WorldHome));
        this.dataOrganism.add(new Sheep(18, 7, this.WorldHome));
        this.dataOrganism.add(new Sheep(3, 19, this.WorldHome));
        this.dataOrganism.add(new Antelope(9, 11, this.WorldHome));
        this.dataOrganism.add(new Fox(6, 6, this.WorldHome));
        this.dataOrganism.add(new Turtle(17, 11, this.WorldHome));
        this.dataOrganism.add(new Turtle(4, 14, this.WorldHome));
        this.dataOrganism.add(new Turtle(9, 9, this.WorldHome));
        this.dataOrganism.add(new Grass(10, 10, this.WorldHome));
        this.dataOrganism.add(new SowThistle(6, 16, this.WorldHome));
        this.dataOrganism.add(new WolfBerries(11, 16, this.WorldHome));
        this.dataOrganism.add(new Guarana(16, 16, this.WorldHome));
        this.dataOrganism.add(new Grass(15, 4, this.WorldHome));
        this.dataOrganism.add(new Human(11, 10, this.WorldHome));
        this.WorldHome.setQuantityOrganism(this.dataOrganism.size());
    }

    public void sortList() {
        Collections.swap(this.dataOrganism, 3, 2);
        for (int i = 0; i < this.dataOrganism.size(); i++) {
            for (int j = 1; j < this.dataOrganism.size() - i; j++) {
                if (this.dataOrganism.get(j - 1).getInitiative() < this.dataOrganism.get(j).getInitiative()) {
                    Collections.swap(this.dataOrganism, j - 1, j);
                } else if (this.dataOrganism.get(j - 1).getInitiative() == this.dataOrganism.get(j).getInitiative()) {
                    if (this.dataOrganism.get(j - 1).getAge() < this.dataOrganism.get(j).getAge()) {
                        Collections.swap(this.dataOrganism, j - 1, j);
                    }
                }
            }
        }
    }

    public int seachOrganism(Organism Organism1) {
        return this.dataOrganism.indexOf(Organism1);
    }

    public void killOrganism(Organism Loser) {
        int numer;
        numer = this.seachOrganism(Loser);
        this.WorldHome.setText(Loser.textDead());
        this.dataOrganism.remove(numer);
        this.WorldHome.setQuantityOrganism(this.WorldHome.getQuanityOrganism() - 1);
    }

    public Organism seachOrgnismPosition(int x, int y) {
        for (int i = 0; i < this.dataOrganism.size(); i++) {
            if (this.dataOrganism.get(i).getPositionX() == x && this.dataOrganism.get(i).getPositionY() == y) {
                return this.dataOrganism.get(i);
            }
        }
        return null;
    }

    public void nextRound() {
        this.sortList();
        for (int i = 0; i < this.dataOrganism.size(); i++) {
            this.dataOrganism.get(i).action();
            System.out.print(this.dataOrganism.get(i).getSign() + ":" + this.dataOrganism.get(i).getStrength());
            this.dataOrganism.get(i).draw();
        }
        System.out.println();
        for (int i = 0; i < this.dataOrganism.size(); i++) {
            this.dataOrganism.get(i).setAge(this.dataOrganism.get(i).getAge() + 1);
        }
        for (int i = 0; i < this.dataOrganism.size(); i++) {
            this.dataOrganism.get(i).setTurn(true);
        }

        this.sortList();
    }

    public Organism addNewOrganism(Organism Second, int x, int y) {
        Organism newOrganism = null;
        try {
            Constructor ctr = Second.getClass().getDeclaredConstructor(int.class, int.class, World.class);
            newOrganism = (Organism) ctr.newInstance(x, y, this.WorldHome);
            newOrganism.draw();
            newOrganism.setTurn(false);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        this.WorldHome.setText(newOrganism.textBorn());
        return newOrganism;
    }

    public Organism funkAddOrganism(Organism Second, int x, int y) {
        Organism Org = this.addNewOrganism(Second, x, y);
        this.dataOrganism.add(Org);
        this.WorldHome.setQuantityOrganism(this.WorldHome.getQuanityOrganism() + 1);
        return Org;
    }

    public void addOrganism(Organism Second) {
        Organism Org;
        int x, x1, x2 = 0;
        int y, y1, y2 = 0;
        char[][] Tab = this.WorldHome.getTabWorld();
        x = Second.getPositionX();
        y = Second.getPositionY();
        x1 = Second.getPositionX() + 1;
        y1 = Second.getPositionY() + 1;
        x2 = Second.getPositionX() - 1;
        y2 = Second.getPositionY() - 1;
        if (Tab[x][y1] == ' ') {
            Org = this.funkAddOrganism(Second, x, y1);
        } else if (Tab[x1][y] == ' ') {
            Org = this.funkAddOrganism(Second, x1, y);
        } else if (Tab[x2][y] == ' ') {
            Org = this.funkAddOrganism(Second, x2, y);
        } else if (Tab[x][y2] == ' ') {
            Org = this.funkAddOrganism(Second, x, y2);
        }
    }

    public void addOrganismHex(Organism Second) {
        Organism Org;
        int x = 0;
        int y = 0;
        char[][] Tab = this.WorldHome.getTabWorld();
        x = Second.getPositionX();
        y = Second.getPositionY();
        if (y % 2 != 0) {
            if (Tab[x][y - 1] == ' ') {
                Org = this.funkAddOrganism(Second, x, y - 1);
            } else if (Tab[x + 1][y - 1] == ' ') {
                Org = this.funkAddOrganism(Second, x + 1, y - 1);
            } else if (Tab[x + 1][y] == ' ') {
                Org = this.funkAddOrganism(Second, x + 1, y);
            } else if (Tab[x + 1][y + 1] == ' ') {
                Org = this.funkAddOrganism(Second, x + 1, y + 1);
            } else if (Tab[x][y + 1] == ' ' && this.WorldHome.getHexWorld()) {
                Org = this.funkAddOrganism(Second, x, y + 1);
            } else if (Tab[x - 1][y] == ' ' && this.WorldHome.getHexWorld()) {
                Org = this.funkAddOrganism(Second, x - 1, y);
            }
        } else if (y % 2 == 0) {
            if (Tab[x - 1][y - 1] == ' ') {
                Org = this.funkAddOrganism(Second, x - 1, y - 1);
            } else if (Tab[x][y - 1] == ' ') {
                Org = this.funkAddOrganism(Second, x, y - 1);
            } else if (Tab[x + 1][y] == ' ') {
                Org = this.funkAddOrganism(Second, x + 1, y);
            } else if (Tab[x][y + 1] == ' ') {
                Org = this.funkAddOrganism(Second, x, y + 1);
            } else if (Tab[x - 1][y + 1] == ' ' && this.WorldHome.getHexWorld()) {
                Org = this.funkAddOrganism(Second, x - 1, y + 1);
            } else if (Tab[x - 1][y] == ' ' && this.WorldHome.getHexWorld()) {
                Org = this.funkAddOrganism(Second, x - 1, y);
            }
        }
    }

    public void addOrganism(Organism Second, int x, int y) {
        Organism Org;
        int quit = 1;
        int random = 0;
        int x1, x2 = 0;
        int y1, y2 = 0;
        char[][] Tab = this.WorldHome.getTabWorld();
        x1 = x + 1;
        y1 = y + 1;
        x2 = x - 1;
        y2 = y - 1;
        while (quit == 1) {

            if (Tab[x][y1] != ' ' && Tab[x1][y] != ' ' && Tab[x2][y] != ' ' && Tab[x][y2] != ' ') {
                quit = 0;
            }
            random = (int) (Math.random() * 4);
            if (random == 0) {
                if (Tab[x][y1] == ' ') {
                    Org = this.funkAddOrganism(Second, x, y1);
                    quit = 0;
                }
            } else if (random == 1) {
                if (Tab[x1][y] == ' ') {
                    Org = this.funkAddOrganism(Second, x1, y);
                    quit = 0;
                }
            } else if (random == 2) {
                if (Tab[x2][y] == ' ') {
                    Org = this.funkAddOrganism(Second, x2, y);
                    quit = 0;
                }
            } else if (random == 3) {
                if (Tab[x][y2] == ' ') {
                    Org = this.funkAddOrganism(Second, x, y2);
                    quit = 0;
                }
            }
        }
    }

    public void addOrganismHex(Organism Second, int x, int y) {
        Organism Org;
        int quit = 1;
        int random = 0;
        char[][] Tab = this.WorldHome.getTabWorld();
        while (quit == 1) {
            random = (int) (Math.random() * 6);
            if (y % 2 != 0) {
                if (Tab[x][y - 1] != ' ' && Tab[x + 1][y - 1] != ' ' && Tab[x + 1][y] != ' '
                        && Tab[x + 1][y + 1] != ' ' && Tab[x][y + 1] != ' ' && Tab[x - 1][y] != ' ') {
                    quit = 0;
                }
                if (random == 0) {
                    if (Tab[x][y - 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x, y - 1);
                        quit = 0;
                    }
                } else if (random == 1) {
                    if (Tab[x + 1][y - 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x + 1, y - 1);
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (Tab[x + 1][y] == ' ') {
                        Org = this.funkAddOrganism(Second, x + 1, y);
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (Tab[x + 1][y + 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x + 1, y + 1);
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (Tab[x][y + 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x, y + 1);
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (Tab[x - 1][y] == ' ') {
                        Org = this.funkAddOrganism(Second, x - 1, y);
                        quit = 0;
                    }
                }

            } else if (y % 2 == 0) {
                if (Tab[x - 1][y - 1] != ' ' && Tab[x][y - 1] != ' ' && Tab[x + 1][y] != ' '
                        && Tab[x][y + 1] != ' ' && Tab[x - 1][y + 1] != ' ' && Tab[x - 1][y] != ' ') {
                    quit = 0;
                }
                if (random == 0) {
                    if (Tab[x - 1][y - 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x - 1, y - 1);
                        quit = 0;
                    }
                } else if (random == 1) {
                    if (Tab[x][y - 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x, y - 1);
                        quit = 0;
                    }
                } else if (random == 2) {
                    if (Tab[x + 1][y] == ' ') {
                        Org = this.funkAddOrganism(Second, x + 1, y);
                        quit = 0;
                    }
                } else if (random == 3) {
                    if (Tab[x][y + 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x, y + 1);
                        quit = 0;
                    }
                } else if (random == 4) {
                    if (Tab[x - 1][y + 1] == ' ') {
                        Org = this.funkAddOrganism(Second, x - 1, y + 1);
                        quit = 0;
                    }
                } else if (random == 5) {
                    if (Tab[x - 1][y] == ' ') {
                        Org = this.funkAddOrganism(Second, x - 1, y);
                        quit = 0;
                    }
                }

            }
        }
    }

    public void addOrganizm1(char sign, int x, int y, int age, int strenght) {// dodawanie dla wczytywania pliku 
        Organism b = null;
        switch (sign) {
            case 'W': {
                b = new Wolf(x, y, this.WorldHome);
                break;
            }
            case 'S': {
                b = new Sheep(x, y, this.WorldHome);
                break;
            }
            case 'F': {
                b = new Fox(x, y, this.WorldHome);
                break;
            }
            case 'T': {
                b = new Turtle(x, y, this.WorldHome);
                break;
            }
            case 'A': {
                b = new Antelope(x, y, this.WorldHome);
                break;
            }
            case 't': {
                b = new Grass(x, y, this.WorldHome);
                break;
            }
            case 'm': {
                b = new SowThistle(x, y, this.WorldHome);
                break;
            }
            case 'g': {
                b = new Guarana(x, y, this.WorldHome);
                break;
            }
            case 'j': {
                b = new WolfBerries(x, y, this.WorldHome);
                break;
            }
            case 'H': {
                b = new Human(x, y, this.WorldHome);
                break;
            }
        }
        b.setAge(age);
        b.setStrength(strenght);
        this.dataOrganism.add(b);
        this.WorldHome.setQuantityOrganism(this.WorldHome.getQuanityOrganism() + 1);
    }

    public void addOrganizm1(char sign, int x, int y) {// dodawanie dla wczytywania pliku 
        Organism b = null;
        switch (sign) {
            case 'W': {
                b = new Wolf(x, y, this.WorldHome);
                break;
            }
            case 'S': {
                b = new Sheep(x, y, this.WorldHome);
                break;
            }
            case 'F': {
                b = new Fox(x, y, this.WorldHome);
                break;
            }
            case 'T': {
                b = new Turtle(x, y, this.WorldHome);
                break;
            }
            case 'A': {
                b = new Antelope(x, y, this.WorldHome);
                break;
            }
            case 't': {
                b = new Grass(x, y, this.WorldHome);
                break;
            }
            case 'm': {
                b = new SowThistle(x, y, this.WorldHome);
                break;
            }
            case 'g': {
                b = new Guarana(x, y, this.WorldHome);
                break;
            }
            case 'j': {
                b = new WolfBerries(x, y, this.WorldHome);
                break;
            }
            case 'H': {
                b = new Human(x, y, this.WorldHome);
                break;
            }
        }
        this.dataOrganism.add(b);
        this.WorldHome.setQuantityOrganism(this.WorldHome.getQuanityOrganism() + 1);
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void saveFile() {
        File file = new File(this.nameFile);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.println(this.dataOrganism.size());
                for (int i = 0; i < this.dataOrganism.size(); i++) {
                    out.println(this.dataOrganism.get(i).getSign());
                    if (this.dataOrganism.get(i).getSign() == 'H') {
                        Human A = (Human) this.dataOrganism.get(i);
                        if (A.getSkillGd() == true) {
                            out.println(1);
                        } else {
                            out.println(0);
                        }
                        if (A.getSkill() == true) {
                            out.println(1);
                        } else {
                            out.println(0);
                        }
                        out.println(A.getSkillTurn());
                    }
                    out.println(this.dataOrganism.get(i).getPositionX());
                    out.println(this.dataOrganism.get(i).getPositionY());
                    out.println(this.dataOrganism.get(i).getAge());
                    out.println(this.dataOrganism.get(i).getStrength());

                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFile() throws FileNotFoundException, MyException {
        this.dataOrganism.clear();
        this.WorldHome.setQuantityOrganism(0);
        Human A;
        char sign = 'S';
        int x;
        int y;
        int age;
        int strenght;
        int a = 0;
        boolean skillGd = true;
        boolean skill = true;
        int skillTurn = 0;
        String bufor;
        File file = new File(this.nameFile);
        try {
            if (file == null) {
                throw new MyException("plik nie zostal znaleziony");
            }
            Scanner fw = new Scanner(file);
            bufor = fw.nextLine();
            a = Integer.parseInt(bufor);
            System.out.print(a);
            System.out.println();
            for (int i = 0; i < a; i++) {
                bufor = fw.nextLine();
                sign = bufor.charAt(0);
                if ("H".equals(bufor)) {
                    bufor = fw.nextLine();
                    if ("1".equals(bufor)) {
                        skillGd = true;
                    } else {
                        skillGd = false;
                    }
                    bufor = fw.nextLine();
                    if ("1".equals(bufor)) {
                        skill = true;
                    } else {
                        skill = false;
                    }

                    bufor = fw.nextLine();
                    skillTurn = Integer.parseInt(bufor);
                }
                bufor = fw.nextLine();
                x = Integer.parseInt(bufor);
                bufor = fw.nextLine();
                y = Integer.parseInt(bufor);
                bufor = fw.nextLine();
                age = Integer.parseInt(bufor);
                bufor = fw.nextLine();
                strenght = Integer.parseInt(bufor);
                addOrganizm1(sign, x, y, age, strenght);
                if (sign == 'H') {
                    A = (Human) this.dataOrganism.get(i);
                    A.setSkill(skill);
                    A.setSkillGd(skillGd);
                    A.setSkillTurn(skillTurn);
                }
                System.out.println(sign);
                System.out.println(x);
                System.out.println(y);
                System.out.println(age);
                System.out.println(strenght);
                System.out.println(skillGd);
                System.out.println(skill);
                System.out.println(skillTurn);
            }

            fw.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
