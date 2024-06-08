package ayed.tp5.ejercicio5;

import ayed.tp1.ejercicio8.Queue;
import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class GradoSeparacion {
    public List<Persona> obtenerJubilados(Graph<Persona> graph, Persona empleado, int gradoSeparacion) {
        Vertex<Persona> origen = graph.search(empleado);

        if (origen != null)
            return bfs(graph, origen, gradoSeparacion);

        return new LinkedList<>();
    }

    public List<Persona> bfs(Graph<Persona> graph, Vertex<Persona> origen, int gradoMaximo) {
        boolean[] visitados = new boolean[graph.getSize()];
        List<Persona> jubilados = new LinkedList<>();
        int gradoActual = 0;

        Queue<Vertex<Persona>> queue = new Queue<>();
        visitados[origen.getPosition()] = true;
        queue.enqueue(origen);
        queue.enqueue(null);

        while (!queue.isEmpty() && gradoActual <= gradoMaximo && jubilados.size() < 40) {
            Vertex<Persona> v = queue.dequeue();
            if (v != null) {
                Persona persona = v.getData();
                // Agrego jubilado a la lista
                if (persona.getTipo() == Persona.TipoPersona.JUBILADO && !persona.isCobroJubilacion())
                    jubilados.add(v.getData());

                List<Edge<Persona>> adyacentes = graph.getEdges(v);
                for (Edge<Persona> edge : adyacentes) {
                    Vertex<Persona> adyacente = edge.getTarget();
                    if (!visitados[adyacente.getPosition()]) {
                        visitados[adyacente.getPosition()] = true;
                        queue.enqueue(adyacente);
                    }
                }
            } else if (!queue.isEmpty()) {
                gradoActual++;
                queue.enqueue(null);
            }
        }

        return jubilados;
    }
}
