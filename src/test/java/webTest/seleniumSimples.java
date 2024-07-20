// 1 - Pacote
package webTest;
// 2- bibliotecas

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

//3 - Classe
public class seleniumSimples {
     // 3.1 -Atributos
    WebDriver driver ; //Objeto do Selenium WebDriver

    // 3.2 -Funçoes e Metodos de apoio
        //NÃO VAMOS CRIAR

    // 3.3 - Antes do testes (@Before)
    @BeforeMethod
    public void setUp(){
        // Instalar e configurar o driver do browser
        WebDriverManager.chromedriver().setup(); // dowload e instalação do chrome

        // configurar as opções para o driver do navegador apartir do Selenium 4.8.0
        ChromeOptions options = new ChromeOptions(); // objeto de configuração do chrome
        options.addArguments("--remote.allow-origins=*"); //permitir qualquer origem remota


        // Instaciar o Selenium coomo driver de um navegador
        driver = new ChromeDriver(options); // instacia o Selenium para o chrome com opções

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); // vai aguardar 5 segundos
        driver.manage().window().maximize(); // maximiza a janela do navegador
    }

    // 3.4 -Depois do testes (After)
    @AfterMethod
    public void tearDown(){
        driver.quit(); //destroi o objeto do Selenium n
    }

    // 3.5 -Testes em si
@Test
    public void testarSelecionarMochila(){
        // Abrir a pagina inicial do site SauceDemo
    driver.get("https://www.saucedemo.com");

    // Digitar usuario e senha para fazer login
    // Clicar no elemento antes de escrever
   WebElement username = driver.findElement(By.id("user-name")); // controlando o elemento da pagina
   username.click(); // clicar no elemento id=user-name
    username.clear(); // Limpa a caixa de texto
    username.sendKeys("standard_user"); // escreve na caixa de texto
    //username.sendKeys(Keys.chord("standard_user")); // faz a mesma coisa do sendKeys poren escreve letra por letra igual uma pessoa teclando

    // Entrar com o password na tela de login
    driver.findElement(By.id("password")).sendKeys("secret_sauce");

    driver.findElement(By.id("login-button")).click(); //Clicar botão login

    //Transição de pagina / carregamento de nova pagina(lentidão)

    // Verificar se estamos na pagina interna (se consegui o acesso)
    //Verifica a palavra "Products" em determinado elemento
   assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Products");

   // Verifica se está presente o carrinho de complas
        assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed()); // usando asserTrue vericar se sim ou não

   //seleciona o produto que seria o id n4
    driver.findElement(By.id("item_4_title_link")).click();
    //transicção de tela para página do produto

    //Validar nome e valor
    assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(),
            "Sauce Labs Backpack");

    //Validar o preço
    assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(),
            "$29.99");

    // clicar no botão adiconar no carinho
    driver.findElement(By.id("add-to-cart")).click();
    // clicar no icone do carinho
    driver.findElement(By.id("shopping_cart_container")).click();

    //Outra transição de tela/ carregamento de pagina

    //Valida o titulo da pagina, nom do produto, quantidade e preço
   assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Your Cart");
   assertEquals(driver.findElement(By.id("item_4_title_link")).getText(),"Sauce Labs Backpack");
   assertEquals(driver.findElement(By.className("cart_quantity")).getText(), "1");
    assertEquals(driver.findElement(By.className("inventory_item_price")).getText(),"$29.99");

    //clicar em checkout
    driver.findElement(By.id("checkout")).click();

    // Outra transição de tela

    //Valida o titulo da pagina (checkout)
    assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Checkout: Your Information");

    //Clilar no first name
    WebElement firstName = driver.findElement(By.id("first-name"));
    firstName.click();
    firstName.sendKeys("Leandro");
    }

}
