package steps;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LanguageSteps {
	WebDriver driver = new ChromeDriver();
    
    public LanguageSteps() {
    	CommonSteps.driver = driver;
    }
    
    @Given("estoy en página de inicio")
    public void estoy_en_la_pagina_de_inicio() {
        driver.get("https://juice-shop.herokuapp.com/#/search");
    }
    
    @When("cambio el idioma a catalan desde el icono de arriba a la derecha")
    public void cambiaidiomacatalan() {
    	WebElement button = driver.findElement(By.cssSelector("[aria-label='Language selection menu']"));
        button.click();
        WebElement option = driver.findElement(By.id("mat-radio-3"));
        option.click();
    }
    
    @Then("el título de la página es Tots els productes")
    public void titulodelapaginaestotselsproductes() {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
            WebElement precedingElement = driver.findElement(By.xpath("//*[@id='search-result-heading']/preceding-sibling::*[1]"));
            System.out.println("Preceding element text: " + precedingElement.getText());
            assertEquals(precedingElement.getText(), "Tots els productes");
        } catch (NoSuchElementException e) {
            System.out.println("No preceding sibling found for the element with ID 'search-result-heading'.");
        }
    }
}
