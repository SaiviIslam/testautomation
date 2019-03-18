package se.iths.PetStore;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class PetStoreTest {
    @Test
    public void getPet() throws UnirestException {
        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 53425,\n" +
                        "    \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"small animals\"\n" +
                        "    },\n" +
                        "    \"name\": \"dido\",\n" +
                        "    \"photoUrls\": [\n" +
                        "        \"http://example.url\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"nice pet\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"status\": \"available\"\n" +
                       "}")
                .asJson();
        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );
        HttpResponse<String> deletePetResponse = Unirest.delete("http://petstore.swagger.io/v2/pet/53425")
                .asString();
        Assert.assertEquals(
                200,
                deletePetResponse.getStatus()
        );
        HttpResponse<JsonNode> getPetResponse = Unirest.get("http://petstore.swagger.io/v2/pet/53425")
                .asJson();

        Assert.assertEquals(404,
                getPetResponse.getStatus()
        );
        Assert.assertEquals(
                "dido",
                getPetResponse.getBody().getObject().getString("name")

        );
    }

    @Test
    public void createNewPet() throws UnirestException {
        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 53425,\n" +
                        "    \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"small animals\"\n" +
                        "    },\n" +
                        "    \"name\": \"dido\",\n" +
                        "    \"photoUrls\": [\n" +
                        "        \"http://example.url\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"nice pet\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"status\": \"available\"\n" +
                        "}")
                .asJson();
        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );
    }
    @Test
    public void deletePet() throws UnirestException {
        HttpResponse<String> getPetResponse = Unirest.delete("http://petstore.swagger.io/v2/pet/53425")
                .asString();
        Assert.assertEquals(
                200,
                getPetResponse.getStatus()
        );

    }
}
