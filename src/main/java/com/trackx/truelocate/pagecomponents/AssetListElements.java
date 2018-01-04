package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class AssetListElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();
	
	/**
	 * Edit Elements
	 */
	@FindBy(id = "createNumber")
	WebElement txt_primarynumber;
	
	@FindBy(id = "select2-chosen-3")
	WebElement dropdown_editlocation;

	@FindBy(id = "s2id_autogen3_search")
	WebElement txt_editlocation;

	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li")
	List<WebElement> list_editlocation;
	
	@FindBy(id = "select2-chosen-5")
	WebElement dropdown_editassetstatus;

	@FindBy(id = "s2id_autogen5_search")
	WebElement txt_assetstatus;

	@FindBy(xpath = "//*[@id=\"select2-results-5\"]/li")
	List<WebElement> list_editassetstatus;
	
	@FindBy(id = "select2-chosen-7")
	WebElement dropdown_owner;

	@FindBy(id = "s2id_autogen7_search")
	WebElement txt_owner;

	@FindBy(xpath = "//*[@id=\"select2-results-7\"]/li")
	List<WebElement> list_owner;
	
	@FindBy(id = "select2-chosen-9")
	WebElement dropdown_assingee;

	@FindBy(id = "s2id_autogen9_search")
	WebElement txt_assingee;

	@FindBy(xpath = "//*[@id=\"select2-results-9\"]/li")
	List<WebElement> list_assingee;
	
	@FindBy(xpath = "//*[@id='editIdentifiers']/div/div/table/tbody/tr/td[1]/label/input")
	WebElement txt_editstocknumber;
	

	/**
	 * AdvanceFilter Elements
	 */

	@FindBy(id = "select2-chosen-14")
	WebElement dropdown_stocknumber;

	@FindBy(id = "s2id_autogen14_search")
	WebElement txt_stocknumber;

	@FindBy(xpath = "//*[@id=\"select2-results-14\"]/li")
	List<WebElement> list_stocknumber;

	@FindBy(id = "select2-chosen-15")
	WebElement dropdown_vin;

	@FindBy(id = "s2id_autogen15_search")
	WebElement txt_vin;

	@FindBy(xpath = "//*[@id=\"select2-results-15\"]/li")
	List<WebElement> list_vin;

	@FindBy(id = "select2-chosen-16")
	WebElement dropdown_rfid;

	@FindBy(id = "s2id_autogen16_search")
	WebElement txt_rfid;

	@FindBy(xpath = "//*[@id=\"select2-results-16\"]/li")
	List<WebElement> list_rfid;

	@FindBy(id = "s2id_facilityName")
	WebElement dropdown_facility;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_facility;

	@FindBy(id = "s2id_locationName")
	WebElement dropdown_location;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_location;

	@FindBy(id = "s2id_assetStatusName")
	WebElement dropdown_assetstatus;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_assetstatus;

	@FindBy(id = "s2id_itemName")
	WebElement dropdown_item;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_item;

	@FindBy(id = "s2id_itemClassName")
	WebElement dropdown_itemclass;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_itemclass;

	@FindBy(id = "s2id_itemTypeName")
	WebElement dropdown_itemtype;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li")
	List<WebElement> list_itemtype;

	@FindBy(id = "manufacturingName")
	WebElement txt_manufacturename;

	@FindBy(id = "select2-chosen-23")
	WebElement dropdown_make;

	@FindBy(id = "s2id_autogen23_search")
	WebElement txt_make;

	@FindBy(xpath = "//*[@id=\"select2-results-23\"]/li")
	List<WebElement> list_make;

	@FindBy(id = "select2-chosen-24")
	WebElement dropdown_model;

	@FindBy(id = "s2id_autogen24_search")
	WebElement txt_model;

	@FindBy(xpath = "//*[@id=\"select2-results-24\"]/li")
	List<WebElement> list_model;

	@FindBy(id = "lastMoveDatefromDate")
	WebElement txt_lastmovefromdate;

	@FindBy(id = "lastMoveDatetoDate")
	WebElement txt_lastMoveDatetoDate;

	@FindBy(id = "arrivalTimefromDate")
	WebElement txt_arrivalTimefromDate;

	@FindBy(id = "arrivalTimetoDate")
	WebElement txt_arrivalTimetoDate;

	/**
	 * Menu Elements
	 */

	@FindBy(xpath = "//*[@id='menuField']/ul[3]/li/a/span")
	WebElement menu_asset;

	@FindBy(linkText = "Asset List")
	WebElement menu_assetlist;

	public AssetListElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method used to click Asset menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_asset,
					"Click button : menu_asset");
			inAction.linkClick(driver, menu_assetlist,
					"Click button : menu_assetlist");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used for Advance Filter
	 * 
	 * @param sStocknumbe
	 * @param sStocknumberdropdown
	 * @param sFacilitytype
	 * @param sFacilitydropdown
	 * @param sLoactiontype
	 * @param sLocationTypedropdown
	 * @param sEntries
	 */

	public void enterAdvanceFilterInfo(String sStocknumber,
			String sStocknumberdropdown, String sVin, String sVindropdown,
			String sRfid, String sRfiddropdown, String sFacilitydropdown,
			String sLocationdropdown, String sAssetstatusdropdown,
			String sItemdropdown, String sItemclassdropdown,
			String sItemtypedropdown, String sManufacture, String sMake,
			String sMakedropdown, String sModel, String sModeldropdown,
			String sLastmovefromdate, String sLastmovetodate,
			String sArrivalfromdate, String sArrivaltodate) {
		try {
			selectStocknumber(sStocknumber, sStocknumberdropdown);
			selectVin(sVin, sVindropdown);
			selectRfid(sRfid, sRfiddropdown);
			selectFacility(sFacilitydropdown);
			selectLocation(sLocationdropdown);
			selectAssetstatus(sAssetstatusdropdown);
			selectItem(sItemdropdown);
			selectItemclass(sItemclassdropdown);
			selectItemtype(sItemtypedropdown);
			inAction.inputText(driver, txt_manufacturename, sManufacture,
					"Enter txt_manufacturename : " + sManufacture);
			//sMake(sMake, sMakedropdown);
			//sModel(sModel, sModeldropdown);
			inAction.inputText(driver, txt_lastmovefromdate, sLastmovefromdate,
					"Enter sLastmovefromdate : " + sLastmovefromdate);
			inAction.inputText(driver, txt_lastMoveDatetoDate, sLastmovetodate,
					"Enter sLastmovetodate : " + sLastmovetodate);
			inAction.inputText(driver, txt_arrivalTimefromDate,
					sArrivalfromdate, "Enter sArrivalfromdate : "
							+ sArrivalfromdate);
			inAction.inputText(driver, txt_arrivalTimetoDate, sArrivaltodate,
					"Enter sArrivaltodate : " + sArrivaltodate);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Stock number
	 * 
	 * @param sStocknumber
	 * @param sStocknumberdropdown
	 *            )
	 */
	public void selectStocknumber(String sStocknumber,
			String sStocknumberdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_stocknumber,
					"Click button : dropdown_stocknumber");
			inAction.inputText(driver, txt_stocknumber, sStocknumber,
					"Enter sStocknumber : " + sStocknumber);
			inAction.selectByTextInDropdown(driver, list_stocknumber,
					sStocknumberdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select VIN
	 * 
	 * @param sVin
	 * @param sVindropdown
	 */
	public void selectVin(String sVin, String sVindropdown) {
		try {
			inAction.buttonClick(driver, dropdown_vin,
					"Click button : dropdown_vin");
			inAction.inputText(driver, txt_vin, sVin, "Enter sVin : " + sVin);
			inAction.selectByTextInDropdown(driver, list_vin, sVindropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select RFID
	 * 
	 * @param sRfid
	 * @param sRfiddropdown
	 */
	public void selectRfid(String sRfid, String sRfiddropdown) {
		try {
			inAction.buttonClick(driver, dropdown_rfid,
					"Click button : dropdown_rfid");
			inAction.inputText(driver, txt_rfid, sRfid, "Enter sRfid : "
					+ sRfid);
			inAction.selectByTextInDropdown(driver, list_rfid, sRfiddropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Facility
	 * 
	 * @param sFacility
	 * @param sFacilitydropdown
	 */
	public void selectFacility(String sFacilitydropdown) {
		try {
			inAction.buttonClick(driver, dropdown_facility,
					"Click button : dropdown_facility;");
			inAction.selectByTextInDropdown(driver, list_facility,
					sFacilitydropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Location
	 * 
	 * @param sLocationdropdown
	 */
	public void selectLocation(String sLocationdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_location,
					"Click button : dropdown_location");
			inAction.selectByTextInDropdown(driver, list_location,
					sLocationdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Asset status
	 * 
	 * @param sAssetstatusdropdown
	 */
	public void selectAssetstatus(String sAssetstatusdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_assetstatus,
					"Click button : dropdown_assetstatus");
			inAction.selectByTextInDropdown(driver, list_assetstatus,
					sAssetstatusdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Item
	 * 
	 * @param sItemdropdown
	 */
	public void selectItem(String sItemdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_item,
					"Click button : dropdown_item");
			inAction.selectByTextInDropdown(driver, list_item, sItemdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Itemclass
	 * 
	 * @param sItemclassdropdown
	 */
	public void selectItemclass(String sItemclassdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_itemclass,
					"Click button : dropdown_itemclass");
			inAction.selectByTextInDropdown(driver, list_itemclass,
					sItemclassdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Itemtype
	 * 
	 * @param sItemtypedropdown
	 */
	public void selectItemtype(String sItemtypedropdown) {
		try {
			inAction.buttonClick(driver, dropdown_itemtype,
					"Click button : dropdown_itemtype");
			inAction.selectByTextInDropdown(driver, list_itemtype,
					sItemtypedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Make
	 * 
	 * @param sMake
	 * @param sMakedropdown
	 */

	public void sMake(String sMake, String sMakedropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_make);
			inAction.buttonClick(driver, dropdown_make,
					"Click button : dropdown_fliteritem");
			inAction.inputText(driver, txt_make, sMake,
					"Enter sMakedropdown : " + sMakedropdown);
			inAction.selectByTextInDropdown(driver, list_make, sMakedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to select Model
	 * 
	 * @param sModel
	 * @param sModeldropdown
	 */

	public void sModel(String sModel, String sModeldropdown) {
		try {
			inAction.waitForElementToBeClickable(driver, dropdown_model);
			inAction.buttonClick(driver, dropdown_model,
					"Click button : dropdown_model");
			inAction.inputText(driver, txt_model, sModel, "Enter sModel : "
					+ sModel);
			inAction.selectByTextInDropdown(driver, list_model, sModeldropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterEditAssetListInfo(String sPrimaryIdentifier,String sLocation,String sLocationdropdown,String sAssetstatus,
			String sAssetstatusdropdown,String sOwner,String sOwnerdropdown,String sAssingee,String sAssigneedropdown) {
		try {
			inAction.inputText(driver, txt_primarynumber, sPrimaryIdentifier,
					"txt_primarynumber : " + sPrimaryIdentifier);
			selectEditLocation(sLocation, sLocationdropdown);
			selectEditAssetstatus(sAssetstatus,sAssetstatusdropdown);
			selectOwner(sOwner,sOwnerdropdown);
			selectAssingee(sAssingee,sAssigneedropdown);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   /**
	 * This method used to select Location
	 * 
	 * @param sLocationdropdown
	 */
	public void selectEditLocation(String sLocation, String sLocationdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_editlocation,
					"Click button : dropdown_location");
			inAction.inputText(driver, txt_editlocation, sLocation,
					"Enter txt_editlocation : " + sLocation);
			inAction.selectByTextInDropdown(driver, list_editlocation,
					sLocationdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectEditAssetstatus(String sAssetstatus,String sAssetstatusdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_editassetstatus,
					"Click button : dropdown_editassetstatus");
			inAction.inputText(driver, txt_assetstatus, sAssetstatus,
					"Enter txt_assetstatus : " + sAssetstatus);
			inAction.selectByTextInDropdown(driver, list_editassetstatus,
					sAssetstatusdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectOwner(String sOwner,String sOwnerdropdown) {
		try {
			inAction.buttonClick(driver, dropdown_owner,
					"Click button : dropdown_owner");
			inAction.inputText(driver, txt_owner, sOwner,
					"Enter txt_owner : " + sOwner);
			inAction.selectByTextInDropdown(driver, list_owner,
					sOwnerdropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAssingee(String sAssingee,String sAssigneedropdown) {
		try {
			inAction.buttonClick(driver, dropdown_assingee,
					"Click button : dropdown_assingee");
			inAction.inputText(driver, txt_assingee, sAssingee,
					"Enter txt_owner : " + sAssingee);
			inAction.selectByTextInDropdown(driver, list_assingee,
					sAssigneedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
