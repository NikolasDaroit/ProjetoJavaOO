/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Aluno
 */
class ContaSalario extends Conta{

  

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numero) {
        this.numeroConta = numero;
    }

    public static AtomicLong getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(AtomicLong idCounter) {
        ContaSalario.idCounter = idCounter;
    }
    
    protected String numeroConta = createID();//UUID.randomUUID().toString();
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
    public ContaSalario(){
        saldo = 0;
    }
   

    @Override
    public String toString() {
        return "ContaSalario{" + "saldo=" + saldo + ", numeroConta=" + numeroConta + '}';
    }
    
}
