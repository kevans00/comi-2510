package planets.transportation;

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
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public String getVehicleClassification() {
		return vehicleClassification;
	}
	
	public void setVehicleClassification(String vehicleClassification) {
		this.vehicleClassification = vehicleClassification;
	}
	
	public double getMaxWeight() {
		return maxWeight;
	}
	
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public double getBuildCost() {
		return buildCost;
	}
	
	public void setBuildCost(double buildCost) {
		this.buildCost = buildCost;
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public double getCrew() {
		return crew;
	}
	
	public void setCrew(double crew) {
		this.crew = crew;
	}
	
	public double getFoodCost() {
		return foodCost;
	}
	
	public void setFoodCost(double foodCost) {
		this.foodCost = foodCost;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
/**
 * This is a constructor
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
