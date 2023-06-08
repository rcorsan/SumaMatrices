package SumaMatrices;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Matrices {
	
	//Metodo que crea las matrices leyendo cada elemento y escribiendolo en un fichero
    public static void creacionFicheros(int[][] matriz, int filas, int columnas,String nombreFichero) {
        try {
            FileWriter fw = new FileWriter(nombreFichero);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    pw.write(matriz[i][j] + " ");
                }
                pw.println();
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metodo que lee cada matriz de un fichero, va iterando para leer cada linea del ficero y la guarda en un array multidimensional
    public static int[][] leerMatriz(String nombreArchivo, int filas, int columnas) throws IOException {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists() || filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Error en formato o archivo no existe");
        }

        int[][] matriz = new int[filas][columnas];

        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        int lineaC = 0;
        while ((linea = reader.readLine()) != null) {
            String[] values = linea.trim().split(" ");
            for (int j = 0; j < columnas; j++) {
                int value = Integer.parseInt(values[j]);
                matriz[lineaC][j] = value;
            }
            lineaC++;
        }
        reader.close();

        return matriz;
    }
    //Metodo que resta las matrices para poder calcular la matriz B y la guarda en un array multidimensional
    public static int[][] sumaMatrices(int[][] matrizA, int[][] matrizC, int filas, int columnas) {
        if (matrizA == null || matrizA.length == 0 || matrizA[0] == null || matrizA[0].length == 0
                || matrizC == null || matrizC.length == 0 || matrizC[0] == null || matrizC[0].length == 0
                || filas <= 0 || columnas <= 0 || matrizA.length != matrizC.length
                || matrizA[0].length != matrizC[0].length) {
            throw new IllegalArgumentException("Error en formato o dimensiones de las matrices");
        }

        int[][] matrizB = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizB[i][j] = matrizC[i][j] - matrizA[i][j];
            }
        }

        return matrizB;
    }

    public static void main(String[] args) {
        int filas = 3;
        int columnas = 3;
        int[][] matrizA= new int[filas][columnas];
		int[][] matrizC= new int[filas][columnas];

		//matriz A
		
		matrizA[0][0]= 1;
		matrizA[0][1]= 2;
		matrizA[0][2]= 3;
		matrizA[1][0]= 4;
		matrizA[1][1]= 5;
		matrizA[1][2]= 6;
		matrizA[2][0]= 7;
		matrizA[2][1]= 8;
		matrizA[2][2]= 9;
		
		//matriz C
		
		matrizC[0][0]= 9;
		matrizC[0][1]= 8;
		matrizC[0][2]= 7;
		matrizC[1][0]= 6;
		matrizC[1][1]= 5;
		matrizC[1][2]= 4;
		matrizC[2][0]= 3;
		matrizC[2][1]= 2;
		matrizC[2][2]= 1;
		
        try {
        	creacionFicheros(matrizA, filas, columnas,"MatrizA.txt");
        	creacionFicheros(matrizC, filas, columnas,"MatrizC.txt");
            int[][] matrizA2 = leerMatriz("matrizA.txt", filas, columnas);
            int[][] matrizC2 = leerMatriz("matrizC.txt", filas, columnas);
            int[][] matrizB = sumaMatrices(matrizA, matrizC, filas, columnas);
            creacionFicheros(matrizB, filas, columnas,"MatrizB.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

