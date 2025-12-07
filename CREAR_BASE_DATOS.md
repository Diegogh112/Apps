# 🗄️ Crear Base de Datos PostgreSQL

## Error Actual:
```
FATAL: no existe la base de datos ?pasarela_ventas?
```

## Solución: Crear la Base de Datos

### Opción 1: Usando psql (Línea de Comandos)

1. Abre PowerShell o CMD
2. Conéctate a PostgreSQL:
```powershell
psql -U postgres
```
3. Ingresa tu contraseña cuando te la pida (Diegogh10)
4. Crea la base de datos:
```sql
CREATE DATABASE pasarela_ventas;
```
5. Verifica que se creó:
```sql
\l
```
6. Salir:
```sql
\q
```

### Opción 2: Usando pgAdmin (Interfaz Gráfica)

1. Abre pgAdmin
2. Conéctate al servidor PostgreSQL (usuario: postgres, contraseña: Diegogh10)
3. Click derecho en "Databases" → "Create" → "Database"
4. Nombre: `pasarela_ventas`
5. Click en "Save"

### Opción 3: Desde PowerShell (Una línea)

```powershell
psql -U postgres -c "CREATE DATABASE pasarela_ventas;"
```

## Verificar que PostgreSQL está corriendo

```powershell
# Ver servicios de PostgreSQL
Get-Service | Where-Object {$_.Name -like "*postgres*"}

# O verificar el puerto
netstat -ano | findstr :5432
```

## Después de crear la base de datos

1. Ejecuta la aplicación nuevamente
2. Hibernate creará automáticamente las tablas
3. Los productos se inicializarán automáticamente

