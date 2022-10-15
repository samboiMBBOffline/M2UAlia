import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

if (WebUI.verifyElementPresent(findTestObject('TAC/TAC/button_Secure Verification'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('TAC/TAC/button_Secure Verification'))

    WebUI.click(findTestObject('TAC/TAC/div_SMS TAC'))
}

WebUI.click(findTestObject('TAC/TAC/button_REQUEST'))

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(1)

WebUI.navigateToUrl(' https://172.31.11.35/cgi-bin/bvuat1/scripts/infopayee.jsp')

WebUI.delay(2)

def message

if ((((findTestData('Transfer').getValue(6, 1) == 'N') && (findTestData('Transfer').getValue(8, 1) == 'Y')) || (findTestData(
    'Transfer').getValue(6, 1) == 'Y')) && (findTestData('Transfer').getValue(8, 1) == 'Y')) {
    message = findTestData('Transfer').getValue(8, 7)
} else if ((findTestData('Transfer').getValue(6, 1) == 'Y')&& (findTestData('Transfer').getValue(8, 1) == 'N')) {
    message = findTestData('Transfer').getValue(6, 7)
} else {
    message = TACmessage
}

println(message)

WebUI.delay(5)
tac=TAC(message)
WebUI.switchToWindowIndex(0)
println(tac)
WebUI.setText(findTestObject('TAC/input_TAC whitebox'), tac)

WebUI.click(findTestObject('TAC/button_CONFIRM'))

def TAC(def message) {
    def ALLotp = WebUI.getText(findTestObject('TAC/html'))

    Pattern p1 = Pattern.compile(message)

    Matcher m1 = p1.matcher(ALLotp)

    if (m1.find()) {
        def TAC = m1.group(1)

        println(TAC)
		return TAC
    }
    
   
}