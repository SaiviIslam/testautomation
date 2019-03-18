package se.iths.PetStore;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.util.Collections;

public class JacksonEx {
    PetStoreClient client = new PetStoreClient();

    @Test

    public void serializePet() throws JsonProcessingException, UnirestException {
        Pet fido = new Pet(
                123457,
                "Fido II",
                Collections.emptyList(),
                "available"
        );
        client.createPet(fido);

     ObjectMapper mapper = new ObjectMapper();
     String fidoAsJson = mapper.writeValueAsString(fido);
        System.out.println(fidoAsJson);

    }
    @Test

    public void orderSerialize() throws JsonProcessingException {

        Order order = new Order(
                1,
                123457,
                1,
                "2019-02-22",
                "available"

        );

        ObjectMapper mapper = new ObjectMapper();
        String orderAsJson = mapper.writeValueAsString(order);
        System.out.println(orderAsJson);

    }
}
