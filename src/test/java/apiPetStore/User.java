package apiPetStore;

import entidades.UserEntidade;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {

    //Atributos
    Gson gson = new Gson();
    String json = "application/json";
    String uri = "https://petstore.swagger.io/v2/";

    @Test
    public void testCreateUser(){

        //Configura - Arrange
        //Dados de Entrada
        UserEntidade user = new UserEntidade(); //Instanciando para usar
        user.id = 100;
        user.usename = "jell";
        user.firstName = "jell";
        user.lastName ="brown";
        user.email = "jellbrown@gmail.com";
        user.password = "password123";
        user.phone = "1197299999";
        user.userStatusString = 0;

        String jsonBody = gson.toJson(user); //transformando user em json

        // Executa - Act
        //Given- Dado / When - Quando / Then - Então
        given()
                .contentType(json) //json usando ("application/json)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "user")

                // Valida -
       .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message",is("100"))
        ;



    }
}
