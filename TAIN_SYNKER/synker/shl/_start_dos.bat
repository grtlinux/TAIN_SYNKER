@echo on

setlocal

set JAVA_HOME=M:\PROG\jdk1.7.0_79
set CATALINA=M:\PROG\apache-tomcat-7.0.68-x64

set PATH=%JAVA_HOME%\bin;%CATALINA%\bin;%PATH%

cd %CATALINA%\bin

start

::endlocal

