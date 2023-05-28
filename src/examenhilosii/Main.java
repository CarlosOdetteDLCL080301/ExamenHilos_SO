package examenhilosii;
public class Main {
    public static void main(String[] args) {
        int n = 2; // Número de lugares (renglones) en la matriz
        int m = 7; // Número de días de la semana (columnas) en la matriz

        // Crear la matriz de afluencia
        int[][] matrizAfluencia = new int[n][m];

        // Crear los hilos lectores para cada lugar
        Lector[] hilosLectores = new Lector[n * 2]; // Dos lectores por lugar

        for (int i = 0; i < n; i++) {
            String nombreLugar = (i == 0) ? "Jardín Botánico" : "Pabellón Nacional de la Biodiversidad";

            hilosLectores[i] = new Lector(nombreLugar, matrizAfluencia, i, m);
            hilosLectores[i + n] = new Lector(nombreLugar, matrizAfluencia, i, m);
        }

        // Iniciar los hilos lectores
        for (Lector hilo : hilosLectores) {
            hilo.start();
        }

        // Esperar a que los hilos lectores terminen
        for (Lector hilo : hilosLectores) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostrar la afluencia diaria
        System.out.println("\n\nAfluencia diaria:");
        for (int i = 0; i < n; i++) {
            System.out.print("Lugar: " + ((i == 0) ? "Jardín Botánico\t" : "Pabellón Nacional de la Biodiversidad\t") );
            for (int j = 0; j < m; j++) {
                System.out.print(matrizAfluencia[i][j] + "\t");
            }
            System.out.println("");
        }

        // Mostrar la afluencia semanal
        System.out.println("\nAfluencia semanal:");
        for (int i = 0; i < n; i++) {
            int totalSemanal = 0;
            for (int j = 0; j < m; j++) {
                totalSemanal += matrizAfluencia[i][j];
            }
            System.out.println("Lugar: " + ((i == 0) ? "Jardín Botánico" : "Pabellón Nacional de la Biodiversidad") +
                    ", Total de visitantes: " + totalSemanal);
        }
    }
    
    
    
}


