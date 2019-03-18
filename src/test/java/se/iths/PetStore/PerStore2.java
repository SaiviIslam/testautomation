package se.iths.PetStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

public class PerStore2 {

    @Test
    public void getPet() throws UnirestException, IOException {

        Pet fido = new Pet(
                123457,
                "Fido II",
                Collections.emptyList(),
                "available"
        );
        ObjectMapper mapper = new ObjectMapper();
        String fidoAsJson = mapper.writeValueAsString(fido);

        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .body(fidoAsJson)
                .asJson();
        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );
        HttpResponse<String>  getPetResponse = Unirest
                .get("http://petstore.swagger.io/v2/pet/123457")
                .asString();
        Pet myPetAgain = mapper.readValue(getPetResponse.getBody(),Pet.class);

        Assert.assertEquals(
                200,
                getPetResponse.getStatus()
        );

        Assert.assertEquals(
                "Fido II",
                myPetAgain.getName()
        );
    }

    @Test
    public void getOrder() throws IOException, UnirestException {

        Order order = new Order(
                1,
                123457,
                1,
                "2019-02-22",
                "available"

        );

        ObjectMapper mapper = new ObjectMapper();
        String orderAsJson = mapper.writeValueAsString(order);

        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .body(orderAsJson)
                .asJson();
        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );


    }
}
