import java.io.File;
import java.util.ArrayList;

public interface DataSource {

    void loadDataFromFile(File file);

    ArrayList<IndividualCustomer> getData();

    void formatOutput();

    void writeResultToFile();

    void filterDataUsingBenchMarkDistance(double benchMarkDistance, DistanceCalculator distanceCalculator);

}
