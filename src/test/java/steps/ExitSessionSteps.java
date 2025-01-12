package steps;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExitSessionSteps {
	WebDriver driver = WebDriverManager.getDriver();

	@When("Clicas al botón de cerrar sesión")
	public void clicas_al_botón_de_cerrar_sesión() {
		WebElement button = driver.findElement(By.id("navbarLogoutButton"));
		button.click();
	}
	@Then("Aparece el botón de loguear")
	public void aparece_el_botón_de_loguear() {
		WebElement button = driver.findElement(By.id("navbarLoginButton"));
		assertNotNull(button, "Button not found!");
	}
}
