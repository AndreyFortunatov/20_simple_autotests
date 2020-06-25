package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Tag("TestFindBySteps")
class TestFindBySteps extends TestBase {

    @Test
    @DisplayName("Найти информацию и проверить ее наличие на странице реультатат, выведя результат теста шагами в отчете Allure")
    void findInformation() {
        step("Открываем сайт Википедия", () ->
                open("http://ru.wikipedia.org/")
        );
        step("Вводим запрос 'список людей, сожжённых как еретики' в поле поиска и ждем на кнопку 'Найти'", () ->
                $(byName("search")).val("список людей, сожжённых как еретики").pressEnter()
        );
        step("Проверяем в результате наличие слов 'список'", () ->
                $("html").shouldHave(text("список"))
        );
    }

}