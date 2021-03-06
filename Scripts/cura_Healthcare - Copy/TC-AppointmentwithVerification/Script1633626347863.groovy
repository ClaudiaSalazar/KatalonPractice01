import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import org.openqa.selenium.Keys as Keys

CustomKeywords.'kw_browser.Browser.loadbrowser'(GlobalVariable.cura_url)

CustomKeywords.'kw_homepage.Homepage.initiateApp'()

CustomKeywords.'kw_login.Login.Login_curahealthcare'(findTestData('test/Facility_option').getValue(1, 1), findTestData('test/Facility_option').getValue(
        2, 1))

CustomKeywords.'kw_App.Appointment.chooseFacility'(findTestData('test/Facility_option').getValue(3, 1))

CustomKeywords.'kw_App.Appointment.applyReadmission'(true)

CustomKeywords.'kw_App.Appointment.chooseHealhcareProgram'(findTestData('test/Facility_option').getValue(7, 1))


CustomKeywords.'kw_App.Appointment.setDate'(findTestData('Data Files/test/Facility_option').getValue(6, 1))

CustomKeywords.'kw_App.Appointment.enterComment'(findTestData('Data Files/test/Facility_option').getValue(4,1))

CustomKeywords.'kw_App.Appointment.submitAppointment'()

CustomKeywords.'kw_App.Appointment.validateAppointment'()

WebUI.closeBrowser()

