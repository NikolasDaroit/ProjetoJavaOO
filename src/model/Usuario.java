    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Aluno
 */
public class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected String reSenha;
    protected String uniqueID = createID();//UUID.randomUUID().toString();
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
    public String getUniqueID() {
        return uniqueID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getReSenha() {
        return reSenha;
    }

    public void setReSenha(String reSenha) {
        this.reSenha = reSenha;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{Nome: " +this.nome+ " Email: "+this.email+"}";
    }
}
