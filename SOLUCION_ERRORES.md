# Solución de Errores de Compilación

## Problema
VS Code no está reconociendo las clases del proyecto. Los errores indican que está buscando en una ruta diferente.

## Solución Rápida

### Paso 1: Recargar el Workspace de Java
1. Presiona `Ctrl+Shift+P` para abrir la paleta de comandos
2. Escribe: `Java: Clean Java Language Server Workspace`
3. Selecciona la opción y confirma
4. VS Code se recargará automáticamente

### Paso 2: Recompilar el Proyecto
1. Presiona `Ctrl+Shift+P` nuevamente
2. Escribe: `Java: Rebuild Projects`
3. Espera a que termine la compilación

### Paso 3: Verificar que el Workspace Correcto Esté Abierto
Asegúrate de que VS Code esté abierto en la carpeta:
```
C:\Users\diego\OneDrive\Escritorio\EJERCICIOS\java\Apps-1
```

NO en:
```
C:\Users\diego\OneDrive\Escritorio\EJERCICIOS\java\Apps\Apps
```

### Paso 4: Si Persisten los Errores
1. Cierra VS Code completamente
2. Abre VS Code nuevamente
3. Abre la carpeta `Apps-1` (no `Apps`)
4. Espera a que VS Code indexe los archivos (verás notificaciones en la esquina inferior derecha)

## Verificación
Después de estos pasos, los errores deberían desaparecer. Si aún persisten, ejecuta:
- `Ctrl+Shift+P` → `Java: Restart Language Server`

