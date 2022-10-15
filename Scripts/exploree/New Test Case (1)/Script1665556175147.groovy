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

//import com.schedule.dateFormat as dateFormat
//    a = CustomKeywords.'com.schedule.dateFormat'('1', 'September 2023')
//
//
//WebUI.verifyEqual(CustomKeywords.'com.schedule.dateFormat'('1', 'September 2023'), '1 Sep 2023')
//
WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('trf/PnT'))

WebUI.click(findTestObject('trf/trf/span_x'))

WebUI.click(findTestObject('trf/div_TRANSFER'))

//WebUI.getText(findTestObject('testing'))
WebUI.click(findTestObject('trf/trf to/button_trf to dd'))
CustomKeywords.'com.Xpath.sizeNtext'('//div[@class="col-sm-10 col-xs-12 PayFromToContainer---dropdownHolder---1fWw2"]/div/ul/li', 'testing')

