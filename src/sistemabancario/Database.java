/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.util.ArrayList;

/**
 *
 * @author majinbuzz
 */
public class Database {
  private static Database instance;


  public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
  public ArrayList<Conta> contas = new ArrayList<Conta>();
  public ArrayList<Empregado> empregados = new ArrayList<Empregado>();
  public Cliente clienteAtivo ;

  static {
    instance = new Database();
  }

  Database() { 
    // hidden constructor
        Gerente gerente = new Gerente();
        gerente.setNome("Patrão");
        empregados.add(gerente);
        Agencia agencia = new Agencia();
        agencia.setGerente(gerente);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Ehentao");
        funcionario.setGerente(gerente);
        empregados.add(funcionario);
        
        Seguranca seguranca = new Seguranca();
        seguranca.setNome("Boladão");
        seguranca.setTurno(0);
        empregados.add(seguranca);
  }    

  public static Database getInstance() {
    return instance;
  }
  
      public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public Cliente getClienteAtivo() {
        return clienteAtivo;
    }

    public void setClienteAtivo(Cliente clienteAtivo) {
        this.clienteAtivo = clienteAtivo;
    }

    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(ArrayList<Empregado> empregados) {
        this.empregados = empregados;
    }
    
}

