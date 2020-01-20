
package geocoding.vo.reversegeocoding;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReverseGeocoding {

    @SerializedName("plus_code")
    @Expose
    public PlusCode plusCode;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;
    @SerializedName("status")
    @Expose
    public String status;

}
