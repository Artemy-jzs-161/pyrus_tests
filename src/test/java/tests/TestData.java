package tests;

import com.github.javafaker.Faker;
import data.models.members.MembersRequestModel;

public class TestData {
    Faker faker = new Faker();
    public String nameCompany = "ИП Ромашка";
    public String securityKey = "Lpu9qnyqN550YhBCEtRc1oILXKl-jc-nZm0VmusEUEdtEk0ZdV~meigGWkLL3HgKsEZltOgIyaj4bfHLG53or3n7BnFjrMR1";
    public String email = "carapyz54@gmail.com";
    public String incorrectEmail = faker.internet().emailAddress();
    public String password = "Nv6J!Ew2s2ehKir";
    public String incorrectPassword = faker.internet().password();
    public String incorrectPasswordMessage = "Неверный пароль";
    public String nameArticle = "Как организовать совещание с помощью Pyrus";
    public String noExistArticle = faker.harryPotter().book();
    public String titleCreateCompany = "Создание организации";
    public String elementSearchResultMissing = "Ничего не найдено";
    public Integer randomId = faker.idNumber().valid().indexOf(10);
    public String taskName = "Задача номер 1";
    public String taskDescription = "Описание задачи 1";
    public String backgroundColorBlackTheme = "#1c1e21";
    public String infoText = "Pyrus is the best way to collaborate with your team.";

    public MembersRequestModel BorovikA = new MembersRequestModel(
            1108384,
            "Артем",
            "Боровик");

    public MembersRequestModel memberFirst = new MembersRequestModel(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.job().position(),
            faker.idNumber().valid().indexOf(3),
            faker.name().username(),
            faker.phoneNumber().phoneNumber(),
            faker.pokemon().name());

    public MembersRequestModel memberSecond = new MembersRequestModel(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.job().position(),
            faker.idNumber().valid().indexOf(3),
            faker.name().username(),
            faker.phoneNumber().phoneNumber(),
            faker.pokemon().name());
}