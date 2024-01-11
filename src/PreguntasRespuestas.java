import java.util.Arrays;

public class PreguntasRespuestas{
    static String[][] matrizContenedora = new String[5][5]; //Matriz contenedora de la Trivia

    public static void preguntasRespuestas(){ //Preguntas y respuestas
        // PR1
        matrizContenedora[0][0] = "Estas tres ciudades se localizan en las costas del mar Caribe:";
        matrizContenedora[0][1] = "Tumacoí, Buenaventura y Nuquí.";
        matrizContenedora[0][2] = "Santa Marta, Barranquilla y Cartagena.";
        matrizContenedora[0][3] = "Cali, Medellín y Pasto.";
        matrizContenedora[0][4] = "Bogotá, Pasto, Ibagué";
        //PR2
        matrizContenedora[1][0] = "¿Con cuántos países comparte Colombia fronteras terrestres?";
        matrizContenedora[1][1] = "5";
        matrizContenedora[1][2] = "7";
        matrizContenedora[1][3] = "4";
        matrizContenedora[1][4] = "9";
        //PR3
        matrizContenedora[2][0] = "Los siguientes territorios formaron parte de la Gran Colombia entre 1821 y 1830:";
        matrizContenedora[2][1] = "Nueva Granada, Venezuela, Ecuador y Panamá.";
        matrizContenedora[2][2] = "Perú, Venezuela, Nueva Granada y México.";
        matrizContenedora[2][3] = "Ecuador, Brasil, Nueva Granada y Cuba.";
        matrizContenedora[2][4] = "Nueva Granada, España, México.";
        //PR4
        matrizContenedora[3][0] = "¿Cuál es la capital del Departamento de Amazonas?";
        matrizContenedora[3][1] = "Popayán.";
        matrizContenedora[3][2] = "Florencia.";
        matrizContenedora[3][3] = "Leticia.";
        matrizContenedora[3][4] = "Chocó.";
        //PR5
        matrizContenedora[4][0] = "¿Cuándo ganó la selección colombiana la Copa América de Fútbol?";
        matrizContenedora[4][1] = "2011.";
        matrizContenedora[4][2] = "2007.";
        matrizContenedora[4][3] = "2001.";
        matrizContenedora[4][4] = "1999.";
    }

    public static void comenzarTrivia(int cantidadPreguntas){
        int[] comparadorAleatoriedad = new int[cantidadPreguntas];
        int aleatoriedad, acumuladorAleatoriedad;
        Arrays.fill(comparadorAleatoriedad, -1);
        for (int i = 0; i < cantidadPreguntas; i++) {
            do {
                acumuladorAleatoriedad = 0;
                aleatoriedad = (int) (Math.random() * cantidadPreguntas);
                for (int j = 0; j < cantidadPreguntas; j++) {
                    if (comparadorAleatoriedad[j] == aleatoriedad){
                        acumuladorAleatoriedad += 1;
                        break;
                    }
                }
                if(acumuladorAleatoriedad == 0){
                    comparadorAleatoriedad[i] = aleatoriedad;
                }
            }while (acumuladorAleatoriedad != 0);
            System.out.println(comparadorAleatoriedad[i]);
        }
    }
}
