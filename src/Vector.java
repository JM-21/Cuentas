import java.util.Scanner;

public class Vector {
    private int n_cuentas;
    private Cuenta [] vecCuentas ;

    public Vector() {
    }

    public Vector(int capacidad){
        this.vecCuentas = new Cuenta[capacidad];
        this.n_cuentas = 0;
    }

    public int getN_cuentas() {
        return n_cuentas;
    }

    public void setN_cuentas(int n_cuentas) {
        this.n_cuentas = n_cuentas;
    }

    public Cuenta[] getVecCuentas() {
        return vecCuentas;
    }

    public void setVecCuentas(Cuenta[] vecCuentas) {
        this.vecCuentas = vecCuentas;
    }

    public void inserCuenta(Cuenta nuevaCuenta) {
        if (this.n_cuentas < this.vecCuentas.length) {
            this.vecCuentas[this.n_cuentas] = nuevaCuenta;
            this.n_cuentas++;
        }

    }

    public boolean searchCuenta(long num_cuenta){
        for (int i = 0; i <this.n_cuentas ; i++) {
            if (num_cuenta == this.vecCuentas[i].getNumCuenta() && this.vecCuentas[i].getEstado() != false) {
                return true;
            }else {
                System.out.println("Buscando...");
            }
        }
        System.out.println("Su cuenta se encuentra bloqueada o no ha sido activada, para mayor informacion comuniquese con el banco");
        return false;
    }

    public void redimensionarVec(int cantidad){
        Cuenta [] nuevoVector = new Cuenta[vecCuentas.length + cantidad];
        for (int i = 0; i < this.n_cuentas ; i++) {
            nuevoVector[i] = this.vecCuentas[i];
        }
        this.vecCuentas = nuevoVector;
    }
    public void promedio() {
        double suma = 0;
        for (int i = 0; i <this.n_cuentas ; i++) {
            suma = suma + this.vecCuentas[i].getSaldo();
        }
        double prom = suma / this.n_cuentas;
        System.out.println("Dinero promedio en las cuentas es de $" + prom);
    }

    public void deletCuenta(long num_cuenta){
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < this.vecCuentas.length ; i++) {
            if (num_cuenta == this.vecCuentas[i].getNumCuenta()){
                System.out.println("¿Seguro que desea borrar cuenta?");
                String confirmacion = entrada.nextLine();
                if (confirmacion.toLowerCase().equals("si")){
                    vecCuentas[i] = null;
                    System.out.println("Se elimino cuenta satisfactoriamente");
                    break;
                }
            }
        }
    }

    public boolean vec_vacio(){
        int capacidad =0;
        if (capacidad == this.vecCuentas.length){
            return true;
        }
        return false;
    }

    public boolean vec_lleno(){
        if (this.n_cuentas == this.vecCuentas.length){
            return true;
        }
        return false;
    }

    public void imprimirCuentas(){
        for (int i = 0; i < vecCuentas.length ; i++) {
            System.out.println(vecCuentas[i]);
        }
    }
}
