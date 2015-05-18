@echo off
cls
echo ---------------------------------------------------
echo.   DB IMPORT BATCH FILE
echo.   TAE HOON KIM
echo.
echo.
echo ---------------------------------------------------


SET DATABASE=XE

echo Database를 import할 파일 이름 명을 적어주세요.(file.dmp)
set /p IMPORT_FILE=IMPORT_FILE:
set /p LOGIN_ID=LOGIN_ID:
set /p LOGIN_PWD=LOGIN_PWD:
echo Default Database =  %DATABASE%
echo imp %LOGIN_ID%/%LOGIN_PWD% owner=%LOGIN_ID% file=%IMPORT_FILE%

REM timeout 5
imp %LOGIN_ID%/%LOGIN_PWD% full=y grants=y file=%IMPORT_FILE%

timeout 3