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

WebUI.callTestCase(findTestCase('login'), [('x') : 'webope_user11', ('y') : 'Maybank@1'])

//casaBal = WebUI.getText(findTestObject('custom/casa get RM', [('accNo') : casaAcc]))
WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_ASNB Accounts'))

not_run: WebUI.delay(5)

not_run: WebUI.click(findTestObject('Page_Maybank2u  Maybank Malaysia/x-errormsg'))

not_run: WebUI.delay(5)

WebUI.click(findTestObject('trf/other acc-mbb/pre-trx/input_other acc dd'))

WebUI.click(findTestObject('asnb/product/button_product dd'))

WebUI.click(findTestObject('asnb/product/span_Amanah Saham Didik'))

WebUI.setText(findTestObject('asnb/main/input_Membership no_asnbNumber'), '000003933052')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('asnb/id type/button_id type dd'))

WebUI.click(findTestObject('asnb/id type/span_New IC'))

WebUI.setText(findTestObject('asnb/main/input_concat(Member  s ID Number)_idNumber'), '990127027928')

WebUI.setText(findTestObject('asnb/main/input_Transfer Amount_amount'), '123')

WebUI.click(findTestObject('asnb/relay/button_relay dd'))

WebUI.click(findTestObject('asnb/relay/span_Parent'))

WebUI.click(findTestObject('asnb/purpose/button_purpose dd'))

WebUI.click(findTestObject('asnb/purpose/span_Savings'))

WebUI.click(findTestObject('asnb/main/img'))

WebUI.click(findTestObject('asnb/main/button_TRANSFER'))

