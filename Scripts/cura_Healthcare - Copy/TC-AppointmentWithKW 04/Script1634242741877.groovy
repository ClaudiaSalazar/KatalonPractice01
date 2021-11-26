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

CustomKeywords.'helper_browser.Browser.launchUrl'(GlobalVariable.cura_url)

CustomKeywords.'helper_makeappointment.Appointment.clickMakeApButton'()

CustomKeywords.'helper_login.Login.login_curasite'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'helper_makeappointment.Appointment.selectFacility'(findTestData('Cura_Healthcare/Appointment_example').getValue(
	2, 1))

CustomKeywords.'helper_makeappointment.Appointment.checkReadmission'(findTestData('Cura_Healthcare/Appointment_example').getValue(
	3, 1))

CustomKeywords.'helper_makeappointment.Appointment.selectHealthcareProgram'(findTestData('Cura_Healthcare/Appointment_example').getValue(
	4, 1))

CustomKeywords.'helper_makeappointment.Appointment.selectDate'(findTestData('Cura_Healthcare/Appointment_example').getValue(
	5, 1))

CustomKeywords.'helper_makeappointment.Appointment.addComment'(findTestData('Cura_Healthcare/Appointment_example').getValue(
	6, 1))

CustomKeywords.'helper_makeappointment.Appointment.createAppointment'()

CustomKeywords.'helper_makeappointment.Appointment.verifyAppointmentSubmitted'()



