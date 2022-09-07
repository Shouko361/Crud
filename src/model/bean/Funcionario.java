/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author shouko3613
 */
public class Funcionario {
    private int id;
    private String name;
    private Departamento Dep;

    public Funcionario() {
    }

    public Funcionario(int Matricula, String Nome) {
        this.id = Matricula;
        this.name = Nome;
    }

    public int getMatricula() {
        return id;
    }

    public void setMatricula(int Matricula) {
        this.id = Matricula;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String Nome) {
        this.name = Nome;
    }

    public Departamento getDep() {
        return Dep;
    }

    public void setDep(Departamento Dep) {
        this.Dep = Dep;
    }
    
}
