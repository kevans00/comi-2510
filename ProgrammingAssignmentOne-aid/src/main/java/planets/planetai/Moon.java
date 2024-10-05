package planets.planetai;

public class Moon extends PlanetaryBody {

	private double DRAG_COEFFICIENT_CONST = 0.75;
	
	/**
	 * Constructor to set values
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
	public Moon(String name, String classification, double diameter,
			double weight, double distanceEarth, double distanceSun, double orbitalecc,
			double albedo, double dayLength, double yearLength) {
		
		super(name, classification, diameter, weight, distanceEarth, distanceSun,
				orbitalecc, albedo, dayLength, yearLength);
	}
	
	/**
	 * This method gets the Dwarf Planet drag coefficient
	 */
	@Override
	public double getDragCoefficient() {
		double dragCoefficient = DRAG_COEFFICIENT_CONST + this.getDragCoefficientBase();
		return dragCoefficient;
	}
}
