package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.openqa.selenium.WebDriver.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class seleniumIde {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
   @BeforeMethod//Roda antes do Test
    public void setUp() {
     WebDriverManager.chromedriver().setup(); //instala o driver do chrome
       ChromeOptions options  = new ChromeOptions(); // instacia o obj de configuraçãp
       options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options); // instancia o Selenium como ChromeDriver a configuração
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));



        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterMethod //Roda depois do teste
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void login() throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); //abrir site
        driver.manage().window().setSize(new Dimension(1000, 700));
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
        //carregando pagina interna -- demora um pouco
        //Passo abaixo não é necessario pois carinho inicia vazio
        // driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();

        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
        driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
        driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
        assertThat(driver.findElement(By.cssSelector("*[data-test=\"title\"]")).getText(), is("Checkout: Your Information"));
    }
}
