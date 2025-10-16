# EJERCICIO GREP

## Explicacion del Ejercicio

- Estructura del archivo
    - Mi archivo consta de **1 solo fichero** *(fichero pricnipal)* en el que se encuentra el **programa completo**.
      - En el podremos encontrar el **desarrollo del programa completo** con sus distintos metodos, y objetos
    - Luego por ultimo tendremos el archivo **README** donde explicaremos como funciona este programa.

## Estructura del Programa

- GREP/
├── src/
│   ├── main/
│   │   ├── java/es/etg/dam/grep/Lanzador/
│   │   │                       └── Lanzador.java
│   │   └── resources/
    ├── target/
    ├── .gitignore
    ├── pom.xml
    └── README.md
## Codigo completo Lanzador.java
``` java

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.io.PrintWriter;

        public class Lanzador {
        
            public static final String TEXTO = """
                Me gusta PSP y java
                PSP se programa en java
                es un módulo de DAM
                y se programa de forma concurrente en PSP
                PSP es programación.
                """;

            public static final String TEXT = "Linea psp";

            public static void main(String[] args) throws Exception {
                Process p = Runtime.getRuntime().exec("grep PSP");
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));

                pw.print(TEXTO);
                pw.close();

                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                System.out.println(TEXT);

                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        }
```
## Explicacion de codigo Lanzador.java

### Constantes
- En esta parte explicare por que he realizado las dos contasntes que estan abajo.
  - La constante llamada **TEXTO** es la que tiene que leer el programa para que saque todas las lineas que contenga la palabra PSP y como es un string que tiene varias lineas creamos dicha constante tambien llamada text block.
  - La segunda constante llamada **text** la he creado para poner un texto y que no sea hardcode.
    ``` java 
    public class Lanzador {

    public static final String TEXTO = """
        Me gusta PSP y java
        PSP se programa en java
        es un módulo de DAM
        y se programa de forma concurrente en PSP
        PSP es programación.
        """;

    public static final String TEXT = "Linea psp";

    ```
### Main

#### Proceso
- En este apartado explicare que es lo que hace el proceso que he creado.
  - La accion del proceso consiste en que tiene que ejecutar el comando grep y que cuando lo ejecute tiene que **sacar todas las lineas que contengan la palabra psp**. Para ello cojera de referencia la constante llamada **TEXTO** donde alamacenará el texto que tiene que examinar.
```java
        Process p = Runtime.getRuntime().exec("grep PSP");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));

        pw.print(TEXTO);
        pw.close();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        System.out.println(TEXT);

```
> Una vez que finalizamos el proceso cerramos el printWriter


### Bucle
Por ultimo crearemos el bucle para que lea todas las lineas de la constante **TEXTO** y saque todas las lineas de la constante que contienen la palabra PSP.

```java
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
```