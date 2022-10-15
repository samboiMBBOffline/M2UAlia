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

WebUI.callTestCase(findTestCase('login'), [('x') : 'webope_user123', ('y') : 'Maybank@1'])

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_Mobile Number'))

WebUI.click(findTestObject('Page_Maybank2u  Maybank Malaysia/x'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_Mobile Number'))

WebUI.setText(findTestObject('trf/duitnow/popup mobile no/input_Mobile Number_proxyId'), '0132512314')

WebUI.setText(findTestObject('trf/duitnow/popup mobile no/input_Transfer Amount_amount'), trfAmt)

WebUI.setText(findTestObject('trf/duitnow/popup mobile no/input_concat(Recipient  s Reference)_transferPurpose'), 'testing1')

WebUI.click(findTestObject('trf/duitnow/popup mobile no/img'))

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))

WebUI.callTestCase(findTestCase('TAC'), [:], FailureHandling.CONTINUE_ON_FAILURE)

def casaAftr1 = WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])

CustomKeywords.'com.Calculate.Balance'(casaBfr, trfAmt.toDouble() + 0.1, casaAftr1)

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))

//IC
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_NRIC Number'))

WebUI.setText(findTestObject('trf/duitnow/popup IC/input_NRIC Number_proxyId'), '550809065190')

WebUI.setText(findTestObject('trf/duitnow/popup IC/input_Transfer Amount_amount'), trfAmt)

WebUI.setText(findTestObject('trf/duitnow/popup IC/input_concat(Recipient  s Reference)_transferPurpose'), 'test')

WebUI.click(findTestObject('trf/duitnow/popup IC/img'))

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))

WebUI.callTestCase(findTestCase('TAC'), [:], FailureHandling.CONTINUE_ON_FAILURE)

def casaAftr2 =WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])

CustomKeywords.'com.Calculate.Balance'(casaBfr, trfAmt.toDouble() + 0.1, casaAftr2)

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))

//PASSPORT
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_Passport Number'))

WebUI.setText(findTestObject('trf/duitnow/popup passport/input_Passport Number_proxyId'), 'GT6524677')

WebUI.setText(findTestObject('trf/duitnow/popup passport/input_Transfer Amount_amount'), trfAmt)

WebUI.setText(findTestObject('trf/duitnow/popup passport/input_concat(Recipient  s Reference)_transferPurpose'), 'test')

WebUI.click(findTestObject('trf/duitnow/popup passport/img'))

WebUI.click(findTestObject('trf/duitnow/popup passport/input_Country_RenderSearchableDropdown---paymentInput---21ojH'))

WebUI.click(findTestObject('trf/duitnow/popup passport/div_AFGHANISTAN'))

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))

WebUI.callTestCase(findTestCase('TAC'), [:], FailureHandling.CONTINUE_ON_FAILURE)

def casaAftr3 = WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])

CustomKeywords.'com.Calculate.Balance'(casaBfr, trfAmt.toDouble() + 0.1, casaAftr3)

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))

//POLICE
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_Army ID  Police ID'))

WebUI.click(findTestObject('trf/duitnow/popup police/input_Army ID  Police ID_proxyId'))

WebUI.setText(findTestObject('trf/duitnow/popup police/input_Army ID  Police ID_proxyId'), 'RF789456')

WebUI.setText(findTestObject('trf/duitnow/popup police/input_Transfer Amount_amount'), trfAmt)

WebUI.setText(findTestObject('trf/duitnow/popup police/input_concat(Recipient  s Reference)_transferPurpose'), 'test')

WebUI.click(findTestObject('trf/duitnow/popup police/img'))

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))

WebUI.callTestCase(findTestCase('TAC'), [:], FailureHandling.CONTINUE_ON_FAILURE)

def casaAftr4 =WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])

CustomKeywords.'com.Calculate.Balance'(casaBfr, trfAmt.toDouble() + 0.1, casaAftr4)

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))

//BUSINESS
casaBfr = WebUI.getText(findTestObject('custom/span_bal before')).replaceAll(' ', '')

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/input_duitnow dd'))

WebUI.click(findTestObject('trf/duitnow/duitnow ddc/div_Business Registration Number'))

WebUI.setText(findTestObject('trf/duitnow/popup bisnes/input_Business Registration Number_proxyId'), 'PP9988771F')

WebUI.setText(findTestObject('trf/duitnow/popup bisnes/input_Transfer Amount_amount'), trfAmt)

WebUI.setText(findTestObject('trf/duitnow/popup bisnes/input_concat(Recipient  s Reference)_transferPurpose'), 'test')

WebUI.click(findTestObject('trf/duitnow/popup bisnes/img'))

WebUI.click(findTestObject('trf/duitnow/button_TRANSFER'))

WebUI.callTestCase(findTestCase('TAC'), [:], FailureHandling.CONTINUE_ON_FAILURE)

def casaAftr5 =WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Transaction Unsuccessful', ('success') : 'Transaction Successful!'])

CustomKeywords.'com.Calculate.Balance'(casaBfr, trfAmt.toDouble() + 0.1, casaAftr5)