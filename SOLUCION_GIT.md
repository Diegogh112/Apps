# 🔧 Solución para el Error de Git Pull

## Problema
Git está intentando hacer pull pero hay archivos compilados en `target/` que causan conflictos.

## Solución Rápida

### Paso 1: Eliminar el directorio target (archivos compilados)
```powershell
# En PowerShell, desde el directorio del proyecto:
Remove-Item -Path target -Recurse -Force
```

### Paso 2: Agregar target al .gitignore (ya está creado)
El archivo `.gitignore` ya está creado y excluye el directorio `target/`.

### Paso 3: Hacer commit de los cambios
```powershell
git add .gitignore
git commit -m "Agregar .gitignore y excluir target/"
```

### Paso 4: Hacer stash de cambios locales (si hay cambios sin commitear)
```powershell
git stash
```

### Paso 5: Hacer pull
```powershell
git pull
```

### Paso 6: Aplicar cambios guardados (si hiciste stash)
```powershell
git stash pop
```

## Solución Alternativa (Si quieres mantener tus cambios)

### Opción A: Commitear tus cambios primero
```powershell
# 1. Eliminar target
Remove-Item -Path target -Recurse -Force

# 2. Agregar todos los cambios
git add .

# 3. Hacer commit
git commit -m "Actualizar proyecto con autenticación y perfil"

# 4. Hacer pull
git pull
```

### Opción B: Descartar cambios en target y hacer pull
```powershell
# 1. Eliminar solo los archivos compilados
Remove-Item -Path target -Recurse -Force

# 2. Hacer pull
git pull
```

## Prevención Futura

El archivo `.gitignore` ahora excluye:
- `target/` - Archivos compilados de Maven
- `*.class` - Archivos compilados individuales
- Archivos de IDE (`.idea/`, `.vscode/`, etc.)

**Importante:** Los archivos en `target/` son generados automáticamente al compilar. No deben estar en el repositorio Git.

