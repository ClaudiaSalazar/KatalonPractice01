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

@com.kms.katalon.core.annotation.SetUp
def iniating() {
	
	CustomKeywords.'helper_browser.Browser.launchUrl'(GlobalVariable.cura_url)
	
	CustomKeywords.'helper_makeappointment.Appointment.clickMakeApButton'()
	
	CustomKeywords.'helper_login.Login.login_curasite'(GlobalVariable.username, GlobalVariable.password)
	
}

@com.kms.katalon.core.annotation.TearDown
def ending() {
	
	CustomKeywords.'helper_logout.cura_logout.logoutFromCura'()
	WebUI.closeBrowser()
	
}

WebUI.callTestCase(findTestCase('Test Cases/cura_Healthcare/TC01-AppointmentWithKW'), null, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/cura_Healthcare/TC02-AppointmentWithKW'), null, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/cura_Healthcare/TC03 -AppointmentWithKW'), null, FailureHandling.STOP_ON_FAILURE)





