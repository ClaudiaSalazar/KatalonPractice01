package kw_App

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Appointment {


	@Keyword
	public void chooseFacility(String myFac) {

		WebUI.selectOptionByValue(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/select_Facility'), myFac, false)
	}


	@Keyword
	public void chooseHealhcareProgram(String myProgram) {

		switch(myProgram) {
			case "Medicard":
				WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_Medicare_programs'))
				break;

			case "Medicard":
				WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_Medicaid_programs'))
				break;

			case "Medicard":
				WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/radiobutton_None_programs'))
				break;

			default:
				println("The option wasn´t find")
				break;
		}
	}


	@Keyword
	public void applyReadmission(String myReadmission) {

		if (myReadmission == true) {

			WebUI.check(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'))
			WebUI.verifyElementChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'),
					GlobalVariable.timeout)
		}
	}

	@Keyword
	public void setDate(def myDate) {

		WebUI.setText(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'),
				myDate)
	}

	@Keyword
	public void enterComment(def myComment) {

		WebUI.sendKeys(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/textarea_Comment_comment'), myComment)
	}

	@Keyword
	public void submitAppointment() {
		WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/button_Book Appointment'))
		WebUI.waitForPageLoad(GlobalVariable.timeout)
		WebUI.verifyElementVisible(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/h2_Appointment Confirmation'))
	}

	@Keyword
	public def validateAppointment() {
		WebUI.waitForPageLoad(GlobalVariable.timeout)
		WebUI.verifyElementVisible(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/title_appointmentConfirmation'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/button_goToHomepage'))
	}
}