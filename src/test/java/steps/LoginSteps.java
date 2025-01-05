package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class LoginSteps {
    WebDriver driver;

    @Given("que el usuario está en la página de login")
    public void usuarioEnLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("introduce un usuario válido {string} y contraseña válida {string}")
    public void usuarioValido(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @When("introduce un usuario inválido {string} y contraseña inválida {string}")
    public void usuarioInvalido(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("debería ver un mensaje de éxito {string}")
    public void verificarMensajeExito(String mensaje) {
        String mensajeActual = driver.findElement(By.id("flash")).getText();
        driver.quit();
    }

    @Then("debería ver un mensaje de error {string}")
    public void verificarMensajeError(String mensaje) {
        String mensajeActual = driver.findElement(By.id("flash")).getText();
        driver.quit();
    }
}
