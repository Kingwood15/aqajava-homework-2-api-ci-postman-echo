package ru.netology;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postmanEchoTest {

    @Test
    void shouldPostmanEchoApiFirstTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                //.body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .body("ru.netology.api.postman")
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                //.body(/* --> ваша проверка здесь <-- */)
                .body("data", equalTo("raw data"))
        ;
    }

    @Test
    void shouldPostmanEchoApiSecondTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Мой дядя самых честных правил,\n" +
                        "Когда не в шутку занемог,\n" +
                        "Он уважать себя заставил\n" +
                        "И лучше выдумать не мог.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("А.С. Пушкин"))
        ;
    }
}
