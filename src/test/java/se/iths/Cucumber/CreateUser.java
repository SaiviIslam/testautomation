package se.iths.Cucumber;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CreateUser {


    @Given("create a user")
    public void create_a_user() throws UnirestException {

        HttpResponse<JsonNode> postUserResponse = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"saivi\",\n" +
                        "  \"firstName\": \"Saivi\",\n" +
                        "  \"lastName\": \"Islam\",\n" +
                        "  \"email\": \"saivi.islam@hotmail.com\",\n" +
                        "  \"password\": \"123456\",\n" +
                        "  \"phone\": \"08237656\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .asJson();

        Assert.assertEquals(
                200,
                postUserResponse.getStatus()
        );

    }

    @Then("login user with right username and passsword")
    public void login_user_with_right_username_and_passsword() throws UnirestException {

        HttpResponse<String> logInUserWithRightUsernamePw = Unirest
                .get("https://swagger-petstore.azurewebsites.net/v2/user/login?username=saivi&password=123456")
                .asString();
        Assert.assertEquals(
                200,
                logInUserWithRightUsernamePw.getStatus()
        );

    }

    @Then("login user with wrong username and password")
    public void login_user_with_wrong_username_and_password() throws UnirestException {
        HttpResponse<String> logInUserWithFelPw = Unirest
                .get("https://swagger-petstore.azurewebsites.net/v2/user/login?username=saiviIslam&password=129872")
                .asString();
        Assert.assertEquals(
                400,
                logInUserWithFelPw.getStatus()
        );
    }


    @Given("create many users")
    public void create_many_users() throws UnirestException {
        HttpResponse<JsonNode> postManyUsersResponse = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/createWithList")
                .header("Content-Type", "application/json")
                .body("[\n" +
                        "{\n" +
                        "\"id\": 1234,\n" +
                        "\"username\": \"maria\",\n" +
                        "\"firstName\": \"Maria\",\n" +
                        "\"lastName\": \"Berg\",\n" +
                        "\"email\": \"maria.123@live.com\",\n" +
                        "\"password\": \"qr4345\",\n" +
                        "\"phone\": \"04628374\",\n" +
                        "\"userStatus\": 0\n" +
                        "}," +
                        "{\n" +
                        "\"id\": 189,\n" +
                        "\"username\": \"linda\",\n" +
                        "\"firstName\": \"Linda\",\n" +
                        "\"lastName\": \"strom\",\n" +
                        "\"email\": \"linda777@gmail.com\",\n" +
                        "\"password\": \"strom123\",\n" +
                        "\"phone\": \"12345666\",\n" +
                        "\"userStatus\": 0\n" +
                        "}\n" +
                        "]")
                .asJson();

        Assert.assertEquals(
                200,
                postManyUsersResponse.getStatus()
        );
    }

    @Then("login users")
    public void login_users() throws UnirestException {
        HttpResponse<String> manyUserLogin = Unirest
                .get("https://swagger-petstore.azurewebsites.net/v2/user/login")
                .asString();
        Assert.assertEquals(200,
                manyUserLogin.getStatus());

    }

    @Then("delete users")
    public void delete_users() throws UnirestException {
        HttpResponse<String> deleteUser1Response = Unirest.delete("https://swagger-petstore.azurewebsites.net/v2/user/maria")
                .asString();
        Assert.assertEquals(200, deleteUser1Response.getStatus());

        HttpResponse<String> deleteUser2Response = Unirest.delete("https://swagger-petstore.azurewebsites.net/v2/user/linda")
                .asString();
        Assert.assertEquals(200, deleteUser2Response.getStatus());
    }

    @Then("update user mail adress")
    public void update_user_mail_adress() throws UnirestException {
        HttpResponse<JsonNode> updateMailAddress = Unirest.put("https://swagger-petstore.azurewebsites.net/v2/user/saivi")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"saivi\",\n" +
                        "  \"firstName\": \"Saivi\",\n" +
                        "  \"lastName\": \"islam\",\n" +
                        "  \"email\": \"abcd.123@hotmail.com\",\n" +
                        "  \"password\": \"123456\",\n" +
                        "  \"phone\": \"08237656\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .asJson();
        Assert.assertEquals(200,
                updateMailAddress.getStatus());

    }

    @Then("get the updated user")
    public void get_the_updated_user() throws UnirestException {

        HttpResponse<String> getUpdatedUserResponse = Unirest.get("https://swagger-petstore.azurewebsites.net/v2/user/saivi")
                .asString();

        Assert.assertEquals(200,
                getUpdatedUserResponse.getStatus()
        );
    }
}
