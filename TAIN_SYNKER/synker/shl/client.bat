@echo off

setlocal

:: --------------------------------------------------------------
set JAVA_HOME=M:\PROG\jdk1.7.0_79
set PATH=%JAVA_HOME%\bin;%PATH%

:: --------------------------------------------------------------
set TAIN_HOME=N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER

:: --------------------------------------------------------------
set DEBUG=
set DEBUG=%DEBUG% -Dtain.kr.main=tain.kr.com.proj.synker.v04.main.client.ClientMain
set DEBUG=%DEBUG% -Dtain.kr.synker.properties.file=N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties

:: --------------------------------------------------------------
java %DEBUG% -jar %TAIN_HOME%/synker/libs/tain-synker-1.0.jar

:: --------------------------------------------------------------
pause

endlocal

