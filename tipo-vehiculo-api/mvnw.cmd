@ECHO OFF
SETLOCAL
SET WRAPPER_JAR=.mvn\wrapper\maven-wrapper.jar
IF NOT EXIST "%WRAPPER_JAR%" (
  ECHO ERROR: Falta %WRAPPER_JAR%. Descárgalo desde:
  ECHO https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar
  EXIT /B 1
)
SET JAVA_EXE=java
IF NOT "%JAVA_HOME%"=="" SET JAVA_EXE="%JAVA_HOME%\bin\java.exe"
%JAVA_EXE% -Dmaven.multiModuleProjectDirectory=%CD% -cp "%WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*