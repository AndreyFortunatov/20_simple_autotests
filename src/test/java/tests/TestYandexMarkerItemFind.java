package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
        step("Находим Яндекс.Маркет на странице и кликаем на него", () ->
                $(byText("Маркет")).click()
        );
        step("Переходим в новое окно браузера где открылся Маркет", () ->
                switchTo().window(1)
        );
        step("Вводим в поле поиска объект поиска 'HUAWEI P40 Lite' и нажимаем 'Enter'", () ->
                $(byId("header-search")).val("HUAWEI P40 Lite").pressEnter()
        );
        step("Находим первый товар в результатах поиска и кликаем на заголовок чтобы перейти на его карточку товара", () ->
                $("h3 a").click()
//              $("h3").$("a").click()
        );
        step("Переходим в новое окно браузера где открылась карточка товара", () ->
                switchTo().window(2)
        );
        step("Проверяем что в заголовке карточки товара присутствует текст, заданный в поиске", () ->
                $("h1").shouldHave(text("HUAWEI P40 Lite"))
        );
    }
}
