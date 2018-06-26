/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public abstract class Conta {
   protected int tipo; //10 salario //20 poupanca //30 corrente
   protected Cliente cliente;
   protected double saldo;
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
   public Conta(){
     saldo = 0;
    }
    public void deposita(double val){
      this.saldo += val; 
    }
    public void retira(double val){
        if (this.saldo >= val){
            this.saldo -= val;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta{" + "tipo=" + tipo + ", cliente=" + cliente + '}';
    }

    

    
    
}
