package steps;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GithubSteps {
	WebDriver driver = WebDriverManager.getDriver();
	
	@When("Clico en el icono del github")
	public void clico_en_el_icono_del_github() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement button = driver.findElement(By.cssSelector("a[aria-label='Go to OWASP Juice Shop GitHub page']"));
		button.click();
	}
	@Then("Estoy en la página de github")
	public void estoy_en_la_página_de_github() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> d.getCurrentUrl().contains("github.com/juice-shop/juice-shop"));
        assertTrue(driver.getCurrentUrl().contains("github.com/juice-shop/juice-shop"));
	}
}
