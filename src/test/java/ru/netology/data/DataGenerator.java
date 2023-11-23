package ru.netology.data;


import com.github.javafaker.Faker;
import io.restassured.internal.ValidatableResponseOptionsImpl;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponseOptions;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class DataGenerator {

    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    private static Faker faker = new Faker(new Locale("en"));



    private DataGenerator() {
    }

    private static RegistrationDto (RegistrationDto user) {
        given()
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(user) // передаём в теле объект, который будет преобразован в JSON
                .when() // "когда"
                .post("/api/system/users") // на какой путь относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200); // код 200 OK
        return user;
    }




    public static String generateLogin(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().username();
    }

    public static String generatePassword(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateStatus() {
        var status = new String[]{
                "active", "blocked"
        };
        return status[new Random().nextInt(status.length)];
    }


    public static class Registration {
        private Registration() {

        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateLogin(locale), generatePassword(locale), generateStatus());

        }

    }

    @Value
    public static class UserInfo {
        String login;
        String password;
        String status;
    }

}
