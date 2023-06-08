package SumaMatrices;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class MatricesTest {

	@Test
	void testCreacionFicheros() {
		  int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	      int filas = 3;
	      int columnas = 3;
	      String nombreFichero = "MatrizTest.txt";
	      try {
	    	  Matrices.creacionFicheros(matriz, filas, columnas, nombreFichero);
	          int[][] matrizLeida = Matrices.leerMatriz(nombreFichero, filas, columnas);
	          assertArrayEquals(matriz, matrizLeida);
	      } catch (IOException e) {
	          e.printStackTrace();
	            
	      }
		
	}

	@Test
	void testLeerMatriz() {
		 int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	     try {
	    	 int[][] actual = Matrices.leerMatriz("MatrizA.txt", 3, 3);
	         assertArrayEquals(expected, actual);
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
		

	@Test
	void testSumaMatrices() {
		 int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		 int[][] matrizC = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
		 int[][] expected = {{8, 6, 4}, {2, 0, -2}, {-4, -6, -8}};
		 int[][] actual = Matrices.sumaMatrices(matrizA, matrizC, 3, 3);
		 assertArrayEquals(expected, actual);
		
	}
	
	@Test
    public void testLeerMatrizFicheroInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
        Matrices.leerMatriz("ArchivoInexistente.txt", 3, 3);
        });
    }

    @Test
    public void testLeerMatrizFormatoIncorrecto() {
        assertThrows(IllegalArgumentException.class, () -> {
        Matrices.leerMatriz("MatrizInvalida.txt", 3, 3);
        });
    }
}
