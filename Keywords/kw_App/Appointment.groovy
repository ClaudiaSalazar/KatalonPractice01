package kw_App

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
	public void applyReadmission(boolean myReadmission) {

		if (myReadmission == true) {
			
			WebUI.check(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'))
			WebUI.verifyElementChecked(findTestObject('Cura - Make Appointment/Page_CURA Healthcare Service/checkbox_Apply for hospital readmission_hospital_readmission'),
				GlobalVariable.timeout)
			
		}
			
	}
}