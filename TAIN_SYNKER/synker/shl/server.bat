@echo off

setlocal

:: --------------------------------------------------------------
set JAVA_HOME=M:\PROG\jdk1.7.0_79
set PATH=%JAVA_HOME%\bin;%PATH%

:: --------------------------------------------------------------
set TAIN_HOME=N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER

:: --------------------------------------------------------------
java -Dtain.kr.main=tain.kr.com.proj.synker.v01.main.ServerMain -jar %TAIN_HOME%/synker/libs/tain-synker-1.0.jar

:: --------------------------------------------------------------
pause

endlocal

