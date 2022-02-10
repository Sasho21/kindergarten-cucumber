Feature: Класиране на дете

 
  Scenario Outline: Класиране на дете от админ
    Given Потребителя отваря екрана за регистрация на дете
    When Въвежда собственото име на детето: "<Соб. име>"
    And Въвежда фамилното име на детето: "<Фам. Име>"
    And Въвежда рождената дата на детето: "<Рожден Ден>"
    And Въвежда дали детето е инвалид: "<Инвалид е>"
    And Въвежда броя на работещите родители: "<Работещи Родители>"
    And Въвежда дали детето има близнак: "<Има близнак>"
    And Въвежда телефонния номер на родителя: "<Телефон>"
    And Админът натиска бутона за регистрация
    Then Вижда съобщение: "<Съобщение>"

    Examples: 
      |Соб. име|Фам. Име|Рожден Ден|Инвалид е|Работещи Родители|Има близнак|Телефон|Съобщение                                   |
      |Иванчо  |Иванов  |2019-04-15|false    |2                |false      |0892345678|Успешно регистриране, детето има 3 точки.|
      |Иванчо  |Иванов  |2019-04-15|true     |2                |false      |0892345678|Успешно регистриране, детето има 5 точки.|
      |Иванчо  |Иванов  |2019-04-15|true     |2                |true       |0892345678|Успешно регистриране, детето има 6 точки.|
      |Иванчо  |Иванов  |2019-04-15|true     |2                |true       |0002345678|Телефонът на родителя не е валиден.      |
      |Иванчо  |Иванов  |2019-04-15|true     |2                |true       |0881111111|Не съществува такъв родител.             |
      |        |        |2019-04-15|false    |2                |false      ||Моля въведете и двете имена на детето.             |
      |Иванчо  |        |2019-04-15|false    |2                |false      ||Моля въведете и двете имена на детето.             |
      |        |Иванов  |2019-04-15|false    |2                |false      ||Моля въведете и двете имена на детето.             |
      |Иванчо  |Иванов  |2021-04-15|false    |2                |false      |0892345678|Детето е твърде малко или твърде голямо за детска градина.|
      |Иванчо  |Иванов  |2010-04-15|false    |2                |false      |0892345678|Детето е твърде малко или твърде голямо за детска градина.|
      |Ivancho |Ivanov  |2018-04-12|false    |2                |false      |0892345678|Детето е вече регистрирано.              |
