# ⚡ Solución Rápida: Crear Base de Datos

## El Error:
```
FATAL: no existe la base de datos ?pasarela_ventas?
```

## Solución en 3 Pasos:

### Paso 1: Abrir pgAdmin
1. Busca "pgAdmin" en el menú de Windows
2. Ábrelo
3. Conéctate al servidor (usuario: `postgres`, contraseña: `Diegogh10`)

### Paso 2: Crear la Base de Datos
1. En el panel izquierdo, expande "Servers" → "PostgreSQL X.X"
2. Click derecho en "Databases"
3. Selecciona "Create" → "Database..."
4. En la pestaña "General":
   - **Name:** `pasarela_ventas`
5. Click en "Save"

### Paso 3: Ejecutar la Aplicación
Ahora ejecuta tu aplicación nuevamente. Hibernate creará automáticamente las tablas.

## Alternativa: Usar SQL desde pgAdmin

1. Abre pgAdmin
2. Click derecho en "Databases" → "Query Tool"
3. Ejecuta este SQL:
```sql
CREATE DATABASE pasarela_ventas;
```
4. Click en el botón "Execute" (⚡)

## Verificar que se Creó

En pgAdmin, deberías ver `pasarela_ventas` en la lista de bases de datos.

## Si no tienes pgAdmin instalado:

1. Busca la ruta de instalación de PostgreSQL (normalmente: `C:\Program Files\PostgreSQL\XX\bin`)
2. Abre PowerShell en esa carpeta
3. Ejecuta:
```powershell
.\psql.exe -U postgres
```
4. Ingresa la contraseña: `Diegogh10`
5. Ejecuta: `CREATE DATABASE pasarela_ventas;`
6. Salir: `\q`

