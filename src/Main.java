
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();
        Scanner scanner = new Scanner(System.in);
        Archivo archivo = new Archivo();
        archivo.escribirInformacion();
        gestionEmpleados.cargarDesdeArchivo("empleados.txt");

        label27:
        while(true) {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Mostrar todos los empleados");
            System.out.println("2. Alta de un nuevo empleado");
            System.out.println("3. Eliminar un empleado");
            System.out.println("4. Buscar un empleado por RFC");
            System.out.println("5. Buscar empleados con sueldo mayor a $10,000");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Todos los empleados:");
                    gestionEmpleados.mostrarEmpleados();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el RFC del empleado: ");
                    String rfc = scanner.nextLine();
                    System.out.print("Ingrese la fecha de ingreso del empleado (YYYY-MM-DD): ");
                    String fechaIngreso = scanner.nextLine();
                    System.out.print("Ingrese el sueldo del empleado: ");
                    double sueldo = scanner.nextDouble();
                    scanner.nextLine();
                    Empleado nuevoEmpleado = new Empleado(nombre, rfc, fechaIngreso, sueldo);
                    gestionEmpleados.altaEmpleado(nuevoEmpleado);
                    System.out.println("Empleado agregado exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese el RFC del empleado a eliminar: ");
                    String rfcEliminar = scanner.nextLine();
                    gestionEmpleados.eliminarEmpleado(rfcEliminar);
                    System.out.println("Empleado eliminado exitosamente.");
                    break;
                case 4:
                    System.out.print("Ingrese el RFC del empleado a buscar: ");
                    String rfcBuscar = scanner.nextLine();
                    Empleado empleado = gestionEmpleados.buscarEmpleado(rfcBuscar);
                    if (empleado != null) {
                        System.out.println(empleado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Empleados con sueldo mayor a $10,000:");
                    List<Empleado> empleadosConSueldoAlto = gestionEmpleados.empleadosConSueldoMayorA(10000.0);
                    Iterator var15 = empleadosConSueldoAlto.iterator();

                    while(true) {
                        if (!var15.hasNext()) {
                            continue label27;
                        }

                        Empleado emp = (Empleado)var15.next();
                        System.out.println(emp);
                    }
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
