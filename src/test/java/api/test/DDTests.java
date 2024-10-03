package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userID, String username, String firstName, String lastName, String userEmail, String password, String phoneNumber) {
        User user = new User();
        user.setId(Integer.parseInt(userID));
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(userEmail);
        user.setPassword(password);
        user.setPhone(phoneNumber);

        Response response = UserEndpoints.postUser(user);
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName) {
        Response response = UserEndpoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}


