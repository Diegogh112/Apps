# 📋 Resumen: Configuración de PostgreSQL

## ✅ Lo que se ha configurado:

### 1. Dependencias agregadas al `pom.xml`:
- ✅ `spring-boot-starter-data-jpa` - Para JPA/Hibernate
- ✅ `postgresql` - Driver de PostgreSQL

### 2. Configuración en `application.properties`:
- ✅ URL de conexión: `jdbc:postgresql://localhost:5432/pasarela_ventas`
- ✅ Usuario: `postgres` (cambiar si es necesario)
- ✅ Password: **DEBES CAMBIAR ESTO** con tu contraseña de PostgreSQL
- ✅ Configuración de JPA/Hibernate

### 3. Modelos convertidos a Entidades JPA:
- ✅ `Usuario` - Con anotaciones `@Entity`, `@Table`, `@Column`
- ✅ `Producto` - Entidad JPA completa
- ✅ `Pedido` - Con relaciones `@OneToMany`
- ✅ `ItemCarrito` - Con relaciones `@ManyToOne`

### 4. Repositorios creados:
- ✅ `UsuarioRepository` - Con métodos `findByEmail`, `existsByEmail`
- ✅ `ProductoRepository` - Con método `findByCategoria`
- ✅ `PedidoRepository` - Con método `findByUsuarioId`
- ✅ `ItemCarritoRepository` - Repositorio básico

### 5. Servicios actualizados:
- ✅ `UsuarioService` - Usa `UsuarioRepository`
- ✅ `ProductoService` - Usa `ProductoRepository` (inicializa productos si BD está vacía)
- ✅ `PedidoService` - Usa `PedidoRepository`

## 🔧 Pasos para conectar a PostgreSQL:

### Paso 1: Instalar PostgreSQL
```powershell
# Descargar desde: https://www.postgresql.org/download/windows/
# Durante instalación, anota la contraseña del usuario 'postgres'
```

### Paso 2: Crear la Base de Datos
```sql
-- Conectarse a PostgreSQL
psql -U postgres

-- Crear base de datos
CREATE DATABASE pasarela_ventas;

-- Salir
\q
```

### Paso 3: Configurar application.properties
Edita `src/main/resources/application.properties` y cambia:
```properties
spring.datasource.password=TU_PASSWORD_AQUI
```
Reemplaza `TU_PASSWORD_AQUI` con la contraseña que configuraste durante la instalación.

### Paso 4: Ejecutar la aplicación
```powershell
mvn spring-boot:run
```

Hibernate creará automáticamente las tablas:
- `usuario`
- `producto`
- `pedido`
- `item_carrito`
- `usuario_pedidos` (tabla de relación)

## 📊 Estructura de Tablas:

### Tabla: `usuario`
- `id` (PK, auto-increment)
- `nombre`
- `email` (único)
- `password`
- `direccion`
- `telefono`

### Tabla: `producto`
- `id` (PK, auto-increment)
- `nombre`
- `descripcion`
- `precio`
- `imagen`
- `stock`
- `categoria`

### Tabla: `pedido`
- `id` (PK, auto-increment)
- `usuario_id`
- `total`
- `cliente_nombre`
- `cliente_email`
- `cliente_direccion`
- `metodo_pago`
- `estado`
- `fecha_creacion`

### Tabla: `item_carrito`
- `id` (PK, auto-increment)
- `producto_id` (FK)
- `pedido_id` (FK)
- `cantidad`

## ⚠️ Importante:

1. **Cambiar la contraseña** en `application.properties`
2. **Crear la base de datos** antes de ejecutar
3. **Verificar que PostgreSQL esté corriendo**
4. Los productos se inicializan automáticamente la primera vez

## 🔍 Verificar conexión:

Si todo está bien, verás en la consola:
```
Hibernate: create table usuario ...
Hibernate: create table producto ...
Hibernate: create table pedido ...
```

Si hay errores, revisa:
- Que PostgreSQL esté corriendo
- Que la base de datos exista
- Que el usuario y contraseña sean correctos
- Que el puerto sea 5432

