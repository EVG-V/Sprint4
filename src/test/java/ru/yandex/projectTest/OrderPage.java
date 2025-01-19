package ru.yandex.projectTest;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;

public class OrderPage {

    private WebDriver driver;
    private By orderHeader = By.xpath(".//div[text()='Для кого самокат']"); // для кого самокат
    private By aboutOrderHeader = By.xpath(".//div[text()='Про аренду']"); // про аренду
    private By clickCookieButton = By.xpath(".//button[text()='да все привыкли']"); //принять куки

    // Заполнение данными формы заказа самоката - первая страница
    private By customerName = By.xpath(".//input[@placeholder='* Имя']"); //Имя
    private By customerSurname = By.xpath(".//input[@placeholder='* Фамилия']"); //Фамилия
    private By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //Адрес доставки самоката
    private By metroStantionDelivery = By.xpath(".//input[@placeholder='* Станция метро']"); //Станция метро
    private By customerPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Телефон

    // Нажатие кнопки "Далее"
    private By orderNextButton = By.xpath(".//button[text()='Далее']");

    // Заполнение данными формы заказа самоката - вторая  страница
    private By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //Адрес доставки самоката
    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']"); //Срок аренды
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //Комментарий

    // Нажатие кнопки "Заказать"
    private By orderCreateButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");

    // Кнопка подтверждения заказа - "Да"
    private By orderConfirmButton = By.xpath(".//button[text()='Да']");

    // Кнопка "Посмотреть статус"
    private By confirmHeader = By.xpath(".//button[text()='Посмотреть статус']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    // Геттер для получения текста заголовка страницы заказа
    public String getOrderHeader() {
        return driver.findElement(orderHeader).getText();
    }

    // Геттер для получения текста на кнопке для просмотра статуса заказа
    public String getConfirmHeader() {
        return driver.findElement(confirmHeader).getText();
    }

    // Метод для проверки открытия страницы
    public void isPageOpen(String headerText, String text) {
        MatcherAssert.assertThat(headerText, is(text));
    }

    // Принять куки
    public void acceptCookieButtonClick() {
        driver.findElement(clickCookieButton).click();
    }
    // Методы, заполняющие поля заказа
    public void setName(String name) {
        driver.findElement(customerName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(customerSurname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
    }

    public void setSubway(String subway) {
        driver.findElement(metroStantionDelivery).click();
        driver.findElement(By.xpath(".//div[text()='"+subway+"']")).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(customerPhoneNumber).sendKeys(phoneNumber);
    }
    public void clickOrderNextButton() {
        driver.findElement(orderNextButton).click();
    }
    public void setDate(String date) {
        driver.findElement(deliveryDate).sendKeys(date);
    }
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(aboutOrderHeader).click();
        driver.findElement(this.rentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
    }

    public void setColor(String color) {
        driver.findElement(By.xpath(".//label[text()='"+color+"']")).click();
    }
    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }
    public void clickOrderCreateButton() {
        driver.findElement(orderCreateButton).click();
    }
    public void clickOrderConfirmButton() {
        driver.findElement(orderConfirmButton).click();
    }
}
