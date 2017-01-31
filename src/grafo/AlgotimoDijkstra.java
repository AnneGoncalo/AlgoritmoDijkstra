/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anne
 */
public class AlgotimoDijkstra {

    Grafo grafo = new Grafo();

    List<Vertice> foram = new ArrayList();
    List<Vertice> vem = new ArrayList();

    Vertice antecessor;

    int[] custos;

    public AlgotimoDijkstra(Grafo g) {
        grafo = g;
        custos = new int[grafo.getVertices().size()];
    }

    public void Algoritmo() {

        for (Vertice a : grafo.getVertices()) {
            a.setDist(CalcDist(grafo.getVertices().get(0), a));
            a.setAnt(grafo.getVertices().get(0));
            vem.add(a);
        }

        vem.get(0).setAnt(null);

        while (foram.size() != grafo.getVertices().size()) {

            Vertice w = FindVerticeMin();
            antecessor = w;
            foram.add(w);

            for (Vertice v : vem) {

                System.out.println("Explorando: " + w.getValor());
                System.out.println("Visitando: " + v.getValor());

                System.out.println("Comparando -> "
                        + " w[" + w.getDist() + "] + " + " w-v[" + CalcDist(w, v) + "] OU "
                        + " v[" + v.getDist() + "] ");

                //verifica se a distancia de (v ate w) eh menor do que o custo anterior de w
                if (v.getDist() == 1000) {
                    v.setDist(w.getDist() + CalcDist(w, v));
                    v.setAnt(w);
                    System.out.println("Atualização -> " + v.getValor() + ": " + v.getDist());
                } else if (w.getDist() + CalcDist(w, v) < v.getDist()) {
                    v.setDist(w.getDist() + CalcDist(w, v));
                    v.setAnt(w);
                    System.out.println("Atualização -> " + v.getValor() + ": " + v.getDist());
                }

                System.out.println("");
            }

            vem.remove(w);

            System.out.println("Situação Atual:");
            for (Vertice x : grafo.getVertices()) {
                if (x.getAnt() != null) {
                    System.out.println(x.getValor() + ": " + x.getDist() + " (" + x.getAnt().getValor() + ")");
                } else {
                    System.out.println(x.getValor() + ": " + x.getDist() + "  Null");
                }
            }
        }

        System.out.println("\n---------------------- FINAL --------------------");
        for (Vertice x : foram) {
            if (x.getAnt() != null) {
                System.out.println(x.getValor() + " -> Custo: " + x.getDist() + " Anterior: " + x.getAnt().getValor());
            } else {
                System.out.println(x.getValor() + " -> Custo: " + x.getDist() + " Anterior: Null");
            }
        }
    }

    public int CalcDist(Vertice a, Vertice b) {
        if (a == b) {
            return 0;
        }
        if (!grafo.isAdjacente(a, b)) {
            return 1000;
        } else {
            int min = 1000;
            for (Aresta t : grafo.arestasIncidentes(a)) {
                if (t.hasVertice(b)) {
                    if (t.getCusto() < min) {
                        min = t.getCusto();
                    }
                }
            }
            return min;
        }

    }

    private Vertice FindVerticeMin() {
        Vertice v = vem.get(0);

        for (Vertice x : vem) {
            if (x.getDist() < v.getDist()) {
                v = x;
            }
        }

        return v;
    }
    
    public void findCaminho(String f){
        Vertice x = grafo.findVertice(f);
        List<Vertice> pilha = new ArrayList();
        
        System.out.println("\nO caminho eh ... ");
        while(x != null){
            pilha.add(x);
            x = x.getAnt();
        }
        
        for(int i = pilha.size()-1; i >= 0; i--){
            System.out.print(pilha.get(i).getValor() + " -> ");
        }
        
    }
}
