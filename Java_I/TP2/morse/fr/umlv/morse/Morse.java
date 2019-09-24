package fr.umlv.morse;

public class Morse
{
	public static void main(String[] args)
	{
		 // EXERCICE 2.1
		System.out.println(" --- 2.1 ---");

		for(String argv : args)
			System.out.print(argv + " Stop. ");

		System.out.println();

		 // EXERCICE 2.3
		System.out.println(" --- 2.3 ---");

		StringBuilder stopString = new StringBuilder();
		for(String argv : args)
		{
			stopString.append(argv);
			stopString.append(" Stop. ");
		}
		
		System.out.print(stopString);

		System.out.println();
	}
}

// Exercice 2.2

// StringBuilder sert à créer des chaines de caractères mutables.
// Parce que append va modifier la chaine de caractère

// Exercice 2.3

// La méthode StringBuilder.append permet de travailler sur une chaine mutable
// Cela nous permet de ne pas devoir nous servir du + qui va faire une copie
// à chaque fois qu'il est utilisé.
// StringBuilder.append va seulement rajouter la chaine sans faire de copies inutiles.

// Exercice 2.5

// On peut utiliser le + avec des chaines statiques
// StringBuilder.append pour des chaines pouvant varier