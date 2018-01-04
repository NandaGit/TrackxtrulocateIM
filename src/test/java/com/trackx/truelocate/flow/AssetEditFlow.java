package com.trackx.truelocate.flow;

import java.io.IOException;

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
import com.trackx.truelocate.pagecomponents.AssetListElements;
import com.trackx.truelocate.pagecomponents.CommonElements;
import com.trackx.truelocate.pagecomponents.IMRegionElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class AssetEditFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	AssetListElements assetlistelements ;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "chrome");
		truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		assetlistelements = PageFactory.initElements(driver, AssetListElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver, ReusableActions.getPropFileValues("Url"));	
	}

	/**
	 * Login Script
     */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void userclickflow(String sUsername, String sPassword)
			throws Exception {
		try {
			truelocatelogin.enterUsernamepassword(sUsername, sPassword);
			ReusableActions.takeSnapshot(driver, className);
			Thread.sleep(1000);
			if (truelocatelogin.pageTitleValidation()) {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login successful", "Pass" });
			}else {
				TestNGResults.put("2", new Object[] { "Login screen",
						"Login Failed", "Fail" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * AssetList Edit
	 */
	
	@Test(priority = 2, dataProvider = "createData")
	public void assetlistEditFlow(String sValue,String sPrimaryIdentifier,String sLocation,String sLocationdropdown,String sAssetstatus, 
			String sAssetstatusdropdown,String sOwner,String sOwnerdropdown,String sAssingee,String sAssigneedropdown)throws Exception {
		try {
			assetlistelements.menuClick();
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.globalSearch(sValue);
			Thread.sleep(6000);
			//commonElements.clickValue(driver,sValue);
			commonElements.clickValueAsset(driver, sValue);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickEditButton(driver);
			assetlistelements.enterEditAssetListInfo(sPrimaryIdentifier, sLocation, sLocationdropdown, sAssetstatus, 
					sAssetstatusdropdown, sOwner, sOwnerdropdown, sAssingee, sAssigneedropdown);
			//commonElements.clickCreateOrUpdatebutton(driver);
			commonElements.clickUpdatebutton(driver);
			Thread.sleep(1000);
			ReusableActions.takeSnapshot(driver, className);
			String alertMessage = commonElements.alertMessage(driver);
			if (alertMessage.equalsIgnoreCase(constants.edit_assetlist_successmsg)) {
				TestNGResults.put("11", new Object[] { "AssetList edit screen",
						"AssetList edited successfully", "Pass" });	
				Assert.assertEquals(alertMessage, constants.edit_assetlist_successmsg);
			} else {
				TestNGResults.put("11", new Object[] { "AssetList edit screen",
						"AssetList not edited", "Fail" });
				Assert.assertEquals(alertMessage, constants.edit_assetlist_successmsg);
			}
		}
		catch (Exception e) {
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
		return GeneralActions.getData("EditAssetList");
	}

}
