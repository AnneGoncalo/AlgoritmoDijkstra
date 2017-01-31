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
public class Aresta {
    private Vertice v;          //inicial
    private Vertice w;          //final
    private boolean orientado;
    private String valor;
    private int custo;
    
    public Aresta(Vertice v, Vertice w){
        this.v = v;
        this.w = w;
        orientado = false;
    }
    public Aresta(Vertice v, Vertice w, boolean orientado){
        this.v = v;
        this.w = w;
        this.orientado = orientado;
    }

    public Vertice getV() {
        return v;
    }

    public void setV(Vertice v) {
        this.v = v;
    }

    public Vertice getW() {
        return w;
    }

    public void setW(Vertice w) {
        this.w = w;
    }

    public boolean isOrientado() {
        return orientado;
    }

    public void setOrientado(boolean orientado) {
        this.orientado = orientado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Boolean hasVertice(Vertice x){
        return v == x || w == x;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
    
}
