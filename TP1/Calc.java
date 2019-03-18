import java.util.Scanner; 

public class Calc
{ 
	public static void main(String[] args)
	{
		Scanner scanner;
		scanner = new Scanner(System.in);

		System.out.println("Please enter two integers :");

		int firstValue, secondValue;
		firstValue = scanner.nextInt();
		secondValue = scanner.nextInt();

		System.out.println(firstValue + " + " + secondValue + " = " + (firstValue + secondValue));
		System.out.println(firstValue + " - " + secondValue + " = " + (firstValue - secondValue));
		System.out.println(firstValue + " * " + secondValue + " = " + (firstValue * secondValue));
		System.out.println(firstValue + " / " + secondValue + " = " + (firstValue / secondValue));
	}
}

// nextInt est une méthode de la classe scanner
// import java.util.Scanner va lire le contenu de ce fichier, qui contient la classe Scanner