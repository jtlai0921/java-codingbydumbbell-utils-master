package geocoding;

import com.google.gson.Gson;
import geocoding.vo.geocoding.Geocoding;
import geocoding.vo.placeId.PlaceId;
import geocoding.vo.reversegeocoding.ReverseGeocoding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

// https://developers.google.com/maps/documentation/geocoding/start?hl=zh-TW
public class GeocodingAPI {
    private static final String key = "AIzaSyD02gCH4xVi6s3rMAM-oH82R1ngqf37hn4";

    public static final String GEOCODING_URL_STR =
            "https://maps.googleapis.com/maps/api/geocode/json?" +
                    "address=%s&" +
                    "key=%s";

    public static final String REVERSE_GEOCODING_URL_STR =
            "https://maps.googleapis.com/maps/api/geocode/json?" +
                    "latlng=%s&" +
                    "location_type=%s&" +
                    "result_type=%s&" +
                    "key=%s";

    public static final String PLACE_ID_URL_STR =
            "https://maps.googleapis.com/maps/api/geocode/json?" +
                    "place_id=%s" +
                    "&key=%s";

    static OkHttpClient client = new OkHttpClient();

    static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {

        testGeocoding();

//        testReverseGeocoding();

//        testPlaceId();
    }

    // https://developers.google.com/maps/documentation/geocoding/intro?hl=zh-TW#place-id
    private static void testPlaceId() throws IOException {
        String id = "ChIJd8BlQ2BZwokRAFUEcm_qrcA";
        String url = String.format(PLACE_ID_URL_STR, id, key);

        System.out.println(url);

        Gson gson = new Gson();
        PlaceId placeId = gson.fromJson(run(url), PlaceId.class);

        System.out.println(placeId.results.get(0).formattedAddress);
    }

    // https://developers.google.com/maps/documentation/geocoding/intro?hl=zh-TW#ReverseGeocoding
    private static void testReverseGeocoding() throws IOException {
        String latlng = "25.033964,121.564476";
        // "ROOFTOP" indicates that the returned result is a precise geocode for which we have location information accurate down to street address precision.
        String location_type = "ROOFTOP";
        // street_address indicates a precise street address.
        String result_type = "street_address";
        String url = String.format(REVERSE_GEOCODING_URL_STR, latlng, location_type, result_type, key);

        System.out.println(url);

        Gson gson = new Gson();
        ReverseGeocoding reverseGeocoding = gson.fromJson(run(url), ReverseGeocoding.class);

        System.out.println(reverseGeocoding.results.get(0).formattedAddress);
    }

    // https://developers.google.com/maps/documentation/geocoding/intro?hl=zh-TW#geocoding
    private static void testGeocoding() throws IOException {
        String address = "桃園市中正路 474 號";
        String url = String.format(GEOCODING_URL_STR, address, key);

        System.out.println(url);

        Gson gson = new Gson();
        Geocoding geocoding = gson.fromJson(run(url), Geocoding.class);

        System.out.println(geocoding.results.get(0).geometry.location.lat);
        System.out.println(geocoding.results.get(0).geometry.location.lng);
    }
}
