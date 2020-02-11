
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class DataSourceImpl implements DataSource {

    private ArrayList<IndividualCustomer> customerList = new ArrayList();
    public static final double LONGITUDE = -6.257664;
    public static final double LATITUDE = 53.339428;

    /*
      loads input from file and saves in an arrayList
     */
    @Override
    public void loadDataFromFile(File file) {
        Gson gson = new Gson();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                IndividualCustomer customer =
                gson.fromJson(scanner.nextLine(),IndividualCustomer.class);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /*
     returns arraylist that holds data
     */
    @Override
    public ArrayList<IndividualCustomer> getData() {
        return customerList;
    }


    @Override
    public void formatOutput() {
        Collections.sort(customerList, Comparator.comparingInt(o -> o.userId));
    }


    @Override
    public void writeResultToFile() {
        try (PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
            for (IndividualCustomer customer: customerList) {
                writer.println(customer.userId +"  "+customer.name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void filterDataUsingBenchMarkDistance(double benchMarkDistance, DistanceCalculator distanceCalculator) {
        Iterator<IndividualCustomer> iterator = customerList.iterator();
        while (iterator.hasNext()){
            IndividualCustomer currentCustomer = iterator.next();
            double distance =  distanceCalculator.calculatedDistance(distanceCalculator.degreeToRadians(LATITUDE),
                    distanceCalculator.degreeToRadians(LONGITUDE),
                    distanceCalculator.degreeToRadians(currentCustomer.latitude),
                    distanceCalculator.degreeToRadians(currentCustomer.longitude));
            if (distance > benchMarkDistance){
                iterator.remove();
            }
        }
    }


}
