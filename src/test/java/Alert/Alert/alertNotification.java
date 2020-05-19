package Alert.Alert;

import java.awt.AWTException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class alertNotification {
	
	public static WebDriver driv;
	public static String pass;
	public static Wait<WebDriver> gWait;
	
	@Test
	public void Teltonika_Movement() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  */

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Teltonika")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("Movement");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("Movement"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("Movement")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("Movement"));
          
        }
        }
      
       }
	
	
 	
	}
	
	
	@Test
	public void Teltonika_POWERCUT() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  
*/
	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Teltonika")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("POWERCUT");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("PowerCut"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("POWERCUT")){  
           tdata.get(j).click();       
            Thread.sleep(1000);   
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("POWERCUT"));
          
        }
        }
      
       }
	
	
 	
	}

	
	@Test
	public void Teltonika_No_Transmisson() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  
*/
	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Teltonika")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("No Transmisson");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("No Transmisson"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("NOTRANSMISSION")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("NOTRANSMISSION"));
          
        }
        }
      
       }
	
	
 	
	}

	/*
	@Test
	public void Concox_Movement() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Concox")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("Movement");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("Movement"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("Movement")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("Movement"));
          
        }
        }
      
       }
	
	
 	
	}
	
	
	@Test
	public void Concox_POWERCUT() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Concox")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("POWERCUT");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("POWERCUT"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("POWERCUT")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("POWERCUT"));
          
        }
        }
      
       }
	
	
 	
	}

	
	@Test
	public void Concox_No_Transmisson() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Concox")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("No Transmisson");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("No Transmisson"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("NOTRANSMISSION")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("NOTRANSMISSION"));
          
        }
        }
      
       }
	
	
 	
	}

	@Test
	public void Ruptela_Movement() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Ruptela")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("Movement");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("Movement"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("Movement")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("Movement"));
          
        }
        }
      
       }
	
	
 	
	}
	
	
	@Test
	public void Ruptela_POWERCUT() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Ruptela")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("POWERCUT");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("POWERCUT"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("POWERCUT")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("POWERCUT"));
          
        }
        }
      
       }
	
	
 	
	}

	
	@Test
	public void Ruptela_No_Transmisson() throws AWTException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\EIT-JAGADESHAN\\eclipse-workspace\\Alert\\driver\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("credentials_enable_service", false);
    options.setExperimentalOption("prefs", chromePrefs);
    driv = new ChromeDriver(options);
    driv.get("http://spqa.thegoldenelement.com");
	driv.manage().window().maximize();
	WebElement cid =driv.findElement(By.id("cId"));
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.visibilityOf(cid));
	  cid.sendKeys("demo");
	  driv.findElement(By.id("uName")).sendKeys("demo-ca");;
	  driv.findElement(By.id("pass")).sendKeys("12345");
	  //Thread.sleep(100);
	  driv.findElement(By.id("loginbtn")).click();
	  gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
		        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
	  gWait.until(ExpectedConditions.urlContains("gridview"));
	  WebElement grid =driv.findElement(By.xpath("//a[@href='#/gridview']"));
	  gWait.until(ExpectedConditions.visibilityOf(grid));
	  grid.click();
	  //driv.findElement(By.xpath("//li/div[3]/div/h4"));	
	/*  List<WebElement> lis=driv.findElements(By.tagName("li"));
	  for(int i =0;i<lis.size();i++) {
		  WebElement elem= lis.get(i);
		    String nam=elem.getText();
		  if(nam.equals("Simulator-Testing-Teltonika")) {
			 
			  elem.click();
		  }
	  }
	  

	  WebElement report =driv.findElement(By.xpath("//a[@href='#/allreport']"));
	 report.click();  
	Thread.sleep(10000);
	 WebElement ale = driv.findElement(By.xpath("//div[@class='form-group']/div/div/select"));
	 Select select = new Select(ale); 
	 Thread.sleep(500);
	 select.selectByVisibleText("Alert Report");    
	 driv.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();	
		 List<WebElement> lis=driv.findElement(By.xpath("//ul[@class='select2-results']")).findElements(By.tagName("li"));
		  for(int i =0;i<lis.size();i++) {
			  WebElement elem1= lis.get(i);
			    String nam=elem1.getText();
			    
			  if(nam.equals("Simulator-Testing-Ruptela")) {
				 
				  elem1.click();
				  break;
			  }
		  
		  }
		  
	 WebElement ale_type = driv.findElement(By.xpath("//div[@ng-show='conditionBaedElementsshowallalerttype']/div/div/div/select"));
	Thread.sleep(1000);
	 Select select1 = new Select(ale_type); 
	 select1.selectByValue("No Transmisson");
	
	 
	 driv.findElement(By.id("searchData")).click();
 	 WebElement  data = driv.findElement(By.tagName("td"));
 	Thread.sleep(10000);
 	WebElement move = driv.findElement(By.xpath("//html/body/div[4]/div/div/div[2]/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td//div/div[2]/div/div[3]/div[2]/div/div[3]"));
 	
 	String s= move.getText();
 	System.out.println(s);
	Assert.assertTrue(s.contains("No Transmisson"));
	
	driv.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driv.manage().window().maximize();
	driv.findElement(By.id("identifierId")).sendKeys("jagadeshan@eitworks.com");
	
	Actions a= new Actions(driv);
	
	  a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(10000);
	
	gWait = new FluentWait<WebDriver>(driv).withTimeout(Duration.ofSeconds(60))
	        .pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
  gWait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//input[@name='password']"))));
	driv.findElement(By.xpath("//input[@name='password']")).sendKeys("eitjagadeshan");
	a.moveToElement(driv.findElement(By.xpath("//div[@class='ZFr60d CeoRYc']"))).click().build().perform();
	Thread.sleep(20000);
	List<WebElement> trow = driv.findElements(By.tagName("tr"));
	for(int i=0;i<trow.size();i++){
    	WebElement TR= trow.get(i);
    	List<WebElement> tdata = TR.findElements(By.tagName("td"));
    	for(int j=0;j<tdata.size();j++) {
        WebElement tdtext=tdata.get(j);
    	String text1=tdtext.getText();
        if(text1.contains("NOTRANSMISSION")){  
           tdata.get(j).click();       
               
          WebElement alert =driv.findElement(By.xpath("//h2[@class='hP']"));
           
           String message = alert.getText();
           Assert.assertTrue(message.contains("NOTRANSMISSION"));
          
        }
        }
      
       }
	
	
 	
	}

	*/

	
	
}
