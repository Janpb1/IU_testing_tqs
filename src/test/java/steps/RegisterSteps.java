package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;


public class RegisterSteps {
	WebDriver driver = WebDriverManager.getDriver();
    
	@Given("estoy en la página de registro")
    public void estoy_en_la_pagina_de_registro() {
        driver.get("https://juice-shop.herokuapp.com/#/register");
    }
	
	@When("introduzco un email, contraseña dos veces y la respuesta de seguridad")
	public void introduzcodatosregistro() {
		Random random = new Random();
        int randomNumber = random.nextInt(999999) + 1;
		driver.findElement(By.id("emailControl")).sendKeys("paco" + randomNumber + "@gmail.com");
        driver.findElement(By.id("passwordControl")).sendKeys("paco1234");
        driver.findElement(By.id("repeatPasswordControl")).sendKeys("paco1234");
        WebElement securityQuestionSelect = driver.findElement(By.id("mat-select-0"));
        securityQuestionSelect.click();
        WebElement option = driver.findElement(By.id("mat-option-0"));
        option.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.findElement(By.id("securityAnswerControl")).sendKeys("paco1234");
	}
	
	@When("hago clic en el boton de registro")
    public void hago_clic_en_el_boton_de_inicio_de_sesion() {
        driver.findElement(By.id("registerButton")).click();
    }
	
	@When("Debería ser redirigido a la página de login")
    public void deberia_ser_redirigido_a_la_pagina_principal() {
    	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> d.getCurrentUrl().contains("/#/login"));
        assertTrue(driver.getCurrentUrl().contains("/#/login"));
    }
	
	@When("introduzco un email, contraseña dos veces y me olvido de la pregunta de seguridad")
	public void introduzcodatosregistrosinpreguntadeseguridad() {
		Random random = new Random();
        int randomNumber = random.nextInt(999999) + 1;
		driver.findElement(By.id("emailControl")).sendKeys("paco" + randomNumber + "@gmail.com");
        driver.findElement(By.id("passwordControl")).sendKeys("paco1234");
        driver.findElement(By.id("repeatPasswordControl")).sendKeys("paco1234");
    }
	
	@Then("el botón de registro está deshabilitado") 
	public void botonregistrodeshabilitado() {
		WebElement button = driver.findElement(By.id("registerButton"));
		assertTrue(!button.isEnabled());
	}
}
