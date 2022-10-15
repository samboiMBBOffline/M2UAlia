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


WebUI.callTestCase(findTestCase('login'),[:])

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')
WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))
WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_Army ID  Police ID'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/p_Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')), 'Money withdrawn from your insured deposit(s) is no longer protected by PIDM if transferred to a non PIDM members')

WebUI.click(findTestObject('trf/duitnow/popup police/input_Army ID  Police ID_proxyId'))

WebUI.setText(findTestObject('trf/duitnow/popup police/input_Army ID  Police ID_proxyId'), findTestData('Transfer').getValue(2, 21))

WebUI.setText(findTestObject('trf/duitnow/popup police/input_Transfer Amount_amount'), findTestData('Transfer').getValue(3, 21))

WebUI.setText(findTestObject('trf/duitnow/popup police/input_concat(Recipient  s Reference)_transferPurpose'), findTestData('Transfer').getValue(4, 21))

WebUI.click(findTestObject('trf/duitnow/popup police/img'))

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')
WebUI.callTestCase(findTestCase('TAC'), [('TACmessage'):findTestData('Transfer').getValue(5, 21)], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!',('casaBfr') : casaBfr])