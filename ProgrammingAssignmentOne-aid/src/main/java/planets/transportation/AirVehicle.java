package planets.transportation;

public class AirVehicle extends TransportationVehicle {
	
	private double DRAG_COEFFICIENT_CONST = 0.0102;
	private double MEALS_PER_DAY = 3.5;
	private int PAY_HOURS_PER_DAY = 24;
	
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
	public AirVehicle(String vehicleName, String vehicleClassification, 
			double maxWeight, double volume, double buildCost, double maxSpeed, 
			double crew, double foodCost, double salary) {
			
			super (vehicleName, vehicleClassification, maxWeight, volume,
					buildCost, maxSpeed, crew, foodCost, salary);
			}
	/**
	 * Returns the Air Vehicles drag coefficient constant value
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
