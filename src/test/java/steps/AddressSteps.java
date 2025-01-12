package steps;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressSteps {
	WebDriver driver = WebDriverManager.getDriver();
	
	@When("Clicas a la opción de Orders y Payment")
	public void clicas_a_la_opción_de_orders_y_payment() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement button = driver.findElement(By.cssSelector("button[aria-label='Show Orders and Payment Menu']"));
        Actions actions = new Actions(driver);
		actions.moveToElement(button).perform();
	}
	@When("Clicas a la opción de mis direcciones")
	public void clicas_a_la_opción_de_mis_direcciones() {
		WebElement button = driver.findElement(By.cssSelector("button[aria-label='Go to saved address page']"));
		button.click();
	}
	@When("Clicas al botón de nueva dirección")
	public void clicas_al_botón_de_nueva_dirección() {
		WebElement button = driver.findElement(By.cssSelector("button[aria-label='Add a new address']"));
		button.click();
	}
	@When("Rellenas los datos de tu nueva dirección")
	public void rellenas_los_datos_de_tu_nueva_dirección() {
		driver.findElement(By.cssSelector("input[data-placeholder='Please provide a country.']")).sendKeys("Spain");
		driver.findElement(By.cssSelector("input[data-placeholder='Please provide a name.']")).sendKeys("Paco");
		driver.findElement(By.cssSelector("input[data-placeholder='Please provide a mobile number.']")).sendKeys("656545323");
		driver.findElement(By.cssSelector("input[data-placeholder='Please provide a ZIP code.']")).sendKeys("08100");
		driver.findElement(By.id("address")).sendKeys("Calle Palos Nº2");
		driver.findElement(By.cssSelector("input[data-placeholder='Please provide a city.']")).sendKeys("Barcelona");
	}
	@When("Clicas Submit")
	public void clicas_submit() {
		WebElement button = driver.findElement(By.id("submitButton"));
		button.click();
	}
	
	@Then("Redirige a la página de direcciones guardadas")
	public void direccionesguardadas() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> d.getCurrentUrl().contains("/#/address/saved"));
        assertTrue(driver.getCurrentUrl().contains("/#/address/saved"));
	}
}
