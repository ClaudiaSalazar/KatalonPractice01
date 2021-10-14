package helper_makeappointment

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
	public void checkReadmission(String isChecked) {

		if (isChecked == true) {

			WebUI.check(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'))

			WebUI.verifyElementChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'),
					GlobalVariable.timeout)
		}else {

			WebUI.verifyElementNotChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'),
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

	@Keyword
	public def verifyAppointmentSubmitted() {
		WebUI.waitForPageLoad(GlobalVariable.timeout)
		WebUI.takeScreenshot()
		WebUI.verifyElementVisible(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/title_appointmentConfirmation'), FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/button_goToHomepage'))
		WebUI.delay(3)
	}
}





