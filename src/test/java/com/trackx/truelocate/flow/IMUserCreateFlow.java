package com.trackx.truelocate.flow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.CommonElements;
import com.trackx.truelocate.pagecomponents.UserCreationElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class IMUserCreateFlow extends GeneralActions {
	static WebDriver driver;
	Truelocatelogin truelocatelogin;
	UserCreationElements usercreationelements;
	CommonElements commonElements;
	Constants constants;
	String className = this.getClass().getSimpleName();
	Logger log4jlogger = Logger.getLogger("devpinoyLogger");

	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "Chrome");
		truelocatelogin = PageFactory.initElements(driver,
				Truelocatelogin.class);
		usercreationelements = PageFactory.initElements(driver, UserCreationElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver,
				ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Script
	 */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void siteclickflow(String sUsername, String sPassword)
			throws Exception {
		try {
			truelocatelogin.enterUsernamepassword(sUsername, sPassword);
			Thread.sleep(1000);
			if (truelocatelogin.pageTitleValidation()) {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login successful", "Pass" });
			} else {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login Failed", "Fail" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * User creation script
	 */
	@Test(priority = 2, dataProvider = "createData")
	public void userCreationFlow(String sEmail, String sFirstname,
			String sLastname, String sMobile, String sLanguage, String sEnabled,
			String sPassword, String sConfirmpassword, String sPasswordchange,String sPasswordexpire, String sPortal,
			String sRole) throws Exception {
		try {
		    usercreationelements.menuClick();
		    Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
		    commonElements.clickCreatebutton(driver);
		    usercreationelements.enterUserInfo(sEmail, sFirstname, sLastname, sMobile, sLanguage, sEnabled, 
		    		sPassword, sConfirmpassword,sPasswordchange, sPasswordexpire, sPortal, sRole);
			commonElements.clickCreateOrUpdatebutton(driver);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.add_usersuccessmsg)) {
				TestNGResults.put("5", new Object[] { "User screen",
						"User added successfully", "Pass" });
				Assert.assertEquals(alertMessage,
						constants.add_usersuccessmsg);
			} else {
				TestNGResults.put("5", new Object[] { "User screen",
						"User not created", "Fail" });
				Assert.assertEquals(alertMessage,
						constants.add_usersuccessmsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@AfterClass
	public void quitDriver() {
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@DataProvider
	public static Object[][] createData() {
		return GeneralActions.getData("User");
	}
}
