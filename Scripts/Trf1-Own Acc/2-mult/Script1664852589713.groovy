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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('login'),null)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')

casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_Own Accounts'))

def length = CustomKeywords.'com.Xpath.size'('//*[@class="col-xs-12 OwnAccRecipient---container---1770h"]')

if (length > 5) {
	length = 5
}

for (i = 1; i <= length; i++) {
	WebUI.click(findTestObject('custom/list own acc', [('id') : i]))
	
	WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/p_Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')), 'Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')

	WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_amount'), findTestData('Transfer').getValue(3,12))

	WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_ref'), findTestData('Transfer').getValue(3,13))

	WebUI.click(findTestObject('trf/trf to/span_add other trf'))

	WebUI.scrollToElement(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/scrollRef'), 0)
}

WebUI.click(findTestObject('trf/own acc/mult/trf select all'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')
WebUI.click(findTestObject('TAC/button_CONFIRM'))

WebUI.delay(5)
WebUI.takeFullPageScreenshot()
if (WebUI.verifyTextPresent('Your transactions are unsuccessful.', false, FailureHandling.OPTIONAL)) {

	CustomKeywords.'com.Xpath.sizeNtext'('//p[@class = \'TransactionSummary---errorMessageWrap---14xkN\']', 'trf/own acc/mult/failed desc')

	CustomKeywords.'com.Xpath.sizeNtext'('//*[text()="Reference ID"]/parent::div', 'custom/testf')

	WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/btn_done'))
} else if (WebUI.verifyTextPresent('Your transactions are successful.', false, FailureHandling.OPTIONAL)) {

	CustomKeywords.'com.Xpath.sizeNtext'('//*[text()="Reference ID"]/parent::div', 'custom/testf')

	WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))

	WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

	casaAftr = WebUI.getText(findTestObject('custom/avail bal')).replaceAll(' ', '')

	CustomKeywords.'com.Calculate.Balance'(casaBfr, findTestData('Transfer').getValue(3,12).toDouble() * length, casaAftr)

	WebUI.click(findTestObject('trf/other acc-mbb/conf screen/button_New Transfer'))
} else if (WebUI.verifyTextPresent('Your transactions are partially done.', false) == true) {
	
	WebUI.scrollToElement(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/a_SAVE RECEIPT'), 2)

	CustomKeywords.'com.Xpath.sizeNtext'('//p[@class = \'TransactionSummary---errorMessageWrap---14xkN\']', 'trf/own acc/mult/failed desc')

	CustomKeywords.'com.Xpath.sizeNtext'('//*[text()="Reference ID"]/parent::div', 'custom/testf')

	WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))
	WebUI.takeFullPageScreenshot()
	WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

	casaAftr = WebUI.getText(findTestObject('custom/avail bal')).replaceAll(' ', '')

	CustomKeywords.'com.Calculate.Balance'(casaBfr, findTestData('Transfer').getValue(3,12).toDouble() * length, casaAftr)

	WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/btn_done'))
}

