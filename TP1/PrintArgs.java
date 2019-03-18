public class PrintArgs
{
	public static void main(String[] args)
	{
		/* --- EXO 2.1 --- */
		System.out.println("Exo 2.1 : " + args[0]);
		System.out.println();

		/* --- EXO 2.2 --- */
		int argc = args.length;
		int index = 0;

		System.out.println("Exo 2.2 :");
		
		for(index = 0; index < argc; ++index)
			System.out.print(args[index] + " ");

		System.out.println();
		System.out.println();

		/* --- EXO 2.3 --- */
		System.out.println("Exo 2.3 :");

		for(String argv : args)
			System.out.print(argv + " ");

		System.out.println();
	}
}

// Exercice 2 : Premier execercice

// si on ne met pas d'arguments on a une erreur à l'exécution du programme
// en gros on essaie d'accéder à une case du tableau args qui n'hexiste pas