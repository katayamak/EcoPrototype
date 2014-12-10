set JFLEX_HOME=C:\Users\kanko_guest\Documents\workspace\EcoPrototype

java -Xmx128m -jar %JFLEX_HOME%\lib\jflex-1.6.0.jar %1.jflex %2 %3 %4 %5 %6 %7 %8 %9

java -jar %JFLEX_HOME%\lib\java-cup-11a.jar -interface -parser EcoModelParser < %1Parser.cup


copy /Y ..\import.txt+.\EcoModelParser.java .\jp\co\mra\ecodsl\base\EcoModelParser.java
copy /Y ..\import.txt+.\EcoModelScanner.java .\jp\co\mra\ecodsl\base\EcoModelScanner.java
copy /Y ..\import.txt+.\sym.java .\jp\co\mra\ecodsl\base\sym.java

del .\EcoModelParser.java
del .\EcoModelScanner.java
del .\sym.java
