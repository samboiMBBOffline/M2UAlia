package com

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import java.text.NumberFormat

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class CurrencyCalc {

	def RMtoOthers(a,b) {
		def c=a.replaceAll(",", "")
		def d=b.replaceAll(",", "")
		String[] part1 = c.split('(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)|=|(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)')
//		KeywordUtil.logInfo(part1[1])
//		KeywordUtil.logInfo(part1[2])
//		KeywordUtil.logInfo(part1[3])
//		KeywordUtil.logInfo(part1[0])
		String[] part2 = d.split('(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)|=|(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)')

		def actual = part2[3]
		WebUI.verifyEqual(part2[1], findTestData('Transfer').getValue(2, 63))
//		KeywordUtil.logInfo(part2[1])
//		KeywordUtil.logInfo(part2[2])
//		KeywordUtil.logInfo(part2[3])
//		KeywordUtil.logInfo(part2[0])
		def nf = NumberFormat.getInstance()
		nf.setMinimumFractionDigits(2)
		nf.setMaximumFractionDigits(2)

		def expected
		if (part1[1]=='1') {
			expected=nf.format(findTestData('Transfer').getValue(2, 63).toDouble()*part1[3].toDouble()).replaceAll(",", "")
		}else {
		expected=nf.format(findTestData('Transfer').getValue(2, 63).toDouble()/part1[1].toDouble()).replaceAll(",", "")
		}
		WebUI.verifyEqual( actual, expected)
	}
}
