package ru.yandex.projectTest;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

public class HomePage {

    private WebDriver driver;


    private By question1 = By.xpath(".//div[@class='accordion__item'][1]"); // вопрос 1
    private By question2 = By.xpath(".//div[@class='accordion__item'][2]"); // вопрос 2
    private By question3 = By.xpath(".//div[@class='accordion__item'][3]"); // вопрос 3
    private By question4 = By.xpath(".//div[@class='accordion__item'][4]"); // вопрос 4
    private By question5 = By.xpath(".//div[@class='accordion__item'][5]"); // вопрос 5
    private By question6 = By.xpath(".//div[@class='accordion__item'][6]"); // вопрос 6
    private By question7 = By.xpath(".//div[@class='accordion__item'][7]"); // вопрос 7
    private By question8 = By.xpath(".//div[@class='accordion__item'][8]"); // вопрос 8


    private By answer1 = By.id("accordion__panel-0"); //ответ на вопрос 1
    private By answer2 = By.id("accordion__panel-1"); //ответ на вопрос 2
    private By answer3 = By.id("accordion__panel-2"); //ответ на вопрос 3
    private By answer4 = By.id("accordion__panel-3"); //ответ на вопрос 4
    private By answer5 = By.id("accordion__panel-4"); //ответ на вопрос 5
    private By answer6 = By.id("accordion__panel-5"); //ответ на вопрос 6
    private By answer7 = By.id("accordion__panel-6"); //ответ на вопрос 7
    private By answer8 = By.id("accordion__panel-7"); //ответ на вопрос 8

    // Первая кнопка заказа
    private By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    // Вторая кнопка заказа
    private By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    private By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");

    public void acceptCookieButtonClick() {
        driver.findElement(acceptCookieButton).click();
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Методы для раскрытия вопросов
    public void clickQuestion1() {
        driver.findElement(question1).click();
    }
    public void clickQuestion2() {
        driver.findElement(question2).click();
    }
    public void clickQuestion3() {
        driver.findElement(question3).click();
    }
    public void clickQuestion4() {
        driver.findElement(question4).click();
    }
    public void clickQuestion5() {
        driver.findElement(question5).click();
    }
    public void clickQuestion6() {
        driver.findElement(question6).click();
    }
    public void clickQuestion7() {
        driver.findElement(question7).click();
    }
    public void clickQuestion8() {
        driver.findElement(question8).click();
    }

    // Метод для сравнения ответа на вопрос с правильным текстом
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }

    // Геттеры для получения текса ответов
    public String getAnswer1() {
        return driver.findElement(answer1).getText();
    }
    public String getAnswer2() {
        return driver.findElement(answer2).getText();
    }
    public String getAnswer3() {
        return driver.findElement(answer3).getText();
    }
    public String getAnswer4() {
        return driver.findElement(answer4).getText();
    }
    public String getAnswer5() {
        return driver.findElement(answer5).getText();
    }
    public String getAnswer6() {
        return driver.findElement(answer6).getText();
    }
    public String getAnswer7() {
        return driver.findElement(answer7).getText();
    }
    public String getAnswer8() {
        return driver.findElement(answer8).getText();
    }

    // Методы для клика по кнопкам "Заказать"
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickPageOrderButton() {
        // Проскролить до появления кнопки
        WebElement bigButton = driver.findElement(pageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(pageOrderButton).click();
    }
}
