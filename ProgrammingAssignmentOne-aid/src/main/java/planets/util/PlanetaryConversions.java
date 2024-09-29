package planets.util;

/**
 * This class handles Planetary Conversions from Metric to Imperial and vice versa
 */
public class PlanetaryConversions {

	private static final double KM_TO_MI_CONST = 0.6214;
	private static final double MI_TO_KM_CONST = 1.6093;
	
	/**
	 * This method calculates the imperial value of a metric number
	 * @param metric
	 * @return imperial
	 */
	public double MetricToImperialConversions(double metric)
	{
		double imperial = 0.0;
		imperial = metric * KM_TO_MI_CONST;
		return imperial;
	}

	/**
	 * This method calculates the metric value of an imperial number
	 * @param imperial
	 * @return metric
	 */
	public double ImperialToMetricConversions(double imperial) 
	{
		double metric = 0.0;
		metric = imperial * MI_TO_KM_CONST;
		return metric;
	}
}
