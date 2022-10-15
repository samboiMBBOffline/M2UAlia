import java.text.NumberFormat

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern


//hh='1'
//
//a=hh.toDouble() *5
//println(a)
//
//b=11 - a.toDouble() 
//println(b)
a='RM3.303000'
b='100'

c='RM 100 = SGD 30.28'
d='RM3.303000=SGD1'

String str1 = "RM3.303000";

str=c.replaceAll(' ','')

//String[] part = str1.split("[a-zA-Z]|[0-9]*\.[0-9]+");
//String[] part1 = str1.split("[a-zA-Z]|[0-9]*\\.[0-9]+", Pattern.CASE_INSENSITIVE);
String[] part = str.split("(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)|=|(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)");
println(part[0])
println(part[1])
println(part[2])
println(part[3])
//println(part[4])
//a=part[1].toDouble()
nf = NumberFormat.getInstance()
nf.setMinimumFractionDigits(2)
nf.setMaximumFractionDigits(2)
//println (nf.format(100/part[1].toDouble()).replaceAll(",", ""))
