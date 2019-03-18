package se.iths.RESTinlämning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CreateUser {

    ObjectMapper mapper = new ObjectMapper();

    public HttpResponse createUser(User myUser) throws JsonProcessingException, UnirestException {

        String userAsJson = mapper.writeValueAsString(myUser);
        HttpResponse<JsonNode> postUserResponse = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user")
                .header("Content-Type","application/json")
                .body(userAsJson)
                .asJson();

        return postUserResponse;


    }
}
