package com.Orange.HRMS.MainFunctions;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Orange.HRMS.GenericFunctions.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class KeywordLib {

	public static void enter(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   driver.findElement(Locator.getLocator(ElementRepo)).clear();	
		   driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
		   ETest.log(LogStatus.INFO, input + "is Enter in related field ");
	 }
	
	public static void click(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   driver.findElement(Locator.getLocator(ElementRepo)).click();
		   ETest.log(LogStatus.INFO, input + "is click ");
	 }
	
	public static void select(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   WebElement WeblistEle = driver.findElement(Locator.getLocator(ElementRepo));
		   Select select = new Select(WeblistEle);
		   select.selectByVisibleText(input);
		   System.out.println("Selected value is  : " + input);
		   ETest.log(LogStatus.PASS,  "Selected value is  : " + input);
	}
	
	public static void CalenderCheck(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   WebElement weblist = driver.findElement(Locator.getLocator(ElementRepo));
		   Select select = new Select(weblist);
		   String weblistText = select.getFirstSelectedOption().getText();
		   if(weblistText.contains(input))
		   {
			   System.out.println("Current Month is:  " + input);
			   ETest.log(LogStatus.PASS,  "Current Month is:  " + input);
		   }
		   else{
			   System.out.println("Calender doesn't display : " + input + "Month");
			   ETest.log(LogStatus.FAIL,  "Calender doesn't display : " + input + "Month");
			   select.selectByVisibleText(input);
			   System.out.println("Current Month Selected is : " + input);
			   ETest.log(LogStatus.PASS, "Current Month Selected is : " + input);
		       }
	}
	
	/*  Copy of   verifyTextContains()   or  Similar function as verifyTextContains()   Alternate 
	/* public static void VerifyText(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	 
	{
	   String text = driver.findElement(Locator.getLocator(ElementRepo)).getText();
	   System.out.println("Link text value is " + text);
	   ETest.log(LogStatus.INFO, "Link text value is " + text);
	   
	   String ActualResult = driver.findElement(Locator.getLocator(ElementRepo)).getAttribute("class");
	   String ExpectedResult = input;
	   ETest.log(LogStatus.INFO, "Actual Result" + ActualResult);
	   ETest.log(LogStatus.INFO, "Expected Result" + ExpectedResult);
	   Assert.assertEquals(ExpectedResult, ActualResult);
	} */
	
	public static void VerfiyElementPresent(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
 	    /*if(driver.findElements(Locator.getLocator(ElementRepo)).size()==0)
 	      {	  
 	    	System.out.println("Element is not present");   
 	    	ETest.log(LogStatus.FAIL, "Element is not present");
 	    	}
 	   else  
 	   {
 		    if(driver.findElement(Locator.getLocator(ElementRepo)).isDisplayed())
 		   {  	  System.out.println("Element is displayed");   
 		          ETest.log(LogStatus.PASS, "Element is present");}
 		    else
 			{    
 		    	ETest.log(LogStatus.FAIL, "Element is not present or not displayed");
 		    	//System.out.println("Element is not present"); 
 		    	}
 		}
 	   System.out.println("Element is present :::::"  + input); */
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		List<WebElement> elements = driver.findElements(Locator.getLocator(ElementRepo));
		if(elements.size()> 0 && elements.get(0).isDisplayed())
		{
			ETest.log(LogStatus.PASS,"Element is Present and Displayed");
		}
		else
		{
			ETest.log(LogStatus.FAIL,"Element is Not Present or Displayed");
		}
      }
 	
	
	
	public static void upload(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
    	//driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
    	//System.out.println("Photo has been Uploaded");
    	//ETest.log(LogStatus.PASS, "Photo has been Uploaded");

    	//System.out.println(driver.getTitle());
    	String ActualResult_absoluteFilePath=new File(input).getAbsolutePath();
    	ETest.log(LogStatus.INFO,"absoluteFilePath:"+ActualResult_absoluteFilePath);
		driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(ActualResult_absoluteFilePath);
		ETest.log(LogStatus.PASS, "Photo has been Uploaded");
	}
	
	
	
	public static void verifyTextContains(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		String text_getText=driver.findElement(Locator.getLocator(ElementRepo)).getText();
		String text_innerHTML=driver.findElement(Locator.getLocator(ElementRepo)).getAttribute("innerHTML");
		//String text_textContent=driver.findElement(Locator.getLocator(ElementRepo)).getAttribute("textContent");
		ETest.log(LogStatus.INFO, "Expected text is:"+input);
		ETest.log(LogStatus.INFO, "getText:"+text_getText);
		ETest.log(LogStatus.INFO, "innerHTML:"+text_innerHTML);
		//ETest.log(LogStatus.INFO, "textContent:"+text_textContent);
		if(text_getText.contains(input))
		{	
			ETest.log(LogStatus.PASS,"Verified using getText; Actual text contains Expected text");
		}
		else if(text_innerHTML.contains(input))
		{	
			ETest.log(LogStatus.PASS,"Verified using innerHTML; Actual text contains Expected text");
		}
		/*else if(text_textContent.contains(input))
		{	
			ETest.log(LogStatus.PASS,"Verified using textContent; Actual text contains Expected text");
		}*/
		else
		{
			ETest.log(LogStatus.FAIL,"Actual text DO NOT contains Expected text");
		}
 }
	
	
	public static void verifyImage(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		String actualImageComplete=Utility.GetPageScreenShot(driver, Delta.imageFolderPath);   
				//Utility.getPageScreenShot(driver, AutomationConstants.ActualImageFolder);
		String expectedImage=Delta.ExpectedImageFolder+"/"+input;
		int x=driver.findElement(Locator.getLocator(ElementRepo)).getLocation().getX();
		int y=driver.findElement(Locator.getLocator(ElementRepo)).getLocation().getY();
		int width=driver.findElement(Locator.getLocator(ElementRepo)).getSize().getWidth();
		int height=driver.findElement(Locator.getLocator(ElementRepo)).getSize().getHeight();
		String actualImage=Utility.cropImage(actualImageComplete,x,y,width, height, Delta.ActualImageFolder);
		if(Utility.compareImage(actualImage,expectedImage))
		{
			String p = ETest.addScreenCapture("."+actualImage);
			ETest.log(LogStatus.PASS,"Image verified is:"+p);
		}
		else
		{
			String e=ETest.addScreenCapture("."+expectedImage);
			ETest.log(LogStatus.FAIL,"Expected image is:"+e);
			String a=ETest.addScreenCapture("."+actualImage);
			ETest.log(LogStatus.FAIL,"Actual image is:"+a);
			
		}
	}
	
	public static void verifyElementColor(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		
		String strRGB=driver.findElement(Locator.getLocator(ElementRepo)).getCssValue("color");
		ETest.log(LogStatus.INFO,"RGB is:"+strRGB);
		String hex=Utility.convertRGBtoHex(strRGB);
		
		String msg1="<span style='color:"+input+";'>Expected color</span>";
		ETest.log(LogStatus.INFO,"HTML",msg1);
		
		String msg2="<span style='color:"+hex+";'>Actual color</span>";
		ETest.log(LogStatus.INFO,"HTML",msg2);
		
		
		if(hex.equals(input))
		{
			ETest.log(LogStatus.PASS,"Element color is matching");
		}
		else
		{
			ETest.log(LogStatus.FAIL,"Element color is not matching");
		}
	}
	
}

