import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivo {
    String[][] registros = new String[][]{{"Juan Perez", "Maria Lopez", "Luis Gomez"}, {"ABC123456789", "XYZ987654321", "LMN567890123"}, {"2020-01-01", "2019-03-15", "2021-06-10"}, {"9500", "10500", "12000"}};

    public Archivo() {
    }

    public void escribirInformacion() {
        try {
            FileWriter fichero = new FileWriter("empleados.txt");

            try {
                PrintWriter pw = new PrintWriter(fichero);

                for(int i = 0; i < this.registros[0].length; ++i) {
                    String var10001 = this.registros[0][i];
                    pw.println(var10001 + "," + this.registros[1][i] + "," + this.registros[2][i] + "," + this.registros[3][i]);
                }
            } catch (Throwable var5) {
                try {
                    fichero.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            fichero.close();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }
}
