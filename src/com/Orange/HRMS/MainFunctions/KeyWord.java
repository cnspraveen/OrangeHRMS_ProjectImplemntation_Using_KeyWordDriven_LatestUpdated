package com.Orange.HRMS.MainFunctions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class KeyWord
{
   public static void ExecuteKeyWord(WebDriver driver,String Action, String ElementRepo, String input, ExtentTest ETest )
   {
	   if(Action.equalsIgnoreCase("Enter"))
	   {
		   KeywordLib.enter(driver, Action, ElementRepo, input, ETest);
		   
	   }
	   else if(Action.equalsIgnoreCase("Click"))
	   {
		   KeywordLib.click(driver, Action, ElementRepo, input, ETest);
	   }
	   else if(Action.equalsIgnoreCase("Select"))
	   {
		   KeywordLib.select(driver, Action, ElementRepo, input, ETest);   
	   }
	   else if(Action.equalsIgnoreCase("Calender Check"))
	   {
		   KeywordLib.CalenderCheck(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   else if(Action.equalsIgnoreCase("Verify Text"))
	   {
		   KeywordLib.verifyTextContains(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   
	   else if(Action.equalsIgnoreCase("VerfiyElementPresent"))
	   {
		   KeywordLib.VerfiyElementPresent(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   else if(Action.equalsIgnoreCase("upload"))
	   {
		   KeywordLib.upload(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   else if(Action.equalsIgnoreCase("verifyImage"))
		{
			KeywordLib.verifyImage(driver, Action, ElementRepo, input, ETest);
		}
	   else if(Action.equalsIgnoreCase("verifyElementColor"))
		{
			KeywordLib.verifyElementColor(driver, Action, ElementRepo, input, ETest);
		}
	   else
	   {  System.out.println("invalid action"+Action);  
	   ETest.log(LogStatus.ERROR, "invalid action :  "+  Action);}
   } 
}
