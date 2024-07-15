package apiTest;

import com.google.gson.Gson;
import entidades.LoanEntity;
import org.testng.annotations.*;
import org.testng.ITestContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TestBookStore {

    String uriBooks = "https://bookstore.toolsqa.com/BookStore/v1/"; // End Base

    String ct = "application/json";

    TestAccount account = new TestAccount();
    Gson  gson = new Gson();
    LoanEntity isbn = new LoanEntity(); // Instacia para a lista de livros

    //@BeforeMethod // Antes de cada @Test (usado para pegar interagir com usarios)
    @BeforeClass // Depois da Classe
    public void setUp(ITestContext context){

        account.testCreateUser(context); // Cria um novo usuario
        account.testGererateToken(context); // Gera um novo Token

    }

     //@AfterMethod //Depois de cada @Test
     @AfterClass // Depois de cada Classe
    public void tearDown(){
        account.testDeletarUser(); //excluir usuario

    }

    @Test(priority = 1)
    public void testReaserchBooks(ITestContext context){ //Consultar livros
        //Configura
        //Dados de entrada não são requeridos, somar chamas o endpoint
        //Resultado esperado Statuscod=200, lista de books

        //Executa
        given()
                .log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer " + context.getAttribute("token")) //Esse context.getAttribute vai pegar o token la do account
        .when()
                .get(uriBooks + "Books")
        //Valida
        .then()
                .log().all()
                .statusCode(200)
        ;
     }
     @Test(priority = 2)
     public void testLoanBooks(ITestContext context){ //emprestrar livros
        // Configura
        // Os dados de entrada
        // userId vira pelo context
         isbn.userId = context.getAttribute("userID").toString(); // código do usuário
         isbn.collectionOfIsbns = new LoanEntity.ISBN[]{
                 new LoanEntity.ISBN("9781449325862")
         };
         //isbn.isbn = "9781449325862"; // código do livro

        // Dados de Saída
        //  statusCode = 201
         // Retorne o isbn do livro emprestado (echo)

         // Executa
         given()
                 .log().all()
                 .contentType(ct)
                 .header("Authorization", "Bearer " + context.getAttribute("token"))
                 .body(gson.toJson(isbn))
         .when()
                 .post(uriBooks + "Books")
         // Valida
         .then()
                 .log().all()
                 .statusCode(201)
                 .body("isbn", is(isbn.isbn))
         ;
     }
     @Test(priority = 3)
     public void testUpdateLoan(ITestContext context){ // Atualizar quem está com qual livro
        // Configura
         // Dados de entrada
         //userId é extraido no BeforeMethod
         String isbnAntigo = "9781449325862"; //Livro a trocar
         String isbnNovo = "9781449331818"; // novo livro

         //alimentar a classe LoanEntity apenas com o código do usuário e o isbn
         isbn = new LoanEntity(); // reiniciando o Obj da classe LoanEntity (reset)
         isbn.userId = context.getAttribute("userID").toString();
        isbn.isbn = isbnNovo; //código do livro que estava com o usuário

         //Executa
         given()
                 .log().all()
                 .contentType(ct)
                 .header("Authorization", "Bearer " + context.getAttribute("token") )
                 .body(gson.toJson(isbn)) //isbn vai mandar o que está na linha isbn.isbn livro novo
         .when()
                 .put(uriBooks + "Books/" + isbnAntigo)
         //Valida
         .then()
                 .log().all()
                 .statusCode(200)
                 .body("books[0].isbn",is(isbnNovo))
        ;
     }

}
