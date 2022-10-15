import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.NumberFormat as NumberFormat
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.maybank2u.com.my/home/m2u/common/login.do')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/input_Humanising Banking_username'), 
    'aliasyaf96')

WebUI.click(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/button_LOGIN'))

WebUI.click(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/button_YES'))

WebUI.setText(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/input_Hello_my-password-input'), 
    'Haura-251258')

WebUI.click(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/button_LOGIN_1'))

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_Overseas (FTT Western Union Visa Direct Maybank Overseas Transfer)'))

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

WebUI.click(findTestObject('trf/trf/other acc/Page_Maybank2u  Maybank Malaysia/div_other maybank name', [('id') : findTestData('Transfer').getValue(2, 62)]))

WebUI.setText(findTestObject('OT/screen1/input_RM_CustomInputGroup---textInput---1X446 form-control'), findTestData('Transfer').getValue(
        2, 63))

WebUI.click(findTestObject('OT/screen1/button_Compare'))

WebUI.verifyEqual(WebUI.getText(findTestObject('OT/screen1/p_Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')), 
    'Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')

a = WebUI.getText(findTestObject('custom/currency calc1', [('text') : findTestData('Transfer').getValue(2, 64)])).replaceAll(" ", "")

b = WebUI.getText(findTestObject('custom/currency calc2', [('text') : findTestData('Transfer').getValue(2, 64)])).replaceAll(" ", "")

CustomKeywords.'com.CurrencyCalc.RMtoOthers'(a, b)

WebUI.click(findTestObject('custom/Button based on OT type', [('text') : findTestData('Transfer').getValue(2, 64)]))
