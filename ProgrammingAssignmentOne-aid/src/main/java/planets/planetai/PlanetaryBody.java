package planets.planetai;

import edu.ccri.assignment.planets.data.DataAccessOperations;

  /**
   * This class creates a PlanetaryBody object with all PlanetaryBody values
   */
public abstract class PlanetaryBody {
	String planetName;
	String planetClassification;
	double diameter;
	double weight;
	double distanceEarth;
	double distanceSun;
	double orbitalecc;
	double albedo;
	double dayLength;
	double yearLength;
	
	/**
	 * This method returns the planet name
	 * @return planet name
	 */
	public String getPlanetName() {
		return planetName;
	}
	
	/**
	 * This method sets the planet name to the String passed through the parameter
	 * @param planetName
	 */
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	/**
	 * This method returns the planets classification
	 * @return planetClassification
	 */
	public String getPlanetClassification() {
		return planetClassification;
	}
	
	/**
	 * This method sets the planets classification to the String passed through the parameter
	 * @param planetClassification
	 */
	public void setPlanetClassification(String planetClassification) {
		this.planetClassification = planetClassification;
	}
	
	/**
	 * This method returns the planets diameter
	 * @return diameter
	 */
	public double getDiameter() {
		return diameter;
	}
	
	/**
	 * This method sets the planets diameter to the double passed through the parameter
	 * @param diameter
	 */
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	/**
	 * This method returns the planets weight
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * This method sets the planets weight to the double passed through the parameter
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * This method returns the planets distance from earth
	 * @return distanceEarth
	 */
	public double getDistanceEarth() {
		return distanceEarth;
	}
	
	/**
	 * This method sets the planets distance from earth to the double passed through the parameter
	 * @param distanceEarth
	 */
	public void setDistanceEarth(double distanceEarth) {
		this.distanceEarth = distanceEarth;
	}
	
	/**
	 * This method returns the planets distance from the sun
	 * @return distanceSun
	 */
	public double getDistanceSun() {
		return distanceSun;
	}
	
	/**
	 * This method sets the planets distance from the sun to the double passed through the parameter
	 * @param distanceSun
	 */
	public void setDistanceSun(double distanceSun) {
		this.distanceSun = distanceSun;
	}
	
	/**
	 * This method returns the planets orbital eccentricity
	 * @return orbitalecc
	 */
	public double getOrbitalecc() {
		return orbitalecc;
	}
	
	/**
	 * This method sets the planets orbital eccentricity to the double passed through the parameter
	 * @param orbitalecc
	 */
	public void setOrbitalecc(double orbitalecc) {
		this.orbitalecc = orbitalecc;
	}
	
	/**
	 * This method returns the planets albedo
	 * @return albedo
	 */
	public double getAlbedo() {
		return albedo;
	}
	
	/**
	 * This method sets the planets albedo to the double passed through the parameter
	 * @param albedo
	 */
	public void setAlbedo(double albedo) {
		this.albedo = albedo;
	}
	
	/**
	 * This method returns the planets day length
	 * @return dayLength
	 */
	public double getDayLength() {
		return dayLength;
	}
	
	/**
	 * This method sets the planets day length to the double passed through the parameter
	 * @param dayLength
	 */
	public void setDayLength(double dayLength) {
		this.dayLength = dayLength;
	}
	
	/**
	 * This method returns the planets year length
	 * @return yearLength
	 */
	public double getYearLength() {
		return yearLength;
	}
	
	/**
	 * This method sets the planets year length to the double passed through the parameter
	 * @param yearLength
	 */
	public void setYearLength(double yearLength) {
		this.yearLength = yearLength;
	}
	
	/**
	 * This is the PlanetaryBody constructor
	 * @param name
	 * @param classification
	 * @param diameter
	 * @param weight
	 * @param distanceEarth
	 * @param distanceSun
	 * @param orbitalecc
	 * @param albedo
	 * @param dayLength
	 * @param yearLength
	 */
	public PlanetaryBody (String name, String classification, double diameter,
			double weight, double distanceEarth, double distanceSun, double orbitalecc,
			double albedo, double dayLength, double yearLength)
	{
		this.setPlanetName(name);
		this.setPlanetClassification(classification);
		this.setDiameter(diameter);
		this.setWeight(weight);
		this.setDistanceEarth(distanceEarth);
		this.setDistanceSun(distanceSun);
		this.setOrbitalecc(orbitalecc);
		this.setAlbedo(albedo);
		this.setDayLength(dayLength);
		this.setYearLength(yearLength);
	}
	
	protected double getDragCoefficientBase() {
		double dragCoefficientBase = this.albedo * this.orbitalecc;
		return dragCoefficientBase;
	}
	
	public abstract double getDragCoefficient();
}
