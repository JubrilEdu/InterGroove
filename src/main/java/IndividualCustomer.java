import com.google.gson.annotations.SerializedName;

public class IndividualCustomer {
    @SerializedName("name")
    public String name;
    @SerializedName("longitude")
    public double longitude;
    @SerializedName("latitude")
    public double latitude;
    @SerializedName("user_id")
    public int userId;
}
