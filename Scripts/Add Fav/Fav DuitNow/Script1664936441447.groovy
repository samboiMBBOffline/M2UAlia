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

WebUI.callTestCase(findTestCase('login'), [:], null)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))
WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/div_Transfer From')), 'Transfer From')

WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

WebUI.click(findTestObject('trf/trf to/div_DuitNow'))

WebUI.click(findTestObject('add fav/button_Add New Favourite'))

WebUI.click(findTestObject('add fav/fav duitnow/span_x'))

WebUI.click(findTestObject('add fav/button_Add New Favourite'))

WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/h6_Add New Favourite')), 'Add New Favourite')

WebUI.setText(findTestObject('add fav/fav duitnow/input_Nickname_TransferModal---account-number---1ojej'), findTestData(
        'Transfer').getValue(7, 18))

WebUI.click(findTestObject('add fav/fav duitnow/div_ID type dd'))

WebUI.click(findTestObject('add fav/fav duitnow/span_Mobile Number'))

WebUI.delay(3)

WebUI.setText(findTestObject('add fav/fav duitnow/input_ID Number_paynetIdNumber'), findTestData('Transfer').getValue(8, 
        18))

WebUI.setText(findTestObject('add fav/fav duitnow/input_concat(Recipient  s Name)_paynetRecipientsName'), 'testing')

not_run: WebUI.click(findTestObject('add fav/fav duitnow/button_ADD'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

not_run: call()

//WebUI.click(findTestObject('add fav/fav duitnow/span_x'))
not_run: WebUI.click(findTestObject('add fav/button_Add New Favourite'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/h6_Add New Favourite')), 'Add New Favourite')

WebUI.setText(findTestObject('add fav/fav duitnow/input_Nickname_TransferModal---account-number---1ojej'), findTestData(
        'Transfer').getValue(7, 19))

WebUI.click(findTestObject('add fav/fav duitnow/div_ID type dd'))

WebUI.click(findTestObject('add fav/fav duitnow/span_NRIC Number'))

WebUI.delay(3)

WebUI.setText(findTestObject('add fav/fav duitnow/input_ID Number_paynetIdNumber'), findTestData('Transfer').getValue(8, 
        19))

WebUI.setText(findTestObject('add fav/fav duitnow/input_concat(Recipient  s Name)_paynetRecipientsName'), 'testing')

not_run: WebUI.click(findTestObject('add fav/fav duitnow/button_ADD'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

not_run: call()

not_run: WebUI.click(findTestObject('add fav/button_Add New Favourite'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/h6_Add New Favourite')), 'Add New Favourite')

WebUI.setText(findTestObject('add fav/fav duitnow/input_Nickname_TransferModal---account-number---1ojej'), findTestData(
        'Transfer').getValue(7, 20))

WebUI.click(findTestObject('add fav/fav duitnow/div_ID type dd'))

WebUI.click(findTestObject('add fav/fav duitnow/span_Army ID  Police ID'))

WebUI.delay(3)

WebUI.setText(findTestObject('add fav/fav duitnow/input_ID Number_paynetIdNumber'), findTestData('Transfer').getValue(8, 
        20))

WebUI.setText(findTestObject('add fav/fav duitnow/input_concat(Recipient  s Name)_paynetRecipientsName'), 'testing')

not_run: WebUI.click(findTestObject('add fav/fav duitnow/button_ADD'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

not_run: call()

not_run: WebUI.click(findTestObject('add fav/button_Add New Favourite'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/h6_Add New Favourite')), 'Add New Favourite')

WebUI.setText(findTestObject('add fav/fav duitnow/input_Nickname_TransferModal---account-number---1ojej'), findTestData(
        'Transfer').getValue(7, 21))

WebUI.click(findTestObject('add fav/fav duitnow/div_ID type dd'))

WebUI.click(findTestObject('add fav/fav duitnow/span_Business Registration Number'))

WebUI.delay(3)

WebUI.setText(findTestObject('add fav/fav duitnow/input_ID Number_paynetIdNumber'), findTestData('Transfer').getValue(8, 
        21))

WebUI.setText(findTestObject('add fav/fav duitnow/input_concat(Recipient  s Name)_paynetRecipientsName'), 'testing')

not_run: WebUI.click(findTestObject('add fav/fav duitnow/button_ADD'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

not_run: call()

not_run: WebUI.click(findTestObject('add fav/button_Add New Favourite'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/h6_Add New Favourite')), 'Add New Favourite')

WebUI.setText(findTestObject('add fav/fav duitnow/input_Nickname_TransferModal---account-number---1ojej'), findTestData(
        'Transfer').getValue(7, 22))

WebUI.click(findTestObject('add fav/fav duitnow/div_ID type dd'))

WebUI.click(findTestObject('add fav/fav duitnow/span_Passport Number'))

WebUI.click(findTestObject('add fav/fav duitnow/input_Country PP dd'))

WebUI.click(findTestObject('add fav/fav duitnow/div_AFGHANISTAN'))

WebUI.delay(3)

WebUI.setText(findTestObject('add fav/fav duitnow/input_ID Number_paynetIdNumber'), findTestData('Transfer').getValue(8, 
        22))

WebUI.setText(findTestObject('add fav/fav duitnow/input_concat(Recipient  s Name)_paynetRecipientsName'), 'testing')

not_run: WebUI.click(findTestObject('add fav/fav duitnow/button_ADD'))

not_run: WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/span_Please confirm the details')), 'Please confirm the details')

not_run: call( //println(refIDvalue.length())
    //assertThat(isNumeric(refIDvalue)).isTrue();
    )

def call() {
    WebUI.callTestCase(findTestCase('TAC'), [('TACmessage') : 'Your TAC No. is ([^.]*). ADD/UPDATE FAV'], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.getText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/refID'))

    def refIDvalue = WebUI.getText(findTestObject('enhc/get refID value'))

    WebUI.verifyEqual(refIDvalue.length(), '10')

    if (WebUI.verifyTextPresent('Add Favourite Unsuccessful', false, FailureHandling.OPTIONAL)) {
        WebUI.getText(findTestObject('add fav/failed summary'))

        WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/btn_done'))
    } else if (WebUI.verifyTextPresent('New Favorite Successfully Added', false) == true) {
        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Done'))

        WebUI.click(findTestObject('Page_Maybank2u  Maybank Malaysia/x-greenbox'))
    }
    
    WebUI.click(findTestObject('trf/trf to/button_trf to dd'))

    WebUI.click(findTestObject('trf/trf to/div_DuitNow'))
}

