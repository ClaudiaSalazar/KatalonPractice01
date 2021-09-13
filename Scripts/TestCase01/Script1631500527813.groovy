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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Cura - Home/Page_CURA Healthcare Service/button_MakeAppointment'))

WebUI.waitForPageLoad(3)

WebUI.setText(findTestObject('Cura - Login/Page_CURA Healthcare Service/input_Username_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Cura - Login/Page_CURA Healthcare Service/input_Password_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Cura - Login/Page_CURA Healthcare Service/button_Login'))

WebUI.waitForPageLoad(3)

WebUI.selectOptionByValue(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/Select_Facility'), 'Seoul CURA Healthcare Center', 
    false)

WebUI.check(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/Checkbox_Apply for hospital readmission_hospital_readmission'))

WebUI.verifyElementChecked(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/Checkbox_Apply for hospital readmission_hospital_readmission'), 
    2)

WebUI.click(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/radiobutton_Medicare_programs'))

WebUI.click(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/Calendar_Visit Date (Required)_glyphicon glyphicon-calendar'))

WebUI.click(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/Fecha_30Sept'))

/*WebUI.setText(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'), 
    '30/09/2021')*/
WebUI.sendKeys(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/textarea_Comment_comment'), 'Testing Appointment 01')

WebUI.click(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.waitForPageLoad(3)

WebUI.verifyElementVisible(findTestObject('Curra - Make Appointment/Page_CURA Healthcare Service/h2_Appointment Confirmation'))

WebUI.takeScreenshot('C:\\Katalon App\\Screenshots\\test01.png')

WebUI.closeBrowser()

