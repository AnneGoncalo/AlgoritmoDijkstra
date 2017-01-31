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
 * @author Ana Gonçalo
 */
public class Grafo {

    private List<Vertice> vertices = new ArrayList();
    private List<Aresta> arestas = new ArrayList();

    public Vertice findVertice(String o) {
        for (Vertice v : vertices) {
            //System.out.println(v.getValor() + " " + o);
            if (v.getValor().equals(o)) {
                return v;
            }
        }
        return null;
    }

    public Aresta findAresta(String o) {
        for (Aresta a : arestas) {
            if (a.getValor().equals(o)) {
                return a;
            }
        }
        return null;
    }

    public List<Vertice> finalVertices(Aresta a) {
        List<Vertice> vets = new ArrayList();
        vets.add(a.getV());
        vets.add(a.getW());
        return vets;
    }

    public List<Vertice> finalVertices(String o) {
        Aresta a = findAresta(o);
        List<Vertice> vets = new ArrayList();
        vets.add(a.getV());
        vets.add(a.getW());
        return vets;
    }

    public Vertice oposto(Vertice v, Aresta a) {
        if (v == a.getV()) {
            return a.getW();
        } else if (v == a.getW()) {
            return a.getV();
        } else {
            return null;
        }
    }

    public Vertice oposto(String o, String b) {
        Vertice v = findVertice(o);
        Aresta a = findAresta(b);
        if (v == a.getV()) {
            return a.getW();
        } else if (v == a.getW()) {
            return a.getV();
        } else {
            return null;
        }
    }

    public boolean isAdjacente(Vertice v, Vertice w) {
        for (Aresta a : arestas) {
            if ((a.getV() == v && a.getW() == w)){// || (a.getV() == w && a.getW() == v)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdjacente(String o, String b) {
        Vertice v = findVertice(o);
        Vertice w = findVertice(b);
        for (Aresta a : arestas) {
            if (a.hasVertice(v) && a.hasVertice(w)) {
                return true;
            }
        }
        return false;
    }

    //Substituir Valor do Vertice
    public void substituirVertice(Vertice v, String x) {
        for (Vertice w : vertices) {
            if (w == v) {
                w.setValor(x);
                break;
            }
        }
    }

    //Substituir Valor do Vertice
    public void substituirVertice(String o, String x) {
        Vertice v = findVertice(o);
        for (Vertice w : vertices) {
            if (w == v) {
                w.setValor(x);
                break;
            }
        }
    }

    //Substituir Valor da Aresta
    public void substituirAresta(Aresta a, String x) {
        for (Aresta d : arestas) {
            if (d == a) {
                d.setValor(x);
                break;
            }
        }
    }

    //Substituir Valor da Aresta
    public void substituirAresta(String o, String x) {
        Aresta a = findAresta(o);
        for (Aresta d : arestas) {
            if (d == a) {
                d.setValor(x);
                break;
            }
        }
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public Vertice inserirVertice(String o) {
        Vertice v = new Vertice(o);
        vertices.add(v);
        return v;
    }

    public Aresta inserirAresta(Vertice v, Vertice w, String o) {
        Aresta a = new Aresta(v, w);
        a.setValor(o);
        arestas.add(a);
        return a;
    }

    public Aresta inserirAresta(String i, String j, String o) {
        Vertice v = findVertice(i);
        Vertice w = findVertice(j);
        Aresta a = new Aresta(v, w);
        a.setValor(o);
        arestas.add(a);
        return a;
    }
    
    public Aresta inserirAresta(String i, String j, int o) {
        Vertice v = findVertice(i);
        Vertice w = findVertice(j);
        Aresta a = new Aresta(v, w);
        a.setCusto(o);
        arestas.add(a);
        return a;
    }

    public Aresta inserirArestaOrientada(Vertice V, Vertice w, String o) {
        Aresta a = new Aresta(V, w, true);
        a.setValor(o);
        arestas.add(a);
        return a;
    }

    public Aresta inserirArestaOrientada(String i, String j, String o) {
        Vertice v = findVertice(i);
        Vertice w = findVertice(j);
        Aresta a = new Aresta(v, w, true);
        a.setValor(o);
        arestas.add(a);
        return a;
    }
    
    public Aresta inserirArestaOrientada(String i, String j, int o) {
        Vertice v = findVertice(i);
        Vertice w = findVertice(j);
        Aresta a = new Aresta(v, w, true);
        a.setCusto(o);
        arestas.add(a);
        return a;
    }

    public String removerVertice(Vertice v) {
        for (Aresta a : arestas) {
            if (a.hasVertice(v)) {
                arestas.remove(a);
            }
        }
        String retorno = v.getValor();
        vertices.remove(v);
        return retorno;
    }

    public String removerVertice(String o) {
        Vertice v = findVertice(o);
        for (Aresta a : arestas) {
            if (a.hasVertice(v)) {
                arestas.remove(a);
            }
        }
        String retorno = v.getValor();
        vertices.remove(v);
        return retorno;
    }

    public String removerAresta(Aresta a) {
        String retorno = a.getValor();
        arestas.remove(a);
        return retorno;
    }

    public String removerAresta(String o) {
        Aresta a = findAresta(o);
        String retorno = a.getValor();
        arestas.remove(a);
        return retorno;
    }

    public List<Aresta> arestasIncidentes(Vertice v) {
        List<Aresta> lista = new ArrayList();
        for (Aresta a : arestas) {
            if (a.hasVertice(v)) {
                lista.add(a);
            }
        }
        return lista;
    }

    public List<Aresta> arestasIncidentes(String o) {
        Vertice v = findVertice(o);
        List<Aresta> lista = new ArrayList();
        for (Aresta a : arestas) {
            if (a.hasVertice(v)) {
                lista.add(a);
            }
        }
        return lista;
    }

    public boolean ehDirecionado(Aresta a) {
        return a.isOrientado();
    }

    public boolean ehDirecionado(String o) {
        Aresta a = findAresta(o);
        return a.isOrientado();
    }

    //Matriz de Adjacência
    public void MatrizAdjacencia() {
        System.out.println("MATRIZ DE ADJACÊNCIA");
        for (int i = -1; i < vertices.size(); i++) {
            if (i >= 0) {
                System.out.print(vertices.get(i).getValor());
            }

            for (int j = -1; j < vertices.size(); j++) {

                if(i == -1)
                    if(j >= 0)
                        System.out.print(vertices.get(j).getValor() + " ");
                    else
                        System.out.print("   ");
                else if (i >= 0 && j >= 0) {
                    if (isAdjacente(vertices.get(i), vertices.get(j))) {
                        System.out.print(" 1 ");
                    } 
                    else {
                        System.out.print(" 0 ");
                    }
                } 
            }
            System.out.println("");
        }
        System.out.println("");

    }


}
