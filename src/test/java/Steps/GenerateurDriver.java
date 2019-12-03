package Steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GenerateurDriver {

        public static WebDriver driver = null;
        public static ChromeOptions options = new ChromeOptions();


        @Before
        public void DemarrageScenarioTest() {

                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @After
        public void ArretScenarioTest(Scenario scenario) {

                if (scenario.isFailed()) {
                        scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
                }
                driver.quit();
        }


}
