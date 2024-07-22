public class Empleado {
    private String nombre;
    private String rfc;
    private String fechaIngreso;
    private double sueldo;

    public Empleado(String nombre, String rfc, String fechaIngreso, double sueldo) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", rfc='" + rfc + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
