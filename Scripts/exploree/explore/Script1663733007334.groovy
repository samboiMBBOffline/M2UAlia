import java.text.NumberFormat as NumberFormat

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String str = "RM1,234.00";
str=str.replaceAll(',','')
String[] part = str.split("(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)");
println(part[0])
println(part[1])
//System.out.println(part[0]);
//System.out.println(part[1]);

a=part[1].toDouble()
println(a)
//b=a-1.50
//println(b)
nf = NumberFormat.getInstance()
nf.setMinimumFractionDigits(2)
nf.setMaximumFractionDigits(2)
println (nf.format(a-1).replaceAll(",", ""))
	casaAftr=casaAftr.replaceAll(',','')
	String[] part2 = casaAftr.split("(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)");
	actualBal=nf.format(part2[1].toDouble()).replaceAll(",", "")
	WebUI.verifyEqual(expectedBal, actualBal)

calculate('RM 5,001.05'.replaceAll(' ', ''), '2.05', 'RM 4,999.00'.replaceAll(' ', ''))

def calculate(def casaBfr, def trfToOwn_amt, def casaAftr) {
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
}


