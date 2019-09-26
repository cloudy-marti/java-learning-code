package fr.umlv.vehicle;

import java.util.Objects;
import java.util.Optional;

abstract class Vehicle implements IVehicle
{
	private final int year;

	public Vehicle(int year)
	{
		this.year = year;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(year);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}

		if (!(obj instanceof Vehicle))
		{
			return false;
		}

		Vehicle tmp = (Vehicle) obj;

		return tmp.getYear() == this.year;
	}

	@Override
	public int getYear()
	{
		return year;
	}
}
