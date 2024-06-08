package ayed.tp5.ejercicio5;
import static org.junit.jupiter.api.Assertions.*;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio1.adjList.AdjListGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class GradoSeparacionTest {

    private Graph<Persona> graph;
    private GradoSeparacion gradoSeparacion;

    @BeforeEach
    public void setUp() {
        graph = new AdjListGraph<>();

        // Crear empleados y jubilados
        Persona empleado1 = new Persona("Empleado1", Persona.TipoPersona.EMPLEADO, "Calle 1", false);
        Persona jubilado1 = new Persona("Jubilado1", Persona.TipoPersona.JUBILADO, "Calle 2", false);
        Persona jubilado2 = new Persona("Jubilado2", Persona.TipoPersona.JUBILADO, "Calle 3", true);  // Ya cobró
        Persona jubilado3 = new Persona("Jubilado3", Persona.TipoPersona.JUBILADO, "Calle 4", false);
        Persona jubilado4 = new Persona("Jubilado4", Persona.TipoPersona.JUBILADO, "Calle 5", false);
        Persona jubilado5 = new Persona("Jubilado5", Persona.TipoPersona.JUBILADO, "Calle 6", false);

        // Añadir vértices
        Vertex<Persona> emp1 = graph.createVertex(empleado1);
        Vertex<Persona> jub1 = graph.createVertex(jubilado1);
        Vertex<Persona> jub2 = graph.createVertex(jubilado2);
        Vertex<Persona> jub3 = graph.createVertex(jubilado3);
        Vertex<Persona> jub4 = graph.createVertex(jubilado4);
        Vertex<Persona> jub5 = graph.createVertex(jubilado5);

        // Añadir aristas
        graph.connect(emp1, jub1);
        graph.connect(emp1, jub2);
        graph.connect(jub1, jub3);
        graph.connect(jub2, jub4);
        graph.connect(jub3, jub5);
        gradoSeparacion = new GradoSeparacion();
    }

    @Test
    public void testObtenerJubiladosCercanos() {
        Persona empleado1 = new Persona("Empleado1", Persona.TipoPersona.EMPLEADO, "Calle 1", false);
        List<Persona> jubilados = gradoSeparacion.obtenerJubilados(graph, empleado1, 2);

        assertEquals(3, jubilados.size());
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado1")));
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado3")));
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado4")));
    }

    @Test
    public void testObtenerJubiladosCercanosSeparacion1() {
        Persona empleado1 = new Persona("Empleado1", Persona.TipoPersona.EMPLEADO, "Calle 1", false);
        List<Persona> jubilados = gradoSeparacion.obtenerJubilados(graph, empleado1, 1);

        assertEquals(1, jubilados.size());
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado1")));
    }



    @Test
    public void testObtenerJubiladosCercanosSeparacion3() {
        Persona empleado1 = new Persona("Empleado1", Persona.TipoPersona.EMPLEADO, "Calle 1", false);
        List<Persona> jubilados = gradoSeparacion.obtenerJubilados(graph, empleado1, 3);

        assertEquals(4, jubilados.size());
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado1")));
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado3")));
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado4")));
        assertTrue(jubilados.stream().anyMatch(p -> p.getNombre().equals("Jubilado5")));
    }


    @Test
    public void testObtenerJubiladosCercanosMax40() {
        Persona empleado1 = new Persona("Empleado1", Persona.TipoPersona.EMPLEADO, "Calle 1", false);
        Vertex<Persona> emp1 = graph.createVertex(empleado1);
        for (int i = 0; i < 50; i++) {
            Persona jubilado = new Persona("Jubilado" + (i + 6), Persona.TipoPersona.JUBILADO, "Calle " + (i + 6), false);
            Vertex<Persona> jub = graph.createVertex(jubilado);
            graph.connect(emp1, jub);
        }

        List<Persona> jubilados = gradoSeparacion.obtenerJubilados(graph, empleado1, 1);

        assertEquals(40, jubilados.size());
    }
}

