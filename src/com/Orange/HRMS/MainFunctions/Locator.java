package com.Orange.HRMS.MainFunctions;

import org.openqa.selenium.By;

public class Locator 
{
	public static By getLocator(String ElementRepo)
	{
		By  b=null;
		
		//This will Work only for for only one attribute(PropertyName_PropertyValue(has Only One  "_"))
		/*String[] str = Input.split("_");
	    String locator = str[0];
		String value = str[1];*/
		
		
		
		// This will work for one attribute(PropertyName_PropertyValue(have Multiple "_"))
		/*public static By getLocator(String input1){
			By b=null;
			String[] str=input1.split("_",2);
			String locator=str[0];
			String value=str[1]; 	*/

// 	OR  

		//This below code will work  for only one attribute(PropertyName_PropertyValue(has Multiple "_"))
		int p = ElementRepo.indexOf("_");
		   String locator = ElementRepo.substring(0, p);
		   String value = ElementRepo.substring(p+1);
		
		if(locator.equalsIgnoreCase("ID"))
		{
			b= By.id(value);
			System.out.println(b);
		}
		else if(locator.equalsIgnoreCase("NAME"))
		{
			b=By.name(value);
		}
		else if(locator.equalsIgnoreCase("XPATH"))
		{
			b=By.xpath(value);
			System.out.println(b);
		}
		else if(locator.equalsIgnoreCase("ClassName"))
		{
			b = By.className(value);
			 System.out.println("Clcik on Calender");
		}
		else if(locator.equalsIgnoreCase("LinkText"))
		{			
			b=By.linkText(value);
			System.out.println("Link name is: "   + b);
		}
		else if(locator.equalsIgnoreCase("PartialLinkText"))
		{
			b=By.partialLinkText(value);
		}
		else if(locator.equalsIgnoreCase("CssSelector"))
		{
			b=By.cssSelector(value);
		}
		else if(locator.equalsIgnoreCase("TagName"))
		{
			b=By.tagName(value);
		}
		else
		{
			System.out.println("invalid selector");
		}
		return b;
	}
}
