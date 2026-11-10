# finca-grupo9 · Taller Grupal 3

*Lambdas y patrón Strategy*: calculadora de costos de producción agropecuaria (banano, cacao y arroz) en Java 21.

*Universidad Agraria del Ecuador* · Programación 3 · Semana 3

## Grupo 9

| Integrante | Rol |
|---|---|
| González Suárez Chrystel Karolina | Coordinador |
| Soledispa Chiquito Miriam Elizabeth | Desarrollador principal |
| Gómez Arias Genesis Keyla | Revisor de calidad |

## Descripción

Las fórmulas de cálculo del costo de un lote son intercambiables en tiempo de ejecución (patrón Strategy), con interfaces funcionales y lambdas sobre una jerarquía sellada de cultivos.

Clases del paquete ec.uagraria.costos: Insumo, Cultivo, Banano, Cacao, Arroz, Lote, EstrategiaCosto, Estrategias, CalculadoraCostos y Main (demostración).

## Requisitos

- JDK 21
- Maven 3.9 o superior
- IntelliJ IDEA (opcional)

## Cómo ejecutar

bash
git clone https://github.com/gnsgomez/finca-grupo9.git
cd finca-grupo9
git checkout taller-03

mvn -q clean compile     # compila el proyecto
mvn test                 # ejecuta las pruebas JUnit 5


Para correr la demostración, en IntelliJ abre src/main/java/ec/uagraria/costos/Main.java y pulsa *Run*.

## Pruebas

mvn test ejecuta 15 pruebas, todas en verde, incluida la clase CalculadoraCostosTest.

# Taller Grupal N.º 4 – Refactorización SOLID con Factory y Observer

## 1. Diagnóstico del código

| Pregunta | Respuesta |
|---|---|
| ¿Qué clase tiene más de un motivo para cambiar? | Se identificó la clase que combina varias responsabilidades dentro del proyecto. |
| ¿Dónde se utiliza new directamente? | En las clases donde se crean directamente objetos del dominio, antes de utilizar la fábrica. |
| ¿Hay umbrales escritos como números sueltos? | Se revisaron las reglas para identificar los valores fijos y trasladarlos a una configuración. |
| ¿Hay herencia que exista solo para reutilizar código? | Se revisaron las relaciones de herencia para evitar reutilización inadecuada. |

## 2. Aplicación de los principios SOLID

| Principio | Aplicación en el proyecto |
|---|---|
| S – Responsabilidad única | Las clases se separan según sus responsabilidades. |
| O – Abierto/cerrado | Se pueden agregar nuevas reglas sin modificar el motor de alertas. |
| L – Sustitución de Liskov | Las implementaciones cumplen los contratos de sus interfaces. |
| I – Segregación de interfaces | Se utilizan interfaces específicas para evitar métodos innecesarios. |
| D – Inversión de dependencias | El motor trabaja con abstracciones para las reglas y observadores. |

## 3. Justificación de los umbrales

Los umbrales se establecieron considerando las condiciones del dominio del proyecto. Estos valores permiten identificar situaciones que requieren atención y generar alertas cuando se cumplen las condiciones definidas.

Se debe justificar individualmente el umbral de cada una de las tres alertas.

## 4. Pruebas unitarias

Se implementaron pruebas utilizando JUnit 5 para comprobar:

- Activación de las tres alertas.
- Comportamiento de las alertas en el umbral exacto.
- Creación de productos mediante Factory.
- Notificación a los observadores.

## 5. Evidencias

- Ejecución de pruebas con Maven.
- Salida del motor de alertas.
- Diagrama UML actualizado.
- Pull Request del Taller 4.