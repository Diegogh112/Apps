# 🐘 Guía de Configuración de PostgreSQL

## Paso 1: Instalar PostgreSQL

### Windows:
1. Descarga PostgreSQL desde: https://www.postgresql.org/download/windows/
2. Ejecuta el instalador
3. Durante la instalación:
   - Anota la contraseña del usuario `postgres` (la necesitarás)
   - Puerto por defecto: `5432`
   - Deja las opciones por defecto

### Verificar instalación:
```powershell
psql --version
```

## Paso 2: Crear la Base de Datos

### Opción A: Usando pgAdmin (Interfaz Gráfica)
1. Abre pgAdmin (viene con PostgreSQL)
2. Conéctate al servidor (usuario: `postgres`, tu contraseña)
3. Click derecho en "Databases" → "Create" → "Database"
4. Nombre: `pasarela_ventas`
5. Click en "Save"

### Opción B: Usando línea de comandos
```powershell
# Abrir psql
psql -U postgres

# Crear base de datos
CREATE DATABASE pasarela_ventas;

# Salir
\q
```

## Paso 3: Configurar application.properties

Edita el archivo `src/main/resources/application.properties`:

```properties
# Cambia estos valores según tu configuración:
spring.datasource.url=jdbc:postgresql://localhost:5432/pasarela_ventas
spring.datasource.username=postgres
spring.datasource.password=TU_PASSWORD_AQUI
```

**Importante:** Reemplaza `TU_PASSWORD_AQUI` con la contraseña que configuraste durante la instalación.

## Paso 4: Verificar la Conexión

1. Asegúrate de que PostgreSQL esté corriendo:
   - Windows: Busca "Services" → Busca "postgresql" → Debe estar "Running"

2. Ejecuta la aplicación:
   ```powershell
   mvn spring-boot:run
   ```

3. Si hay errores de conexión, verifica:
   - Que PostgreSQL esté corriendo
   - Que la base de datos `pasarela_ventas` exista
   - Que el usuario y contraseña sean correctos
   - Que el puerto sea 5432 (o el que configuraste)

## Paso 5: Tablas Automáticas

Con la configuración `spring.jpa.hibernate.ddl-auto=update`, Hibernate creará automáticamente las tablas cuando ejecutes la aplicación.

Las tablas se crearán en este orden:
- `usuario` - Usuarios del sistema
- `producto` - Productos disponibles
- `pedido` - Pedidos realizados
- `item_carrito` - Items de los pedidos

## Solución de Problemas

### Error: "Connection refused"
- Verifica que PostgreSQL esté corriendo
- Verifica el puerto (por defecto 5432)

### Error: "Database does not exist"
- Crea la base de datos `pasarela_ventas` manualmente

### Error: "Password authentication failed"
- Verifica el usuario y contraseña en `application.properties`
- Prueba conectarte con pgAdmin primero

### Error: "Driver not found"
- Verifica que la dependencia de PostgreSQL esté en `pom.xml`
- Ejecuta `mvn clean install` para descargar dependencias

## Comandos Útiles

```sql
-- Conectarse a la base de datos
psql -U postgres -d pasarela_ventas

-- Ver todas las tablas
\dt

-- Ver estructura de una tabla
\d nombre_tabla

-- Ver todos los usuarios
SELECT * FROM usuario;

-- Ver todos los productos
SELECT * FROM producto;

-- Ver todos los pedidos
SELECT * FROM pedido;
```

## Configuración de Producción

Para producción, considera:
1. Cambiar `spring.jpa.hibernate.ddl-auto=update` a `validate` o `none`
2. Usar variables de entorno para credenciales
3. Configurar pool de conexiones apropiado
4. Habilitar SSL si es necesario

