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

//futureDateM = 'October 2022'
//
//futureDateD = '16'
//
////F=findTestData('Transfer').getValue(6, 1)
//recurring = 'Y'
//
////R=findTestData('Transfer').getValue(8, 1)
//recurM = 'November 2022'
//
//recurD = '17'
println(findTestData('Transfer').getValue(6, 3))
println(findTestData('Transfer').getValue(8, 3))
println(findTestData('Transfer').getValue(8, 5))
if ((findTestData('Transfer').getValue(6, 1) == 'Y') && (findTestData('Transfer').getValue(8, 1) == 'Y')) {
    WebUI.click(findTestObject('future dated/input screen/input_Effective Date_form-control'))

    while (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) != findTestData('Transfer').getValue(
        6, 3)) {
        WebUI.click(findTestObject('future dated/input screen/div_'))

        if (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) == findTestData('Transfer').getValue(
            6, 3)) {
            break
        }
    }
    
    WebUI.click(findTestObject('future dated/input screen/td_29', [('id') : findTestData('Transfer').getValue(6, 2)]))

    WebUI.click(findTestObject('future dated/input screen/div__Toggle---container---3i-fe'))

    WebUI.click(findTestObject('future dated/input screen/input__form-control'))

    while (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) != findTestData('Transfer').getValue(
        8, 5)) {
        WebUI.click(findTestObject('future dated/input screen/div_'))

        if (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) == findTestData('Transfer').getValue(
            8, 5)) {
            break
        }
    }
    
    
    WebUI.click(findTestObject('future dated/input screen/td_29', [('id') : findTestData('Transfer').getValue(8, 4)]))
} else if ((findTestData('Transfer').getValue(6, 1) == 'N') && (findTestData('Transfer').getValue(8, 1) == 'Y')) {
	WebUI.click(findTestObject('future dated/input screen/div__Toggle---container---3i-fe'))
    WebUI.click(findTestObject('future dated/input screen/input_Effective Date_form-control'))

    while (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) != findTestData('Transfer').getValue(
        8, 3)) {
        WebUI.click(findTestObject('future dated/input screen/div_'))

        if (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) == findTestData('Transfer').getValue(
           8, 3)) {
            break
        }
    }
    
    
    WebUI.click(findTestObject('future dated/input screen/td_29', [('id') : findTestData('Transfer').getValue(8, 2)]))

    WebUI.click(findTestObject('future dated/input screen/input__form-control'))

    while (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) != findTestData('Transfer').getValue(
        8, 5)) {
        WebUI.click(findTestObject('future dated/input screen/div_'))

        if (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) == findTestData('Transfer').getValue(
            8, 5)) {
            break
        }
    }
    
    
    WebUI.click(findTestObject('future dated/input screen/td_29', [('id') : findTestData('Transfer').getValue(8, 4)]))
} else if ((findTestData('Transfer').getValue(6, 1) == 'Y') && (findTestData('Transfer').getValue(8, 1) == 'N')) {
    WebUI.click(findTestObject('future dated/input screen/input_Effective Date_form-control'))

      while (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) != findTestData('Transfer').getValue(
        6, 3)) {
        WebUI.click(findTestObject('future dated/input screen/div_'))

        if (WebUI.getText(findTestObject('future dated/input screen/span_October 2022')) == findTestData('Transfer').getValue(
            6, 3)) {
            break
        }
    }
    
	WebUI.click(findTestObject('future dated/input screen/td_29', [('id') : findTestData('Transfer').getValue(6, 2)]))
}