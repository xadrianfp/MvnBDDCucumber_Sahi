package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {


	public static WebDriver open (String pathResources, String browserType) {
		

	    System.out.println("Antes de manager: Path: "+pathResources);
	    
	    try {
	    
	    	if (browserType.equals("Chrome")) {
			    System.setProperty("webdriver.chrome.driver", pathResources + "chromedriver.exe");
			    return new ChromeDriver();
	        }
		    else if (browserType.equals("Firefox")) {
		       System.setProperty("webdriver.gecko.driver", pathResources + "geckodriver.exe");
		       return new FirefoxDriver();
			}
			else {
			    System.setProperty("webdriver.ie.driver", pathResources + "IEDriverServer.exe");
			    return new InternetExplorerDriver();
			}
	    	    
	    
	    }  catch(ArrayIndexOutOfBoundsException excepcion)
	    {
	        System.out.println("Ha ocurrido el siguiente error" + excepcion);
			return null;
	    }

				
	}

}
