package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("TestYandexMarkerItemFind")
class TestYandexMarkerItemFind extends TestBase {

    @Test
    @DisplayName("Найти в магазине Яндекс.Маркет заданный элемент с возможностью подставить свой через терминал")
    void findItem() {
        step("Открываем сайт Яндекс", () ->
                open("https://yandex.ru/")
        );
        step("Находим Маркет и кликаем на его ссылку", () ->
                $(byText("Маркет")).click()
        );
        step("Переходим в новое окно браузера где открылся Маркет", () ->
                switchTo().window(1)
        );
        step("Вводим в поле поиска объект поиска 'ssd' и начинаем искать нажав 'Enter'", () ->
                $(byId("header-search")).val("ssd").pressEnter()
        );
        step("Находим первый товар в результатах поиска и переходим на его карточку товара", () ->
//              $x("//h3/a[1]").click();
        );
        step("Переходим в новое окно браузера где открылась карточка товара", () ->
                switchTo().window(1)
        );
        step("Проверяем что в заголовке карточки товара присутствует текст, заданный в поиске", () ->
//              $(".n-title__text").shouldHave(text(yandexMarketItemName));
        );
    }
}
