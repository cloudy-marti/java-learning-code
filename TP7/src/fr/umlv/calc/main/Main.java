package fr.umlv.calc.main;

import fr.umlv.calc.OpOrValue;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        OpOrValue expression = new OpOrValue(OpOrValue.OP_ADD,
                new OpOrValue(2),
                new OpOrValue(3)
        );
        System.out.println(expression.eval());

        System.out.println("input here please");
        Scanner scanner = new Scanner(System.in);

        OpOrValue calculator = OpOrValue.parse(scanner);
        System.out.println(calculator);
    }
}

/**
 * Exerice 1 - Arbre d'expressions
 *
 * 1.1
 * Le constructeur qui prend 4 arguments est privé car il est rappelé par l'autre constructeur public.
 * Lorsqu'un créé un noeud, il a pas de fils, donc pas besoin de lui en attribuer à la main
 * (d'autres fonctions seront sûrement prévues à cet effet)
 *
 * 1.2
 * Le "bug" c'est le requireNonNull
 */
