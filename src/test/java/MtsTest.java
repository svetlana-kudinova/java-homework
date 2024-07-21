import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://mts.by");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEmptyFieldLabels() {
        // Проверка надписей в незаполненных полях для каждого варианта оплаты услуг
        String[][] fieldData = {
                {"//*[@id=\"connection-phone\"]", "Номер телефона"},
                {"//*[@id=\"connection-sum\"]", "Сумма"},
                {"//*[@id=\"connection-email\"]", "E-mail для отправки чека"},
                {"//*[@id=\"internet-phone\"]", "Номер абонента"},
                {"//*[@id=\"internet-sum\"]", "Сумма"},
                {"//*[@id=\"internet-email\"]", "E-mail для отправки чека"},
                {"//*[@id=\"score-instalment\"]", "Номер счета на 44"},
                {"//*[@id=\"instalment-sum\"]", "Сумма"},
                {"//*[@id=\"instalment-email\"]", "E-mail для отправки чека"},
                {"//*[@id=\"score-arrears\"]", "Номер счета на 2073"},
                {"//*[@id=\"arrears-sum\"]", "Сумма"},
                {"//*[@id=\"arrears-email\"]", "E-mail для отправки чека"}
        };

        for (String[] data : fieldData) {
            WebElement field = driver.findElement(By.xpath(data[0]));
            String placeholder = field.getAttribute("placeholder");
            assertEquals(data[1], placeholder, "Placeholder text is not correct for field: " + data[0]);
        }
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
}