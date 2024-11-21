package fr.mrl;

import java.util.Scanner;
import java.util.Random;

public class Player {
    Scanner scanner = new Scanner(System.in);

    private String name = "";
    private int force;
    private int agility;
    private int pv;

    public Player() {

        while (name ==  "") {
            System.out.print(" -Your name ");
            this.name = scanner.nextLine();
        }
        while (force < 1) {
            try {
                System.out.print(" -Your force ");
                this.force = scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
        }

        while (agility < 1) {
            try {
                System.out.print(" -Your agility ");
                this.agility = scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
        }
        while (pv < 1) {
            try {
                System.out.print(" -Your Pv ");
                this.pv = scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
        }
        System.err.println();
    }

    public String getName() {
        return name;
    }

    public int getForce() {
        return force;
    }

    public int getAgility() {
        return agility;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
        if (pv <= 0) {
            this.pv = 0;
        }
    }

    public void describe() {
        System.out.println("Je suis " + name);
        System.out.println(" -Force : " + force);
        System.out.println(" -Agilité : " + agility);
        System.out.println(" -Points de vie : " + pv);
        System.err.println();
    }

    public void attack(Player target){
        int baseDamage = force / 2;
        int agilityAdd = randomNumber(0, agility);
        int agilityReduce = randomNumber(0, target.getAgility());

        int damage = Math.max(baseDamage + agilityAdd - agilityReduce, 0);

        System.out.println(name + " attaque " + target.getName() + " et inflige " + damage + " dégâts.");
        System.out.println(target.getPv() + " - " + damage);
        
        target.setPv(target.getPv() - damage);
        System.out.println("il reste " + target.getPv() + " Pv a " + target.getName());
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
