package cp.abb.entities;

public class Cliente {
    private String nome;
    private String cpfCnpj;
    private int numeroConta;
    private String tipoConta;
    private double saldo;

    public Cliente(String nome, String cpfCnpj, int numeroConta, String tipoConta, double saldo) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
