package api.endpoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class UserEndpoints {

    public static Response getUser (String username) {

      Response response = given()
                .pathParam("username", username)
                .when()
                .get(Root.getUserLink);

      return response;
    }

    public static Response postUser (User data) {

      Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(data)
                .when()
                .post(Root.postUserLink);

        return response;
    }

    public static Response putUser (String username, User data) {

      Response response = given()
                .pathParam("username", username)
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .put(Root.updateUserLink);

      return response;
    }

    public static Response deleteUser (String username) {

        Response response = given()
                .pathParam("username",username)
                .when()
                .delete(Root.deleteUserLink);

        return  response;
    }


}
