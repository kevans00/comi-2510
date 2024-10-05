package planets.util;

import planets.planetai.PlanetaryBody;

public class TravelCalculator {

	public TravelCalculator() {	}
	
	public static double calculateOrbitalVelocity(double distFromSunOrigin, double orbitalPeriodInDays) {
		double orbitalVelocity = (PlanetaryConstants.METERS_TO_KILOMETERS_FACTOR * Math.sqrt((2 * Math.PI * distFromSunOrigin) / (orbitalPeriodInDays * PlanetaryConstants.SECONDS_IN_A_DAY)));
		return orbitalVelocity; // returns in km/h
	}
	
	public static double calculateGravityAssistVelocity(double orbitalVelocity, double transportVehicleVelocity) {
		double gav = (2 * orbitalVelocity) + transportVehicleVelocity;
		return gav; // returns in km/h
	}
	
	public static double calculateRelativeDistance(PlanetaryBody startingPlanet, PlanetaryBody endingPlanet) {	
		// We are using the relative distance from the sun because this makes most sense; we cannot physically land on the sun
		// so we do not have to account for any distance to/from it
		double distance = Math.abs(startingPlanet.getDistanceSun() - endingPlanet.getDistanceSun());
		return distance; // in km
	}
	
	public static double calculateTripTimeHours(double velocity, double distance) {
		double time = distance / velocity; // km and km/hr
		return time; // in hours
	}
	
	public static double calculateTripTimeDays(double velocity, double distance) {
		double time = TravelCalculator.calculateTripTimeHours(velocity, distance) / PlanetaryConstants.HOURS_IN_A_DAY;
		return time; // in days
	}
	
	public static double calculateTriptimeYears(double velocity, double distance) {
		double time = calculateTripTimeDays(velocity, distance) / PlanetaryConstants.DAYS_IN_A_YEAR;
		return time; // in years
	}
	
	//Calculate
	
	

}
