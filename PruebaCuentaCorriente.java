import java.util.Scanner;

public class PruebaCuentaCorriente {
    public static void main(String[] args) {
        CuentaCorriente[] Banco1 = CuentaCorriente.crearCC("banco1.txt");
        System.out.println();
        System.out.println("Datos Banco1");
        for (int i = 0; i < Banco1.length; i++) {
            System.out.println(Banco1[i].getTitular() + "Saldo:" + Banco1[i].getSaldo());
        }
        Scanner entrada = new Scanner(System.in);
        System.out.print("Saldo:");
        int saldo = Integer.parseInt(entrada.nextLine());
        saldoMayor(Banco1, saldo);
    }

    public static void saldoMayor(CuentaCorriente[] Banco, int saldo){
        System.out.println("clientes con saldo mayor " + saldo);

        int i = 0;

        while (i < Banco.length) {
            CuentaCorriente cuentaCorriente = Banco[i];
            if (cuentaCorriente.getSaldo() > saldo){
                System.out.println(cuentaCorriente.getTitular() + "  Saldo:" + cuentaCorriente.getSaldo());
            }
            i++;
        }
    }

    
}
