@echo off
echo ========================================
echo   Sistema Web de Imagenes Aleatorias
echo ========================================
echo.
echo Verificando Java...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java no esta instalado o no esta en el PATH
    pause
    exit /b 1
)
echo.
echo ========================================
echo   INSTRUCCIONES PARA EJECUTAR:
echo ========================================
echo.
echo OPCION 1 - Si tienes Maven instalado:
echo   mvn spring-boot:run
echo.
echo OPCION 2 - Si usas IntelliJ IDEA o Eclipse:
echo   1. Abre el proyecto en tu IDE
echo   2. Espera a que descargue las dependencias
echo   3. Ejecuta ImagenAleatoriaApplication.java
echo.
echo OPCION 3 - Instalar Maven:
echo   1. Descarga desde: https://maven.apache.org/download.cgi
echo   2. Descomprime y agrega a PATH
echo   3. Ejecuta: mvn spring-boot:run
echo.
echo ========================================
echo   Una vez ejecutado, abre:
echo   http://localhost:8080
echo ========================================
echo.
pause

