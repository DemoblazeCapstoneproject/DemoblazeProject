package com.store.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class SignUp extends Baseclass {
     
	// Test case to verify signup functionality
    @Test
    public void testSignUpFunction() throws InterruptedException, IOException {
        // Click on the "Sign up" button
        driver.findElement(By.linkText("Sign up")).click();
        Thread.sleep(2000);

        // Fill in the sign-up form
        driver.findElement(By.id("sign-username")).sendKeys("Balakrishna" + System.currentTimeMillis());
        driver.findElement(By.id("sign-password")).sendKeys("balu123");
        // Click on the "Sign up" button
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        
      //take screenshot
        takeScreenshot("signpage");
        test.log(Status.PASS, "signup successful").addScreenCaptureFromPath("Screenshots/sign.png");
        Thread.sleep(2000);
     
        // Handle the alert
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Sign up successful"), "Alert text did not match expected value!");
        driver.switchTo().alert().accept();  
    }
}