package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        logStatus("End TestCase", "All TestCases Enden" , "DONE");
        driver.close();
        driver.quit();

    }

    public static void logStatus(String type, String message, String status) {

        System.out.println(String.format("%s |  %s  |  %s | %s",
                String.valueOf(java.time.LocalDateTime.now()), type, message, status));
    }
    
    
    static boolean status;
    public  void testCase01(){
        logStatus("Start TestCase", "TestCase 01 : Verify the Homepage URL and Initial Display", "DONE");
        driver.get("https://www.google.com/");
        status = driver.getCurrentUrl().contains("google");
        if(status)
            logStatus("TestCase 01", "Test Case Pass. The url contains google." , status ? "PASS" : "FAIL");
        else
            logStatus("TestCase 01", "Test Case Pass. The url does not contains google." , status ? "PASS" : "FAIL");
        WebElement searchTextField = driver.findElement(By.id("APjFqb"));
        searchTextField.sendKeys("calculator");
        searchTextField.submit();
        // System.out.println(driver.findElement(By.xpath("//div[@id='search']/div/div/div/div/div/div/div/div/h2")).getText());
        status = driver.findElement(By.xpath("//div[@id='search']/div/div/div/div/div/div/div/div/h2")).getText().contains("Calculator Result");
        if(status)
            logStatus("TestCase 01", "Test Case Pass. Google calculator is loaded." , status ? "PASS" : "FAIL");
        else
            logStatus("TestCase 01", "Test Case fail. Google calculator is not loaded." , status ? "PASS" : "FAIL");
        
        status = driver.findElement(By.id("cwos")).getText().equals("0");
        if(status)
            logStatus("TestCase 01", "Test Case Pass. Initial display shows Zero(0)." , status ? "PASS" : "FAIL");
        else
            logStatus("TestCase 01", "Test Case fail. Initial display not showing Zero(0)." , status ? "PASS" : "FAIL");
        
        logStatus("End TestCase", "Test Case pass. The url contains word" , status ? "PASS" : "FAIL");
        }

        public void testCase02() throws InterruptedException{
            logStatus("Start TestCase", "TestCase 02 : Verify Addition and Subtraction Operations", "DONE");
            
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='5']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='+']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='7']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='=']")).click();
            logStatus("TestCase 02", "Performing Addition of 5 + 7." , "DONE");
            Thread.sleep(1000);
            status = driver.findElement(By.id("cwos")).getText().equals("12");
            if(status)
                logStatus("TestCase 02", "The displayed result is correct which is 12." , status ? "PASS" : "FAIL");
            else
                logStatus("TestCase 02", "The displayed result is not correct which is 12." , status ? "PASS" : "FAIL");

            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='AC']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='1']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='5']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='−']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='8']")).click();
            driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='=']")).click();
            logStatus("TestCase 02", "Performing Substraction of 15 - 8." , "DONE");
            Thread.sleep(1000);
            status = driver.findElement(By.id("cwos")).getText().equals("7");
            if(status)
                logStatus("TestCase 02", "The displayed result is correct which is 7." , status ? "PASS" : "FAIL");
            else
                logStatus("TestCase 02", "The displayed result is not correct which is 7." , status ? "PASS" : "FAIL");
            
            logStatus("End TestCase", "Test Case pass.  Addition and Subtraction Operations is done." , status ? "PASS" : "FAIL");
            }

            public void testCase03() throws InterruptedException{
                logStatus("Start TestCase", "TestCase 03 : Verify the Functionality of the All Clear (AC) Button and Multiplication Operation", "DONE");
                
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='1']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='0']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='×']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='3']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='=']")).click();
                
                logStatus("TestCase 03", "Performing Multiplications of 10 * 3." , "DONE");
                Thread.sleep(1000);
                status = driver.findElement(By.id("cwos")).getText().equals("30");
                if(status)
                    logStatus("TestCase 03", "The displayed result is correct which is 30." , status ? "PASS" : "FAIL");
                else
                    logStatus("TestCase 03", "The displayed result is not correct which is 30." , status ? "PASS" : "FAIL");
                
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='AC']")).click();
                Thread.sleep(1000);
                status = driver.findElement(By.id("cwos")).getText().equals("0");
                if(status)
                    logStatus("TestCase 03", "The All clear button is worked correctly." , status ? "PASS" : "FAIL");
                else
                    logStatus("TestCase 03", "The All clear button is not working correctly." , status ? "PASS" : "FAIL");
                
                
                logStatus("End TestCase", "Test Case pass.  The \"All Clear\" (AC) button should clear the display, and the Google Calculator should correctly perform the multiplication operation." , status ? "PASS" : "FAIL");
            }   

            public void testCase04() throws InterruptedException{
                logStatus("Start TestCase", "TestCase 04 : Verify that the Google Calculator can perform division correctly.", "DONE");
                
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='2']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='0']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='÷']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='4']")).click();
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='=']")).click();
                
                logStatus("TestCase 04", "Performing Multiplications of 20 * 4." , "DONE");
                Thread.sleep(1000);
                status = driver.findElement(By.id("cwos")).getText().equals("5");
                if(status)
                    logStatus("TestCase 04", "The displayed result is correct which is 5." , status ? "PASS" : "FAIL");
                else
                    logStatus("TestCase 04", "The displayed result is not correct which is 5." , status ? "PASS" : "FAIL");
                
                driver.findElement(By.xpath("//table[@class='ElumCf']/tbody/tr/td/div/div[text()='AC']")).click();
                
                logStatus("End TestCase", "Test Case pass. The Google Calculator should correctly perform the division operation." , status ? "PASS" : "FAIL");
            }   
        }

