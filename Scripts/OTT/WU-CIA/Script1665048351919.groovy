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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

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

a = WebUI.getText(findTestObject('custom/currency calc1', [('text') : findTestData('Transfer').getValue(8, 64)])).replaceAll(
    ' ', '')

b = WebUI.getText(findTestObject('custom/currency calc2', [('text') : findTestData('Transfer').getValue(8, 64)])).replaceAll(
    ' ', '')

CustomKeywords.'com.CurrencyCalc.RMtoOthers'(a, b)

WebUI.click(findTestObject('custom/Button based on OT type', [('text') : findTestData('Transfer').getValue(8, 64)]))

KeywordUtil.logInfo('Sender Details')

WebUI.setText(findTestObject('OT/WU-Sender Details/input_Promo Code(Optional)_promoCode'), findTestData('Transfer').getValue(
        8, 66))

WebUI.setText(findTestObject('OT/WU-Sender Details/textarea_address line1'), findTestData('Transfer').getValue(8, 67))

WebUI.setText(findTestObject('OT/WU-Sender Details/textarea_address line2'), findTestData('Transfer').getValue(8, 68))

WebUI.setText(findTestObject('OT/WU-Sender Details/input_Email Address (Optional)_senderEmailAddress'), findTestData('Transfer').getValue(
        8, 69))

WebUI.setText(findTestObject('OT/WU-Sender Details/textarea_Temporary Address Line 1 (Optional)_senderTempAddrLine1'), findTestData(
        'Transfer').getValue(8, 70))

WebUI.setText(findTestObject('OT/WU-Sender Details/textarea_Temporary Address Line 2 (Optional)_senderTempAddrLine2'), findTestData(
        'Transfer').getValue(8, 71))

WebUI.setText(findTestObject('OT/WU-Sender Details/input_Postcode_senderTempAddrPostCode'), findTestData('Transfer').getValue(
        8, 72))

WebUI.setText(findTestObject('OT/WU-Sender Details/input_City_senderTempAddrCity'), findTestData('Transfer').getValue(8, 
        73))

WebUI.setText(findTestObject('OT/WU-Sender Details/input_StateProvince_senderTempAddrState'), findTestData('Transfer').getValue(
        8, 74))

WebUI.click(findTestObject('OT/WU-Sender Details/button_ID Type dd'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OT/WU-Sender Details/span_PoliceMilitary ID Card - ID Type3', [('id') : findTestData('Transfer').getValue(
                8, 75)]))

WebUI.setText(findTestObject('OT/WU-Sender Details/input_ID Number_senderIdNumber'), findTestData('Transfer').getValue(8, 
        76))

//77 n 78 date o issue
if (WebUI.verifyElementPresent(findTestObject('OT/WU-Sender Details/Page_Notification/input_ID Date of Issue (DDMMYYYY)_senderIdDateOfIssue'), 
    0, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('OT/WU-Sender Details/Page_Notification/input_ID Date of Issue (DDMMYYYY)_senderIdDateOfIssue'), 
        findTestData('Transfer').getValue(8, 77))

    WebUI.setText(findTestObject('OT/WU-Sender Details/Page_Notification/input_ID Date of Expiry (DDMMYYYY)_senderIdDateOfExpiry'), 
        findTestData('Transfer').getValue(8, 78))
}

WebUI.click(findTestObject('OT/WU-Sender Details/input_ID Issue Country_RenderSearchableDropdown---paymentInput---21ojH'))

WebUI.click(findTestObject('OT/WU-Sender Details/div_Afghanistan -ID issue country', [('id') : findTestData('Transfer').getValue(
                8, 79)]))

WebUI.click(findTestObject('OT/WU-Sender Details/button_Please Select Occupation'))

WebUI.click(findTestObject('OT/WU-Sender Details/span_AirlineMaritime Employee -Occupation', [('id') : findTestData('Transfer').getValue(
                8, 80)]))

//emp pos (81)
if (WebUI.verifyTextPresent('Employment Position Level', false, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('OT/WU-Sender Details/Page_Notification/button_Please Select -emp pos'))

    WebUI.click(findTestObject('OT/WU-Sender Details/Page_Notification/span_Entry Level -emp pos', [('id') : findTestData(
                    'Transfer').getValue(8, 81)]))
}

WebUI.click(findTestObject('OT/WU-Sender Details/button_Please Select Rel to Ben'))

WebUI.click(findTestObject('OT/WU-Sender Details/span_Family -Rel to Ben', [('id') : findTestData('Transfer').getValue(8, 
                82)]))

