package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WomenDressSteps {
	
	WebDriver driver;

	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage() {
	    System.setProperty("webdriver.gecko.driver", "C:/Users/Jan/Documents/4t curs/1r semestre/TQS/Practiques/Practica2/Practica2TQS/Drivers/geckodriver.exe");
	    FirefoxOptions options = new FirefoxOptions();
	    options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
	    driver = new FirefoxDriver(options);
	    driver.navigate().to("https://automationexercise.com");
	    WebElement consentButton = driver.findElement(By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button"));
	    if (consentButton.isDisplayed() && consentButton.isEnabled()) {
	        consentButton.click();
	    }
	}

	@When("the user clicks the products option")
	public void theUserClicksTheProductsOption() {
	    driver.findElement(By.partialLinkText("Products")).click();
	}

	@When("the user enters dress in the search bar")
	public void theUserEntersDressInTheSearchBar() {
	    driver.findElement(By.id("search_product")).sendKeys("dress");
	}

	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton() {
	    driver.findElement(By.id("submit_search")).click();
	}

	@Then("the dress list appears")
	public void theDressListAppears() {
	    String title = driver.findElement(By.className("features_items")).getText();
	    Assert.assertTrue(title.contains("SEARCHED PRODUCTS"));
	}
}
