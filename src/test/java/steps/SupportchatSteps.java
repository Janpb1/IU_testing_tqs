package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SupportchatSteps {
	WebDriver driver = WebDriverManager.getDriver();
	
	@When("Clico en el icono de chat de soporte")
	public void clic_icono_chat_soporte() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement button = driver.findElement(By.cssSelector("a[aria-label='Go to chatbot page']"));
		button.click();
	}
	@When("Estoy en la página de soporte")
	public void estoy_en_la_página_de_soporte() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	wait.until(d -> d.getCurrentUrl().contains("/#/chatbot"));
        assertTrue(driver.getCurrentUrl().contains("/#/chatbot"));
	}
	@When("Escribo hola")
	public void escribo_hola() {
		driver.findElement(By.id("message-input")).sendKeys("Hola" + Keys.ENTER);
	}
	@Then("Recibo un mensaje del bot")
	public void recibo_un_mensaje_del_bot() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement chatWindow = driver.findElement(By.id("chat-window"));
		List<WebElement> childDivs = chatWindow.findElements(By.xpath("./div"));
		int count = childDivs.size();
		assertEquals(count, 3);
	}
}
