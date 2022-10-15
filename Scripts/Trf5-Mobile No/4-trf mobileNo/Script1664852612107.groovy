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

WebUI.callTestCase(findTestCase('login'), [:])

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')

casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_Mobile Number'))

WebUI.click(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/inputclick'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/p_Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')), 'Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')

WebUI.setText(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/input_Mobile Number_mobileNumber'), findTestData(
        'Transfer').getValue(2, 54))

WebUI.setText(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/input_concat(Recipient  s Name)_nickName'), findTestData(
        'Transfer').getValue(2, 55))

WebUI.setText(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/input_concat(Recipient  s Reference)_receipientReference'), 
    'test')

WebUI.click(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/img_Please Select_RenderDesktopDropdown---caret---1M9rq'))

WebUI.click(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/span_RM10000'))

WebUI.click(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/img'))

WebUI.click(findTestObject('trf/mobile/Page_Maybank2u  Maybank Malaysia/button_TRANSFER'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')
WebUI.callTestCase(findTestCase('TAC'), [('TACmessage'): findTestData('Transfer').getValue(2, 57)], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.getText(findTestObject('trf/mobile/REFid'))
refIDvalue = WebUI.getText(findTestObject('enhc/get refID value'))

//println(refIDvalue.length())
//assertThat(isNumeric(refIDvalue)).isTrue();
WebUI.verifyEqual(refIDvalue.length(), '10')

WebUI.takeFullPageScreenshot()
if (WebUI.verifyTextPresent('Transaction Unsuccessful', false, FailureHandling.OPTIONAL)) {

    WebUI.getText(findTestObject('trf/other acc-mbb/unsuccess/p_Unsuccessful desc'))

    WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Done')) 

} else if (WebUI.verifyTextPresent('Transaction Accepted!', false, FailureHandling.OPTIONAL)) {
	def totalAmt = WebUI.getText(findTestObject('enhc/total amt value')).replaceAll(' ','')
    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))
	WebUI.delay(5)
	WebUI.takeFullPageScreenshot()
	WebUI.verifyEqual(totalAmt, WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_RM1.00')).replaceAll(' ',''))

	WebUI.verifyEqual(refIDvalue, WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_2943679728')))

	WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_This receipt is computer generated and no signature is required')),
		'This receipt is computer generated and no signature is required.')
    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

    casaAftr = WebUI.getText(findTestObject('custom/avail bal')).replaceAll(' ', '')

    CustomKeywords.'com.Calculate.Balance'(casaBfr, '100', casaAftr)

    if (WebUI.verifyElementPresent(findTestObject('trf/other acc-mbb/ADD FAV/button_Add to Favourite'), 2, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Add to Favourite'))

        WebUI.setText(findTestObject('trf/other acc-mbb/ADD FAV/input_Nickname_TransferModal---account-number---1ojej'), 
            findTestData('Transfer').getValue(3, 58))

        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_ADD'))

        WebUI.click(findTestObject('trf/mobile/after success/img'))

        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_ADD'))

        WebUI.callTestCase(findTestCase('TAC'), [('TACmessage'):findTestData('Transfer').getValue(3,57)], FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('trf/mobile/after success/button_Done'))

        WebUI.click(findTestObject('Page_Maybank2u  Maybank Malaysia/x-greenbox'))
    } else {
        WebUI.click(findTestObject('trf/other acc-mbb/conf screen/button_New Transfer'))
    }
}