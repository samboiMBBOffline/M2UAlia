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

WebUI.callTestCase(findTestCase('login'), [:], null)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

not_run: WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

not_run: WebUI.click(findTestObject('trf/trf to/span_Other Accounts ( Maybank and other banks )'))

not_run: WebUI.click(findTestObject('add fav/fav other acc/button_Add New Favourite'))

not_run: WebUI.setText(findTestObject('add fav/fav other acc/input_Nickname_TransferModal---account-number---1ojej'), 'nicky')

not_run: WebUI.click(findTestObject('add fav/fav other acc/input_Choose Bank_RenderSearchableDropdown---paymentInput---21ojH'))

not_run: WebUI.click(findTestObject('add fav/fav other acc/div_Maybank  Maybank Islamic'))

not_run: WebUI.setText(findTestObject('add fav/fav other acc/input_Account number_acctno1'), '512361088207')

not_run: WebUI.click(findTestObject('add fav/fav other acc/button_ADD'))

not_run: WebUI.callTestCase(findTestCase('TAC'), [('TACmessage') : 'Your TAC No. is ([^.]*). ADD/UPDATE FAV'], FailureHandling.CONTINUE_ON_FAILURE)

//    WebUI.getText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/refID'))
//
//    def refIDvalue = WebUI.getText(findTestObject('enhc/get refID value'))
//
//    WebUI.verifyEqual(refIDvalue.length(), '10')
not_run: WebUI.callTestCase(findTestCase('confirmation screen'), [('Xsuccess') : 'Add Favourite Unsuccessful', ('success') : 'New Favorite Successfully Added'])

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/span_Other Accounts ( Maybank and other banks )'))

WebUI.click(findTestObject('add fav/fav other acc/button_Add New Favourite'))

WebUI.setText(findTestObject('add fav/fav other acc/input_Nickname_TransferModal---account-number---1ojej'), 'nicky')

WebUI.click(findTestObject('add fav/fav other acc/input_Choose Bank_RenderSearchableDropdown---paymentInput---21ojH'))

WebUI.click(findTestObject('add fav/fav other acc/div_AFFIN BANK BERHAD'))

WebUI.setText(findTestObject('add fav/fav other acc/input_Account number_acctno1'), '512361088207')

WebUI.click(findTestObject('add fav/fav other acc/input_Choose Bank_RenderSearchableDropdown---paymentInput---21ojH'))

WebUI.click(findTestObject('add fav/fav other acc/span_Funds Transfer'))

