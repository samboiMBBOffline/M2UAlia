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

WebUI.callTestCase(findTestCase('login'), [('x') : 'webope_user11', ('y') : 'Maybank@1'], null)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')
WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_Other Accounts ( Maybank and other banks )'))

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

WebUI.click(findTestObject('trf/trf/other acc/Page_Maybank2u  Maybank Malaysia/div_Maybank  Maybank Islamic'))

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/span_x'))

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

WebUI.click(findTestObject('trf/trf/other acc/Page_Maybank2u  Maybank Malaysia/div_Maybank  Maybank Islamic'))

WebUI.setText(findTestObject('trf/other acc-mbb/pre-trx/input_Account number_toAccount'), accTo)

WebUI.setText(findTestObject('trf/other acc-mbb/pre-trx/input_Transfer Amount_amount'), trfAmt)

WebUI.setText(findTestObject('trf/other acc-mbb/pre-trx/input_concat(Recipient  s Reference)_transferPurpose'), 'testing')

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))

WebUI.callTestCase(findTestCase('TAC'), [:])

WebUI.delay(5)

def casaAftr =WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])
CustomKeywords.'com.Calculate.Balance'(casaBfr, trfAmt, casaAftr)
WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_Other Accounts ( Maybank and other banks )'))

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

WebUI.click(findTestObject('trf/trf/other acc/Page_Maybank2u  Maybank Malaysia/div_other maybank name'))

for (u = 1; u <= 4; u++) {
    WebUI.click(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/button_trf mode dd'))

    WebUI.click(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/mult trf mode', [('id') : 2]))

    WebUI.click(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/button_trx type dd'))

    WebUI.click(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/mult trx type', [('id') : u]))

    WebUI.setText(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/input_Account number_beneficiaryAccountNumber'), 
        '232323323')

    WebUI.setText(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/input_concat(Recipient  s Name)_beneficiaryName'), 
        'sigh')

    WebUI.setText(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/input_Transfer Amount_amount'), 
        '123')

    WebUI.setText(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/input_concat(Recipient  s Reference)_transactionReferenceNo'), 
        'testing2')

    WebUI.click(findTestObject('trf/other acc-not mbb/Page_Maybank2u  Maybank Malaysia/button_TRANSFER'))

    WebUI.callTestCase(findTestCase('TAC'), [:])

    WebUI.delay(5)

    WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Accepted!'])

    WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

    WebUI.click(findTestObject('trf/trf to/span_Other Accounts ( Maybank and other banks )'))

    WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

    WebUI.click(findTestObject('trf/trf/other acc/Page_Maybank2u  Maybank Malaysia/div_other maybank name'))
}
