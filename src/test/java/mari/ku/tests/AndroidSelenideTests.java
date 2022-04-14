package mari.ku.tests;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase {

    @Owner("marina-ku4erenko")
    @DisplayName("Поиск в википедии")
    @Test
    void searchTest() {
        step("Скипаем приветственное окно", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Вбиваем поисковый запрос", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("Проверяем, что присустствуют результаты поиска", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }
}
