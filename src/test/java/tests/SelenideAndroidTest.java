package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

public class SelenideAndroidTest extends TestBase {
    @Tag("android")
    @Test
    void searchTestAndroid() {
        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
            $(MobileBy.id("org.wikipedia.alpha:id/search_container")).click();
        });

        step("Verify content found", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text"))
                    .shouldBe(visible);
        });

    }
}
