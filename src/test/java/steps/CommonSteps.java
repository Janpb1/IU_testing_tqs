package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

public class CommonSteps {
	public static WebDriver driver;
	
	public CommonSteps() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
	}
	
	@When("Cierro el banner de bienvenida")
    public void cerrarBannerDeBienvenida() {
    	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    	wait.until(d -> d.findElement(By.cssSelector("[aria-label='Close Welcome Banner']")));
        WebElement closeButton = driver.findElement(By.cssSelector("[aria-label='Close Welcome Banner']"));
        closeButton.click();
    }
}
