package fr.umlv.fight;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Robot bob = new Robot("DRD2");
        System.out.println("This is " + bob);

        Robot foo = new Robot("Data");
        System.out.println("This is " + foo + " !\n");

        Robot winner = Arena.fight(bob, foo);

        /**
         * Create a Random object to get my new seed.
         */
        Random seed = new Random();

        /**
         * seed.nextInt() will give a random Int which will be used by my fighter.
         */
        Fighter kyle = new Fighter("Kyle", seed.nextInt());
        System.out.println("This is " + kyle + " !\n");

        winner.revive();

        winner = Arena.fight(winner, kyle);

        kyle.revive();

        /**
         * Sniper
         */
        Fighter klara = new Fighter("Klara", seed.nextInt());
        System.out.println("This is " + klara + " !\n");

        winner = Arena.fight(kyle, klara);
    }
}

/**
 * Exercise 2 - Fighter
 *
 * 1. Un générateur pseudo-aléatoire est une série d'opérations mathématiques
 * qui vont générer un numéro du type désiré à partir d'une "seed" ou graine en français.
 *
 * Ce pourquoi la meme seed va générer le meme résultat.
 *
 * 3. Un champ doit etre private ; c'est le principe d'encapsulation sur lequel s'appuie
 * la programmation orientée objet.
 *
 * Le fait qu'un champ soit private permet le changement du type de celui-ci facilement depuis la classe
 * sans devoir aller dans tous les fichiers utilisant ce champs pour tout changer.
 *
 * En effet, si on a un champ int age, et qu'on veut le changer en float age, on va tout simplement
 * le changer dans la classe, lui et les fonctions qui le récupèrent.
 *
 * Hors de la classe, si un programmeur a utilisé un myObject.getAge() pour récupérer l'age, rien ne va changer pour lui.
 *
 * 6. Les méthodes rollDice() (ou aim()) doivent etre protected car on veut que les sous-classes
 * qui en héritent puissent aussi les voir, mais pas les autres.
 *
 * 9.
 * Sous-Typage :
 * C'est lorsque qu'une classe hérite d'une autre classe et récupère ses champs et méthodes
 * On dit qu'une classe est un sous-type d'une classe lorsqu'elle "extend" cette classe.
 * Toutes les classes que nous crééons sont des sous-types d'Object.
 * Un sous-type peut etre considéré comme plus précis que sa super-classe ou type parent.
 * Par exemple, Fighter est un sous-type de Robot.
 *
 * Polymorphisme :
 * Ceci s'applique aux méthodes.
 * C'est le fait de redéfinir plusieurs fois une meme méthode, avec @Override.
 * Le Compilateur va choisir ainsi quelle méthode correspond au bout de code qu'il compile.
 * Par exemple, on utilise le polymorphisme avec toString() et aim().
 *
 */