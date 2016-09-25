package com.Orange.HRMS.GenericFunctions;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.server.Response.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Utility 
{
	
  public  static String getFormatCurrentDate()
  {
	  SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			  String date = sdf.format(new Date());
			  System.out.println( "date is:  " + date);
			  return date;
  }
  
  public static String GetPageScreenShot(WebDriver  driver , String ImageFolderPath)
  {
	  String imagePath = ImageFolderPath + "/" + getFormatCurrentDate() + ".png";
	  EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	  try{
		  FileUtils.copyFile(edriver.getScreenshotAs(org.openqa.selenium.OutputType.FILE), new File(imagePath));}
	  catch(Exception e){System.out.println("Exception caught in GetPageScreenShot()");}
	  return imagePath;
  }
  
  
  
  public static String cropImage(String imagePath,int x,int y,int width,int height,String OutputImgFolder)
	{
		String newImagePath=OutputImgFolder+"/"+getFormatCurrentDate()+".png";
		try{
			BufferedImage originalImage = ImageIO.read(new File(imagePath));
	        BufferedImage subImage = originalImage.getSubimage(x,y,width,height);
	        ImageIO.write(subImage,"png", new File(newImagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return newImagePath;
		
		
	}
	public static boolean compareImage( String actualImage,String expectedImage) {        
		try {
		        DataBuffer eImg = ImageIO.read(new File(expectedImage)).getData().getDataBuffer();
		        int sizeA = eImg.getSize();         
		        DataBuffer aImg = ImageIO.read(new File(actualImage)).getData().getDataBuffer();
		        int sizeB = aImg.getSize();
		        if(sizeA != sizeB) return false;
		            for(int i=0; i<sizeA; i++) 
		                if(eImg.getElem(i) != aImg.getElem(i)) return false;
		    	} 
		    	catch (Exception e){return  false;}
		    return true;
		}
  
	public static String convertRGBtoHex(String strRGB)
	{
		String hex="";
		List<Integer> rgb=new ArrayList<Integer>();
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(strRGB);
		 while(m.find())
		 {
			 int v=Integer.parseInt(m.group());
			 rgb.add(v);
		 }
		 System.out.println(rgb.size());
		
		 int red=rgb.get(0);
		 int green=rgb.get(1);
		 int blue=rgb.get(2);
		 hex = String.format("#%02x%02x%02x",red, green,blue);
		 return hex; 
	}
	

}
