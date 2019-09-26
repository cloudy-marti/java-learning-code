package fr.umlv.vehicle;

import java.util.Objects;

public class Car extends Vehicle
{
	private final String model;
	
	public Car(String model, int year)
	{
		super(year);
		this.model = Objects.requireNonNull(model);
	}
	
	public String getModel()
	{
		return this.model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + super.getYear();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}

		if (!(obj instanceof Car))
		{
			return false;
		}

		Car tmp = (Car) obj;

		return tmp.getYear() == super.getYear() && tmp.model.equals(model);
	}

	@Override
	public String toString()
	{
		return this.model + " " + super.getYear();
	}

	@Override
	public int getInsuranceCost(int year)
	{
		if( year < super.getYear() )
		{
			throw new IllegalArgumentException("Car is younger than the year asked");
		}

		if( year - super.getYear() > 10)
		{
			return 500;
		}
		else
		{
			return 200;
		}
	}
}
