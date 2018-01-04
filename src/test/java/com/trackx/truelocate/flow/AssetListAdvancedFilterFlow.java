package com.trackx.truelocate.flow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.AssetListElements;
import com.trackx.truelocate.pagecomponents.CommonElements;
import com.trackx.truelocate.pagecomponents.IMItemElements;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;

public class AssetListAdvancedFilterFlow extends GeneralActions {
	WebDriver driver;
	Truelocatelogin truelocatelogin;
	AssetListElements assetlistElements;
	CommonElements commonElements;
	Constants constants = new Constants();
	String className = this.getClass().getSimpleName();

	@BeforeClass
	public void setUp() throws IOException {
		driver = GeneralActions.launchBrowser(driver, "Chrome");
		truelocatelogin = PageFactory.initElements(driver,
				Truelocatelogin.class);
		assetlistElements = PageFactory.initElements(driver, AssetListElements.class);
		commonElements = PageFactory.initElements(driver, CommonElements.class);
		ReusableActions.loadPropFileValues();
		ReusableActions.openUrl(driver,
				ReusableActions.getPropFileValues("Url"));
	}

	/**
	 * Login Script
	 */
	@Test(priority = 1, dataProviderClass = Truelocatelogin.class, dataProvider = "getData")
	public void userLogin(String sUsername, String sPassword) throws Exception {
		try {

			truelocatelogin.enterUsernamepassword(sUsername, sPassword);
			ReusableActions.takeSnapshot(driver, className);
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
	 * Asset Advanced Filter Search
	 */
	@Test(priority = 2, dataProvider = "filterData")
	public void assetAdvancedFilterFlow(String sStocknumber,String sStocknumberdropdown,String sVin,String sVindropdown,String sRfid,String sRfiddropdown,String sFacilitydropdown,
			String sLocationdropdown,String sAssetstatusdropdown,String sItemdropdown,String sItemclassdropdown,String sItemtypedropdown, 
			String sManufacture,String sMake,String sMakedropdown,String sModel,String sModeldropdown,String sLastmovefromdate, 
			String sLastmovetodate,String sArrivalfromdate,String sArrivaltodate)
			throws Exception {
		try {
			assetlistElements.menuClick();
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedFilterOpen(driver);
			ReusableActions.takeSnapshot(driver, className);
			assetlistElements.enterAdvanceFilterInfo(sStocknumber, sStocknumberdropdown, sVin, sVindropdown, sRfid, sRfiddropdown, sFacilitydropdown,
					sLocationdropdown, sAssetstatusdropdown, sItemdropdown, sItemclassdropdown, sItemtypedropdown, 
					sManufacture, sMake, sMakedropdown, sModel, sModeldropdown, sLastmovefromdate, 
					sLastmovetodate, sArrivalfromdate, sArrivaltodate);
			ReusableActions.takeSnapshot(driver, className);
			commonElements.clickAdvancedSearch(driver);
			ReusableActions.takeSnapshot(driver, className);
			if (commonElements.filtetResultValidation(sVin)) {
				TestNGResults.put("24", new Object[] { "Asset Advance Filter",
						"Asset Advance Filter successful", "Pass" });
			} else {
				TestNGResults.put("24", new Object[] { "Asset Advance Filter",
						"Asset Advance Filter", "Fail" });
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
	public static Object[][] filterData() {
		return GeneralActions.getData("AssetAdvancedFilter");
	}
}
