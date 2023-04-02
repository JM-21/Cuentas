import java.util.*;


public class ProgPPAL  {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int nume_cuentas = 0;
        System.out.println("Bienvenido al banco de estudiantes");
        System.out.println(" ");
        System.out.print("¿Cuantas cuentas desea crear?: ");
        nume_cuentas = entrada.nextInt();
        Vector cuentas = new Vector(nume_cuentas);
        for (int i = 0; i <nume_cuentas ; i++) {
            Cuenta nuevaCuenta = new Cuenta();
            nuevaCuenta.crearCuenta();
            cuentas.inserCuenta(nuevaCuenta);
            System.out.println("Cuenta guardada correctamente");
            System.out.println(" ");
        }

        System.out.println(" ");
        System.out.println("   -----  Menu -----  ");
        System.out.println("   1. Crear otra cuenta bancaria  ");
        System.out.println("   2. Consultar cuenta       ");
        System.out.println("   3. Retirar saldo          ");
        System.out.println("   4. Consignar saldo        ");
        System.out.println("   5. Eliminar cuenta        ");
        System.out.println("   6. Mostar todas las cuentas       ");
        System.out.println("   7.  Promedio de las cuentas        ");
        System.out.println("   0. Salir del menu         ");
        System.out.print("     Seleccione opcion: ");
        int op = entrada.nextInt();
        entrada.nextLine();
        System.out.println(" ");

        do {
            switch (op) {
                case 1:
                    Cuenta otraCuenta = new Cuenta();
                    cuentas.redimensionarVec(1);
                    otraCuenta.crearCuenta();
                    cuentas.inserCuenta(otraCuenta);
                    System.out.println("Cuenta guardada correctamente");
                    break;
                case 2:
                    System.out.print("Ingrese numero de cuenta a buscar: ");
                    long num_cuenta = entrada.nextLong();
                    cuentas.searchCuenta(num_cuenta);
                    if (cuentas.searchCuenta(num_cuenta) == true) {
                        Cuenta cuenta1 = new Cuenta();
                        for (int i = 0; i < cuentas.getN_cuentas(); i++) {
                            if (cuentas.getVecCuentas()[i].getNumCuenta() == num_cuenta) {
                                cuenta1 = cuentas.getVecCuentas()[i];
                                break;
                            }
                        }
                        cuenta1.consultarCuenta(cuenta1);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese numero de cuenta: ");
                    long num_cuenta3 = entrada.nextLong();
                    cuentas.searchCuenta(num_cuenta3);
                    if (cuentas.searchCuenta(num_cuenta3) == true) {
                        Cuenta cuenta = new Cuenta();
                        for (int i = 0; i < cuentas.getN_cuentas(); i++) {
                            if (cuentas.getVecCuentas()[i].getNumCuenta() == num_cuenta3) {
                                cuenta = cuentas.getVecCuentas()[i];
                            }
                        }
                        cuenta.retirarSaldo();
                    }
                    break;
                case 4:
                    System.out.print("Ingrese numero de cuenta: ");
                    long num_cuenta2 = entrada.nextLong();
                    cuentas.searchCuenta(num_cuenta2);
                    if (cuentas.searchCuenta(num_cuenta2) == true) {
                        Cuenta cuenta = new Cuenta();
                        for (int i = 0; i < cuentas.getN_cuentas(); i++) {
                            if (cuentas.getVecCuentas()[i].getNumCuenta() == num_cuenta2) {
                                cuenta = cuentas.getVecCuentas()[i];
                            }
                        }
                        cuenta.consignarSaldo(cuenta);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese numero de cuenta: ");
                    long num_cuenta4 = entrada.nextLong();
                    cuentas.searchCuenta(num_cuenta4);
                    if (cuentas.searchCuenta(num_cuenta4) == true) {
                        for (int i = 0; i < cuentas.getN_cuentas(); i++) {
                            if (cuentas.getVecCuentas()[i].getNumCuenta() == num_cuenta4) {
                                num_cuenta4 = cuentas.getVecCuentas()[i].getNumCuenta();
                            }
                        }
                        cuentas.deletCuenta(num_cuenta4);
                    }
                    break;
                case 6:
                    cuentas.imprimirCuentas();
                    break;
                case 7:
                    cuentas.promedio();
            }
            System.out.println(" ");
            System.out.println("   -----  Menu -----  ");
            System.out.println("   1. Crear cuenta bancaria  ");
            System.out.println("   2. Consultar cuenta       ");
            System.out.println("   3. Retirar saldo          ");
            System.out.println("   4. Consignar saldo       ");
            System.out.println("   5. Eliminar cuenta        ");
            System.out.println("   6. Mostrar todas las cuentas cuentas  ");
            System.out.println("   7. Promedio del dinero manejado por el banco ");
            System.out.println("   0. Salir del menu         ");
            System.out.print("     Seleccione opcion: ");
            op = entrada.nextInt();
        } while (op != 0);


    }

}