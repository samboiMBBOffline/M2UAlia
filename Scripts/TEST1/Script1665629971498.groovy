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

if (WebUI.verifyElementPresent(findTestObject('TAC/TAC/button_Secure Verification'), 2, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('TAC/TAC/button_Secure Verification'))

	WebUI.click(findTestObject('TAC/TAC/div_SMS TAC'))
}

WebUI.click(findTestObject('TAC/TAC/button_REQUEST'))

WebUI.executeJavaScript('window.open();', [])

WebUI.switchToWindowIndex(1)

WebUI.navigateToUrl(' https://172.31.11.35/cgi-bin/bvuat1/scripts/infopayee.jsp')
def ALLotp = WebUI.getText(findTestObject('TAC/html'))
WebUI.delay(2)
if ((findTestData('Transfer').getValue(6, 1) == 'Y') || (findTestData('Transfer').getValue(8, 1) == 'N')) {
	Pattern p1 = Pattern.compile(findTestData('Transfer').getValue(6, 7))
}else if((findTestData('Transfer').getValue(6, 1) == 'N') || (findTestData('Transfer').getValue(8, 1) == 'Y')) {
	Pattern p1 = Pattern.compile(findTestData('Transfer').getValue(8, 7))
}else {
Pattern p1 = Pattern.compile(TACmessage)
}

Matcher m1 = p1.matcher(ALLotp)

if (m1.find()) {
    def TAC = m1.group(1)

    println(TAC)

    return TAC
}