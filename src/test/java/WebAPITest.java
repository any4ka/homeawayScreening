import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna Kruglyanskaya on 2/9/2016.
 */
public class WebAPITest {
    final String API_KEY = "ofBGe2aCXm2YMjwS5BoPSmBmZXuj8Pen0zTaaSzV";
    String response;
    int stationCode;

    static {
        RestAssured.baseURI = "https://developer.nrel.gov/api/alt-fuel-stations/";
    }

    @Test
    public void getStationNameAndId() {
        response = RestAssured.get("v1.json?api_key=" + API_KEY + "&ev_network=ChargePoint Network&state=TX&city=Austin").then().contentType(ContentType.JSON).extract().response().asString();
        JsonPath jsonPath = new JsonPath(response).setRoot("fuel_stations");
        List<String> stationNames = jsonPath.get("station_name");
        List<Integer> stationId = jsonPath.get("id");
        Map<String, Integer> station = new HashMap<String, Integer>();

        for (int i = 0; i < stationNames.size(); i++) {
            station.put(stationNames.get(i), stationId.get(i));
        }
        Assert.assertTrue(station.containsKey("HYATT AUSTIN"));
        stationCode = station.get("HYATT AUSTIN");
    }

    @Test
    public void getAddress() {
        response = RestAssured.get("v1.json?api_key=" + API_KEY + "&id="+stationCode).then().contentType(ContentType.JSON).extract().response().asString();
        System.out.println(response);
    }

}
