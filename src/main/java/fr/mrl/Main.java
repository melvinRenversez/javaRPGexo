package fr.mrl;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void attack(Player attacker, Player defender) {
        int baseDamage = attacker.getForce() / 2;
        int agilityAdd = randomNumber(0, attacker.getAgility());
        int agilityReduce = randomNumber(0, defender.getAgility());

        int damage = Math.max(baseDamage + agilityAdd - agilityReduce, 0);

        defender.setPv(defender.getPv() - damage);

        System.out.println(attacker.getName() + " attaque " + defender.getName() + " et inflige " + damage + " dégâts.");
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player("Frank", 100, 80, 5000);
        Player player2 = new Player("Baptiste", 120, 70, 3500);

        System.out.println("Bienvenue dans l'arène !");
        player1.sayAll();
        player2.sayAll();

        System.out.println("----------------------------------------");
        System.out.println("Le combat commence !");

        int round = 1;

        while (player1.getPv() > 0 && player2.getPv() > 0) {
            System.out.println("------------ Round " + round + " ------------");

            // Tour du joueur 1
            System.out.println(player1.getName() + " attaque !");
            attack(player1, player2);
            if (player2.getPv() <= 0) break;

            System.err.println("");

            // Tour du joueur 2
            System.out.println(player2.getName() + " attaque !");
            attack(player2, player1);

            round++;
        }

        System.out.println("----------------------------------------");
        if (player1.getPv() > 0) {
            System.out.println(player1.getName() + " a gagné le combat !");
        } else {
            System.out.println(player2.getName() + " a gagné le combat !");
        }

        scanner.close();
    }
}
