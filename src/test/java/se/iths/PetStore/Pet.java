package se.iths.PetStore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    private int id;
    private String name;
    private List<String> photourls;
    private String status;

    public Pet(int id, String name, List<String> photourls, String status) {
        this.id = id;
        this.name = name;
        this.photourls = photourls;
        this.status = status;
    }
    public Pet(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotourls() {
        return photourls;
    }

    public void setPhotourls(List<String> photourls) {
        this.photourls = photourls;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
