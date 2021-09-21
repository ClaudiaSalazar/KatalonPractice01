package helper_makeappointment

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Appointment {

	@Keyword
	public void clickMakeApButton() {
		WebUI.click(findTestObject('Cura - Home/Page_CURA Healthcare Service/button_MakeAppointment'))
		WebUI.waitForPageLoad(GlobalVariable.timeout)
	}

	@Keyword
	public void selectFacility(String my_Fac_option) {
		WebUI.selectOptionByValue(findTestObject('Object Repository/Cura - Make Appointment/Page_CURA Healthcare Service/Select_Facility'), my_Fac_option, false)
	}

	@Keyword
	public void checkReadmission(boolean isChecked) {

		if (isChecked == true) {

			WebUI.check(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'))

			WebUI.verifyElementChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'),
					GlobalVariable.timeout)
		}else {

			WebUI.verifyElementUnchecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'),
					GlobalVariable.timeout)
		}
	}

	@Keyword
	public void selectHealthcareProgram(String myProgram) {

		switch(myProgram) {
			case "Medicare":
				WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_Medicare_programs'))
				break;
			case "Medicard":
				WebUI.click(findTestObject('Object Repository/Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_Medicaid_programs'))
				break;
			case "None":
				WebUI.click(findTestObject('Object Repository/Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_None_programs'))
				break;
			default:
				println("No matching case found")
				break;
		}
	}

	@Keyword
	public void selectDate(def myDate) {

		WebUI.setText(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'),
				myDate)
	}

	@Keyword
	public void addComment(def myComment) {

		WebUI.sendKeys(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/textarea_Comment_comment'), myComment)
	}

	@Keyword
	public void createAppointment() {
		WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/button_Book Appointment'))
		WebUI.waitForPageLoad(GlobalVariable.timeout)
		WebUI.verifyElementVisible(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/h2_Appointment Confirmation'))
	}
}





