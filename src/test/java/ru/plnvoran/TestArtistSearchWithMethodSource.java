package ru.plnvoran;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestArtistSearchWithMethodSource extends TestBase {

  static Stream<Arguments> artistSearchMethodSource() {
    return Stream.of(
            Arguments.of( List.of("David Bowie", "8 January 1947", "10 January 2016")),
            Arguments.of( List.of("John Lennon", "9 October 1940", "8 December 1980"))
    );
  }

  @MethodSource
  @ParameterizedTest(name = "Для артиста по запросу {0} найдены дата рождения {1} и дата смерти {2}")
  @DisplayName("Тест для проверки соответствия дат жизни артиста на сайте Wikipedia эталонным датам")
  @Tags({@Tag("CRITICAL"), @Tag("SEARCH"), @Tag("ARTISTS")})
    void artistSearchMethodSource(List<String> info) {

      open("https://en.wikipedia.org/wiki/Main_Page");
      $("#searchform [title='Search Wikipedia [alt-shift-f]']").setValue(info.get(0));;
      $("#searchform button").click();

      $$(".infobox-label").findBy(text("Born")).parent().shouldHave(text(info.get(1)));
      $$(".infobox-label").findBy(text("Died")).parent().shouldHave(text(info.get(2)));

    }

}
