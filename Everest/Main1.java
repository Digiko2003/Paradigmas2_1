package Everest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main1 {
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

        // 1) Mostrar nombre y nacionalidad de aquellas personas que pertenezcan a United Kingdom
        Predicate<Persona> deReinoUnido = persona -> persona.getNacionalidad().equals("United Kingdom");
        List<Persona> personasDeReinoUnido = listaPersonas.stream()
                .filter(deReinoUnido)
                .collect(Collectors.toList());
        System.out.println("Personas de United Kingdom:");
        personasDeReinoUnido.forEach(persona -> System.out.println(persona.getNombre() + ", " + persona.getNacionalidad()));

        // 2) Mostrar nombre y edad de aquellas personas cuya edad esté entre 18 y 21
        Predicate<Persona> entre18y21 = persona -> persona.getEdad() >= 18 && persona.getEdad() <= 21;
        List<Persona> personasEntre18y21 = listaPersonas.stream()
                .filter(entre18y21)
                .collect(Collectors.toList());
        System.out.println("\nPersonas entre 18 y 21 años:");
        personasEntre18y21.forEach(persona -> System.out.println(persona.getNombre() + ", " + persona.getEdad()));

        // 3) Mostrar nombre y edad de las personas que no sean menores a 50 años
        Predicate<Persona> noMenoresDe50 = persona -> persona.getEdad() >= 50;
        List<Persona> personasNoMenoresDe50 = listaPersonas.stream()
                .filter(noMenoresDe50)
                .collect(Collectors.toList());
        System.out.println("\nPersonas no menores de 50 años:");
        personasNoMenoresDe50.forEach(persona -> System.out.println(persona.getNombre() + ", " + persona.getEdad()));

        // 4) Mostrar nombre, edad y nacionalidad de las personas que tengan 25 años o que sean de nacionalidad mexicana
        Predicate<Persona> nacionalidadMexicana = persona -> persona.getNacionalidad().equals("Mexican");
        Predicate<Persona> edad25 = persona -> persona.getEdad() == 25;
        Predicate<Persona> condicion4 = nacionalidadMexicana.or(edad25);

        System.out.println("Personas con 25 años o de nacionalidad mexicana: ");
        listaPersonas.stream()
                .filter(condicion4)
                .forEach(System.out::println);
        System.out.println();

        // 5) Pedir una letra. Mostrar nombre y causa de muerte de las personas cuyos nombres empiecen con esa letra
        System.out.print("Ingresa una letra: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letra = br.readLine().toLowerCase();

        Predicate<Persona> empiezaConLetra = persona -> persona.getNombre().toLowerCase().startsWith(letra);
        System.out.println("Personas cuyos nombres empiezan con la letra " + letra + ": ");
        listaPersonas.stream()
                .filter(empiezaConLetra)
                .forEach(persona -> System.out.println(persona.getNombre() + " - " + persona.getCausaDeMuerte()));
        System.out.println();

        // 6) Mostrar nombre y causa de muerte de todas las personas en orden ascendente según causa de muerte
        Comparator<Persona> ordenarPorCausaDeMuerte = Comparator.comparing(Persona::getCausaDeMuerte);
        System.out.println("Personas ordenadas por causa de muerte: ");
        listaPersonas.stream()
                .sorted(ordenarPorCausaDeMuerte)
                .forEach(persona -> System.out.println(persona.getNombre() + " - " + persona.getCausaDeMuerte()));
    }
}
