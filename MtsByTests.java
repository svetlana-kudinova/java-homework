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

public class MtsByTests {

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
    public void testBlockTitle() {
        // Проверка названия блока «Онлайн пополнение без комиссии»
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div"));
        assertEquals("Онлайн пополнение\n" + "без комиссии\n" + "Услуги связи\n" + "Домашний интернет\n" + "Рассрочка\n" + "Задолженность\n" + "Услуги связи\n" + "+375\n" + "Руб.\n" + "Продолжить\n" + "Подробнее о сервисе", blockTitle.getText().trim());
    }

    @Test
    public void testPaymentSystemLogos() {
        // Проверка наличия логотипов платёжных систем
        WebElement logosContainer = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul"));
        List<WebElement> logos = logosContainer.findElements(By.tagName("li"));
        assertFalse(logos.isEmpty(), "No payment system logos found");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Payment system logo is not displayed");
        }
    }

    @Test
    public void testMoreInfoLink() {
        // Проверка работы ссылки «Подробнее о сервисе»
        WebElement moreInfoLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        moreInfoLink.click();

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "More info link did not navigate correctly");
    }

    @Test
    public void testContinueButtonFunctionality() {
        // Заполнение полей и проверка работы кнопки «Продолжить» для варианта «Услуги связи»
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneNumberField.sendKeys("297777777");

        WebElement amountField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        amountField.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        // Проверки успешного перехода и отображения результатов
        WebElement confirmationElement = driver.findElement(By.id("/html/body/app-root/div/div"));
        assertTrue(confirmationElement.isDisplayed(), "Confirmation element is not displayed");

        // Проверка корректности отображения данных
        // Пример проверки текста на кнопке, номера телефона и т.д.
        WebElement amountButton = driver.findElement(By.xpath("//button[@id='amount-button-id']"));
        assertEquals("Продолжить", amountButton.getText().trim(), "Text is not correct");
    }
}