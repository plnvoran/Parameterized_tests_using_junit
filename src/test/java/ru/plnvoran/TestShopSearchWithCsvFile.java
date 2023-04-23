package ru.plnvoran;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestShopSearchWithCsvFile extends TestBase {
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Для часового брэнда по запросу {0} найден магазин {1} в списке ")
    @DisplayName("Тест для проверки нахождения магазина в списке всех найденных магазинов по запросу")
    @Tags({@Tag("CRITICAL"), @Tag("SEARCH"), @Tag("SHOP")})
    void searchShopByBrandWithCsvFile(String brand, String shop) {
        open("https://skytime.ru/trade-point");

        $("#points-filter-form").$(byText(brand)).click();
        $(byClassName("points-sidebar__button")).click();
        $$(".points-sidebar__point-header").findBy(text(shop));

    }


}
