package se.iths.PetStore;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class ReqResTest {
    @Test
    public void createUser() throws UnirestException {

        HttpResponse<JsonNode> postUserResponse = Unirest
                .post(" https://reqres.in/api/users")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\",\n" +
                        "    \"id\": \"727\",\n" +
                        "    \"createdAt\": \"2019-02-26T08:31:07.696Z\"\n" +
                        "}")
                .asJson();
        Assert.assertEquals(
                201,
                postUserResponse.getStatus()
        );

    }
}