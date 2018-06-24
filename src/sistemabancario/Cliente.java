/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

/**
 *
 * @author Aluno
 */
public class Cliente extends Usuario{
    protected String cpf;
    protected Conta cCorrente = null;
    protected Conta cPoupanca = null;
    protected Conta cSalario = null;
   
    public Cliente(){
        cCorrente = null;
        cPoupanca = null;
        cSalario = null;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void abrirConta(int tipo){
        switch (tipo){
            case 10:
                ContaSalario contaSalario = new ContaSalario();
                contaSalario.setCliente(this);
                this.cSalario = contaSalario;
                break;
            case 20:
                ContaCorrente contaCorrente = new ContaCorrente();
                contaCorrente.setCliente(this);
                this.cCorrente = contaCorrente;
                break;
            case 30: 
                ContaPoupanca contaPoupanca = new ContaPoupanca();
                contaPoupanca.setCliente(this);
                this.cPoupanca = contaPoupanca;
                break;
        }  
    }
    
    public Conta getConta(int tipo){
        if (tipo== 10) return this.cSalario;
        if (tipo== 20) return this.cCorrente;
        if (tipo== 30) return this.cPoupanca;
        
        return null;
    }

    @Override
    public String toString() {
        String txt = "";
        if (this.getConta(10)!=null){
            txt+=" Salario:" + this.getConta(10);
        }
        if (this.getConta(20)!=null){
            txt+=" Corrente:" + this.getConta(20);
        }
        if (this.getConta(30)!=null){
            txt+=" Poupanca:" + this.getConta(30);
        }
        return "Cliente{Nome: " +this.nome + txt +'}';
    }
    
}
