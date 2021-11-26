package kw_ebay
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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable


public class ClickOnTabs {

	private def captureXpath(String tabName) {

		return "//*[contains(@class, 'hl-cat-nav__js-tab' )]/a[text()='" + tabName + "']"
	}

	private def createTestObject(String tabName) {

		TestObject tabInEbay = new TestObject (tabName)
		println captureXpath(tabName)

		tabInEbay.addProperty("xpath", ConditionType.EQUALS , captureXpath(tabName), true)
	}

	@Keyword
	def ClickEbayTab(String tabOnEbay) {

		TestObject ebayTab =  createTestObject(tabOnEbay)

		WebUI.waitForElementVisible(ebayTab, GlobalVariable.timeout)
		WebUI.click(ebayTab)
	}
}
