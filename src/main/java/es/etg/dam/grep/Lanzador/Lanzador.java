package es.etg.dam.grep.Lanzador;

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

    public static void main(String[] args) throws Exception {
        Process p = Runtime.getRuntime().exec("grep PSP");
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));

        pw.print(TEXTO);
        pw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    }
}
