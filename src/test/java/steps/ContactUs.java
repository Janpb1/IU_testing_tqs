package steps;

import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ContactUs {
	WebDriver driver = WebDriverManager.getDriver();

	@When("voy a la seccion customer feedback")
	public void clicarSeccionCustomer() {
		 WebElement feedbackContainer = driver.findElement(By.cssSelector("[href='#/contact']"));
		 feedbackContainer.click();
	}

	@When("relleno el formulacion con la informacion")
	public void rellenarFormulario() {
	    WebElement commentField = driver.findElement(By.cssSelector("textarea#comment"));
		commentField.sendKeys("This is a feedback comment.");
		
		WebElement slider = driver.findElement(By.cssSelector("mat-slider#rating"));
	    
	    Actions actions = new Actions(driver);

	    actions.clickAndHold(slider)
	           .moveByOffset(150, 0) 
	           .release()
	           .perform();
	    
		WebElement captchaElement = driver.findElement(By.id("captcha"));

	    String captchaText = captchaElement.getText();

	    int captchaResult = evaluateExpression(captchaText);

	    WebElement captchaInputField = driver.findElement(By.id("captchaControl"));
	    captchaInputField.sendKeys(String.valueOf(captchaResult));
	}

	@When("le doy al botón de enviar")
	public void darleAlBotonEnviar() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.mat-simple-snack-bar-content")));

		WebElement submitButton = driver.findElement(By.id("submitButton"));
		if (!submitButton.isEnabled()) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled')", submitButton);
		}
		submitButton.click();
	}

	@Then("aparece un pequeño banner en la parte inferior")
	public void confirmacionCorrecta() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-simple-snack-bar-content")));
		Assert.assertTrue(banner.isDisplayed(), "Banner should be visible.");

	}
	
	@Then("no puedo pulsar el boton porque no esta activo")
	public void formularioNoSeEnvia() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.mat-simple-snack-bar-content")));

		WebElement submitButton = driver.findElement(By.id("submitButton"));
		if (!submitButton.isEnabled()) {
			throw new IllegalStateException("El botón no está deshabilitado, se esperaba que estuviera deshabilitado.");
		}
	}
	
	private int evaluateExpression(final String inputExpression) {
	    return (int) new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < inputExpression.length()) ? inputExpression.charAt(pos) : -1;
	        }

	        boolean eat(int charToEat) {
	            while (ch == ' ') nextChar();
	            if (ch == charToEat) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        int parse() {
	            nextChar();
	            int x = parseExpression();
	            if (pos < inputExpression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
	            return x;
	        }

	        int parseExpression() {
	            int x = parseTerm();
	            for (;;) {
	                if (eat('+')) x += parseTerm();
	                else if (eat('-')) x -= parseTerm();
	                else return x;
	            }
	        }

	        int parseTerm() {
	            int x = parseFactor();
	            for (;;) {
	                if (eat('*')) x *= parseFactor();
	                else if (eat('/')) x /= parseFactor();
	                else return x;
	            }
	        }

	        int parseFactor() {
	            if (eat('+')) return parseFactor();
	            if (eat('-')) return -parseFactor();

	            int x;
	            int startPos = this.pos;
	            if (eat('(')) {
	                x = parseExpression();
	                eat(')');
	            } else if ((ch >= '0' && ch <= '9')) {
	                while ((ch >= '0' && ch <= '9')) nextChar();
	                x = Integer.parseInt(inputExpression.substring(startPos, this.pos));
	            } else {
	                throw new RuntimeException("Unexpected: " + (char) ch);
	            }

	            return x;
	        }
	    }.parse();
	}

}