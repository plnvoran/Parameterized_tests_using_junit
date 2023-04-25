package ru.plnvoran;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    void openSiteApple() {
        Configuration.baseUrl = "1920x1080";

    }
}
