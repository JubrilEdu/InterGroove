import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceCalculatorImplTest {
    private DistanceCalculatorImpl distanceCalculator;
    double[] longitude = {-6.043701,-10.27699,-6.257664,0,-6.043701};
    double[] latitude = {52.986375,51.92893,53.339428,0,52.986375};


    @Before
    public void setUp() {
        distanceCalculator = new DistanceCalculatorImpl();
    }


    /*
    * Actual values were calculated here [http://www.meridianoutpost.com/resources/etools/calculators/calculator-latitude-longitude-distance.php?]
    *
    * */
    @Test
    public void calculatedDistance() {
        double distance = distanceCalculator.calculatedDistance(distanceCalculator.degreeToRadians(latitude[0]),
                distanceCalculator.degreeToRadians(longitude[0]),distanceCalculator.degreeToRadians(latitude[1]),
                distanceCalculator.degreeToRadians(longitude[1]));
        assertEquals(309.92,distance,0.5);
    }

    @Test
    public void  testFromDistanceToPointZero() {
        double distance = distanceCalculator.calculatedDistance(distanceCalculator.degreeToRadians(latitude[2]),
                distanceCalculator.degreeToRadians(longitude[2]),distanceCalculator.degreeToRadians(latitude[3]),
                distanceCalculator.degreeToRadians(longitude[3]));
        assertEquals(5958.99,distance,0.5);
    }

    @Test
    public void testSameStartAndFinish() {
        double distance = distanceCalculator.calculatedDistance(distanceCalculator.degreeToRadians(latitude[4]),
                distanceCalculator.degreeToRadians(longitude[4]),distanceCalculator.degreeToRadians(latitude[4]),
                distanceCalculator.degreeToRadians(longitude[4]));
        assertEquals(0.0,distance,0.0);
    }
}
