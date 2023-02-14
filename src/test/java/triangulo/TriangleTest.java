package triangulo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    /**
     * Casos de test:
     *
     * - Los lados son 0 (las 3 posibles combinaciones), lanza excepcion
     * - Los lados son negativos (las 3 posibles combinaciones), lanza excepcion
     * - Las dimensiones de los lados no son validas (las 3 posibles combinaciones), lanza excepcion
     * - Triangulo isosceles valido (las 3 posibles combinaciones).
     * - Triangulo equilatero valido.
     * - Triangulo escaleno valido (las 3 posibles combinaciones).
     */

    Triangle triangulo;

    @BeforeEach
    void setUp(){
        triangulo = new Triangle();
    }

    @AfterEach
    void shutDown(){
        triangulo = null;
    }

    @Test
    void ladosCero1(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(0,0,0));

    }

    @Test
    void ladosCero2(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(10,0,0));

    }

    @Test
    void ladosCero3(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(10,10,0));

    }

    @Test
    void ladosNegativos1(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(-1,-1,-1));

    }

    @Test
    void ladosNegativos2(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(12,-1,-1));

    }

    @Test
    void ladosNegativos3(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(11,31,-1));

    }
    @Test
    void dimensionesInvalidas1(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(1,1,10));
        assertEquals("The side lengths do not correspond to a valid triangle", e.getMessage());
    }

    @Test
    void dimensionesInvalidas2(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(10,1,1));
        assertEquals("The side lengths do not correspond to a valid triangle", e.getMessage());
    }

    @Test
    void dimensionesInvalidas3(){
        RuntimeException e = assertThrows(RuntimeException.class,() -> triangulo.getType(1,10,1));
        assertEquals("The side lengths do not correspond to a valid triangle", e.getMessage());
    }

    @Test
    void trianguloIsosceles1(){
        Triangle.TriangleType tipo = triangulo.getType(3,3,4);
        assertEquals(Triangle.TriangleType.ISOSCELES,tipo);
    }

    @Test
    void trianguloIsosceles2(){
        Triangle.TriangleType tipo = triangulo.getType(3,4,3);
        assertEquals(Triangle.TriangleType.ISOSCELES,tipo);
    }

    @Test
    void trianguloIsosceles3(){
        Triangle.TriangleType tipo = triangulo.getType(4,3,3);
        assertEquals(Triangle.TriangleType.ISOSCELES,tipo);
    }

    @Test
    void trianguloEquilatero(){
        Triangle.TriangleType tipo = triangulo.getType(15,15,15);
        assertEquals(Triangle.TriangleType.EQUILATERAL,tipo);
    }


    @Test
    void trianguloEscaleno1(){
        Triangle.TriangleType tipo = triangulo.getType(5,6,7);
        assertEquals(Triangle.TriangleType.SCALENE,tipo);
    }

    @Test
    void trianguloEscaleno2(){
        Triangle.TriangleType tipo = triangulo.getType(6,5,7);
        assertEquals(Triangle.TriangleType.SCALENE,tipo);
    }

    @Test
    void trianguloEscaleno3(){
        Triangle.TriangleType tipo = triangulo.getType(6,7,5);
        assertEquals(Triangle.TriangleType.SCALENE,tipo);
    }


    @Test
    void trianguloDoubles(){
        Triangle.TriangleType tipo = triangulo.getType(2.5,3.5,5.5);
        assertEquals(Triangle.TriangleType.SCALENE,tipo);
    }

}