import java.util.Scanner;

public class App {
    static double promedio;
    static int opcion;
    static String nombre;
    static double notas[] = new double[3];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            opcion = MostrarElMenu(scanner);

            switch (opcion) {
                case 1:
                    RegistrarInformacion(scanner);
                    break;
                case 2:
                    MostrarInfo();
                    break;
                case 3:
                    promedio = CalcularPromedio(notas);
                    System.out.printf("Con un promedio de : %.2f ", promedio);
                    break;
                case 4:
                    RegistrarInformacion(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del menu");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 0);

        scanner.close();

    }

    public static int MostrarElMenu(Scanner scanner) {// Se muestra el menu y se lee la opcion del usuario//

        System.out.println("""


                --- Sistema de Registro de Estudiantes ---

                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante actual
                3. Calcular promedio de notas del estudiante actual
                4. Sobrescribir los datos anteriores y registrar un nuevo estudiante
                0. Salir
                Ingrese su opción:     """);

        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public static double[] RegistrarInformacion(Scanner scanner) {

        do {
            System.out.println("Ingrese el nombre del estudiante: ");
            nombre = scanner.nextLine();
            if (ValidarNombre(nombre) == false) {
                System.out.println("Nombre invalido vuelva a ingresar el nombre");
            }
        } while (ValidarNombre(nombre) == false);

        for (int i = 0; i < 3; i++) {
            double nota;
            do {
                System.out.println("Ingrese la nota " + (i + 1) + " del estudiante");
                nota= scanner.nextDouble();
                scanner.nextLine();

                if (ValidarNotas(nota) == false) {
                    System.out.println("Nota "+(i+1)+" invalida vuelva a ingresarla ");
                }
            } while (ValidarNotas(nota)==false);
            notas[i]=nota;
        }
        System.out.println("----Estudiante registrado exitosamente-----");
        return notas;
    }

    public static void MostrarInfo() {

        if (nombre == null) {
            System.out.println("-----No se ha registrado ningun estudiante------- ");
        } else {
            System.out.println("-----El nombre del estudiante es:" + nombre + " ----");
            for (int i = 0; i < 3; i++) {
                System.out.println("----La nota " + (i + 1) + " del estudiante es:-----");
                System.out.println(notas[i]);
            }
        }
    }

    public static double CalcularPromedio(double[] notas) {
        double suma = 0;
        for (int i = 0; i < 3; i++) {
            suma += notas[i];
        }
        promedio = suma / 3;
        String mensaje= (ValidarNotas(promedio)==false) ? "El estudiante no aprobo":"El estudiante aprobo";
        System.out.println(mensaje);
        return promedio;
    }

    public static boolean ValidarNombre(String nombre) {

        if (nombre == null) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean ValidarNotas(double nota) {

        if (nota<0.0 || nota>5.0) {
            return false;
        }
        else{
        return true;}
    }

    public static boolean EstudianteAprobo(double promedio){
        if (promedio<3.0) {
            return false;
        }
        else{
            return true;
        }

    }




}
