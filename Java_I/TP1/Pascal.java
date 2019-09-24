public class Pascal
{
	public static int pascal(int nBut, int pBut)
	{
		int tab[] = new int[nBut+1];
		int n, i;

		tab[0] = 1;

		for(n = 1; n <= nBut; n++)
		{
			tab[n] = 1;

			for(i = n-1; i > 0; i--)
				tab[i] = tab[i-1] + tab[i];
		}

		int result = tab[pBut];
		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(" Cn, p = " + Pascal.pascal(30000, 250));
	}
}
// En C et en java le résultat est le meme ( Cn, p = -1742193024 )

// >> time ./a.out

// real	0m1,118s
// user	0m1,118s
// sys	0m0,000s

// >> time java Pascal.java

// real	0m0,337s
// user	0m0,330s
// sys	0m0,033s

// Le temps d'exécution du programme en Java est beaucoup plus rapide
// ratio de 1/3 environ

// Car l'interpréteur java traduit le byte code en "Run Time"
// et optimise au plus possible la traduction du code