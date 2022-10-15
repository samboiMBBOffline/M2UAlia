import java.time.LocalDate as LocalDate
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

def month = new Date().format('MMMM YYYY')

def day = new Date().getDate()

println(month)

println(day)

//v=new Date().format("dd-MM-yyyy").toString()
//println(v)
//date= LocalDate.parse(v)
//a=date.plusMonths(1)
//println(date)
//println(a)
def x = 0

def y = 5

while (y-- > 0) {
    x++
}

assert x == 5

while (WebUI.verifyElementNotPresent(findTestObject('null'), 0,[('text'):'October 2022'],)) {
	WebUI.click()
}



