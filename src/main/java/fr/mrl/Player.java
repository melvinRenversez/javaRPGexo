package fr.mrl;

public class Player {

    private String name;
    private int force;
    private int agility;
    private int pv;

    public Player(String name, int force, int agility, int pv) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.pv = pv;
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
    }

    public void sayAll() {
        System.out.println("Je suis " + name);
        System.out.println("Force : " + force);
        System.out.println("Agilité : " + agility);
        System.out.println("Points de vie : " + pv);
        System.out.println("----------------------------------------");
    }
}
