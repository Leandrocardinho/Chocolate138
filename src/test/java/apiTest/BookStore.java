package apiTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestContext;

import static io.restassured.RestAssured.given;

public class BookStore{

    String uriBooks = "https://bookstore.toolsqa.com/BookStore/v1/"; // End Base

    Account account = new Account();

    @BeforeMethod // Antes de cada @Test (usado para pegar interagir com usarios)
    public void setUp(ITestContext context){

        account.testCreateUser(); // Cria um novo usuario
        account.testGererateToken(context); // Gera um novo Token

    }

    @AfterMethod //Depois de cada @Test
    public void tearDown(){
        account.testDeletarUser(); //excluir usuario

    }

    @Test(priority = 1)
    public void testReaserchBooks(ITestContext context){
        //Configura
        //Dados de entrada não são requeridos, somar chamas o endpoint
        //Resultado esperado Statuscod=200, lista de books

        //Executa
        given()
                .log().all()
                .contentType("application/json")
                .header("Authentication", "Bearer " + context.getAttribute("token")) //Esse context.getAttribute vai pegar o token la do account
        .when()
                .get(uriBooks + "Books")
        //Valida
        .then()
                .log().all()
                .statusCode(200)
        ;


    }

}
