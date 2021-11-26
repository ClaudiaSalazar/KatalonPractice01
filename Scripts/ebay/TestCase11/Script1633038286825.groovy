import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'kw_browser.Browser.loadbrowser'(GlobalVariable.ebay_url)

/*WebUI.waitForElementVisible(findTestObject('Object Repository/Ebay/Search_button'), GlobalVariable.timeout)

TestObject newbutton = findTestObject('Object Repository/Ebay/Search_button')

newbutton.addProperty('xpath', ConditionType.EQUALS, "//*[@type='submit']", true)

WebUI.waitForElementVisible(newbutton, GlobalVariable.timeout)

WebUI.setText(findTestObject('Object Repository/Ebay/Search_bar'), "Laptop Lenovo")

WebUI.click(newbutton)
*/

WebUI.waitForElementVisible(findTestObject('Object Repository/Ebay/Search_button'), GlobalVariable.timeout)

TestObject newbutton03 = WebUI.removeObjectProperty(findTestObject('Object Repository/Ebay/Search_button'), 'id')

WebUI.setText(findTestObject('Object Repository/Ebay/Search_bar'), "Tablet")

WebUI.click(newbutton03)


TestObject newbutton04 = WebUI.modifyObjectProperty(findTestObject, null, null, null, false)

WebUI.closeBrowser()




	