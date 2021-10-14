package kw_ebay

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import selectors.Ebay_selectors

public class Carrousel {

	private def contructXpath01(String articleName) {

		return String.format(Ebay_selectors.dynamicArticleXpath, articleName)
	}

	private def constructXpath02(String articleName) {
		return String.format(Ebay_selectors.dynamicOfferXpath, articleName)
	}


	private def creatingArticle01(String articleName) {
		TestObject offerName01 =  new TestObject(articleName)
		offerName01.addProperty("xpath", ConditionType.EQUALS, contructXpath01(articleName), true)
		return offerName01
	}

	private def creatingArticle02(String articleName) {
		TestObject offerName02 =  new TestObject(articleName)
		offerName02.addProperty("xpath", ConditionType.EQUALS, constructXpath02(articleName), true)
		return offerName02
	}

	private def foundRealXpath(String articleName) {
		boolean isFound
		TestObject selection01 = creatingArticle01(articleName)
		TestObject selection02 = creatingArticle02(articleName)

		isFound = WebUI.verifyElementPresent(selection01, 1, FailureHandling.OPTIONAL)

		if (isFound) {
			return selection01
		}else {
			return selection02
		}
	}

	@Keyword
	public def clickingDynamicElement(String articleName) {

		TestObject mySelection = foundRealXpath(articleName)
		boolean isVisible
		int count = 1


		isVisible = WebUI.verifyElementVisible(mySelection, FailureHandling.OPTIONAL)

		while (isVisible == false) {
			WebUI.click(findTestObject('Object Repository/Ebay/nextArrow'))
			isVisible = WebUI.verifyElementVisible(mySelection, FailureHandling.OPTIONAL)
			count++
			if (count >= 4) {
				break
			}
		}

		WebUI.click(mySelection)
	}
}
