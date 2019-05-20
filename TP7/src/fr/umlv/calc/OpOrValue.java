package fr.umlv.calc;

import java.util.Objects;
import java.util.Scanner;

public class OpOrValue
{
	public static final int OP_NONE = 0;
	public static final int OP_ADD = 1;
	public static final int OP_SUB = 2;

	private final int operator;
	private final int value;
	private final OpOrValue left;
	private final OpOrValue right;

	private OpOrValue(int operator, int value, OpOrValue left, OpOrValue right)
	{
		this.operator = operator;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public OpOrValue(int value)
	{
		this(OP_NONE, value, null, null);
	}

	public OpOrValue(int operator, OpOrValue left, OpOrValue right)
	{
		this(operator, 0, Objects.requireNonNull(left), Objects.requireNonNull(right));
	}

	public int eval()
	{
		switch(operator)
		{
			case OP_ADD:
				return left.eval() + right.eval();
			case OP_SUB:
				return left.eval() - right.eval();
			default: // case OP_NONE:
				return value;
		}
	}

	private static OpOrValue parseRec(Scanner scanner)
	{
		String next = scanner.next();

		try
		{
			int value = Integer.parseInt(next);
			return new OpOrValue(value);
		}
		catch(NumberFormatException e)
		{
			String operator = next;

			switch(operator)
			{
				case "+" :
					return new OpOrValue(OP_ADD, parseRec(scanner), parseRec(scanner));
				case "-" :
					return new OpOrValue(OP_SUB, parseRec(scanner), parseRec(scanner));
				default :
					throw new IllegalStateException("invalid value here");
			}
		}
	}

	public static OpOrValue parse(Scanner scanner)
	{
		OpOrValue calcTree = parseRec(scanner);

		/*if(scanner.hasNext())
		{
			System.out.println(scanner.next());
			throw new IllegalArgumentException("scanner too long");
		}*/

		return calcTree;
	}

	/**
	 * Suffix path - Adding operator / value when going under node
	 * @return String
	 */
	private String polishCalculatorString()
	{
		StringBuilder calcStr = new StringBuilder();

		switch(operator)
		{
			case OP_ADD :
				calcStr.append("(");
				calcStr.append(left.polishCalculatorString());
				calcStr.append(" + ");
				calcStr.append(right.polishCalculatorString());
				calcStr.append(")");
				return calcStr.toString();

			case OP_SUB :
				calcStr.append("(");
				calcStr.append(left.polishCalculatorString());
				calcStr.append(" - ");
				calcStr.append(right.polishCalculatorString());
				calcStr.append(")");
				return calcStr.toString();

			default :
				return String.valueOf(value);
		}
	}

	@Override
	public String toString()
	{
		return polishCalculatorString();
	}
}
