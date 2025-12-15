# hapifyme-test_tema17

Proiect de testare automată realizat în cadrul **Tema 17**, pentru aplicația HapifyMe.

## Tehnologii folosite
- Java
- Maven
- Selenide
- Cucumber (BDD)
- JUnit

## Structura proiectului
- `pageobjectmodel` – Page Object Model pentru pagini
- `stepdefinition` – definiții de pași Cucumber
- `features` – fișiere `.feature` cu scenarii BDD

## Scenarii acoperite
- Login cu date valide
- Login cu date invalide
- Teste data-driven (Scenario Outline, DataTable)

## Rulare teste
Testele pot fi rulate folosind comanda:
```bash
mvn test
