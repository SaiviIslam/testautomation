package se.iths.RESTinlämning;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class CreateUserTest {

    CreateUser user = new CreateUser();

    @Test

    public void userLoginTest() throws JsonProcessingException, UnirestException {
        User user1 = new User(
                0,
                "saiviIslam",
                "Saivi",
                "Islam",
                "saivi_islam@hotmail.com",
                "087635654",
                0,
                "1234"

        );
        HttpResponse response = user.createUser(user1);

        Assert.assertEquals(
                200,
                response.getStatus()
        );
    }

    @Test
    public void userLoginWithFelPw() throws JsonProcessingException, UnirestException {
        User user1 = new User(
                0,
                "saiviIslam",
                "Saivi",
                "Islam",
                "saivi_islam@hotmail.com",
                "087635654",
                0,
                "1234"
        );
        HttpResponse response = user.createUser(user1);
        Assert.assertEquals(
                200,
                response.getStatus()
        );

        HttpResponse<String> getResponse = Unirest
                .get("https://swagger-petstore.azurewebsites.net/v2/user?abc&xyz")
                .asString();

        Assert.assertEquals(400,
                getResponse.getStatus()
        );

    }


}
