/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;

/**
 *
 * @author shouko3613
 */
public class Departamento {
    private int id;
    private String name;
    ArrayList<Funcionario> ListaFunc;

    public Departamento() {
        ListaFunc = new ArrayList();
    }

    public Departamento(int Codigo, String Nome) {
        this.id = Codigo;
        this.name = Nome;
        ListaFunc = new ArrayList();
    }

    public int getCodigo() {
        return id;
    }

    public void setCodigo(int Codigo) {
        this.id = Codigo;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String Nome) {
        this.name = Nome;
    }

    public ArrayList<Funcionario> getListaFunc() {
        return ListaFunc;
    }

    public void setListaFunc(ArrayList<Funcionario> ListaFunc) {
        this.ListaFunc = ListaFunc;
    }
    
    public void addFunc(Funcionario F){
        F.setDep(this);
        ListaFunc.add(F);
    }
}
