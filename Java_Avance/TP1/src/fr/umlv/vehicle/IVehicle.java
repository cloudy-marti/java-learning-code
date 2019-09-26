package fr.umlv.vehicle;

import java.util.Optional;

public interface IVehicle
{
	int getYear();
	int getInsuranceCost(int year);
	Optional<IVehicle> findACarByModel(String model);
}
