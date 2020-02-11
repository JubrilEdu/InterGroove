public class DistanceCalculatorImpl implements DistanceCalculator {

    /*
    Calculates distance between two points using the Haversine formula
    https://en.wikipedia.org/wiki/Haversine_formula
     */
    @Override
    public double calculatedDistance(double latitideA, double longitudeA, double latitudeB, double longitudeB) {
        final int RADIUS = 6371;
        if(latitideA == latitudeB && longitudeA == longitudeB) {
            return 0;
        }
        double distance = Math.pow(Math.sin((latitudeB - latitideA) / 2.0), 2)
                + Math.cos(latitideA) * Math.cos(latitudeB)
                * Math.pow(Math.sin((longitudeB - longitudeA) / 2.0), 2);

        return  2.0 * RADIUS * Math.asin(Math.sqrt(distance));
    }

    /*
      converts values from degree to radians
     */
    @Override
    public double degreeToRadians(double degreeValue) {
        return  Math.toRadians(degreeValue);
    }
}
