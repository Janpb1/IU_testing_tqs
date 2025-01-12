package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver = WebDriverManager.getDriver();

    @Given("Estoy en la página de inicio de sesión")
    public void estoy_en_la_pagina_de_inicio_de_sesion() {
        driver.get("https://juice-shop.herokuapp.com/#/login");
    }

    @When("Introduzco un correo electrónico y contraseña válidos")
    public void introduzco_un_correo_electronico_y_contrasena_validos() {
        driver.findElement(By.id("email")).sendKeys("paco@gmail.com");
        driver.findElement(By.id("password")).sendKeys("paco1234");
    }

    @When("Hago clic en el botón de inicio de sesión")
    public void hago_clic_en_el_boton_de_inicio_de_sesion() {
        driver.findElement(By.id("loginButton")).click();
    }

    @When("^Introduzco un correo electrónico o contraseña inválidos$")
    public void introduzco_un_correo_electronico_o_contrasena_invalidos() {
        driver.findElement(By.id("email")).sendKeys("invaliduser@example.com");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
    }

    @Then("Debería ver un mensaje de error")
    public void deberia_ver_un_mensaje_de_error() {
    	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> d.findElement(By.cssSelector(".error.ng-star-inserted")));
        WebElement errorMessage = driver.findElement(By.cssSelector(".error.ng-star-inserted"));
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Invalid email or password.", errorMessage.getText());
    }

}
