package MvnBddCucumberAuto.Sahi;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDSahiLoginTest {
	  String baseUrl = "http://www.sahitest.com/demo/training/login.htm";
	  String strSelector;
	  public String srtValue;
	  String strTxtUser;
	  String strTxtPass;
	  String testCase;
      WebDriver driver;
	  public String mainPath = "C:\\eclipse\\Resources\\";
	  public String browser = "Firefox"; //"IE" � Chrome � Firefox
    
	@Given("^El usuario se encuentra en la pagina de login$")
	public void user_login_page () {
		System.out.println("El usuario se encuentra en la pagina de login");
  	    driver = utilities.DriverFactory.open(mainPath, browser);
		System.out.println("Abre el navegador");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();  //maximizo mi browser
	}
    
	@When ("^El usuario ingresa correctamente el usuario y la contrasena$")
	public void user_do_login () throws InterruptedException {
		System.out.println("El usuario se encuentra en la pagina de login");
		//Inicio el Login		 
		strTxtUser = "test";
		driver.findElement(By.name("user")).sendKeys(strTxtUser);
    
		strTxtPass = "secret";
		driver.findElement(By.name("password")).sendKeys(strTxtPass);

		driver.findElement(By.cssSelector("input.button")).click();
		Thread.sleep(2000);
		
	}
	
    
	@When ("^El usuario ingresa el usuario (.*)$")
	public void user_set_user (String username) {
		System.out.println("El usuario se encuentra en la pagina de login, con el usuario:"+username);
		//Inicio el Login		 
		driver.findElement(By.name("user")).sendKeys(username);
		
	}
     
	@And ("^El usuario ingresa el passwd (.*)$")
	public void user_set_passwd (String passwd) {
    		driver.findElement(By.name("password")).sendKeys(passwd);
		System.out.println("El usuario ingresa la contrase�a:"+passwd);
	}
	
	@And ("^El usuario presiona clic en  boton login$")
	public void clic_button_login () throws InterruptedException {
		driver.findElement(By.cssSelector("input.button")).click();
		Thread.sleep(2000);
	}
	
	@Then ("^El usuario accede al carrito de compras$")
	public void user_access_ShoppinPage () throws InterruptedException {
		System.out.println("El usuario se encuentra en la pagina de login");
		System.out.println("Estamos en la p�gina:" + driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Logout']")).click();

	}
	
	@Then ("^El usuario obtiene el resultado (.*)$")
	public void user_gets_confirmation (String status) throws InterruptedException {

		System.out.println("Estamos en la p�gina:" + driver.getTitle() + ". Y el resultado fue: "+status);
		Thread.sleep(1000);

	}
	
 
	@When ("^Utilizando los siguientes datos$")
	public void utilizando_datos (DataTable data) {
		
		String showText;
		List<List<String>> datos = data.raw();
		 ; //      | username  | passwd | status  |
		showText = datos.get(0).get(0) + " | " +datos.get(0).get(1) + " | " + datos.get(0).get(2);
		showText = showText + "\\n" +  datos.get(1).get(0) + " | " +datos.get(1).get(1) + " | " + datos.get(1).get(2);
		showText = showText + "\\n" +  datos.get(2).get(0) + " | " +datos.get(2).get(1) + " | " + datos.get(2).get(2); 
		
		System.out.println("Estamos trabajando con los siguientes datos:\n"+showText);
	}
	
	 @After
	 public void tearDown() throws Exception {
	    
		Thread.sleep(1000);	
		 driver.quit();
	
	  }

}
