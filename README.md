# 🛒 Proyecto Spring Boot — Gestión de Productos
API REST desarrollada con **Spring Boot**, **Arquitectura en Capas**, **PostgreSQL**, **Gradle**, validaciones con **Bean Validation**, y manejo global de excepciones.

## 📌 Tecnologías utilizadas
- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Validation (Jakarta Validation)
- Lombok
- Gradle

## 📂 Estructura del proyecto
```
src/main/java/com/ejemplo/productos/
├── controller/
├── dto/
├── entity/
├── exception/
├── repository/
└── service/
```

## 🗄️ Configuración de la base de datos
Editar `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/productosdb
spring.datasource.username=postgres
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🚀 Ejecutar el proyecto
```
./gradlew bootRun
```

## 🧪 Endpoints disponibles
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/productos | Crear producto |
| GET | /api/productos/{id} | Obtener producto |
| GET | /api/productos | Listar productos |
| PUT | /api/productos/{id} | Actualizar producto |
| DELETE | /api/productos/{id} | Eliminar producto |

## 📤 Ejemplo POST
```
{
  "nombre": "Laptop Lenovo",
  "precio": 2500.50,
  "stock": 10
}
```

## ⚠️ Manejo global de excepciones

Las excepciones se manejan desde:

```
GlobalExceptionHandler.java
```

Ejemplo de error de validación:
```
{
  "timestamp": "2024-01-01T10:00:00",
  "mensaje": "El nombre no puede estar vacío",
  "ruta": "uri=/api/productos"
}
```

Ejemplo de “no encontrado”:
```
{
  "timestamp": "2024-01-01T10:00:00",
  "mensaje": "Producto no encontrado con id 5",
  "ruta": "uri=/api/productos/5"
}
```

## 📦 Build del proyecto

Crear el .jar ejecutable:
```
./gradlew build
```

El archivo generado estará en:
```
build/libs/
```
🧰 Dependencias usadas

Desde build.gradle:
```
spring-boot-starter-web

spring-boot-starter-data-jpa

spring-boot-starter-validation

postgresql

lombok
```
## 🤝 Contribuir

Crear una rama nueva:
```
git checkout -b feature/mi-mejora
```

Commit de cambios:
```
git commit -m "Agrega nueva característica"
```

Push:
```
git push origin feature/mi-mejora
```

## 📄 Licencia

Este proyecto es de libre uso para fines educativos o personales.

---

## 👨‍⚕️ Autor

Desarrollado por **Ing. Cristian Díaz**

---

<p align="center">
  <img width="300" src="https://i.imgur.com/YYf2LgH.png" alt="Logo del autor">
</p>