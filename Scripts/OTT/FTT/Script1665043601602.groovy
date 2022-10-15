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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')

casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_Overseas (FTT Western Union Visa Direct Maybank Overseas Transfer)'))

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

WebUI.click(findTestObject('trf/trf/other acc/Page_Maybank2u  Maybank Malaysia/div_other maybank name', [('id') : findTestData(
                'Transfer').getValue(2, 62)]))

WebUI.setText(findTestObject('OT/screen1/input_RM_CustomInputGroup---textInput---1X446 form-control'), findTestData('Transfer').getValue(
        2, 63))

WebUI.click(findTestObject('OT/screen1/button_Compare'))

a = WebUI.getText(findTestObject('custom/currency calc1', [('text') : findTestData('Transfer').getValue(4, 64)])).replaceAll(
    ' ', '')

b = WebUI.getText(findTestObject('custom/currency calc2', [('text') : findTestData('Transfer').getValue(4, 64)])).replaceAll(
    ' ', '')

CustomKeywords.'com.CurrencyCalc.RMtoOthers'(a, b)

WebUI.click(findTestObject('custom/Button based on OT type', [('text') : findTestData('Transfer').getValue(4, 64)]))

if (WebUI.verifyTextPresent('Service Notice Assignment', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyEqual(WebUI.getText(findTestObject('OT/FTT offline/h3_Maybank2u Foreign TT service is currently offline')), 
        'Maybank2u Foreign TT service is currently offline')

    WebUI.verifyEqual(WebUI.getText(findTestObject('OT/FTT offline/p_Please try again on weekdays anytime from 1000am to 600pm')), 
        'Please try again on weekdays anytime from 10:00am to 6:00pm.')

    WebUI.click(findTestObject('OT/FTT offline/X-popup'))
} else {
    KeywordUtil.logInfo('Sender Details')

    WebUI.click(findTestObject('OT/FTT online/sender details/button_Malaysian(CitizenPermanent Resident) -nationality'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('OT/FTT online/sender details/span_Malaysian(CitizenPermanent Resident) -nationality'))

    WebUI.setText(findTestObject('OT/FTT online/sender details/textarea_sender Address Line 1'), findTestData('Transfer').getValue(
            4, 67))

    WebUI.setText(findTestObject('OT/FTT online/sender details/textarea_sender Address Line 2'), findTestData('Transfer').getValue(
            4, 68))

    WebUI.setText(findTestObject('OT/FTT online/sender details/input_Postcode_sdrPostCode'), findTestData('Transfer').getValue(
            4, 69))

    WebUI.click(findTestObject('OT/FTT online/sender details/input_Country_RenderSearchableDropdown---paymentInput---21ojH'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('OT/FTT online/sender details/div_Andorra -country'))

    KeywordUtil.logInfo('Recipient bank Details')

    WebUI.click(findTestObject('OT/FTT online/recipient bank details/a_RECIPIENTS BANK DETAILS'))

    WebUI.click(findTestObject('OT/FTT online/recipient bank details/input_concat(Recipient, , s Bank)_RenderSearchableDropdown---paymentInput---21ojH'))

    WebUI.click(findTestObject('OT/FTT online/recipient bank details/div_ABN AMRO BANK'))

    WebUI.setText(findTestObject('OT/FTT online/recipient bank details/input_Account Number_creditAcctNo'), findTestData(
            'Transfer').getValue(4, 74))

    WebUI.setText(findTestObject('OT/FTT online/recipient bank details/textarea_Branch Address_branchAddress'), findTestData(
            'Transfer').getValue(4, 75))

    WebUI.setText(findTestObject('OT/FTT online/recipient bank details/input_City_branchCity'), findTestData('Transfer').getValue(
            4, 76))

    KeywordUtil.logInfo('Recipient Details')

    WebUI.click(findTestObject('OT/FTT online/recipient details/a_RECIPIENTS DETAILS'))

    WebUI.click(findTestObject('OT/FTT online/recipient details/button_Please Select -nationality'))

    WebUI.click(findTestObject('OT/FTT online/recipient details/span_Malaysian'))

    WebUI.setText(findTestObject('OT/FTT online/recipient details/input_Name_beneName'), findTestData('Transfer').getValue(
            4, 80))

    WebUI.setText(findTestObject('OT/FTT online/recipient details/input_ICPassport No.Biz Registration No_beneID'), findTestData(
            'Transfer').getValue(4, 81))

    WebUI.setText(findTestObject('OT/FTT online/recipient details/textarea_Recipient Address Line 1_beneAddr1'), findTestData(
            'Transfer').getValue(4, 82))

    WebUI.setText(findTestObject('OT/FTT online/recipient details/textarea_Recipient Address Line 2_beneAddr2'), findTestData(
            'Transfer').getValue(4, 83))

    WebUI.click(findTestObject('OT/FTT online/recipient details/input_Country_RenderSearchableDropdown---paymentInput---21ojH'))

    WebUI.click(findTestObject('OT/FTT online/recipient details/div_Andorra'))

    WebUI.setText(findTestObject('OT/FTT online/recipient details/input_Contact Number_beneContact'), findTestData('Transfer').getValue(
            4, 85))

    WebUI.setText(findTestObject('OT/FTT online/recipient details/input_Email (Optional)_beneEmail'), findTestData('Transfer').getValue(
            4, 86))
	KeywordUtil.logInfo('Transfer Details')
    WebUI.click(findTestObject('OT/FTT online/transfer details/a_TRANSFER DETAILS'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/button_Please Select -purpose'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/Page_Maybank2u  Maybank Malaysia/span_CAPITAL TRANSACTION', 
            [('text') : 'TRANSFER']))

    WebUI.click(findTestObject('OT/FTT online/transfer details/button_Please Select-subpurpose'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/Page_Maybank2u  Maybank Malaysia/span_MERCHANDISE', 
		[('text') : 'PRIVATE TRANSFER - OTHER CAPITAL TRANSFERS']))

    WebUI.click(findTestObject('OT/FTT online/transfer details/button_Please Select-trx fees'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/Page_Maybank2u  Maybank Malaysia/div_I will pay (Recipient will receive the full transferred amount)'))

    WebUI.setText(findTestObject('OT/FTT online/transfer details/textarea_Additional Info_additionalInfo'), 'testing')

    WebUI.click(findTestObject('OT/FTT online/transfer details/img'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/button_TRANSFER RM41.00'))

    WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

    WebUI.delay(20)

    WebUI.callTestCase(findTestCase('TAC'), [('TACmessage') : findTestData('Transfer').getValue(4, 95)], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'
            , ('future') : 'Your transfer is scheduled.', ('casaBfr') : casaBfr])
}

