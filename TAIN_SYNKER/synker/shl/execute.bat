@echo off

setlocal

set JAVA_HOME=M:\PROG\jdk1.7.0_79

set PATH=%JAVA_HOME%\bin;%PATH%

java -jar ../libs/tain-synker-1.0.jar

pause

endlocal

