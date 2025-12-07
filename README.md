# 🛒 Pasarela de Ventas

Sistema completo de pasarela de ventas y pagos desarrollado en Java con Spring Boot.

## 🚀 Características

- **Catálogo de Productos**: Visualización de productos con imágenes, precios y descripciones
- **Carrito de Compras**: Agregar, actualizar y eliminar productos del carrito
- **Checkout**: Proceso de compra con formulario de envío y pago
- **Gestión de Pedidos**: Confirmación y seguimiento de pedidos
- **Filtros por Categoría**: Navegación fácil por categorías de productos
- **Interfaz Moderna**: Diseño responsive y atractivo

## 🛠️ Tecnologías

- **Java 17**
- **Spring Boot 3.2.0**
- **Thymeleaf** (plantillas HTML)
- **Maven** (gestión de dependencias)

## 📋 Requisitos

- Java 17 o superior
- Maven 3.6 o superior (opcional si usas IDE)

## 🏃 Cómo Ejecutar

### Opción 1: Visual Studio Code

1. Abre VS Code en la carpeta del proyecto
2. Instala la extensión **Extension Pack for Java**
3. Abre `PasarelaVentasApplication.java`
4. Haz clic en el botón **▶ Run** sobre el método `main()`
5. Abre tu navegador en: `http://localhost:8080`

### Opción 2: Maven

```bash
mvn spring-boot:run
```

### Opción 3: IDE (IntelliJ IDEA / Eclipse)

1. Importa el proyecto como proyecto Maven
2. Ejecuta la clase `PasarelaVentasApplication`
3. Abre `http://localhost:8080` en tu navegador

## 📱 Funcionalidades

### Página Principal (`/`)
- Catálogo completo de productos
- Agregar productos al carrito
- Ver detalles de productos

### Productos (`/productos`)
- Lista de todos los productos
- Filtros por categoría (Electrónica, Accesorios, Audio)
- Búsqueda y navegación

### Detalle de Producto (`/producto/{id}`)
- Información completa del producto
- Selección de cantidad
- Agregar al carrito

### Carrito (`/carrito`)
- Ver todos los productos agregados
- Actualizar cantidades
- Eliminar productos
- Ver total
- Proceder al checkout

### Checkout (`/checkout`)
- Formulario de información del cliente
- Selección de método de pago
- Resumen del pedido
- Confirmación de compra

### Confirmación (`/checkout/procesar`)
- Detalles del pedido confirmado
- Número de pedido
- Información de envío y pago

## 🗂️ Estructura del Proyecto

```
Apps-1/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── pasarelaventas/
│       │               ├── PasarelaVentasApplication.java
│       │               ├── controller/
│       │               │   ├── ProductoController.java
│       │               │   ├── CarritoController.java
│       │               │   └── CheckoutController.java
│       │               ├── model/
│       │               │   ├── Producto.java
│       │               │   ├── ItemCarrito.java
│       │               │   └── Pedido.java
│       │               └── service/
│       │                   ├── ProductoService.java
│       │                   ├── CarritoService.java
│       │                   └── PedidoService.java
│       └── resources/
│           ├── application.properties
│           └── templates/
│               ├── index.html
│               ├── productos.html
│               ├── detalle-producto.html
│               ├── carrito.html
│               ├── checkout.html
│               └── confirmacion.html
└── README.md
```

## 🎨 Características de la Interfaz

- Diseño moderno y responsive
- Gradientes y animaciones suaves
- Navegación intuitiva
- Indicador de cantidad en el carrito
- Formularios validados
- Confirmaciones visuales

## 🔧 Configuración

El puerto por defecto es **8080**. Puedes cambiarlo en `src/main/resources/application.properties`:

```properties
server.port=8080
```

## 📝 Notas

- Los productos se cargan automáticamente al iniciar la aplicación
- El carrito se mantiene en memoria durante la sesión
- Los pedidos se almacenan en memoria (se pierden al reiniciar)
- Las imágenes usan un servicio de placeholder (puedes cambiarlas por imágenes locales)

## 🚀 Próximas Mejoras

- Base de datos para persistencia
- Autenticación de usuarios
- Integración con pasarelas de pago reales
- Sistema de inventario
- Historial de pedidos
- Búsqueda de productos
- Sistema de reseñas
