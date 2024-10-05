package planets.transportation;

public class SeaVehicle extends TransportationVehicle {

	private double DRAG_COEFFICIENT_CONST = 0.0744;
	private double MEALS_PER_DAY = 8;
	private int PAY_HOURS_PER_DAY = 16;

	/**
	 * Constructor to create an AirVehicle object with TransportationVehicle values
	 * @param vehicleName
	 * @param vehicleClassification
	 * @param maxWeight
	 * @param volume
	 * @param buildCost
	 * @param maxSpeed
	 * @param crew
	 * @param foodCost
	 * @param salary
	 */
	public SeaVehicle(String vehicleName, String vehicleClassification, 
			double maxWeight, double volume, double buildCost, double maxSpeed, 
			double crew, double foodCost, double salary) {
			
			super (vehicleName, vehicleClassification, maxWeight, volume,
					buildCost, maxSpeed, crew, foodCost, salary);
			}
	
	/**
	 * Returns the Sea Vehicles drag coefficient constant value
	 * @return DRAG_COEFFICIENT_CONST
	 */
	public double getDragCoefficient() {
		return DRAG_COEFFICIENT_CONST;
	}

	public double getMealsPerDay() {
		return MEALS_PER_DAY;
	}
	
	public int getPayHoursPerDay() {
		return PAY_HOURS_PER_DAY;
	}
}
