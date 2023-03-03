package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;

import com.application.pageelements.ForgotPassPageElement;
import com.framework.webdriver.WebDriverClass;


public class ForgotPasspageActions extends ForgotPassPageElement {
	
	public void verifyWhetherForgotLoginInfoPageIsLaunched() {
		waitForElement(forgotPassPageHeader);
		log("PASS", "Forgot Login Information Page is Successfully Launched");
	}
	
	public static ForgotPasspageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ForgotPasspageActions.class);
	}

}


