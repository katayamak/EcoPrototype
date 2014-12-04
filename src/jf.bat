set JFLEX_HOME=C:\Users\Koji\Documents\workspace\EcoPrototype

java -Xmx128m -jar %JFLEX_HOME%\lib\jflex-1.6.0.jar %1.jflex %2 %3 %4 %5 %6 %7 %8 %9

java -jar %JFLEX_HOME%\lib\java-cup-11a.jar -interface -parser EcoModelParser < %1Parser.cup
