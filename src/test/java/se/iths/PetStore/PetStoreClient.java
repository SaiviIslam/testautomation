package se.iths.PetStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;

public class PetStoreClient {
    ObjectMapper mapper = new ObjectMapper();

    public void createPet(Pet myPet) throws JsonProcessingException, UnirestException {
        try {
            String fidoAsJson = mapper.writeValueAsString(myPet);
            HttpResponse<JsonNode> postPetResponse = Unirest
                    .post("http://petstore.swagger.io/v2/pet")
                    .header("Content-Type", "application/json")
                    .body(fidoAsJson)
                    .asJson();
            System.out.println(postPetResponse.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Pet getPet(int id) throws UnirestException {
        return getPet(id, 200);
    }

    public Pet getPet(int id, int expectedStatusCode) throws UnirestException {
        try {
            HttpResponse<String> getPetResponse = Unirest
                    .get("http://petstore.swagger.io/v2/pet/123457")
                    .asString();

            Pet myPet = mapper.readValue(
                    getPetResponse.getBody(),
                    Pet.class
            );

            Assert.assertEquals(expectedStatusCode, getPetResponse.getStatus());
            return myPet;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
