package data;

import com.github.javafaker.Faker;
import tests.api.models.members.MembersRequestModel;

public class TestData {
    Faker faker = new Faker();
    public String nameCompany = "ИП Ромашка";
    public String securityKey = "Lpu9qnyqN550YhBCEtRc1oILXKl-jc-nZm0VmusEUEdtEk0ZdV~meigGWkLL3HgKsEZltOgIyaj4bfHLG53or3n7BnFjrMR1";
    public String email = "carapyz54@gmail.com";
    public String invalidEmail = "carapyz";
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
    public String incorrectPasswordMessageMobile = "The password you entered is incorrect";

    public MembersRequestModel BorovikA() {
        return MembersRequestModel.builder()
                .id(1108384)
                .firstName("Артем")
                .lastName("Боровик")
                .build();
    }

    public MembersRequestModel memberFirst() {
        return MembersRequestModel.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .position(faker.job().position())
                .department(faker.idNumber().valid().indexOf(3))
                .skype(faker.name().username())
                .phone(faker.phoneNumber().phoneNumber())
                .status(faker.pokemon().name())
                .build();
    }

    public MembersRequestModel memberSecond() {
        return MembersRequestModel.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .position(faker.job().position())
                .department(faker.idNumber().valid().indexOf(3))
                .skype(faker.name().username())
                .phone(faker.phoneNumber().phoneNumber())
                .status(faker.pokemon().name())
                .build();
    }
}