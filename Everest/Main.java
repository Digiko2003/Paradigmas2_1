package Everest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("muertes_everest.txt"));

        List<Persona> listaPersonas = new ArrayList<>();

        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split("\\|");
            String nombre = fields[0];
            String fecha = fields[1];
            double edad = Double.parseDouble(fields[2]);
            String expedicion = fields[3];
            String nacionalidad = fields[4];
            String causaDeMuerte = fields[5];
            String ubicacion = fields[6];

            Persona persona = new Persona(nombre, fecha, edad, expedicion, nacionalidad, causaDeMuerte, ubicacion);
            listaPersonas.add(persona);

            line = reader.readLine();
        }

        // Agrupación de personas por nacionalidad

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Personas por nacionalidad:");

        Map<String, List<Persona>> agrupadoPorNacionalidad = listaPersonas.stream().collect(Collectors.groupingBy(Persona::getNacionalidad));
        imprimirEncabezado();
        agrupadoPorNacionalidad.forEach((nacionalidad, personasPorNacionalidad) -> {
            System.out.println(nacionalidad);
            printPersonasEnColumnas(personasPorNacionalidad);
            imprimirRenglon();
        });

        // Agrupación de personas por causa de muerte
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Personas por causa de muerte:");

        Map<String, List<Persona>> agrupadoPorCausaDeMuerte = listaPersonas.stream().collect(Collectors.groupingBy(Persona::getCausaDeMuerte));
        imprimirEncabezado();
        agrupadoPorCausaDeMuerte.forEach((causaDeMuerte, personasPorCausaDeMuerte) -> {
            System.out.println(causaDeMuerte);
            printPersonasEnColumnas(personasPorCausaDeMuerte);
            imprimirRenglon();
        });

        // Agrupación de personas por ubicación
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Personas por ubicación:");
        Map<String, List<Persona>> agrupadoPorUbicacion = listaPersonas.stream().collect(Collectors.groupingBy(Persona::getUbicacion));
        imprimirEncabezado();
        agrupadoPorUbicacion.forEach((ubicacion, personasPorUbicacion) -> {
            System.out.println(ubicacion);
            printPersonasEnColumnas(personasPorUbicacion);
            imprimirRenglon();
        });

        reader.close();
    }

    public static void printPersonasEnColumnas(List<Persona> personas) {
        personas.forEach(persona -> System.out.printf("%25s %25s %11s %45s%n", persona.getNombre(), persona.getFecha(), persona.getEdad(), persona.getExpedicion()));
    }

    public static void imprimirRenglon() {
        System.out.println("----------     ----------     ----------     ----------     ----------     ----------     -----------");
    }

    public static void imprimirEncabezado() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("%22s %22s %17s %22s%n", "Nombre", "Fecha", "Edad", "Expedición");
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }
}





