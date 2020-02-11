import org.junit.Before;

import java.io.File;

import static org.junit.Assert.*;

public class DataSourceImplTest {
    private DataSourceImpl dataSource;
    private DistanceCalculator distanceCalculator;

    @Before
    public void setUp(){
        dataSource = new DataSourceImpl();
        distanceCalculator = new DistanceCalculatorImpl();
    }

    @org.junit.Test
    public void loadDataFromFile() {
        assertEquals(dataSource.getData().size(),0);
        dataSource.loadDataFromFile(new File("/Users/Jubril/IdeaProjects/InterGroove/src/test/resources/testInput"));
        assertTrue(dataSource.getData().size() > 0);

    }


    @org.junit.Test
    public void filterDataUsingBenchMarkDistance() {
        IndividualCustomer newCustomer = new IndividualCustomer();
        newCustomer.userId = 5;
        newCustomer.name = "Jubril Edu";
        newCustomer.latitude =  59.339428;
        newCustomer.longitude= -8.257664;
        dataSource.getData().add(newCustomer);
        dataSource.filterDataUsingBenchMarkDistance(50,distanceCalculator);
        assertFalse(dataSource.getData().contains(newCustomer));
    }
}
