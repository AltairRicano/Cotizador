**Facultad de Contaduría y Administración**

**Región Coatzacoalcos-Minatitlán**

**Programa educativo**  
Licenciado en Ingeniería de Software

**Experiencia Educativa**  
**Fundamentos de pruebas de Software**

Cotizador de impresiones: casos de prueba y JUnit

**Los Tiburones Rojos de Veracruz**  
**Presenta:**  
FABIAN HERNANDEZ JOSE MANUEL  
MATEOS DE LA CRUZ JOSE  
REYES MENDOZA LUIS ANGEL  
RICAÑO CASTELLANOS ALTAIR  
TRUJILLO MARTINEZ CESAR ELOY  
   
   
**Grupo:**  
LIS-501

**Docente:**  
Javier Pino Herrera

Coatzacoalcos, Ver.,  Octubre de 2026

“Lis de Veracruz: Arte, Ciencia, Luz”

**Reporte**

1. Captura de la ejecución de las pruebas.  
2. Especificación de pruebas fallidas (foto y descripción).  
3. Declaración de IA.

✅  ❌

| ID | REQUISITO | ENTRADAS |  |  |  | Esperado | Obtenido | Veredicto |
| :---: | :---: | :---: | :---: | ----- | :---: | :---: | :---: | :---: |
|  |  | **T.Usuario** | **Pags** | **Color** | **Doble Cara** |  |  |  |
| **CP01\_** | R1.1 usuario Nulo LanzaExcepcion | NULL | 100  | Si  | No | “TIPO DE USUARIO REQUERIDO”   | “TIPO DE USUARIO REQUERIDO” | 1 |
| **CP02\_** | R1.2  Valor Maximo | ESTUDIANTE | 500  | No  | No | 281.60 | “PAGINAS FUERA DE RANGO: 500” | 0 |
| **CP03\_** | R1.2 Fuera de rango máximo | DOCENTE | 600 |  No | No | “PAGINAS FUERA DE RANGO: 600” | “PAGINAS FUERA DE RANGO: 600” | 1 |
| **CP04\_** |  R1.2 Fuera de rango mínimo | EXTERNO | 0  | Si  | Si | “PAGINAS FUERA DE RANGO: 0” | “PAGINAS FUERA DE RANGO: 0” | 1 |
| **CP05\_** |  R1.2 Valor mínimo | EXTERNO | 1  | Si  | No |  5.18 | 5.17 | 0 |
| **CP06\_** |  R1.3 Jerarquía de error | NULL | 800  | Si  | No | “TIPO DE USUARIO REQUERIDO”    | “TIPO DE USUARIO REQUERIDO” | 1 |
| **CP07\_** |  R2.1 Precio por pagina b/n | ESTUDIANTE | 20 | No  | No |  12.80 | 12.80 | 1 |
| **CP08\_** | R3.1 Sin descuento por volumen | ESTUDIANTE | 80  | No | No | 51.20 | 51.20 | 1 |
| **CP09\_** | R3.1 Sin descuento por volumen  | DOCENTE | 90 | NO | NO | 36.00 | 36.00 | 1 |
| **CP10\_** | R3.1 Sin descuento por volumen  | EXTERNO | 72 | Si | No | 372.60 | 372.60 | 1 |
| **CP11\_** | R5.1  Descuento 5% por volumen | ESTUDIANTE | 150  |  No | No | 91.20 | 91.20 | 1 |
| **CP12\_** |  R3.3 Descuento 12% por volumen | ESTUDIANTE | 400  | No  | No | 225.28 | 225.28 | 1 |
| **CP13\_** |  R4.1 Descuento doble cara | ESTUDIANTE | 80  | No | Si |  46.08 | 46.08 | 1 |
| **CP14\_** |  R4.1 Descuento doble cara, descuento volumen 5% | ESTUDIANTE | 150  |  No | Si |  82.08 | 82.08 | 1 |
| **CP15\_** |   R4.1 Descuento doble cara, descuento volumen 12% | ESTUDIANTE | 400  | No  | Si |  202.75 | 202.75 | 1 |
| **CP16\_** | R5.1  Estudiante: 20 % de descuento.  | ESTUDIANTE | 50  | Si | Si |  162.00 | 162.00 | 1 |
| **CP17\_** |  R4.2 Una pagina no doble cara | ESTUDIANTE | 1  | Si  | Si |  3.60 | 3.24 | 0 |
| **CP18\_** |  R5.1 Descuento estudiante | ESTUDIANTE | 25  | Si  | No | 90.00  | 90.00 | 1 |
| **CP19\_** |  R5.2 Descuento de Docente | DOCENTE |  37 | Si  | No | 83.25  | 83.25 | 1 |
| **CP20\_** |  R5.3 Cargo de externo | EXTERNO | 71  | No   | No | 65.32  | 65.32 | 1 |
| **CP21\_** |  R6  Cargo Minimo | DOCENTE | 4  | No  | Si |  2.00 | 2.00 | 1 |
| **CP22\_** | R6 Cargo Minimo  | DOCENTE | 1  | No  | No | 2.00  | 2.00 | 1 |
| **CP23\_** | R7 Total redondeado | DOCENTE | 45 | Si | Si | 91.13 | 91.12 | 0 |
| **CP24\_** |  R7  Total redondeado | EXTERNO | 71  | Si  | No |  367.43 | 367.42 | 0 |
| **CP25\_** | R7 Total redondeado | ESTUDIANTE | 127 | Si | Si | 390.91 | 390.90 | 0 |
| **CP26\_** |  R2.1 Precio por pagina Color | ESTUDIANTE | 20 | Si  | No | 72.00 | 72.00 | 1 |
| **CP27\_** | R3.2 Descuento por volumen | ESTUDIANTE | 100 | No | No | 60.80 | 64.00 | 0 |
