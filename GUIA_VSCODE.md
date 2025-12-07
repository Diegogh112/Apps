# 🚀 Guía para Ejecutar en Visual Studio Code

## Paso 1: Instalar Extensiones Necesarias

1. Abre VS Code
2. Presiona `Ctrl+Shift+X` para abrir el panel de extensiones
3. Busca e instala estas extensiones:
   - **Extension Pack for Java** (por Microsoft) - Incluye todo lo necesario
   - O individualmente:
     - Java Extension Pack
     - Spring Boot Extension Pack (opcional pero recomendado)

## Paso 2: Abrir el Proyecto

1. En VS Code, presiona `Ctrl+K Ctrl+O` o ve a **File → Open Folder**
2. Selecciona la carpeta: `C:\Users\diego\OneDrive\Escritorio\EJERCICIOS\java\Apps-1`
3. Espera a que VS Code reconozca el proyecto Maven (verás notificaciones en la esquina inferior derecha)

## Paso 3: Descargar Dependencias

1. VS Code debería detectar automáticamente el `pom.xml`
2. Si aparece una notificación sobre "Maven projects need to be imported", haz clic en **Import**
3. Espera a que descargue todas las dependencias (puede tardar unos minutos la primera vez)
4. Verás el progreso en la barra de estado inferior

## Paso 4: Ejecutar la Aplicación

### Método 1: Desde el archivo Java (Más fácil)

1. Abre el archivo: `src/main/java/com/example/imagenaleatoria/ImagenAleatoriaApplication.java`
2. Verás un botón **▶ Run** sobre el método `main()` o sobre la clase
3. Haz clic en **Run** o presiona `F5`
4. Selecciona la configuración "Spring Boot - ImagenAleatoriaApplication" si te pregunta

### Método 2: Desde la Terminal Integrada

1. Presiona `` Ctrl+` `` para abrir la terminal integrada
2. Ejecuta:
   ```bash
   mvn spring-boot:run
   ```
   (Solo funciona si tienes Maven instalado)

### Método 3: Usando el Debugger

1. Abre `ImagenAleatoriaApplication.java`
2. Presiona `F5` o ve a **Run → Start Debugging**
3. Selecciona "Spring Boot - ImagenAleatoriaApplication"

## Paso 5: Ver la Aplicación

1. Espera a ver en la consola:
   ```
   Started ImagenAleatoriaApplication in X.XXX seconds
   ```
2. Abre tu navegador web
3. Ve a: **http://localhost:8080**
4. ¡Listo! Ya puedes usar la aplicación

## Solución de Problemas

### Si no aparece el botón "Run":
- Asegúrate de tener instalado "Extension Pack for Java"
- Recarga VS Code: `Ctrl+Shift+P` → "Developer: Reload Window"

### Si hay errores de compilación:
- Presiona `Ctrl+Shift+P`
- Escribe: "Java: Clean Java Language Server Workspace"
- Selecciona y recarga

### Si las dependencias no se descargan:
- Abre la terminal integrada (`` Ctrl+` ``)
- Ejecuta: `mvn clean install` (si tienes Maven)
- O espera a que VS Code las descargue automáticamente

### Si el puerto 8080 está ocupado:
- Edita `src/main/resources/application.properties`
- Cambia `server.port=8080` a otro puerto, por ejemplo `server.port=8081`

## Atajos Útiles

- `F5` - Ejecutar/Debug
- `Ctrl+F5` - Ejecutar sin debug
- `Ctrl+Shift+P` - Paleta de comandos
- `` Ctrl+` `` - Terminal integrada

