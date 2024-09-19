package planets.util;

public class PlanetaryConversions {

	private static final double KM_TO_MI_CONST = 0.6214;
	private static final double MI_TO_KM_CONST = 1.6093;
	
	public double MetricToImperialConversions(double metric)
	{
		double imperial = 0.0;
		imperial = metric * KM_TO_MI_CONST;
		return imperial;
	}

	public double ImperialToMetricConversions(double imperial) 
	{
		double metric = 0.0;
		metric = imperial * MI_TO_KM_CONST;
		return metric;
	}
}
