package com

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
public class Xpath {
	@Keyword
	def size(def Xpath) {
		WebDriver driver = DriverFactory.getWebDriver()

		List<WebElement> refID = driver.findElements(By.xpath(Xpath))

		return refID.size()
	}

	@Keyword
	def sizeNtext(def Xpath,def obj) {
		def i
		WebDriver driver = DriverFactory.getWebDriver()

		List<WebElement> refID = driver.findElements(By.xpath(Xpath))

		for ( i = 1;  i <= refID.size(); i++) {
			println(refID.size())

			KeywordUtil.logInfo(WebUI.getText(findTestObject(obj, [('id') : i])))
//			def refIDvalue = WebUI.getText(findTestObject('enhc/get refID value dynamic', [('id') : i]))
//			WebUI.verifyEqual(refIDvalue.length(), '10')
		}
	}
}
