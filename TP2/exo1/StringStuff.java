import java.lang.Object;

public class StringStuff
{
	public static void main(String[] args)
	{
		String s1 = "toto";
		String s2 = s1;
		String s3 = new String(s1);

		System.out.println(" --- Exo 1.1 --- ");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		System.out.println("\n --- Exo 1.2 ---");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));

		System.out.println("\n --- Exo 1.3 ---");
		String s6 = "toto";
      	String s7 = "toto";

	    System.out.println(s6 == s7);

	    System.out.println("\n --- Exo 1.5 ---");
	    String s8 = "hello";
	    s8.toUpperCase();
	    System.out.println(s3);
	}
}

// 				Exercice 1 - Assignation, égalité, référence			//

// 	1. Le code affiche :

// true
// false

// Lorsqu'on fait machin == machin, on compare la référence, pas la valeur.

// Avec s2 = s1, on attribue à s2 la meme référence que s1
// du coup s2 est un pointeur qui va pointer sur la meme case mémoire que s1

// Lorsqu'on fait s3 = new String(s1), on donne à s3 la valeur de s1, mais s3 va pointer sur une autre case mémoire que s1
// meme si les cases mémoire pointées par s3 et s1 ont la meme valeur.

// Du coup s1 == s3 donne false parce qu'on compare les références, les adresses mémoires, qui ne sont pas les memes.

//  3. Le code affiche true.

// Ceci es du au fait qu'on attribue à s6 et à s7 une chaine fixe
// Et pour des raisons de préservation de la mémoire, javac fait pointer s6 et s7
// là où la chaine est déjà déclarée (d'ailleurs s6 == s1 donne aussi true)

//  4. Parce qu'on ne devrait pas avoir le droit de changer une chaine de caractères invariable.
// Comme certaines variables partagent la meme chaine, si on la change pour une variable
// on la changera pour toutes et ça peut ne pas etre ce qu'on voulait.

//  5. ça affiche hello
// Car la classe String est immutable

