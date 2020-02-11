import java.io.File;

public class Main {

    public static final String filePath = "./src/main/resources/input";
    public static final double DISTANCE_THRESHOLD = 100;


    public static void main(String[] args) {
      DataSourceImpl dataSource = new DataSourceImpl();
      DistanceCalculator distanceCalculator = new DistanceCalculatorImpl();
      dataSource.loadDataFromFile(new File(filePath));
      dataSource.filterDataUsingBenchMarkDistance(DISTANCE_THRESHOLD,distanceCalculator);
      dataSource.formatOutput();
      dataSource.writeResultToFile();
    }

}
