package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndpointsTests {

    Faker faker;
    User user;


    @Test (priority = 1)
    public void postUserTest () {
        faker = new Faker();
        user = new User();

        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());

        Response response = UserEndpoints.postUser(user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test (priority = 2)
    public void getUserTest () {
        Response response = UserEndpoints.getUser(this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test (priority = 3)
    public void updateUserTest () {

        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());

        Response response = UserEndpoints.putUser(this.user.getUsername(),user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        Response responseAfterUpdate = UserEndpoints.getUser(this.user.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test (priority = 4)
    public void deleteUserTest () {
        Response response = UserEndpoints.deleteUser(this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
