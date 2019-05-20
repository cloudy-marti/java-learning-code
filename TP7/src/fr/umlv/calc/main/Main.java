package fr.umlv.calc.main;

import fr.umlv.calc.Expr;
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

        System.out.println(Expr.parse(scanner));
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
 *
 * Exercice 2 - Arbre d'héritage
 *
 * 1.2
 * La fonction parse peut être codée en statique dans l'interface Expr.
 *
 * 1.3
 * Expr peut être une interface où on met des prototypes des fonctions utilisées dans Value, Add et Sub
 * Et la méthode parse qui n'a pas besoin qu'on instancie de nouveaux objets pour qu'elle soit utilisée (la méthode
 * parse instancie de nouveaux objets de type value, add ou sub).
 *
 * 1.5
 * L'interface Expr ne peut être que publique, ainsi que value, add et sub.
 *
 * En fait, Value, Add et Sub vont être les trois types de noeuds existants dans cette calculatrice.
 * Sub et Add ont pour champs les fils gauche et droit et Value a pour champs un entier.
 *
 * La méthode toString de l'arbre va montrer les valeurs des deux fils de la racine, après calcul.
 */
