package fr.umlv.morse;

public class Test
{
	public static void main(String[] args)
	{
		String first = args[0];
		String second = args[1];
		String last = args[2];
		System.out.println(first + ' ' + second + ' ' + last);
	}
}

// Exercice 2.4

// On peut utiliser '' à la place de "" parce que la méthode println va convertir
// n'importe quoi en une chaine de caractères.

// javap -c Test fait la ligne suivante :
// InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;