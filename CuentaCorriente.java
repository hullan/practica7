import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

public class CuentaCorriente {
    private String _titular;
    private int _saldo;

    public CuentaCorriente(String t, int s) {
        this._titular = t;
        this._saldo = s;
    }

    public void setTitular(String t) {
        this._titular = t;
    }

    public void setSaldo(int s) {
        this._saldo = s;
    }

    public String getTitular() {
        return _titular;
    }

    public int getSaldo() {
        return _saldo;
    }

    public static CuentaCorriente[] crearCC (String fileName){
        CuentaCorriente[] cuentaCorrientes;
        try{
            Scanner fichero = new Scanner(new FileReader(fileName));

            cuentaCorrientes = new CuentaCorriente[Integer.parseInt(fichero.nextLine())];
            int p = 0;
            while(fichero.hasNext()) {
                String linea = fichero.nextLine().trim().replaceAll(" +", " ");
                String[] datos = linea.split(" ");
                int movimientos = Integer.parseInt(datos[0]);
                int saldo = 0;
                int i = 1;
                while (i <= movimientos) {
                    saldo = saldo + Integer.parseInt(datos[i]);
                    i++;
                }
                int j = movimientos + 1;
                String cliente = "";
                while (j < datos.length) {
                    cliente = cliente + datos[j] + "";
                    j++;
                }
                cuentaCorrientes[p] = new CuentaCorriente(cliente, saldo);
                p++;
            }

            fichero.close();
            return cuentaCorrientes;
        }catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
}