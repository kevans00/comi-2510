package planets.planetai;


/**
 * This is a POJO
 */
public class PlanetaryBody {
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
	
	public String getPlanetName() {
		return planetName;
	}
	
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	public String getPlanetClassification() {
		return planetClassification;
	}
	
	public void setPlanetClassification(String planetClassification) {
		this.planetClassification = planetClassification;
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getDistanceEarth() {
		return distanceEarth;
	}
	
	public void setDistanceEarth(double distanceEarth) {
		this.distanceEarth = distanceEarth;
	}
	
	public double getDistanceSun() {
		return distanceSun;
	}
	
	public void setDistanceSun(double distanceSun) {
		this.distanceSun = distanceSun;
	}
	
	public double getOrbitalecc() {
		return orbitalecc;
	}
	
	public void setOrbitalecc(double orbitalecc) {
		this.orbitalecc = orbitalecc;
	}
	
	public double getAlbedo() {
		return albedo;
	}
	
	public void setAlbedo(double albedo) {
		this.albedo = albedo;
	}
	
	public double getDayLength() {
		return dayLength;
	}
	
	public void setDayLength(double dayLength) {
		this.dayLength = dayLength;
	}
	
	public double getYearLength() {
		return yearLength;
	}
	
	public void setYearLength(double yearLength) {
		this.yearLength = yearLength;
	}
	
	/**
	 * This is a constructor
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
	
	//public String toString() {
	//}
	
}
