package planets.transportation;

public class LandVehicle extends TransportationVehicle {
	
	private double DRAG_COEFFICIENT_CONST = 0.0333;
	private double MEALS_PER_DAY = 5;
	private int PAY_HOURS_PER_DAY = 12;
	
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
	public LandVehicle(String vehicleName, String vehicleClassification, 
			double maxWeight, double volume, double buildCost, double maxSpeed, 
			double crew, double foodCost, double salary) {
			
			super(vehicleName, vehicleClassification, maxWeight, volume,
					buildCost, maxSpeed, crew, foodCost, salary);
			}
	
	/**
	 * Returns the Land Vehicles drag coefficient constant value
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

