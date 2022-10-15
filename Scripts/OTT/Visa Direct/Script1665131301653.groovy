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

WebUI.click(findTestObject('OT/screen2/img_RM_TransferOverseaTypeContainer---rightIndicator---FOa-D'))

WebUI.click(findTestObject('custom/Button based on OT type', [('text') : findTestData('Transfer').getValue(10, 64)]))

WebUI.delay(3)

WebUI.setText(findTestObject('OT/VD online/input'), findTestData('Transfer').getValue(10, 65))

WebUI.click(findTestObject('OT/VD online/button_Submit'))

a = WebUI.getText(findTestObject('custom/currency calc1', [('text') : findTestData('Transfer').getValue(10, 64)])).replaceAll(
    ' ', '')

b = WebUI.getText(findTestObject('custom/currency calc2', [('text') : findTestData('Transfer').getValue(10, 64)])).replaceAll(
    ' ', '')

CustomKeywords.'com.CurrencyCalc.RMtoOthers'(a, b)

WebUI.click(findTestObject('custom/Button based on OT type', [('text') : findTestData('Transfer').getValue(10, 64)]))

WebUI.setText(findTestObject('OT/VD online/Page_Maybank2u  Maybank Malaysia/input_concat(Card holder, , s Last Name)_recipientLastName'), 
    findTestData('Transfer').getValue(10, 68))

WebUI.setText(findTestObject('OT/VD online/Page_Maybank2u  Maybank Malaysia/input_concat(Card holder, , s First Name)_recipientFirstName'), 
    findTestData('Transfer').getValue(10, 69))

WebUI.click(findTestObject('OT/VD online/Page_Maybank2u  Maybank Malaysia/a_TRANSFER DETAILS'))

WebUI.click(findTestObject('OT/VD online/Page_Maybank2u  Maybank Malaysia/img'))

WebUI.click(findTestObject('OT/VD online/Page_Maybank2u  Maybank Malaysia/button_TRANSFER RM50.00'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

WebUI.delay(5)

WebUI.callTestCase(findTestCase('TAC'), [('TACmessage') : findTestData('Transfer').getValue(10, 72)], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'
        , ('future') : 'Your transfer is scheduled.', ('casaBfr') : casaBfr])

