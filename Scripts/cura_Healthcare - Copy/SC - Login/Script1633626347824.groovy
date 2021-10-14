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

//load page
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.cura_url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Cura - Home/Page_CURA Healthcare Service/button_MakeAppointment'))

WebUI.waitForPageLoad(GlobalVariable.timeout)


//login
WebUI.setText(findTestObject('Cura - Login/Page_CURA Healthcare Service/input_Username_username'), findTestData('test/Facility_option').getValue(
		1, 1))

WebUI.setEncryptedText(findTestObject('Cura - Login/Page_CURA Healthcare Service/input_Password_password'), findTestData(
		'test/Facility_option').getValue(2, 1))

WebUI.click(findTestObject('Cura - Login/Page_CURA Healthcare Service/button_Login'))

WebUI.waitForPageLoad(GlobalVariable.timeout)