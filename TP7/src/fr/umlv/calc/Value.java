package fr.umlv.calc;

public class Value implements Expr
{
	private int value;

	public Value(int newValue)
	{
		value = newValue;
	}

	public int eval()
	{
		return value;
	}
}
