package ru.yandex.projectTest;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.yandex.projectTest.Resources.confirmHeader;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Елена", "Леопольдова", "г. Москва, пр. Кутузовский, д.2", "Кутузовская", "+79616329300", "07.12.2024", "сутки", "чёрный жемчуг", "Не работает домофон, позвонить перед приездрм - встречу"},
                {"Олег", "Бунин", "г. Москва, ул. Горьковская", "Бауманская", "+79610000000", "10.12.2024", "сутки", "серая безысходность", "Свяжитесь со мной за 3 часа до приезда"},
        };
    }

    @Test
    public void OrderPositiveTest() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickHeaderOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.acceptCookieButtonClick();
        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setAddress(address);
        objOrderPage.setSubway(subway);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickOrderNextButton();
        objOrderPage.setDate(date);
        objOrderPage.setRentalPeriod(rentalPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), confirmHeader);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}