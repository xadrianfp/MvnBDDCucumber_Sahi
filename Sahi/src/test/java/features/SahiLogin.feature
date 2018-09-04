#Author: adrianfpuerta@gmail.com
#Each feature contains one feature
#Feature files use Gherkin language - bussiness language

Feature: Probar la funcionalidad de login en sahitest

#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure

#Para un paso común utilizo las siguientes claves, y de aquí en 
#adelante quitaría el Given de todos los escenarios puesto que tienen dicha
#situación en común
#

Background: Login comun para las paginas
Given El usuario se encuentra en la pagina de login
  
  @tag1
  Scenario: User could login with correct username and password
  #  Given El usuario se encuentra en la pagina de login
    When El usuario ingresa correctamente el usuario y la contrasena
    Then El usuario accede al carrito de compras


  @tag2
  Scenario Outline: User could login with correct username and password
  #  Given El usuario se encuentra en la pagina de login
    When El usuario ingresa el usuario <username> 
    And El usuario ingresa el passwd <passwd>
    And El usuario presiona clic en  boton login
    Then El usuario obtiene el resultado <status>

    Examples: 
      | username  | passwd | status  |
      | test | secret | success |
      | test | unsecret | Fail |
      