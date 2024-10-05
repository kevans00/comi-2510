package planets.util;

import planets.transportation.AirVehicle;
import planets.transportation.LandVehicle;
import planets.transportation.SeaVehicle;

/**
 * This class calculates values for the crew members aboard the ship
 */
public class CrewCalculator {
	static EasyDebugLogger log = new EasyDebugLogger();

	/**
	 * Default constructor
	 */
	public CrewCalculator() {}
	
	/**
	 * This method calculates the total salary of all crew members on board the ship
	 * @param crewMembers
	 * @param hourlyWage
	 * @param tripDays
	 * @param tripHours
	 * @return crewTotalSalary
	 */
	public static double calculateCrewTotalSalary(double crewMembers, double hourlyWage, double tripDays, double payHoursPerDay) {
		log.formatLogger("Pay hours per day", hourlyWage);
		double crewTotalSalary = crewMembers * hourlyWage * tripDays * payHoursPerDay;
		return crewTotalSalary; 	//returns in USD
	}
	
	/**
	 * This method returns the total food cost of all crew members on board the ship
	 * @param crewMembers
	 * @param mealCostPerPerson
	 * @param tripDays
	 * @param mealsPerDay
	 * @return crewFoodCost
	 */
	public static double calculateCrewFoodCost(double crewMembers, double mealCostPerPerson, double tripDays, double mealsPerDay) {
		double crewFoodCost = crewMembers * mealCostPerPerson * tripDays * mealsPerDay;
		return crewFoodCost;		//returns in USD
	}
	
	/**
	 * This method returns the gross income of all crew members on board the ship
	 * @param crewTotalSalary
	 * @param crewFoodCost
	 * @return crewGrossIncome
	 */
	public static double calculateCrewGrossIncome(double crewTotalSalary, double crewFoodCost) {
		double crewGrossIncome = crewTotalSalary + crewFoodCost;
		return crewGrossIncome;		//returns in USD
	}
	
	public static int getDailyFoodCostPerCrewMember() {
		return -1;
		}

}

