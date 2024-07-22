<<<<<<< HEAD
public class GestionEmpleados {

=======

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestionEmpleados {
    private Map<String, Empleado> empleados = new HashMap();

    public GestionEmpleados() {
    }

    public void altaEmpleado(Empleado empleado) {
        this.empleados.put(empleado.getRfc(), empleado);
    }

    public void eliminarEmpleado(String rfc) {
        this.empleados.remove(rfc);
    }

    public Empleado buscarEmpleado(String rfc) {
        return (Empleado)this.empleados.get(rfc);
    }

    public List<Empleado> empleadosConSueldoMayorA(double sueldo) {
        List<Empleado> resultado = new ArrayList();
        Iterator var4 = this.empleados.values().iterator();

        while(var4.hasNext()) {
            Empleado empleado = (Empleado)var4.next();
            if (empleado.getSueldo() > sueldo) {
                resultado.add(empleado);
            }
        }

        return resultado;
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));

            String linea;
            try {
                while((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    String nombre = datos[0];
                    String rfc = datos[1];
                    String fechaIngreso = datos[2];
                    double sueldo = Double.parseDouble(datos[3]);
                    Empleado empleado = new Empleado(nombre, rfc, fechaIngreso, sueldo);
                    this.altaEmpleado(empleado);
                }
            } catch (Throwable var12) {
                try {
                    br.close();
                } catch (Throwable var11) {
                    var12.addSuppressed(var11);
                }

                throw var12;
            }

            br.close();
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }

    public void mostrarEmpleados() {
        Iterator var1 = this.empleados.values().iterator();

        while(var1.hasNext()) {
            Empleado empleado = (Empleado)var1.next();
            System.out.println(empleado);
        }

    }
>>>>>>> fe5e474 (Integracion de la clase Archivo, y funcionalidades del main)
}
