import java.lang.Double;
import java.lang.Math;

public class Delta
{
	 // return the coefficients of the quadratic polynomial
	public static double[] getDouble(String[] args)
	{
		System.out.print("a b c : ");

		double doubleArray[] = new double[args.length];

		for(int i = 0; i < args.length; ++i)
		{
			doubleArray[i] = Double.parseDouble(args[i]);
			System.out.print(doubleArray[i] + " ");
		}

		System.out.println();

		return doubleArray;
	}

	 // return the discriminant of the given coefficients
	public static double getDelta(double[] coefficients)
	{
		return Math.pow(coefficients[1], 2.0) - (4.0 * coefficients[0] * coefficients[2]);
	}

	 // return an int array containing the roots of the quadratic polynomial
	public static double[] getRoots(double[] coefficients)
	{
		double delta = Delta.getDelta(coefficients);
		System.out.println("Delta : " + delta);

		double[] roots = new double[3];

		if(delta < 0)
		{
			System.out.println("Negative Delta, cannot get roots ...");
			return null;
		}
		else
		{
			roots[0] = ((-coefficients[1]) - (Math.sqrt(delta))) / (2*coefficients[0]);
			roots[1] = ((-coefficients[1]) + (Math.sqrt(delta))) / (2*coefficients[0]);
		}

		return roots;
	}

	public static void main(String[] args)
	{
		double[] coefficients = new double[args.length];
		double[] roots = new double[2];

		if(args.length < 3)
		{
			System.out.println("too few arguments ...");
			return;
		}

		coefficients = Delta.getDouble(args);
		roots = getRoots(coefficients);

		if(roots == null)
			return;
		else if(roots[0] == roots[1])
			System.out.println("double root = " + roots[0]);
		else
			System.out.println("two roots = " + roots[0] + " & " + roots[1]);
	}
}