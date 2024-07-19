import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        dismissCookiesBanner();
    }

    private void dismissCookiesBanner() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookiesBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie")));
            WebElement acceptButton = cookiesBanner.findElement(By.xpath("//button[text()='Принять']"));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(cookiesBanner));
        } catch (Exception e) {
            System.out.println("No cookies banner displayed.");
        }
    }

    @Test
    public void testBlockTitle() {
        // Проверка названия блока «Онлайн пополнение без комиссии»
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div"));
        assertEquals("Онлайн пополнение\n" + "без комиссии\n" + "Услуги связи\n" + "Домашний интернет\n" + "Рассрочка\n" + "Задолженность\n" + "Услуги связи\n" + "+375\n" + "Руб.\n" + "Продолжить\n" + "Подробнее о сервисе", blockTitle.getText().trim());
    }

    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        assertEquals(5, logos.size());

        String[] expectedLogos = {
                "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"
        };

        for (int i = 0; i < logos.size(); i++) {
            assertEquals(expectedLogos[i], logos.get(i).getAttribute("alt"));
        }
    }

    @Test
    public void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();

        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        driver.navigate().back();
    }

    @Test
    public void testEmptyFieldPlaceholders() {
        checkEmptyFieldPlaceholder("pay-connection", "connection-phone", "Номер телефона");
        checkEmptyFieldPlaceholder("pay-internet", "internet-phone", "Номер абонента");
        checkEmptyFieldPlaceholder("pay-instalment", "score-instalment", "Номер счета на 44");
        checkEmptyFieldPlaceholder("pay-arrears", "score-arrears", "Номер счета на 2073");
    }

    private void checkEmptyFieldPlaceholder(String formId, String inputId, String expectedPlaceholder) {
        WebElement form = driver.findElement(By.id(formId));
        WebElement input = form.findElement(By.id(inputId));
        assertEquals(expectedPlaceholder, input.getAttribute("placeholder"));
    }

    @Test
    public void testFormSubmission() {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        WebElement submitButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));

        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("10");
        emailInput.sendKeys("test@example.com");

        submitButton.click();

        WebElement confirmationElement = driver.findElement(By.xpath("/html/body/div[17]"));
        assertTrue(confirmationElement.isDisplayed(), "Confirmation element is not displayed");

        WebElement amountButton = driver.findElement(By.xpath("//button[@id='amount-button-id']"));
        assertEquals("Продолжить", amountButton.getText().trim(), "Text is not correct");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}