import java.lang.Integer;
import java.util.Arrays;

public class Sum
{
	public static int[] strToInt(String[] args)
	{
		System.out.print("integers : ");

		int intArray[] = new int[args.length];

		int sum = 0;

		for(int i = 0; i < args.length; ++i)
		{
			intArray[i] = Integer.parseInt(args[i]);
			System.out.print(intArray[i] + " ");
		}

		System.out.println();

		System.out.println("integers (with java.utils) : " + Arrays.toString(intArray));

		return intArray;
	}

	public static int getSum(int[] intArray)
	{
		int sum = 0;

		for(int i = 0; i < intArray.length; ++i)
			sum += intArray[i];

		return sum;
	}
	
	public static void main(String[] args)
	{
		int intArray[] = new int[args.length];

		intArray = Sum.strToInt(args);

		int sum = Sum.getSum(intArray);

		System.out.println("sum = " + sum);
	}
}

// static veut dire qu'elle est accessible que par le fichier qui la contient
// avec static on ne peut pas utiliser "this"

// si un argument n'est pas un nombre, le programme plante à ce niveau en disant que parseInt n'accepte que des nombres