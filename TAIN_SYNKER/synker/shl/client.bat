@echo off

setlocal

:: --------------------------------------------------------------
set JAVA_HOME=N:\PROG\jdk1.7.0_79
set PATH=%JAVA_HOME%\bin;%PATH%

:: --------------------------------------------------------------
set TAIN_HOME=N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER

:: --------------------------------------------------------------
set DEBUG=
set DEBUG=%DEBUG% -Dtain.kr.synker.conf.folder=%TAIN_HOME%/synker/conf
set DEBUG=%DEBUG% -Dtain.kr.main.service=client
set DEBUG=%DEBUG% -Dtain.kr.tr.list=TT0000,TR0000,

:: --------------------------------------------------------------
java %DEBUG% -jar %TAIN_HOME%/synker/libs/tain-synker-1.0.jar REAL

:: --------------------------------------------------------------
pause

endlocal

