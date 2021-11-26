import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'kw_browser.Browser.loadbrowser'(GlobalVariable.ebay_url)

WebUI.waitForElementVisible(findTestObject('Object Repository/Ebay/Search_button'), GlobalVariable.timeout)

TestObject mysearchbutton = WebUI.modifyObjectProperty(findTestObject('Object Repository/Ebay/Search_button'), "xpath", ConditionType.EQUALS.toString(), "//*[@type='submit']", true)

WebUI.setText(findTestObject('Object Repository/Ebay/Search_bar'), "Tablet")


WebUI.click(mysearchbutton)

WebUI.delay(3)