package fr.umlv.vehicle;

public class Camel extends Vehicle
{
	public Camel(int year)
	{
		super(year);
	}

	@Override
	public String toString()
	{
		return "camel " + super.getYear();
	}

	@Override
	public int getInsuranceCost(int year)
	{
		if( year < super.getYear() )
		{
			throw new IllegalArgumentException("Camel is younger than the year asked");
		}

		return 100 * (year - super.getYear());
	}
}
