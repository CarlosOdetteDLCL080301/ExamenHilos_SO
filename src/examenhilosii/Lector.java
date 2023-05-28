package examenhilosii;
import java.util.Random;

public class Lector extends Thread {
    private String nombreLugar;
    private int[][] matrizAfluencia;
    private int lugarIndex;
    private int numDias;

    public Lector(String nombreLugar, int[][] matrizAfluencia, int lugarIndex, int numDias) {
        this.nombreLugar = nombreLugar;
        this.matrizAfluencia = matrizAfluencia;
        this.lugarIndex = lugarIndex;
        this.numDias = numDias;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < numDias; i++) {
            //int totalDiario = 0;
            int[] totalDiario = new int[numDias];
            for (int j = 0; j < 8; j++) { // Simula 8 horas de servicio (8 iteraciones = 8 horas)
                int numAleatorio = rand.nextInt(100) + 1;
                if (numAleatorio <= 70) {
                    //int visitantes = rand.nextInt(20) + 1;
                    int[] visitantes = new int [8];
                    for (int k = 0; k < visitantes.length; k++){
                        visitantes[k] = rand.nextInt(20) + 1;
                        matrizAfluencia[lugarIndex][i] += visitantes[k];
                        System.out.println("Lugar: " + nombreLugar + "\t- Día: " + (i + 1) +"\t- Hora: " + k + "\t- Entraron: " + visitantes[k]);
                        totalDiario[i] += visitantes[k];
                    }
                    /*
                    try {
                        //Thread.sleep(8000); // Pausa de 1 segundo
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    */
                    
                }
            }
            
            System.out.println("Lugar: " + nombreLugar + ", Día: " + (i + 1) +
                    ", Total de visitantes: " + sumarValores(totalDiario));
        }
    }
    
    private static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    }
    
    private static int sumarValores(int[] arreglo) {
        int suma = 0;
        for (int valor : arreglo) {
            suma += valor;
        }
        return suma;
    }
    
}
