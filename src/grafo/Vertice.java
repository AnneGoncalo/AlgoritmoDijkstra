/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author Ana Gonçalo
 */
public class Vertice {
    private String chave;
    private String valor;
    private int grau;
    
    private Vertice ant;
    private int dist;

    public Vertice(String valor){
        this.valor = valor;
    }
    
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public Vertice getAnt() {
        return ant;
    }

    public void setAnt(Vertice ant) {
        this.ant = ant;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }
    
}
