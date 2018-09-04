#Author: adrianfpuerta@gmail.com
#Each feature contains one feature
#Feature files use Gherkin language - bussiness language

Feature: Ejemplo de lectura de data

#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure

  @tag1
Scenario: Ejemplo para importar un Datatable
  	Given El usuario se encuentra en la pagina de login
    When Utilizando los siguientes datos 
      | username  | passwd | status  |
      | test | secret | exitoso |
      | test | unsecret | fallido |