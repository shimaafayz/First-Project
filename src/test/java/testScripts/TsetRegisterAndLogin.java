package testScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qittah.collectedMethod.ParentClass;

public class TsetRegisterAndLogin
{
	ParentClass parclass = new ParentClass();
	
    @BeforeTest
    public void openBrowser()
    {
    	parclass.chromeDriverDemo("http://demo.nopcommerce.com/register");
    }
   
    @Test
    public void testAny()
    {
    	System.out.println("hello");
    }

    
    
 
}
