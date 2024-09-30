package planets.planetai;

public class DwarfPlanet extends PlanetaryBody {
	
	/**
	 * Constructor to set the values
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
	public DwarfPlanet(String name, String classification, double diameter,
			double weight, double distanceEarth, double distanceSun, double orbitalecc,
			double albedo, double dayLength, double yearLength) {
		
		super(name, classification, diameter, weight, distanceEarth, distanceSun,
				orbitalecc, albedo, dayLength, yearLength);
		}

}
