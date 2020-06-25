package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Tag("GoogleTestsBySteps")
class GoogleTestsBySteps extends TestBase {

    @Test
    @DisplayName("Найти в Гугле по шагам")
    void findWordInGoogle() {
        step("Открываем сайт Гугл", () ->
                open("http://google.com")
        );
        step("Вводим запрос 'lepra' в поле поиска и ждем на кнопку 'Поиск'", () ->
                $(byName("q")).val("lepra").pressEnter()

        );
        step("Проверяем в результате наличие слов 'Лепрозорий: вход'", () ->
                $("html").shouldHave(text("Лепрозорий: вход"))
        );
    }

}