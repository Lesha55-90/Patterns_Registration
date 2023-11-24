package ru.netology.data;


import com.github.javafaker.Faker;
import io.restassured.internal.ValidatableResponseOptionsImpl;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponseOptions;
import jdk.jfr.Registered;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

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

    private static ?????? (?????) {
        given()
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(user) // передаём в теле объект, который будет преобразован в JSON
                .when() // "когда"
                .post("/api/system/users") // на какой путь относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200); // код 200 OK
        return user;
    }


    public static String getRandomLogin () {
        return faker.name().username();
    }

    public static String getRandomPassword() {
        return faker.phoneNumber().phoneNumber();
    }


    public static class Registration {
        private Registration() {
        }

        public static Registration getUser (String status) {
            return new Registration(getRandomLogin(), getRandomPassword(), status);
        }

        public static UserInfo getRegisteredUser(String status) {
            return UserInfo(getUser(status));
        }
    }

    @Value
    public static class UserInfo {
        String login;
        String password;
        String status;
    }

}
