import java.util.Scanner;

public class App {
    static double promedio;
    static int opcion;
    static String nombre;
    static double notas[] = new double[3];

    public static void main(String[] args) {// Aqui se ejecuta la opcion que el usuario ingreso llamando a el metodo correspondiente
                                                 
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
                case 5:
                    BorrarDatos();
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

    public static int MostrarElMenu(Scanner scanner) {// Se muestra el menu y se lee la opcion del usuario

        System.out.println("""


                --- Sistema de Registro de Estudiantes ---

                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante actual
                3. Calcular promedio de notas del estudiante actual
                4. Sobrescribir los datos anteriores y registrar un nuevo estudiante
                5. Borrar los datos del estudiante
                0. Salir
                Ingrese su opción:     """);

        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public static double[] RegistrarInformacion(Scanner scanner) {// Aqui se le piden los datos al usuario y se guardan
       
        String confirmar;//Estas dos variables se utilizan para validar si el usuario si quiere registrar los datos
        boolean registrar;
        do{
        do {
            System.out.println("Ingrese el nombre del estudiante: "); //El nombre se guarda en una variable mientras que las notas en un arreglo
            nombre = scanner.nextLine();
            if (ValidarNombre(nombre) == false) { //Se llama el método ValidarNombre y se valida
                System.out.println("Nombre invalido vuelva a ingresar el nombre");
            }
        } while (ValidarNombre(nombre) == false);

        for (int i = 0; i < 3; i++) {
            double nota;
            do {// Se guardan las notas en una variable para validarlos antes de pasarlos al arreglo
                System.out.println("Ingrese la nota " + (i + 1) + " del estudiante");
                nota= scanner.nextDouble();
                scanner.nextLine();

                if (ValidarNotas(nota) == false) { // Se llama el método ValidarNotas y se valida
                    System.out.println("Nota "+(i+1)+" invalida vuelva a ingresarla ");
                }
            } while (ValidarNotas(nota)==false);
            notas[i]=nota;// Se pasa la nota al arreglo 
        }
        System.out.println("--- Resumen Datos guardados---");////Si son correctos se le muestra al usuario qué ingreso
        System.out.println("--- Nombre del estudiante: "+nombre+" ---");
        //Y se le pregunta si desea registrar los datos
        for(int i = 0; i < 3; i++){
            System.out.println("----La nota " + (i + 1) + " del estudiante es:-----");
            System.out.println(notas[i]);
        }
        System.out.println( """
                ¿Los datos son correctos desea registrar al estudiante? 
                si/ cualquier otra palabra no y se volveran a pedir los datos""");
        confirmar=scanner.nextLine();
        if (confirmar.equals("si")) {
            registrar= true;
        }else{
            registrar= false;
        }
    } while (registrar==false);
            
      System.out.println("----Estudiante registrado exitosamente-----");
        return notas;
    }

    public static void MostrarInfo() { //Se muestran los datos registrados

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

    public static double CalcularPromedio(double[] notas) {//Se hace un promedio de las notas
        double suma = 0;
        for (int i = 0; i < 3; i++) {
            suma += notas[i];
        }
        promedio = suma / 3;
        // Se llama al método EstudianteAprobo que devuelve un boolean para con un operador tenario mostrar un mensaje
        String mensaje= (EstudianteAprobo(promedio)) ? "El estudiante aprobo":"El estudiante no aprobo";
        System.out.println(mensaje);
        return promedio;
    }

    public static boolean ValidarNombre(String nombre) {// Se valida que la variable nombre no este vacia

        if (nombre == null) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean ValidarNotas(double nota) {//Se valida que la variable nota este en un rango 

        if (nota<=0.0 || nota>5.0)  {
            return false;
        }
        else{
        return true;}
    }

    public static boolean EstudianteAprobo(double promedio){// Se valida que el promedio este por encima de 3,0
        if (promedio<3.0) {
            return false;
        }
        else{
            return true;
        }

    }

    public static void BorrarDatos(){ // Se borran los datos

nombre= null;
notas[0]=0.0;
notas[1]=0.0;
notas[2]=0.0;
System.out.println("Se borraron los datos del estudiante actual");
}


}
