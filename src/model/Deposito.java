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
public class Deposito extends CaixaEletronico{
    protected double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void depositar(double valor){
        //TODO
    }

    @Override
    public String toString() {
        return "Deposito{" + "valor=" + valor + '}';
    }
    
}
