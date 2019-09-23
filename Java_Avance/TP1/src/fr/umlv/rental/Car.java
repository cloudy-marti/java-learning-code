package fr.umlv.rental;

import java.util.Objects;

public class Car
{
	private final String model;
	private final int year;
	
	public Car(String model, int year)
	{
		this.model = Objects.requireNonNull(model);
		this.year = year;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return this.model + year;
	}
}
