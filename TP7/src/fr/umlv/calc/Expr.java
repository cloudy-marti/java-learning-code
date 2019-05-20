package fr.umlv.calc;

import java.util.Scanner;

public interface Expr
{
	int eval();

	@Override
	String toString();

	static private Expr parseRec(Scanner scanner)
	{
		String next = scanner.next();

		try
		{
			int value = Integer.parseInt(next);
			return new Value(value);
		}
		catch(NumberFormatException e)
		{
			String operator = next;

			switch(operator)
			{
				case "+" :
					return new Add(parseRec(scanner), parseRec(scanner));
				case "-" :
					return new Sub(parseRec(scanner), parseRec(scanner));
				default :
					throw new IllegalStateException("invalid value here");
			}
		}
	}

	static Expr parse(Scanner scanner)
	{
		return parseRec(scanner);
	}
}
