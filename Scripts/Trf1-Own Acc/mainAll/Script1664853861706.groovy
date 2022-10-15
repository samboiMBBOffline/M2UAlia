import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import java.text.NumberFormat as NumberFormat

WebUI.callTestCase(findTestCase('login'), null)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/p_Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')), 
    'Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')

casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_Own Accounts'))

////SINGLE TRF
WebUI.click(findTestObject('trf/trf to/span_ownAcc', [('text') : casa2]))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/h6_Transfer To Personal Current Account')), 'Transfer To Personal Current Account')

WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_amount'), trfToOwn_amt)

println(trfToOwn_amt)

WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_ref'), trfToOwn_ref)

WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/button_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

WebUI.click(findTestObject('TAC/button_CONFIRM'))

WebUI.getText(findTestObject('Object Repository/enhc/get total amt'))

def casaAftr = WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])

CustomKeywords.'com.Calculate.Balance'(casaBfr, trfToOwn_amt, casaAftr)

/////MULTIPLE TRF
WebUI.click(findTestObject('a_MY ACCOUNTS'))

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_Own Accounts'))

casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

def lenght = CustomKeywords.'com.Xpath.size'('//*[@class="col-xs-12 OwnAccRecipient---container---1770h"]')

if (lenght > 5) {
    lenght = 5
}

for (i = 1; i <= lenght; i++) {
    WebUI.click(findTestObject('custom/list own acc', [('id') : i]))

    WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_amount'), trfToOwn_amt)

    WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_ref'), trfToOwn_ref)

    WebUI.click(findTestObject('trf/trf to/span_add other trf'))

    WebUI.scrollToElement(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/scrollRef'), 0)
}

WebUI.click(findTestObject('trf/own acc/mult/trf select all'))

WebUI.click(findTestObject('TAC/button_CONFIRM'))

WebUI.delay(5)

if (WebUI.verifyTextPresent('Your transactions are unsuccessful.', false, FailureHandling.OPTIONAL)) {
    CustomKeywords.'com.Xpath.sizeNtext'('//p[@class = \'TransactionSummary---errorMessageWrap---14xkN\']', 'trf/own acc/mult/failed desc')

    CustomKeywords.'com.Xpath.sizeNtext'('//*[text()="Reference ID"]/parent::div', 'custom/testf')

    WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/btn_done'))
} else if (WebUI.verifyTextPresent('Your transactions are successful.', false, FailureHandling.OPTIONAL)) {
    CustomKeywords.'com.Xpath.sizeNtext'('//*[text()="Reference ID"]/parent::div', 'custom/testf')

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

    casaAftr = WebUI.getText(findTestObject('custom/avail bal')).replaceAll(' ', '')

    CustomKeywords.'com.Calculate.Balance'(casaBfr, trfToOwn_amt.toDouble() * lenght, casaAftr)

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/button_New Transfer'))
} else if (WebUI.verifyTextPresent('Your transactions are partially done.', false) == true) {
    WebUI.scrollToElement(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/a_SAVE RECEIPT'), 2)

    CustomKeywords.'com.Xpath.sizeNtext'('//p[@class = \'TransactionSummary---errorMessageWrap---14xkN\']', 'trf/own acc/mult/failed desc')

    CustomKeywords.'com.Xpath.sizeNtext'('//*[text()="Reference ID"]/parent::div', 'custom/testf')

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

    casaAftr = WebUI.getText(findTestObject('custom/avail bal')).replaceAll(' ', '')

    CustomKeywords.'com.Calculate.Balance'(casaBfr, trfToOwn_amt.toDouble() * lenght, casaAftr)

    WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/btn_done'))
}


findTestData('Transfer').getValue(1,2)