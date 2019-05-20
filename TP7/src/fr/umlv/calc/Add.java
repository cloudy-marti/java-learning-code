package fr.umlv.calc;

public class Add implements Expr
{
	private Expr leftExpr;
	private Expr rightExpr;

	public Add(Expr left, Expr right)
	{
		leftExpr = left;
		rightExpr = right;
	}

	public int eval()
	{
		return leftExpr.eval() + rightExpr.eval();
	}

	@Override
	public String toString()
	{
		StringBuilder calcStr = new StringBuilder();

		calcStr.append("(");
		calcStr.append(leftExpr.eval());
		calcStr.append(" + ");
		calcStr.append(rightExpr.eval());
		calcStr.append(") = ");
		calcStr.append(eval());

		return calcStr.toString();
	}
}
