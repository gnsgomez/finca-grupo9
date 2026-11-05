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