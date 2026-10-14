# Práctica 6 · Recursos, Estilos y Modo Oscuro
**Unidad II:** Diseño de aplicaciones móviles  
**Proyecto:** Registro de Asistencia  

---

## 👨‍💻 Datos del Alumno
* **Nombre:** Rubén Morales Reyes
* **Matrícula:** 250854
* **Iniciales (INI):** RMR
* **Último dígito ($D$):** 4
* **Paleta asignada ($D = 4$):**
  * **Primario (Claro):** `#2A5D34` (Verde)
  * **Acento:** `#F0BE5E` (Amarillo/Dorado)
  * **Primario (Oscuro):** `#8FD69A` (Verde Claro)
  * **Fondo (Claro):** `#F4F6F7` / **Fondo (Oscuro):** `#15202B`

---

## 🎯 Objetivo de la Práctica
Refactorizar la interfaz de usuario del proyecto de *Registro de Asistencia* para desacoplar textos, colores y estilos de las vistas XML y del código Kotlin. Toda la configuración visual y de datos vive en archivos de recursos (`strings.xml`, `colors.xml`, `themes.xml` y `values-night/colors.xml`), permitiendo el soporte nativo para **Modo Oscuro** (Dark Theme) tanto por preferencia del sistema como por un control manual en vivo.

---

## 🛠️ Cambios Implementados

1. **Extracción de Cadenas (`strings.xml`):**
   * Migración de los 13 textos de la interfaz (hints, botones, mensajes y avisos de validación) usando la nomenclatura con sufijo `RMR`.
   * Implementación de marcadores de posición (`%1$s`, `%2$s`, `%3$d`) para la interpolación dinámica del mensaje de confirmación del contador.

2. **Gestión de Colores (`colors.xml` y `values-night/colors.xml`):**
   * Definición de la paleta personalizada según $D = 4$.
   * Creación de la carpeta de calificación `values-night` para la conmutación automática de colores en tema nocturno.

3. **Definición de Estilos (`themes.xml`):**
   * Creación de estilos reutilizables `BotonRMR` y `CampoRMR` para estandarizar márgenes, tamaños, colores de texto y fondos.

4. **Lógica en Kotlin (`MainActivity.kt`):**
   * Sustitución de cadenas hardcodeadas por `getString(R.string...)` en validaciones y en la función `limpiar()`.
   * Integración de `AppCompatDelegate.setDefaultNightMode()` para alternar manualmente el tema claro/oscuro desde el botón de la interfaz.

---

## 📱 Capturas del Funcionamiento

| Modo Claro (Default) | Modo Oscuro (D = 4) |
| :---: | :---: |
| *App adaptada con paleta diurna* | *App adaptada con paleta nocturna* |

---

## 🧪 Pruebas Realizadas
- [x] Apertura de la aplicación en modo claro con paleta de color correspondiente.
- [x] Disparo de validaciones con Toast en orden (Nombre vacío, nombre corto, matrícula vacía, matrícula incompleta).
- [x] Registro simulado de asistente con barra de progreso (1.5s) y actualización del contador.
- [x] Conmutación manual a Modo Oscuro mediante el botón de la app.
- [x] Retorno manual a Modo Claro actualizando el texto del botón dinámicamente.
- [x] Respuesta automática al cambio de tema global desde los ajustes del sistema operativo.
