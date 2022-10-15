import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//
//'trf/trf to/div_DuitNow'
//
//CustomKeywords.'com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoCells'(null, null, false)
//
WebUI.callTestCase(findTestCase('login'), [('x') : 'webope_user123', ('y') : 'Maybank@1'])

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

//WebUI.click(findTestObject('trf/trf to/button_trf to dd'))
for (i = 1; i <= 6; i++) {
    WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

    WebUI.click(findTestObject('custom/mult trf to', [('id') : i]))

    if (WebUI.verifyElementPresent(findTestObject('trf/other acc-mbb/3dots'), 2, FailureHandling.OPTIONAL)) {
        def lenght = CustomKeywords.'com.Xpath.size'('//*[@src="/static/icons/show_more.svg"]')

        for (z = 1; z <= lenght; z++) {
            println(lenght)

            WebUI.scrollToElement(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/scrollRef'), 0)

            WebUI.click(findTestObject('custom/mult 3dots', [('id') : 1]))

            WebUI.click(findTestObject('trf/other acc-mbb/remove fav'))

            WebUI.click(findTestObject('trf/other acc-mbb/remove fav2'))

            WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

            WebUI.click(findTestObject('custom/mult trf to', [('id') : i]))
			WebUI.click(findTestObject('Page_Maybank2u  Maybank Malaysia/x-greenbox'))
        }
    }
}