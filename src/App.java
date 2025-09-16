import java.util.Scanner;

public class App {
    static double promedio;
    static int opcion;
    static String nombre;
    static double notas[]= new double[3];


    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

 do{
        opcion =MostrarElMenu(scanner);

        switch (opcion) {
        case 1:
            RegistrarInformacion(scanner);
            break;

        case 2: 
            MostrarInfo();
            break;
        case 3:

            promedio=CalcularPromedio(notas);
            System.out.printf("El promedio de las notas del estudiante es: %.2f ",promedio);
            break;
        case 0:
          System.out.println("Saliendo del menu");
                break;
        default:
          System.out.println("Opcion invalida");
            break;
       }
    } while (opcion!=0); 
        
    
    scanner.close();
     

    }


public static int MostrarElMenu(Scanner scanner){// Se muestra el menu y se lee la opcion del usuario//
   
 System.out.println("""  


    --- Sistema de Registro de Estudiantes ---

    1. Registrar datos de un estudiante
    2. Mostrar datos del estudiante actual
    3. Calcular promedio de notas del estudiante actual
    0. Salir
    Ingrese su opción:     """);

        opcion= scanner.nextInt();
        scanner.nextLine();
        return opcion;
}

public static double[] RegistrarInformacion(Scanner scanner){

    System.out.println("Ingrese el nombre del estudiante: ");
    nombre= scanner.nextLine();
    for (int i = 0; i < 3; i++) {
        System.out.println("Ingrese la nota "+(i+1)+" del estudiante");
        notas[i]= scanner.nextDouble();
        scanner.nextLine();
    }
    System.out.println("----Estudiante registrado exitosamente-----");
  return notas;
}

public static void MostrarInfo(){

if (nombre==null) {
    System.out.println("-----No se ha registrado ningun estudiante------- ");
}else {
    System.out.println("-----El nombre del estudiante es:"+ nombre+" ----" );
    for (int i = 0; i < 3; i++) {
        System.out.println("----La nota "+(i+1)+" del estudiante es:-----");
        System.out.println(notas[i]);
    }
}
} 


public static double CalcularPromedio(double[] notas) {
    double suma=0;
    for (int i = 0; i < 3; i++) {
        suma += notas[i] ; 
}
promedio= suma/3;
return promedio;
}

}