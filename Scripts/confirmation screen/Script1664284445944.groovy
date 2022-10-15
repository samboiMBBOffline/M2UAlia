import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.getText(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/refID'))

refIDvalue = WebUI.getText(findTestObject('enhc/get refID value'))

//println(refIDvalue.length())
//assertThat(isNumeric(refIDvalue)).isTrue();
WebUI.verifyEqual(refIDvalue.length(), '10')

if (WebUI.verifyTextPresent(Xsuccess, false, FailureHandling.OPTIONAL)) {
    WebUI.takeFullPageScreenshot()

    WebUI.getText(findTestObject('trf/other acc-mbb/unsuccess/p_Unsuccessful desc'))

    WebUI.click(findTestObject('trf/own acc/Page_Maybank2u  Maybank Malaysia/btn_done'))
} else if (WebUI.verifyTextPresent(success, false, FailureHandling.OPTIONAL) == true) {
    WebUI.takeFullPageScreenshot()

    def totalAmt = WebUI.getText(findTestObject('enhc/total amt value')).replaceAll(' ', '')

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))

    WebUI.delay(5)

    WebUI.takeFullPageScreenshot()

    WebUI.verifyEqual(totalAmt, WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_RM1.00')).replaceAll(
            ' ', ''))

    WebUI.verifyEqual(refIDvalue, WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_2943679728')))

    WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_This receipt is computer generated and no signature is required')), 
        'This receipt is computer generated and no signature is required.')

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

    def casaAftr = WebUI.getText(findTestObject('custom/avail bal')).replaceAll(' ', '')

    CustomKeywords.'com.Calculate.Balance'(casaBfr, findTestData('Transfer').getValue(2, 12), casaAftr)

    if (WebUI.verifyElementPresent(findTestObject('trf/other acc-mbb/ADD FAV/button_Add to Favourite'), 2, FailureHandling.OPTIONAL) == 
    true) {
        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Add to Favourite'))

        WebUI.setText(findTestObject('trf/other acc-mbb/ADD FAV/input_Nickname_TransferModal---account-number---1ojej'), 
            'nicky')

        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_ADD'))

        WebUI.click(findTestObject('TAC/TAC/button_CONFIRM'))

        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Done'))

        WebUI.delay(10)
    } else {
        WebUI.click(findTestObject('trf/other acc-mbb/conf screen/button_New Transfer'))
    }
} else if (WebUI.verifyTextPresent(future, false, FailureHandling.OPTIONAL) == true) {
    WebUI.takeFullPageScreenshot()

    if (WebUI.verifyElementPresent(findTestObject('future dated/conf screen/start date'), 0, FailureHandling.OPTIONAL)) {
        WebUI.getText(findTestObject('future dated/conf screen/start date'))

        WebUI.getText(findTestObject('future dated/conf screen/end date'))

        if ((findTestData('Transfer').getValue(6, 1) == 'Y') && (findTestData('Transfer').getValue(8, 1) == 'Y')) {
            WebUI.verifyEqual(WebUI.getText(findTestObject('future dated/conf screen/start date value')), CustomKeywords.'com.schedule.dateFormat'(
                    findTestData('Transfer').getValue(6, 2), findTestData('Transfer').getValue(6, 3)))

            WebUI.verifyEqual(WebUI.getText(findTestObject('future dated/conf screen/end date value')), CustomKeywords.'com.schedule.dateFormat'(
                    findTestData('Transfer').getValue(8, 4), findTestData('Transfer').getValue(8, 5)))
        } else if ((findTestData('Transfer').getValue(6, 1) == 'N') && (findTestData('Transfer').getValue(8, 1) == 'Y')) {
            WebUI.verifyEqual(WebUI.getText(findTestObject('future dated/conf screen/start date value')), CustomKeywords.'com.schedule.dateFormat'(
                    findTestData('Transfer').getValue(8, 2), findTestData('Transfer').getValue(8, 3)))

            WebUI.verifyEqual(WebUI.getText(findTestObject('future dated/conf screen/end date value')), CustomKeywords.'com.schedule.dateFormat'(
                    findTestData('Transfer').getValue(8, 4), findTestData('Transfer').getValue(8, 5)))
        }
    } else if (WebUI.verifyElementPresent(findTestObject('future dated/conf screen/future date'), 0, FailureHandling.OPTIONAL)) {
        WebUI.getText(findTestObject('future dated/conf screen/future date'))

        WebUI.verifyEqual(WebUI.getText(findTestObject('future dated/conf screen/future date value')), CustomKeywords.'com.schedule.dateFormat'(
                findTestData('Transfer').getValue(6, 2), findTestData('Transfer').getValue(6, 3)))
    }
    
    def totalAmt = WebUI.getText(findTestObject('enhc/total amt value')).replaceAll(' ', '')

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/a_SAVE RECEIPT'))

    WebUI.delay(5)

    WebUI.takeFullPageScreenshot()

    WebUI.verifyEqual(refIDvalue, WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_2943679728')))

    WebUI.verifyEqual(WebUI.getText(findTestObject('enhc/Page_Maybank2u  Maybank Malaysia/span_This receipt is computer generated and no signature is required')), 
        'This receipt is computer generated and no signature is required.')

    WebUI.click(findTestObject('trf/other acc-mbb/conf screen/x-savereceipt'))

    if (WebUI.verifyElementPresent(findTestObject('trf/other acc-mbb/ADD FAV/button_Add to Favourite'), 2, FailureHandling.OPTIONAL) == 
    true) {
        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Add to Favourite'))

        WebUI.setText(findTestObject('trf/other acc-mbb/ADD FAV/input_Nickname_TransferModal---account-number---1ojej'), 
            'nicky')

        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_ADD'))

        WebUI.click(findTestObject('TAC/TAC/button_CONFIRM'))

        WebUI.click(findTestObject('trf/other acc-mbb/ADD FAV/button_Done'))

        WebUI.delay(10)
    } else {
        WebUI.click(findTestObject('trf/other acc-mbb/conf screen/button_New Transfer'))
    }
}

