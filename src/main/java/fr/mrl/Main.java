package fr.mrl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 100; i++) {
            System.out.println();
        }

        System.out.println("----------------------------------------");
        System.out.println("Bienvenue dans l'arène !");
        System.out.println("----------------------------------------");
        
        System.err.println();
        
        System.out.println("----------- Player 1 -----------");
        Player player1 = new Player();
        player1.describe();
        
        System.out.println("----------- Player 2 -----------");
        Player player2 = new Player();
        player2.describe();
        
        
        
        
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("Le combat commence !");
        System.out.println("----------------------------------------");
        
        int round = 1;
        
        while (player1.getPv() > 0 && player2.getPv() > 0) {
            System.out.println("");
            System.out.println("------------ Round " + round + " ------------");

            // Tour du joueur 1
            System.out.println(player1.getName() + " attaque !");
            scanner.nextLine();
            player1.attack(player2);
            if (player2.getPv() <= 0) break;
            
            System.err.println("");
            
            // Tour du joueur 2
            System.out.println(player2.getName() + " attaque !");
            scanner.nextLine();
            player2.attack(player1);

            round++;
        }

        System.err.println();
        System.err.println();

        if (player1.getPv() > 0) {
            System.out.println(player1.getName() + " a gagné le combat !");
        } else {
            System.out.println(player2.getName() + " a gagné le combat !");
        }

        scanner.close();
    }
    
}
