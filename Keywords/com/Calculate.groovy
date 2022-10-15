package com

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.text.NumberFormat as NumberFormat


import internal.GlobalVariable

public class Calculate {

	@Keyword
	def Balance (def casaBfr,def trfToOwn_amt,def casaAftr) {
		casaBfr = casaBfr.replaceAll(',', '')

		String[] part1 = casaBfr.split('(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)')

		def nf = NumberFormat.getInstance()

		nf.setMinimumFractionDigits(2)

		nf.setMaximumFractionDigits(2)

		def expectedBal = nf.format((part1[1]).toDouble() - trfToOwn_amt.toDouble()).replaceAll(',', '')

		casaAftr = casaAftr.replaceAll(',', '')

		String[] part2 = casaAftr.split('(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)')

		def actualBal = nf.format((part2[1]).toDouble()).replaceAll(',', '')

		WebUI.verifyEqual(expectedBal.toString(), actualBal.toString())

		KeywordUtil.logInfo("expected val: "+expectedBal)
		KeywordUtil.logInfo("actual val: "+actualBal)
	}
}
