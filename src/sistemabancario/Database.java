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
        
        Cliente c2 = new Cliente();
        c2.setCpf("234234");
        c2.setNome("JohnDoe2");
        c2.setEmail("2john@doe.com");
        c2.setSenha("1234");
        c2.setReSenha("1234");
        c2.abrirConta(20);
        clientes.add(c2);
        
        Cliente c3 = new Cliente();
        c3.setCpf("234234");
        c3.setNome("JohnDoe3");
        c3.setEmail("3john@doe.com");
        c3.setSenha("1234");
        c3.setReSenha("1234");
        c3.abrirConta(30);
        clientes.add(c3);
        
        Cliente c4 = new Cliente();
        c4.setCpf("234234");
        c4.setNome("JohnDoe4");
        c4.setEmail("4john@doe.com");
        c4.setSenha("1234");
        c4.setReSenha("1234");
        c4.abrirConta(30);
        c4.abrirConta(20);
        clientes.add(c4);
        
        Cliente c5 = new Cliente();
        c5.setCpf("234234");
        c5.setNome("JohnDoe5");
        c5.setEmail("5john@doe.com");
        c5.setSenha("1234");
        c5.setReSenha("1234");
        c5.abrirConta(10);
        c5.abrirConta(20);
        clientes.add(c5);
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

