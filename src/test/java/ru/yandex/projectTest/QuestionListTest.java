package ru.yandex.projectTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.projectTest.Resources.*;

@RunWith(Parameterized.class)
public class QuestionListTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private static String questionId;
    private static String answerId;
    private static String expectedText;


   public QuestionListTest (String questionId, String answerId, String expectedText) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] elementIds() {
        return new Object[][] {
                {".//div[@class='accordion__item'][1]", "accordion__panel-0", answer1Text},
                {".//div[@class='accordion__item'][2]", "accordion__panel-1", answer2Text},
                {".//div[@class='accordion__item'][3]", "accordion__panel-2", answer3Text},
                {".//div[@class='accordion__item'][4]", "accordion__panel-3", answer4Text},
                {".//div[@class='accordion__item'][5]", "accordion__panel-4", answer5Text},
                {".//div[@class='accordion__item'][6]", "accordion__panel-5", answer6Text},
                {".//div[@class='accordion__item'][7]", "accordion__panel-6", answer7Text},
                {".//div[@class='accordion__item'][8]", "accordion__panel-7", answer8Text},

        }; }

    //TODO проверить - нужно выполнять этот метод перед каждым тестом, или один раз до всех тестов
    @Before
    public  void init() {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Проскролить страницу до появления таблицы с вопросами
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        // Создать объект класса с домашней страницей
        homePage = new HomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='да все привыкли']")));
        homePage.acceptCookieButtonClick();
    }



    @Test
    public void testQuestion1() {
        checkAnswer(homePage, questionId,  answerId,  expectedText);
    }


    @After
    public void teardown() {
        driver.quit();
    }

    public void checkAnswer(HomePage objHomePage, String questionId, String answerId, String expectedText) {
        By question = By.xpath(questionId);
        By answer = By.id(answerId);
        // Проверка соответствия текста ответа с ожидаемым
        objHomePage.clickQuestion(question);
        //Ждем пока не появится текст ответа после клика
        wait.until(ExpectedConditions.visibilityOfElementLocated(answer));
        objHomePage.isCorrectText(objHomePage.getAnswer(answer), expectedText);
    }
}
