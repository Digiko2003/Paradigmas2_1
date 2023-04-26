package Everest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Menu {

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

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("                                   MENU");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1. Mostrar nombre y nacionalidad deaquellas personasque pertenezcan a United Kingdom.");
            System.out.println("2. Mostrar nombre y edad de aquellas personascuyaedadesté entre 18y 21");
            System.out.println("3. Mostrar nombre y edadde laspersonasque no sean menores a los 50 años.");
            System.out.println("4. Mostrar nombre, edady nacionalidadde laspersonasque tengan 25añoso que sean de nacionalidad mexicana");
            System.out.println("5. Mostrar nombre y causa de muerte de las personascuyos nombres empiecen con esa letra.");
            System.out.println("6. Mostrar nombre y causa de muertede todas las personasen orden ascendente según causa de muerte.");
            System.out.println("7. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();


                switch (opcion) {
                    case 1:
                        // 1) Mostrar nombre y nacionalidad de aquellas personas que pertenezcan a United Kingdom
                        Predicate<Persona> deReinoUnido = persona -> persona.getNacionalidad().equals("United Kingdom");
                        List<Persona> personasDeReinoUnido = listaPersonas.stream()
                                .filter(deReinoUnido)
                                .collect(Collectors.toList());
                        System.out.println("Personas de United Kingdom:");
                        personasDeReinoUnido.forEach(persona -> System.out.println(persona.getNombre() + ", " + persona.getNacionalidad()));
                        break;
                    case 2:
                        // 2) Mostrar nombre y edad de aquellas personas cuya edad esté entre 18 y 21
                        Predicate<Persona> entre18y21 = persona -> persona.getEdad() >= 18 && persona.getEdad() <= 21;
                        List<Persona> personasEntre18y21 = listaPersonas.stream()
                                .filter(entre18y21)
                                .collect(Collectors.toList());
                        System.out.println("\nPersonas entre 18 y 21 años:");
                        personasEntre18y21.forEach(persona -> System.out.println(persona.getNombre() + ", " + persona.getEdad()));
                        break;
                    case 3:
                        // 3) Mostrar nombre y edad de las personas que no sean menores a 50 años
                        Predicate<Persona> noMenoresDe50 = persona -> persona.getEdad() >= 50;
                        List<Persona> personasNoMenoresDe50 = listaPersonas.stream()
                                .filter(noMenoresDe50)
                                .collect(Collectors.toList());
                        System.out.println("\nPersonas no menores de 50 años:");
                        personasNoMenoresDe50.forEach(persona -> System.out.println(persona.getNombre() + ", " + persona.getEdad()));
                        break;
                    case 4:
                        // 4) Mostrar nombre, edad y nacionalidad de las personas que tengan 25 años o que sean de nacionalidad mexicana
                        // 4) Mostrar nombre, edad y nacionalidad de las personas que tengan 25 años o que sean de nacionalidad mexicana
                        Predicate<Persona> nacionalidadMexicana = persona -> persona.getNacionalidad().equalsIgnoreCase("Mexican");
                        Predicate<Persona> edad25 = persona -> persona.getEdad() == 25;
                        Predicate<Persona> condicion4 = nacionalidadMexicana.or(edad25);

                        System.out.println("Personas con 25 años o de nacionalidad mexicana: ");
                        listaPersonas.stream()
                                .filter(condicion4)
                                .forEach(System.out::println);
                        System.out.println();


                        break;
                    case 5:
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
                        break;
                    case 6:
                        // 6) Mostrar nombre y causa de muerte de todas las personas en orden ascendente según causa de muerte
                        Comparator<Persona> ordenarPorCausaDeMuerte = Comparator.comparing(Persona::getCausaDeMuerte);
                        System.out.println("Personas ordenadas por causa de muerte: ");
                        listaPersonas.stream()
                                .sorted(ordenarPorCausaDeMuerte)
                                .forEach(persona -> System.out.println(persona.getNombre() + " - " + persona.getCausaDeMuerte()));
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 7");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}