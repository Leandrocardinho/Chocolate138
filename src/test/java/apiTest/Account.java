// 1 - Pacote
package apiTest;

// 2- Bibliotecas
// 3 - Classe

import com.google.gson.Gson;
import entidades.AccountEntidade;
import io.restassured.response.Response;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Account {
// 3.1 - Atributos
    String userId; // Criado aqui regra que vale para toda classe, userId tratado no testCreateUser
    String token;
    //3.1.2 Instanciar classes esternas
    Gson gson = new Gson(); // conversão classe para JSon

// 3.2 Métodos e Funções


    //Metodo 1 -Criar Usuário
    @Test
    public void testCreateUser(){
        // Configura - Arrange
        AccountEntidade account = new AccountEntidade(); // Instanciando a classe usario
        account.userName = "Macedo150074"; // entrada e saida (resultado Esperado)
        account.password = "P@ssw0r1"; //entrada

        String jsonBody = gson.toJson(account); //conversa a classe em json

//jeito de fazer tracional de fazer o configura
//String userName = "Malu";       //usuario
// String password = "123456";     //senha

        //Executa -Act

// Dado- Given  Quando-when Então-Then
        Response resposta = (Response) given() //Response vai pegar o que tem dentro do given, nesse caso vamos pegar o id do usuario.
                .contentType("application/json") // tipo de conteudo
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://bookstore.toolsqa.com/Account/v1/User")

        .then()
                .log().all() //registra tudo na volta
                .statusCode(201)
                .body("username", is(account.userName))
                .extract(); // extract vai pegar as informações do usario e jogar no response

        //Extrair o userId (identificar usuario) ou seja userId vai pegar o que tem dentro da resposta
         userId = resposta.jsonPath().getString("userID");
        System.out.println("UserID extraido: " + userId);


    }
    @Test
    public void testGererateToken(){
       //Configura
        AccountEntidade account = new AccountEntidade(); // Instanciando a classe usario, ou seja pegando o que foi criado eno pacote entidades
        account.userName = "Macedo150074";
        account.password = "P@ssw0r1";

        String jsonBody = gson.toJson(account); // transforma em Json o que tem no account criado acima

        // Dado- Given  Quando-when Então-Then
        Response resposta = (Response) given() // Response criado para pegar o id que esta logado
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://bookstore.toolsqa.com/Account/v1/User")
        .then()
                .log().all()
                .statusCode(200)
                .body("username", is(account.userName))
                .extract() // usando para extrair o response
        ;

                token = resposta.jsonPath().getString("expires");
        System.out.println("Token extraido: " + token);




    }

}
