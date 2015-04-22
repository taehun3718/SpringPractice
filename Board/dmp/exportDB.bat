@echo off
cls
echo ---------------------------------------------------
echo.   DB EXPORT BATCH FILE
echo.   TAE HOON KIM
echo.
echo.
echo ---------------------------------------------------


SET DATABASE=XE

echo Database를 export할 파일 이름 명을 적어주세요.(file.dmp)
set /p EXPORT_FILE=EXPORT_FILE:
set /p LOGIN_ID=LOGIN_ID:
set /p LOGIN_PWD=LOGIN_PWD:
echo Default Database =  %DATABASE%
echo %LOGIN_ID%/%LOGIN_PWD%@%DATABASE% file=%EXPORT_FILE%

timeout 5
exp %LOGIN_ID%/%LOGIN_PWD%@%DATABASE% file=%EXPORT_FILE%

timeout 3