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
import org.openqa.selenium.Keys as Keys
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern

WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('Transfer').getValue(1,1))

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/input_Humanising Banking_username'), 
    findTestData('Transfer').getValue(2, 1))

WebUI.click(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/button_LOGIN'))

WebUI.click(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/button_YES'))

WebUI.setText(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/input_Hello_my-password-input'), 
    findTestData('Transfer').getValue(3,1))

WebUI.click(findTestObject('Object Repository/login/Page_Maybank2u  Maybank Malaysia/button_LOGIN_1'))

