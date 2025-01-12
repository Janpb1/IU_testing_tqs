package steps;

import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class SearchProductSteps {

	WebDriver driver = WebDriverManager.getDriver();

	@When("el usuario pulsa el banner de busqueda")
	public void pulsarBusqueda() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("mat-search-bar .mat-search_icon-search")));
		searchIcon.click();
	}

	@When("introduce la palabra juice")
	public void introducirPalabraJuice() {
		WebElement searchInput = driver.findElement(By.cssSelector("mat-search-bar input#mat-input-0"));

		searchInput.sendKeys("juice");
		Actions actions = new Actions(driver);
		actions.sendKeys(searchInput, Keys.ENTER).perform();
	}
	
	@When("introduce la palabra teclado")
	public void introducirPalabraTeclado() {
		WebElement searchInput = driver.findElement(By.cssSelector("mat-search-bar input#mat-input-0"));

		searchInput.sendKeys("teclado");
		Actions actions = new Actions(driver);
		actions.sendKeys(searchInput, Keys.ENTER).perform();
	}

	@Then("aparecen los resultados")
	public void mostrarResultados() {
		WebElement secondSpan = driver.findElement(By.id("searchValue"));
		String secondSpanText = secondSpan.getText();
		assertEquals(secondSpanText, "juice");

		List<WebElement> productos = driver.findElements(By.cssSelector("mat-grid-tile"));

        if (!productos.isEmpty()) {
            System.out.println("Hay productos disponibles.");
        } else {
            System.out.println("No hay productos disponibles.");
        }
	}
	
	@Then("no aparecen resultados")
	public void noMostrarResultados() {
		WebElement secondSpan = driver.findElement(By.id("searchValue"));
		String secondSpanText = secondSpan.getText();
		assertEquals(secondSpanText, "teclado");

		List<WebElement> productos = driver.findElements(By.cssSelector("mat-grid-tile"));

        if (!productos.isEmpty()) {
            System.out.println("Hay productos disponibles.");
        } else {
            System.out.println("No hay productos disponibles.");
        }
	}
}