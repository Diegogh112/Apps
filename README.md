# Sistema Web de Imágenes Aleatorias

Sistema web en Java que permite ingresar un número y obtener una imagen aleatoria basada en ese número.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Thymeleaf** (para las plantillas HTML)
- **Maven** (gestión de dependencias)

## Requisitos

- Java 17 o superior
- Maven 3.6 o superior

## Cómo ejecutar

1. **Compilar el proyecto:**
   ```bash
   mvn clean install
   ```

2. **Ejecutar la aplicación:**
   ```bash
   mvn spring-boot:run
   ```

3. **Abrir en el navegador:**
   - Navega a: `http://localhost:8080`

## Uso

1. Ingresa cualquier número en el formulario
2. Haz clic en "Mostrar Imagen"
3. Se mostrará una imagen aleatoria basada en el número ingresado

## Estructura del Proyecto

```
Apps-1/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── imagenaleatoria/
│       │               ├── ImagenAleatoriaApplication.java
│       │               └── controller/
│       │                   └── ImagenController.java
│       └── resources/
│           └── templates/
│               ├── index.html
│               └── resultado.html
└── README.md
```

## Personalización

Puedes modificar las imágenes en el archivo `ImagenController.java`, cambiando las URLs en la lista `imagenes`. También puedes agregar tus propias imágenes locales colocándolas en `src/main/resources/static/images/` y referenciándolas como `/images/nombre-imagen.jpg`.

