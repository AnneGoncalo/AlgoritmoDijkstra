/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.Scanner;

/**
 *
 * @author Ana Gonçalo
 */
public class Program {
    
    public static void main(String args[]) {
        Scanner leitorScanner = new Scanner(System.in);
        
        Grafo grafo = new Grafo();
        
        //Inserindo Vertices
        grafo.inserirVertice("v1");
        grafo.inserirVertice("v2");
        grafo.inserirVertice("v3");
        grafo.inserirVertice("v4");
        grafo.inserirVertice("v5");
        
        //Inserindo Arestas
        grafo.inserirArestaOrientada("v1", "v2", 10);
        grafo.inserirArestaOrientada("v1", "v4", 30);
        grafo.inserirArestaOrientada("v1", "v5", 100);
        grafo.inserirArestaOrientada("v2", "v3", 50);
        grafo.inserirArestaOrientada("v3", "v5", 10);
        grafo.inserirArestaOrientada("v4", "v3", 20);
        grafo.inserirArestaOrientada("v4", "v5", 60);
        
        //Mostrando Matriz de Adjacencia
        grafo.MatrizAdjacencia();
        
        
        System.out.println("Qual o Vertice final?");
        String fim = leitorScanner.next();
        
        //Executando o Algoritmo
        AlgotimoDijkstra teste = new AlgotimoDijkstra(grafo);
        teste.Algoritmo();
        
        teste.findCaminho(fim);
        
        /*
        for(Vertice a: grafo.getVertices())
        {
            System.out.println(a.getValor());
        }
        */
    }
}
