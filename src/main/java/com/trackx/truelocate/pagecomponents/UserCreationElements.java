package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class UserCreationElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	
	@FindBy(xpath = "//*[@id='menuField']/ul[9]/li/a/span")
	WebElement menu_security;

	@FindBy(linkText = "User")
	WebElement menu_user;

	@FindBy(xpath ="//*[@id=\"filterSlider\"]/header/button")
	WebElement btn_createuser;

	@FindBy(id="email") 
	WebElement txt_email;

	@FindBy(id="firstName") 
	WebElement txt_firstName;

	@FindBy(id="lastName") 
	WebElement txt_lastName;

	@FindBy(id="mobile") 
	WebElement txt_mobile;

	@FindBy(id="select2-chosen-2") 
	WebElement dropdown_language;

	@FindBy(xpath="//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_language;

	@FindBy(id="enabledEdit")
	WebElement togglebtn_enabled;

	@FindBy(id="userPassword")
	WebElement txt_password;

	@FindBy(id="confirmPassword")
	WebElement txt_confirmpwd;

	@FindBy(id="pwdChange")
	WebElement togglebtn_pwdChange;

	@FindBy(id="pwdExpire")
	WebElement togglebtn_expiredPassword;

	@FindBy(xpath ="//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[1]")
	WebElement btn_usercreate;

	@FindBy(className ="btnCancel")
	WebElement btn_usercreatecancel;
	
	@FindBy(className = "nav nav-tabs")
	WebElement tab_portals;

	@FindBy(id = "select2-chosen-4")
	WebElement dropdown_corprole;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li")
	List<WebElement> list_corprole;

	@FindBy(id = "select2-chosen-16")
	WebElement dropdown_growerrole;

	@FindBy(xpath = "//ul[@id='select2-results-16']/li")
	List<WebElement> list_growerrole;
	
	@FindBy(id = "select2-chosen-27")
	WebElement dropdown_warehouserole;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li")
	List<WebElement> list_warehouserole;

	@FindBy(id = "select2-chosen-10")
	WebElement dropdown_partnerrole;

	@FindBy(xpath = "//ul[@id='select2-results-10']/li")
	List<WebElement> list_partnerrole;
	
	@FindBy(id="errorContent")
	WebElement txt_alertmsg;
	
	@FindBy(xpath = "//*[@id='view-form']/fieldset[2]/div/section/button[1]")
	WebElement btn_editclick;
	
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[2]")
	WebElement btn_deleteclick;
	
	@FindBy(xpath = "//*[@id='edit-form']/fieldset[2]/div/section[2]/div/button[1]")
	WebElement btn_updateclick;
	
	@FindBy(className = "pageNo")
	WebElement pageCount;
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[4]")
	WebElement pageNext;
	
	@FindBy(id = "errorContent")
	WebElement txt_validate;
	
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[1]/label[2]/input")
	WebElement txt_globalSearch;
	
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[2]/div/button[1]")
	WebElement btn_go;
	
	@FindBy(id = "bot2-Msg1")
	WebElement btn_accpetAlertMsg;
	
	public UserCreationElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method used to click User menu
	 */
	public void menuClick() {
		try {
			inAction.waitForVisibilityOfElement(driver, menu_security);
			inAction.buttonClick(driver, menu_security,
					"Click button : menu_administration");
		    inAction.waitForVisibilityOfElement(driver, menu_user);
			inAction.linkClick(driver, menu_user,
					"Click link : menu_region");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Method used for selecting the role based on portal
	 * 
	 * @param portal
	 * @param role
	 */
	public void selectPortalRole(String portal, String role) {
		try {
			if(portal.equalsIgnoreCase("Corporate Portal")){
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_corprole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_corprole, role);
			} else if (portal.equalsIgnoreCase("Grower Portal")) {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_growerrole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_growerrole, role);
			}else if (portal.equalsIgnoreCase("Warehouse Portal")) {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_warehouserole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_warehouserole, role);
			}else {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_partnerrole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_partnerrole, role);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	

	/**
	 * Method used for selecting the language
	 * 
	 * @param language
	 */
	public void selectLanguage(String language) {
		try {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_language,
						"Click language dropdown : " + language);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_language, language);
				Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	/**
	 * This method used to enter the values in the text field.
	 * 
	 * @param sEmail
	 * @param sFirstname
	 * @param sLastname
	 * @param sMobile
	 * @param sLanguage
	 * @param sPassword
	 * @param sConfirmpassword
	 * @param sPortal
	 * @param sRole
	 */
	public void enterUserInfo(String sEmail, String sFirstname,
			String sLastname, String sMobile, String sLanguage, String sEnabled,String sPassword,
			String sConfirmpassword,String sPasswordchange,String sPasswordexpire, String sPortal, String sRole) {
		try {

			inAction.inputText(driver, txt_email, sEmail,
					"Enter sEmail : " + sEmail);
			inAction.inputText(driver, txt_firstName, sFirstname,
					"Enter sFirstname : " + sFirstname);
			inAction.inputText(driver, txt_lastName, sLastname,
					"Enter sLastname : " + sLastname);
			inAction.inputText(driver, txt_mobile, sMobile,
					"Enter sMobile : " + sMobile);
			Thread.sleep(1000);
			selectLanguage(sLanguage);
			Thread.sleep(1000);
			clickEnabled(sEnabled);
			inAction.inputText(driver, txt_password, sPassword,
					"Enter sPassword : " + sPassword);
			inAction.inputText(driver, txt_confirmpwd, sConfirmpassword,
					"Enter sConfirmpassword : " + sConfirmpassword);
			Thread.sleep(1000);
			clickPasswordRequireChange(sPasswordchange);
			Thread.sleep(1000);
			clickEnforcePasswordExpire(sPasswordexpire); 
			selectPortalRole(sPortal, sRole);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	/**
	 * This method used to click the Enabled toggle button
	 * 
	 * @param  sEnabled
	 */

	public void clickEnabled(String sEnabled) {
		boolean boovar = ReusableActions.isElementSelected(togglebtn_enabled);
		String str = String.valueOf(boovar);
		if (!sEnabled.equalsIgnoreCase(str) & StringUtils.isNotBlank(sEnabled)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_enabled);
			ReusableActions.selectedRadioButton(driver, togglebtn_enabled,
					"click toggle button: togglebtn_enabled");
		}
	}

	/**
	 * This method used to click the PasswordChange toggle button
	 * 
	 * @param sPasswordchange
	 */

	public void clickPasswordRequireChange(String sPasswordchange) {
		boolean boovar = ReusableActions.isElementSelected(togglebtn_pwdChange);
		String str = String.valueOf(boovar);
		if (!sPasswordchange.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sPasswordchange)) {
			inAction.waitForVisibilityOfElement(driver, togglebtn_pwdChange);
			ReusableActions.selectedRadioButton(driver, togglebtn_pwdChange,
					"click toggle button: togglebtn_pwdChange");
		}
	}

	/**
	 * This method used to click the PasswordExpire toggle button
	 * 
	 * @param sPasswordexpire
	 */
	public void clickEnforcePasswordExpire(String sPasswordexpire) {
		boolean boovar = ReusableActions
				.isElementSelected(togglebtn_expiredPassword);
		String str = String.valueOf(boovar);
		if (!sPasswordexpire.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sPasswordexpire)) {
			inAction.waitForVisibilityOfElement(driver,
					togglebtn_expiredPassword);
			ReusableActions.selectedRadioButton(driver,
					togglebtn_expiredPassword,
					"click toggle button: togglebtn_expiredPassword;");
		}
	}
}
