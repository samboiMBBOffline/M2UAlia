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

WebUI.callTestCase(findTestCase('login'), null)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')
WebUI.delay(5)
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_Own Accounts'))

////SINGLE TRF
WebUI.click(findTestObject('trf/trf to/span_ownAcc', [('text') : findTestData('Transfer').getValue(2, 9)]))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/p_Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')), 
    'Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')

WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_amount'), findTestData('Transfer').getValue(
        2, 12))

println(findTestData('Transfer').getValue(2, 12))

WebUI.setText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/input_ref'), findTestData('Transfer').getValue(
        2, 13))

WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/button_TRANSFER'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

WebUI.click(findTestObject('TAC/button_CONFIRM'))

WebUI.getText(findTestObject('Object Repository/enhc/get total amt'))

WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!',('casaBfr') : casaBfr])



