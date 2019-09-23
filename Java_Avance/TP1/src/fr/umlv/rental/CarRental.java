package fr.umlv.rental;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class CarRental
{
	private final List<Car> cars;
	
	public CarRental()
	{
		this.cars = new ArrayList<>();
	}
	
	public void add(Car car)
	{
		this.cars.add(Objects.requireNonNull(car));
	}
	
	public void remove(Car car)
	{
		this.cars.remove(Objects.requireNonNull(car));
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		Iterator<Car> carsIterator = this.cars.iterator();
		
		while(carsIterator.hasNext())
		{
			str.append(carsIterator.next());
			if(carsIterator.hasNext())
			{
				str.append('\n');
			}
		}
		
		return str.toString();
	}
}
