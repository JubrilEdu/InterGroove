public interface DistanceCalculator {

    double calculatedDistance(double latitideA, double longitudeA, double latitudeB, double longitudeB);

    double degreeToRadians(double degreeValue);
}
