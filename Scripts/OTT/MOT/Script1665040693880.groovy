import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

a = WebUI.getText(findTestObject('custom/currency calc1', [('text') : findTestData('Transfer').getValue(2, 64)])).replaceAll(
    ' ', '')

b = WebUI.getText(findTestObject('custom/currency calc2', [('text') : findTestData('Transfer').getValue(2, 64)])).replaceAll(
    ' ', '')

CustomKeywords.'com.CurrencyCalc.RMtoOthers'(a, b)

WebUI.click(findTestObject('custom/Button based on OT type', [('text') : findTestData('Transfer').getValue(2, 64)]))

WebUI.delay(3)

if (WebUI.verifyTextPresent('Service Notice Assignment', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyTextPresent('Service Notice Assignment', false)

    WebUI.verifyEqual(WebUI.getText(findTestObject('OT/MOT offline/h3_Maybank Overseas Transfer service is currently offline')), 
        'Maybank Overseas Transfer service is currently offline')

    WebUI.verifyEqual(WebUI.getText(findTestObject('OT/MOT offline/p_Please try again on weekdays anytime from 1000am to 600pm')), 
        'Please try again on weekdays anytime from 10:00am to 6:00pm.')
} else {
    KeywordUtil.logInfo('Transfer Details')

    WebUI.click(findTestObject('OT/MOT online/transfer details/button_ recipient bank name'))

    WebUI.click(findTestObject('OT/MOT online/transfer details/span_MAYBANK BANKING BERHAD(MBBESGSG)', [('id') : findTestData(
                    'Transfer').getValue(2, 65)]))

    WebUI.setText(findTestObject('OT/MOT online/transfer details/input_Account Number_creditAcctNo'), findTestData('Transfer').getValue(
            2, 66))

    WebUI.click(findTestObject('OT/MOT online/transfer details/button_CONFIRM'))

    KeywordUtil.logInfo('Sender Details')

    WebUI.click(findTestObject('OT/MOT online/sender details/a_SENDERS DETAILS'))

    WebUI.click(findTestObject('OT/MOT online/sender details/button_Please Select -nationality'))

    WebUI.click(findTestObject('OT/MOT online/sender details/span_Malaysian(CitizenPermanent Resident)',[('id') : findTestData('Transfer').getValue(2, 70)]))

    WebUI.setText(findTestObject('OT/MOT online/sender details/textarea_Sender Address Line 1_sdrAddress1'), findTestData('Transfer').getValue(2, 71))

    WebUI.setText(findTestObject('OT/MOT online/sender details/textarea_Sender Address Line 2_sdrAddress2'), findTestData('Transfer').getValue(2, 72))

    WebUI.setText(findTestObject('OT/MOT online/sender details/input_Postcode_sdrPostCode'), findTestData('Transfer').getValue(2, 73))

    WebUI.click(findTestObject('OT/MOT online/sender details/input_Country_RenderSearchableDropdown---paymentInput---21ojH'))

    WebUI.click(findTestObject('OT/MOT online/sender details/div_Andorra',[('text') : findTestData('Transfer').getValue(2, 74)]))

    KeywordUtil.logInfo('Recipients Details')

    WebUI.click(findTestObject('OT/MOT online/sender details/a_RECIPIENTS DETAILS'))

    WebUI.click(findTestObject('OT/MOT online/recipient details/button_Please Select'))

    WebUI.click(findTestObject('OT/MOT online/recipient details/span_Malaysian',[('id') : findTestData('Transfer').getValue(2, 77)]))

    WebUI.setText(findTestObject('OT/MOT online/recipient details/input_ICPassport NoBusiness Registration No_beneID'), 
         findTestData('Transfer').getValue(2, 78))

    WebUI.setText(findTestObject('OT/MOT online/recipient details/textarea_Recipient Address Line 1_beneAddr1'),  findTestData('Transfer').getValue(2, 79))

    WebUI.setText(findTestObject('OT/MOT online/recipient details/textarea_Recipient Address Line 2_beneAddr2'),  findTestData('Transfer').getValue(2, 80))

    WebUI.click(findTestObject('OT/MOT online/recipient details/input_Country_RenderSearchableDropdown---paymentInput---21ojH'))

    WebUI.click(findTestObject('OT/MOT online/recipient details/div_Malaysia',[('text') : findTestData('Transfer').getValue(2, 81)]))

    WebUI.setText(findTestObject('OT/MOT online/recipient details/input_Contact Number_beneContact'), findTestData('Transfer').getValue(2, 82))

    WebUI.setText(findTestObject('OT/MOT online/recipient details/input_Email (Optional)_beneEmail'), findTestData('Transfer').getValue(2, 83))

    KeywordUtil.logInfo('Additional Details')

    WebUI.click(findTestObject('OT/MOT online/additional info/a_ADDITIONAL INFO'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/button_Please Select -purpose'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/Page_Maybank2u  Maybank Malaysia/span_CAPITAL TRANSACTION', 
            [('text') : findTestData('Transfer').getValue(2, 86)]))

    WebUI.click(findTestObject('OT/FTT online/transfer details/button_Please Select-subpurpose'))

    WebUI.click(findTestObject('OT/FTT online/transfer details/Page_Maybank2u  Maybank Malaysia/span_MERCHANDISE', [('text') : findTestData('Transfer').getValue(2, 87)]))

    WebUI.setText(findTestObject('OT/MOT online/additional info/textarea_Additional Info_additionalInfo'), findTestData('Transfer').getValue(2, 89))

    WebUI.click(findTestObject('OT/MOT online/additional info/img'))
}