# Proyecto Backend - Perfil Argentina Programa

Este proyecto es un backend desarrollado en Java que forma parte de una aplicación para gestionar perfiles en el marco de Argentina Programa. El backend gestiona las operaciones CRUD (crear, leer, actualizar, eliminar) sobre usuarios, roles y otros elementos del perfil.

## Tecnologías utilizadas

- **Java**: Lenguaje principal para el desarrollo del backend.
- **Spring Boot**: Framework para la creación de aplicaciones web en Java.
- **MySQL**: Base de datos relacional utilizada para almacenar los datos.
- **Railway**: Plataforma en la nube utilizada para alojar tanto la base de datos como el backend.

## Migraciones y actualizaciones

Este proyecto ha pasado por varias plataformas en su evolución:

- **Heroku**: Originalmente, el backend fue alojado en Heroku, pero debido a que dejó de ser gratuita en noviembre de 2022, fue necesario buscar nuevas soluciones.
- **Yugabyte y Fly.io**: Posteriormente, se migró la base de datos a Yugabyte y el backend a Fly.io. Sin embargo, tras un tiempo de uso, ambos servicios dejaron de ser viables para el proyecto.
- **Railway**: Actualmente, tanto el backend como la base de datos MySQL han sido migrados a Railway. Esta plataforma ofrece una solución gratuita y escalable para seguir desarrollando y manteniendo el proyecto de forma eficiente.

### Estado actual:

- **Base de datos**: Migrada a Railway con MySQL, lo que permite una mayor estabilidad y escalabilidad.
- **Backend**: Implementado en Railway, facilitando la conexión con la base de datos y el despliegue continuo.

## Requisitos

Para ejecutar este proyecto, necesitarás:

- **JDK 11** o superior.
- **MySQL** (o cualquier instancia de MySQL compatible).
- **Railway CLI** (si se desea desplegar manualmente en Railway).
- **Git** para la gestión del código fuente.

## Configuración de las variables de entorno

Asegúrate de que las siguientes variables de entorno estén configuradas correctamente en Railway para la conexión a la base de datos:

- `DB_HOST`: Dirección del servidor MySQL alojado en Railway.
- `DB_PORT`: Puerto de conexión (normalmente 3306).
- `DB_NAME`: Nombre de la base de datos.
- `DB_USER`: Usuario para conectarse a la base de datos.
- `DB_PASSWORD`: Contraseña para el usuario de la base de datos.

## Instrucciones para clonar y ejecutar localmente

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/frangimz/backendprofileArgProg.git
