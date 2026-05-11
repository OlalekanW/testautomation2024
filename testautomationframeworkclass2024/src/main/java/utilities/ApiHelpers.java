package utilities;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import com.google.gson.GsonBuilder;


public class ApiHelpers {

    private static Gson gson;

    static {
        RestAssured.baseURI = "https://localhost:5055/api/Rate/get-rate";
    }
    public static RequestSpecification givenConfig(){

        RestAssured.useRelaxedHTTPSValidation();
        return given().header("Accept-Language", "en").header("Content-Type", "application/json");
    }

    public static Gson gson(GsonBuilder gsonBuilder){

        gson = gsonBuilder.create();

        return gson;
    }

    public static Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        return gson;
    }

}

