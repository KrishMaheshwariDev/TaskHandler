@echo off
REM === Task Tracker CLI ===
REM === Usage: task-cli add "Some task description" ===

setlocal

REM Set the classpath (include current dir and JSON JAR)
set CLASSPATH=.;lib\json.jar

REM Run the main class with all arguments passed through
java -cp "%CLASSPATH%" Main %*

endlocal
