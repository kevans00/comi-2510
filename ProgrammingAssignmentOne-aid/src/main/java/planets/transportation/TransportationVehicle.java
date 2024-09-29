package planets.transportation;

/**
 * This class creates a TransportationVehicle object
 */
public class TransportationVehicle {
	String vehicleName;
	String vehicleClassification;
	double maxWeight;
	double volume;
	double buildCost;
	double maxSpeed;
	double crew;
	double foodCost;
	double salary;
	
	/**
	 * This method returns the transportation vehicle name
	 * @return vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}
	
	/**
	 * This method sets the transportation vehicle name to the String passed through the parameter
	 * @param vehicleName
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	/**
	 * This method returns the vehicles classification
	 * @return vehicleClassification
	 */
	public String getVehicleClassification() {
		return vehicleClassification;
	}
	
	/**
	 * This method sets the vehicle classification to the String passed through the parameter
	 * @param vehicleClassification
	 */
	public void setVehicleClassification(String vehicleClassification) {
		this.vehicleClassification = vehicleClassification;
	}
	
	/**
	 * This method returns the maximum weight of the vehicle
	 * @return maxWeight
	 */
	public double getMaxWeight() {
		return maxWeight;
	}
	
	/**
	 * This method sets the vehicles max weight to the double passed through the parameter
	 * @param maxWeight
	 */
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	
	/**
	 * This method returns the volume of the vehicle
	 * @return volume
	 */
	public double getVolume() {
		return volume;
	}
	
	
	/**
	 * This method sets the vehicle volume to the double passed through the parameter
	 * @param volume
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	/**
	 * This method returns the build cost of the vehicle
	 * @return buildCost
	 */
	public double getBuildCost() {
		return buildCost;
	}
	
	/**
	 * This method sets the build cost to the double passed through the parameter
	 * @param buildCost
	 */
	public void setBuildCost(double buildCost) {
		this.buildCost = buildCost;
	}
	
	/**
	 * This method returns the maximum speed of the vehicle
	 * @return maxSpeed
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * This method sets the max speed of the vehicle to the double passed through the parameter
	 * @param maxSpeed
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * This method returns the number of crew members on the ship
	 * @return crew
	 */
	public double getCrew() {
		return crew;
	}
	
	/**
	 * This method sets the number of crew members to the double passed through the parameter
	 * @param crew
	 */
	public void setCrew(double crew) {
		this.crew = crew;
	}
	
	/**
	 * This method returns the cost of food per crew member
	 * @return foodCost
	 */
	public double getFoodCost() {
		return foodCost;
	}
	
	/**
	 * This method sets the cost of food per crew member to the double passed through the parameter
	 * @param foodCost
	 */
	public void setFoodCost(double foodCost) {
		this.foodCost = foodCost;
	}
	
	/**
	 * This method returns the crew members salary
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * This method sets the crew members salary to the double passed through the parameter
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
/**
 * This is the TransportationVehicle constructor
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
	public TransportationVehicle(String vehicleName, String vehicleClassification, 
			double maxWeight, double volume, double buildCost, double maxSpeed, 
			double crew, double foodCost, double salary) 
	{
		this.setVehicleName(vehicleName);
		this.setVehicleClassification(vehicleClassification);
		this.setMaxWeight(maxWeight);
		this.setVolume(volume);
		this.setBuildCost(buildCost);
		this.setMaxSpeed(maxSpeed);
		this.setCrew(crew);
		this.setFoodCost(foodCost);
		this.setSalary(salary);
	}
}
