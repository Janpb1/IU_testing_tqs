package steps;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps {
	WebDriver driver = WebDriverManager.getDriver();
	
	@Given("estoy en página de inicio")
    public void estoy_en_la_pagina_de_inicio() {
        driver.get("https://juice-shop.herokuapp.com/#/search");
    }
	
	@When("Cierro el banner de bienvenida")
    public void cerrarBannerDeBienvenida() {
    	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    	wait.until(d -> d.findElement(By.cssSelector("[aria-label='Close Welcome Banner']")));
        WebElement closeButton = driver.findElement(By.cssSelector("[aria-label='Close Welcome Banner']"));
        closeButton.click();
    }
	
	@When("Clicas al botón de cuenta")
	public void clicas_al_botón_de_cuenta() {
		WebElement navbarAccount = driver.findElement(By.id("navbarAccount"));
		navbarAccount.click();
	}
	
	@When("Abro el menu desplegable de la izquierda")
    public void abrirMenuLateralIzquirda() {
        WebElement menuButton = driver.findElement(By.cssSelector("span.mat-button-wrapper mat-icon[aria-hidden='true']"));
        menuButton.click();
    }
	
	@When("Debería ser redirigido a la página principal")
    public void deberia_ser_redirigido_a_la_pagina_principal() {
    	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> {
            String currentUrl = d.getCurrentUrl();
            return currentUrl.contains("/#/search") || currentUrl.endsWith("/#/");
        });
    	String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/#/search") || currentUrl.endsWith("/#/"));
    }
}
