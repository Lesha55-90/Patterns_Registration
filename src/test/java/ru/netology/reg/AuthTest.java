package ru.netology.reg;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.getSelectedText;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.*;

class AuthTest {

    @BeforeEach
    void setup(){
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should Successful User")
    void shouldSucessfulUser() {
        var registerdUser = getRegisterdUser("active");
    }



}