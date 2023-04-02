import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Cuenta {
    private String titular;
    private long numCuenta;
    private int clave;
    private double saldo;
    private boolean estado;
    private Date ultTransc;

    public Cuenta() {
    }

    public Cuenta(String n, long nc, int clave, double sd, boolean estd, Date fc) {
        this.titular = n;
        this.numCuenta = nc;
        this.clave = clave;
        this.saldo = sd;
        this.estado = estd;
        this.ultTransc = fc;
    }

    public String getTitular() {
        return titular;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }


    public void setTitular(String titular) {
        this.titular = titular;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getUltTransc() {
        return ultTransc;
    }

    public void setUltTransc(Date ultTransc) {
        this.ultTransc = ultTransc;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", numCuenta=" + numCuenta +
                ", clave=" + clave +
                ", saldo=" + saldo +
                ", estado=" + estado +
                ", ultTransc=" + ultTransc +
                '}';
    }

    public Cuenta crearCuenta() {
        Random nuCuenta = new Random();
        Long cuenta = 0L;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Creando cuenta");
        System.out.println(" ");
        System.out.print("Ingresa nombre del estudiante: ");
        this.titular = entrada.nextLine();
        while (titular.equals(" ") || !titular.matches("^[a-zA-Z\\s]+$")) {
            System.out.print("Ingresa nombre del estudiante valido: ");
            titular = entrada.nextLine();
        }
        System.out.print("Ingrese saldo inicial $");
        this.saldo = entrada.nextDouble();
        System.out.println("Por favor clave de 4 digitos numericos 0-9");
        System.out.print("Ingrese clave: ");
        this.clave = entrada.nextInt();
        entrada.nextLine();
        while (String.valueOf(clave).length() != 4 && !String.valueOf(clave).matches("[0-9]+")) {
            System.out.print("ingrese clave valida: ");
            this.clave = entrada.nextInt();
        }
        this.numCuenta = nuCuenta.nextLong(1000000000L);
        System.out.println("Su numero de cuenta es: " + this.numCuenta);
        System.out.println("Estado de cuenta activa");
        this.estado = true;
        this.ultTransc = Date.from(Instant.now());
        System.out.println("Fecha de registro de la cuenta: " + this.ultTransc);
        return this;
    }


    public void consultarCuenta(Cuenta cuenta) {
        System.out.println("Nombre del titular: " + cuenta.getTitular());
        System.out.println("Numero de la cuenta: " + cuenta.getNumCuenta());
        System.out.println("Saldo ***********");
        if (cuenta.getEstado()) {
            String activa = "Activa";
            System.out.println("Estado de la cuenta: " + activa);
        } else {
            System.out.println("Estado de la cuenta: Inactiva");
        }
        System.out.println("Fecha de la ultima transacion: " + cuenta.getUltTransc());
    }


    public void retirarSaldo() {
        Scanner entrada = new Scanner(System.in);
        int intentos = 3;
        int clave = 0;
        while (intentos != 0) {
            System.out.print("Ingrese clave: ");
            clave = entrada.nextInt();
            while (String.valueOf(clave).length() != 4 && !String.valueOf(clave).matches("[0-9]+")) {
                System.out.print("Ingrese clave valida: ");
                this.clave = entrada.nextInt();
            }
            if (clave == getClave()) {
                double saldoCuenta = getSaldo();
                System.out.println("Su saldo actual es $" + saldoCuenta);
                System.out.print("Cuanto dinero deseas retirar: ");
                double valor = entrada.nextDouble();
                entrada.nextLine();
                if (valor > saldoCuenta) {
                    System.out.println("Su cuenta ha sido bloqueada");
                    setEstado(false);
                } else if (valor <= saldoCuenta) {
                    double saldoNuevo = saldoCuenta - valor;
                    System.out.println("Su retiro por el valor de $" + valor + " ha sido exitoso");
                    System.out.println("El nuevo saldo de su cuenta es de: " + saldoNuevo);
                    setSaldo(saldoNuevo);
                }
                System.out.println("Transacion finalizada");
                break;
            } else {
                System.out.println("Clave incorrecta, intente nuevamente");
                intentos--;
                System.out.println("Intentos restantes: " + intentos);
            }
        }
    }

    public void consignarSaldo(Cuenta cuenta) {
        Scanner entrada = new Scanner(System.in);
        int intentos = 3;
        while (intentos >= 0) {
            System.out.print("Ingrese clave: ");
            int claveConsultar = entrada.nextInt();
            while (String.valueOf(clave).length() != 4 && !String.valueOf(clave).matches("[0-9]+")) {
                System.out.print("Ingrese clave valida: ");
                claveConsultar = entrada.nextInt();
                intentos--;
            }
            if (claveConsultar == cuenta.getClave()) {
                double saldoCuenta = cuenta.getSaldo();
                System.out.print("Cuanto dinero deseas consignar $");
                double valor = entrada.nextDouble();
                entrada.nextLine();
                double saldoNuevo = valor + saldoCuenta;
                cuenta.setSaldo(saldoNuevo);
                System.out.println("Su saldo actual es $" + saldoCuenta);
            } else {
                System.out.println("Contraseña incorrecta, verifique e intente nuevamente");
                intentos--;
                System.out.println("Intentos restantes: " + (intentos + 1));
                System.out.println(" ");
            }
        }
    }


}



