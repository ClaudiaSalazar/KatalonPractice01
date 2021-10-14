import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.fusesource.jansi.internal.Kernel32.MENU_EVENT_RECORD as MENU_EVENT_RECORD
import org.openqa.selenium.Keys as Keys


@SetUp
void iniciating(){
	WebUI.openBrowser('')
	
	WebUI.navigateToUrl(GlobalVariable.cura_url)
	
	WebUI.maximizeWindow()
}

@TearDown
void ending() {
	WebUI.takeScreenshot()
	
	WebUI.closeBrowser()
	
}





WebUI.click(findTestObject('Cura - Home/Page_CURA Healthcare Service/button_MakeAppointment'))

WebUI.waitForPageLoad(GlobalVariable.timeout)

//login
WebUI.setText(findTestObject('Cura - Login/Page_CURA Healthcare Service/input_Username_username'), findTestData('test/Facility_option').getValue(
        1, 1))

WebUI.setEncryptedText(findTestObject('Cura - Login/Page_CURA Healthcare Service/input_Password_password'), findTestData(
        'test/Facility_option').getValue(2, 1))

WebUI.click(findTestObject('Cura - Login/Page_CURA Healthcare Service/button_Login'))

WebUI.waitForPageLoad(GlobalVariable.timeout)

//Maake Appointment
WebUI.selectOptionByValue(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/select_Facility'), findTestData(
        'test/Facility_option').getValue(3, 1), false)

WebUI.check(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'))

WebUI.verifyElementChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'), 
    GlobalVariable.timeout)

WebUI.uncheck(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'))

WebUI.verifyElementNotChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'), 
    GlobalVariable.timeout)

WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_Medicaid_programs'))

WebUI.setText(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'), 
    findTestData('test/Facility_option').getValue(6, 1))

WebUI.setText(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/textarea_Comment_comment'), findTestData(
        'test/Facility_option').getValue(4, 1))

WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.waitForPageLoad(GlobalVariable.timeout)

WebUI.takeScreenshot(findTestData('test/Facility_option').getValue(5, 1))

//Verify Appointment
WebUI.waitForPageLoad(GlobalVariable.timeout)

WebUI.verifyElementVisible(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/title_appointmentConfirmation'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/button_goToHomepage'))

//Logout
WebUI.click(findTestObject('Object Repository/Cura - Home/Page_CURA Healthcare Service/button_Menu_Healtcare'))

WebUI.click(findTestObject('Object Repository/Cura - Home/Page_CURA Healthcare Service/option_logout'))



