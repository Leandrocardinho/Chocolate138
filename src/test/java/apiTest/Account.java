// 1 - Pacote
package apiTest;

// 2- Bibliotecas
// 3 - Classe

import com.google.gson.Gson;
import entidades.AccountEntidade;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Account {
// 3.1 - Atributos
    String userId; // Criado aqui regra que vale para toda classe, userId tratado no testCreateUser
    String token; // guardar token para autenticação do user
    String ct = "application/json"; //contentType da API
    String uri ="https://bookstore.toolsqa.com/Account/v1/";
    Response response; // guarda o retorno da api linha 50
    //3.1.2 Instanciar classes esternas
    Gson gson = new Gson(); // conversão classe para JSon



// 3.2 Métodos e Funções


    //Metodo 1 -Criar Usuário
    @Test (priority = 0)
    public void testCreateUser(){
        // Configura - Arrange
        AccountEntidade account = new AccountEntidade(); // Instanciando a classe usario
        account.userName = "Japaa10"; // entrada e saida (resultado Esperado)
        account.password = "P@ssw0r1"; //entrada

        String jsonBody = gson.toJson(account); //conversa a classe em json

//jeito de fazer tracional de fazer o configura
//String userName = "Malu";       //usuario
// String password = "123456";     //senha

        //Executa -Act

// Dado- Given  Quando-when Então-Then
        Response resposta = (Response) given() //Response vai pegar o que tem dentro do given, nesse caso vamos pegar o id do usuario.
                .contentType(ct) // tipo de conteudo
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "User")

        .then()
                .log().all() //registra tudo na volta
                .statusCode(201)
                .body("username", is(account.userName))
                .extract(); // extract vai pegar as informações do usario e jogar no response

        //Extrair o userId (identificar usuario) ou seja userId vai pegar o que tem dentro da resposta
         userId = resposta.jsonPath().getString("userID");
        System.out.println("UserID extraido: " + userId);


    }
    @Test (priority = 1)
    public void testGererateToken(){
       //Configura
        AccountEntidade account = new AccountEntidade(); // Instanciando a classe usario, ou seja pegando o que foi criado eno pacote entidades
        account.userName = "Japaa10";
        account.password = "P@ssw0r1";

        String jsonBody = gson.toJson(account); // transforma em Json o que tem no account criado acima

        // Dado- Given  Quando-when Então-Then
        Response resposta = (Response) given() // Response criado para pegar o id que esta logado
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is("Success")) // valida o que status que está voltando da api
                .body("result", is("User authorized successfully.")) // valida o resultado
                .extract() // guarda o token para no response linha 72 e 86
        ;
                //Extraçao do token
                token = resposta.jsonPath().getString("token");


        //Valida
        //comparar token
        String tokenExtraido = resposta.jsonPath().getString("token");

        Assert.assertEquals(token,tokenExtraido);
        System.out.println("Token extraido: " + token);


    }
    @Test (priority = 2)
    public void testAccountAutotizado(){
        AccountEntidade account = new AccountEntidade(); //Instanciando
        account.userName = "Japaa10";
        account.password ="P@ssw0r1";

        String jsonBody = gson.toJson(account); // transforma o account em um json
                given()
                        .contentType(ct)
                        .log().all()
                        .body(jsonBody)
                .when()
                        .post(uri + "Authorized")
                .then()
                        .log().all()
                        .statusCode(200)
                        
                ;

    }/*
   @Test (priority = 3)
   public void testConsultarUser(){

             String account = userId;

        String jsonBody = gson.toJson(account);
       Response resposta = (Response)given() //Dado
                        .contentType(ct)
                        .log().all()

                .when() //Quando
                        .get(uri + "User/{UUID}")
                .then() //Então
                        .log().all()
                        .statusCode(200)
               ;
       token = resposta.jsonPath().getString("token");

                ;
       System.out.println("userID: " + userId)
                        //.body("username", is("Macedo150074"))
                ;

    }
}
*/}