import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


//launch url
CustomKeywords.'kw_browser.Browser.loadbrowser'(GlobalVariable.ebay_url)

WebUI.waitForElementVisible(findTestObject('Object Repository/Ebay/Search_button'), GlobalVariable.timeout)


//Creating a new object and adding the property
TestObject searchButton02 = findTestObject('Object Repository/Ebay/Search_button')

searchButton02.addProperty('xpath', ConditionType.EQUALS, '//input[@value=\'Buscar\']', true)

//Searching using inicial testobject
WebUI.setText(findTestObject('Object Repository/Ebay/Search_bar'), 'Laptop Lenovo')

WebUI.click(findTestObject('Object Repository/Ebay/Search_button'))

WebUI.delay(3)

//Searching using copied testobject
WebUI.setText(findTestObject('Object Repository/Ebay/Search_bar'), 'iphone13')

WebUI.click(searchButton02)

WebUI.delay(3)


//removing property
/* WebUI.waitForElementVisible(findTestObject('Object Repository/Ebay/Search_button'), GlobalVariable.timeout)

TestObject searchButton03 = WebUI.removeObjectProperty(findTestObject('Object Repository/Ebay/Search_button'), 'id')

WebUI.setText(findTestObject('Object Repository/Ebay/Search_bar'), 'Samsung Tablet')

WebUI.click(searchButton03)

WebUI.delay(3)
*/

//Updating a property of existing object

WebUI.waitForElementVisible(findTestObject('Object Repository/Ebay/Search_button'), GlobalVariable.timeout)

TestObject searchButton04 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Ebay/Search_button'), "xpath", ConditionType.EQUALS.toString(), "//*[@type='submit']", true)

WebUI.closeBrowser()


