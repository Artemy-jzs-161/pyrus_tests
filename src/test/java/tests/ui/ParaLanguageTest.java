package tests.ui;

import data.enums.Language;
import data.pages.GreetingWebPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;


public class ParaLanguageTest extends TestBase {
    GreetingWebPage greetingPages = new GreetingWebPage();

}

