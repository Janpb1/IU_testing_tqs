package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProfileSteps {
	WebDriver driver = WebDriverManager.getDriver();
	
	String username = "";
	
	@When("Clicas la opción donde sale tu correo")
	public void clicas_la_opción_donde_sale_tu_correo() {
		WebElement button = driver.findElement(By.cssSelector("button[aria-label='Go to user profile']"));
		button.click();
	}
	@When("Pones un nombre nuevo de usuario")
	public void pones_un_nombre_nuevo_de_usuario() {
		Random random = new Random();
        int randomNumber = random.nextInt(999999) + 1;
		username = "Paco" + randomNumber;
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@When("Clicas Set Username")
	public void clicas_set_username() {
		WebElement button = driver.findElement(By.id("submit"));
		button.click();
	}
	@Then("Sale tu nuevo nombre al lado de la foto")
	public void sale_tu_nuevo_nombre_al_lado_de_la_foto() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement p = driver.findElement(By.cssSelector("p[style='margin-top:8%; color: #FFFFFF; text-align: center;']"));
		String name = p.getText();
		name = name.replace("\\", "");
		assertEquals(name, username);
	}
	
	@Then("Se te redirige a la página de tu perfil")
	public void se_te_redirige_a_tu_perfil() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> d.getCurrentUrl().contains("profile"));
        assertTrue(driver.getCurrentUrl().contains("profile"));
	}
}