WebUI.click(findTestObject('OT/WU-Sender Details/input_Country of Birth_RenderSearchableDropdown---paymentInput---21ojH'))

WebUI.click(findTestObject('OT/WU-Sender Details/div_Afghanistan US Military Base -COB', [('id') : findTestData('Transfer').getValue(
                8, 83)]))

WebUI.click(findTestObject('OT/WU-Sender Details/button_Please Select SOF'))

WebUI.click(findTestObject('OT/WU-Sender Details/span_SalaryIncome -SOF', [('id') : findTestData('Transfer').getValue(8, 
                84)]))

KeywordUtil.logInfo('Recipient\'s Details')

WebUI.click(findTestObject('OT/WU-recipient details/a_RECIPIENTS DETAILS'))

WebUI.click(findTestObject('OT/WU-Sender Details/Page_Notification/input_Bank Name_RenderSearchableDropdown---paymentInput---21ojH'))

WebUI.click(findTestObject('OT/WU-Sender Details/Page_Notification/div_BNP Paribas', [('id') : findTestData('Transfer').getValue(
                8, 87)]))

WebUI.setText(findTestObject('OT/WU-Sender Details/Page_Notification/input_Account Number_benAccountNumber'), findTestData(
        'Transfer').getValue(8, 88))

//bank name n accNo(87,88)
WebUI.setText(findTestObject('OT/WU-recipient details/input_First Name_benFirstName'), findTestData('Transfer').getValue(
        8, 89))

WebUI.setText(findTestObject('OT/WU-recipient details/input_Last Name_benLastName'), findTestData('Transfer').getValue(8, 
        90))

WebUI.setText(findTestObject('OT/WU-recipient details/input_Phone No_benContactNationalNo'), findTestData('Transfer').getValue(
        8, 91))

WebUI.click(findTestObject('OT/WU-recipient details/input_Receiver Country  Code_RenderSearchableDropdown---paymentInput---21ojH'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OT/WU-recipient details/div_Afghanistan -country'))

WebUI.setText(findTestObject('OT/WU-recipient details/textarea_Street Line 1_benStreet'), findTestData('Transfer').getValue(
        8, 93))

WebUI.setText(findTestObject('OT/WU-recipient details/textarea_Street Line 2_benStreet1'), findTestData('Transfer').getValue(
        8, 94))

WebUI.setText(findTestObject('OT/WU-recipient details/input_Postal Code_benPostalCode'), findTestData('Transfer').getValue(
        8, 95))

WebUI.setText(findTestObject('OT/WU-recipient details/input_City (Destination)_benCity'), findTestData('Transfer').getValue(
        8, 96))

WebUI.setText(findTestObject('OT/WU-recipient details/input_State_benState'), findTestData('Transfer').getValue(8, 97))

WebUI.click(findTestObject('OT/WU-recipient details/input_Country_RenderSearchableDropdown---paymentInput---21ojH'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OT/WU-recipient details/div_Afghanistan -country'))

WebUI.click(findTestObject('OT/WU-recipient details/button_Please Select -ID Type'))

WebUI.click(findTestObject('OT/WU-recipient details/span_Passport -id type'))

WebUI.setText(findTestObject('OT/WU-recipient details/input_ID Number (Optional)_benIdNumber'), findTestData('Transfer').getValue(
        8, 100))

WebUI.setText(findTestObject('OT/WU-recipient details/input_Date of Birth (DDMMYYYY)_benDateOfBirth'), findTestData('Transfer').getValue(
        8, 101))

KeywordUtil.logInfo('Transfer Details')

WebUI.click(findTestObject('OT/WU-Transfer details/Page__/a_TRANSFER DETAILS'))

WebUI.click(findTestObject('OT/WU-Transfer details/button_Please Select -purpose'))

WebUI.click(findTestObject('OT/WU-Transfer details/span_Family SupportLiving Expenses -purpose', [('id') : findTestData(
                'Transfer').getValue(6, 104)]))

if (WebUI.verifyElementPresent(findTestObject('OT/WU-Transfer details/Page__/button_Please Select -sub purpose'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('OT/WU-Transfer details/Page__/button_Please Select -sub purpose'))

    WebUI.click(findTestObject('OT/WU-Transfer details/Page__/span_Investment income -subpurpose', [('id') : findTestData(
                    'Transfer').getValue(8, 105)]))
}

WebUI.click(findTestObject('OT/WU-Transfer details/img'))

