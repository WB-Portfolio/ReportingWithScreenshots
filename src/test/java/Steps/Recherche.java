package Steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Recherche {

        public static WebDriver driver = GenerateurDriver.driver;




        @Given("^Le navigateur est ouvert$")
        public void leNavigateurEstOuvert() {

                driver.get("http://www.google.com");
        }

        @And("^\"([^\"]*)\" est affichee$")
        public void estAffichee(String arg0) {

                Assert.assertEquals(arg0, driver.getTitle());

        }

        @When("^une recherche du terme \"([^\"]*)\" est realisee$")
        public void uneRechercheDuTermeEstRealisee(String arg0) {

                WebElement element = driver.findElement(By.name("btnK"));
                driver.findElement(By.name("q")).sendKeys(arg0);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);

        }

        @Then("^verifier la recherche$")
        public void verifierLaRecherche() {

                Assert.assertTrue(driver.getTitle().contains("Je fais echouer le test pour avoir la capture d'ecran dans le rapport"));
        }
}
