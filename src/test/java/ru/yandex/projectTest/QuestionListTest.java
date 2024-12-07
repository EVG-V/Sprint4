package ru.yandex.projectTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static ru.yandex.projectTest.Resources.*;

public class QuestionListTest {

    private WebDriver driver;
    private WebDriverWait wait;



    @Test
    public void QuestionCorrectAnswer() throws InterruptedException {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Проскролить страницу до появления таблицы с вопросами
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        // Создать объект класса с домашней страницей
        HomePage objHomePage = new HomePage(driver);

        //todo add apply cookie method from orderpqgetest

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='да все привыкли']")));
        objHomePage.acceptCookieButtonClick();


        // Проверка соответствия текста ответа с ожидаемым
        objHomePage.clickQuestion1();
        //Ждем пока не появится текст ответа после клика
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-0")));
        objHomePage.isCorrectText(objHomePage.getAnswer1(), answer1Text);

        objHomePage.clickQuestion2();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-1")));
        objHomePage.isCorrectText(objHomePage.getAnswer2(), answer2Text);

        objHomePage.clickQuestion3();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-2")));
        objHomePage.isCorrectText(objHomePage.getAnswer3(), answer3Text);

        objHomePage.clickQuestion4();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-3")));
        objHomePage.isCorrectText(objHomePage.getAnswer4(), answer4Text);

        objHomePage.clickQuestion5();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-4")));
        objHomePage.isCorrectText(objHomePage.getAnswer5(), answer5Text);

        objHomePage.clickQuestion6();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-5")));
        objHomePage.isCorrectText(objHomePage.getAnswer6(), answer6Text);

        objHomePage.clickQuestion7();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-6")));
        objHomePage.isCorrectText(objHomePage.getAnswer7(), answer7Text);

        objHomePage.clickQuestion8();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-7")));
        objHomePage.isCorrectText(objHomePage.getAnswer8(), answer8Text);

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
