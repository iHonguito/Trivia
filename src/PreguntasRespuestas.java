import java.util.Arrays;
import java.util.Scanner;

public class PreguntasRespuestas{
    //Nota: Dependiendo de cuantas preguntas se quiere que haya se cambia el número de columnas que tiene la matriz
    static String[][] matrizContenedora = new String[6][5]; //Matriz contenedora de la Trivia
    static int[] respuestasAleatorias = new int[4]; //Vector contenedor de posiciones aleatorias
    public static void preguntasRespuestas(){ //Preguntas y respuestas
        //Nota: Las primeras preguntas son las respuestas correctas
        // PR1
        matrizContenedora[0][0] = "Estas tres ciudades se localizan en las costas del mar Caribe:";
        matrizContenedora[0][1] = "Santa Marta, Barranquilla y Cartagena.";
        matrizContenedora[0][2] = "Tumacoí, Buenaventura y Nuquí.";
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
        matrizContenedora[3][1] = "Leticia.";
        matrizContenedora[3][2] = "Florencia.";
        matrizContenedora[3][3] = "Popayán.";
        matrizContenedora[3][4] = "Chocó.";
        //PR5
        matrizContenedora[4][0] = "¿Cuándo ganó la selección colombiana la Copa América de Fútbol?";
        matrizContenedora[4][1] = "2001.";
        matrizContenedora[4][2] = "2007.";
        matrizContenedora[4][3] = "2011.";
        matrizContenedora[4][4] = "1999.";
        //PR6
        matrizContenedora[5][0] = "¿Hasta que año Panamá formó parte de Colombia?";
        matrizContenedora[5][1] = "1903.";
        matrizContenedora[5][2] = "1914";
        matrizContenedora[5][3] = "1899.";
        matrizContenedora[5][4] = "1831.";
    }

    public static void comenzarTrivia(int cantidadPreguntas){
        Scanner inComenzarTrivia = new Scanner(System.in);
        int[] comparadorAleatoriedadPreguntas = new int[cantidadPreguntas];
        int aleatoriedadPreguntas, aleatoriedadRespuestas, acumuladorAleatoriedad, respuestaCorrecta, respuestaJugador, contador, puntos;
        preguntasRespuestas();
        Arrays.fill(comparadorAleatoriedadPreguntas, -1); //El array se itera así mismo colocando -1 para evitar errores
        puntos = 0;
        for (int i = 0; i < cantidadPreguntas; i++) {
            limpiarPantalla();
            do { //Aleatoriedad en las preguntas - el do while se cumplirá tantas veces para que las posiciones no sean repetidas
                acumuladorAleatoriedad = 0;
                //Nota: El número de posiciones aleatorias depende de cuantas preguntas haya en este caso es de 5
                aleatoriedadPreguntas = (int) (Math.random() * 6);
                for (int j = 0; j < cantidadPreguntas; j++) {
                    if (comparadorAleatoriedadPreguntas[j] == aleatoriedadPreguntas){ //Si la posicion ya fue utilizada
                        acumuladorAleatoriedad = 1;
                        break;
                    }
                }
                if(acumuladorAleatoriedad == 0){ //En caso de que el número aleatorio no se haya usado set y proseguir
                    comparadorAleatoriedadPreguntas[i] = aleatoriedadPreguntas;
                }
            }while (acumuladorAleatoriedad != 0); //En caso de que la posicion haya sido utilizada
            Arrays.fill(respuestasAleatorias, -1); //El array se itera así mismo colocando -1 para evitar errores
            contador = 0;
            respuestaCorrecta = 0;
            for (int j = 0; j < 4; j++) {
                contador += 1; //Indica cual es la respuesta correcta
                do { //Aleatoriedad en las respuestas - el do while se cumplirá tantas veces para que las posiciones no sean repetidas
                    acumuladorAleatoriedad = 0;
                    aleatoriedadRespuestas = (int) ((Math.random() * 4) + 1); //Posiciones de las respuestas aleatorias según las preguntas
                    for (int k = 0; k < 4; k++) {
                        if(respuestasAleatorias[k] == aleatoriedadRespuestas){ //Si la posicion ya fue utilizada
                            acumuladorAleatoriedad = 1;
                            break;
                        }
                    }
                    if (acumuladorAleatoriedad == 0) { //En caso de que el número aleatorio no se haya usado set y proseguir
                        respuestasAleatorias[j] = aleatoriedadRespuestas;
                    }
                }while (acumuladorAleatoriedad != 0); //En caso de que la posicion haya sido utilizada
                if (aleatoriedadRespuestas == 1){
                    respuestaCorrecta = contador; //Indica cuando la posicon es la respuesta correcta
                }
            }
            //Output
            System.out.println(matrizContenedora[aleatoriedadPreguntas][0]); //Mostrará la pregunta
            for (int j = 0; j < 4; j++) { //Muestra las posibles respuestas de forma aleatoria
                System.out.println((j + 1) + ". " + matrizContenedora[aleatoriedadPreguntas][respuestasAleatorias[j]]);
            }
            respuestaJugador = inComenzarTrivia.nextInt(); //Respuesta del jugador
            if (respuestaJugador == respuestaCorrecta) {
                puntos += 1; //Cantidad de respuestas acertadas
            }
        }
        System.out.print("Tuviste " + puntos + " respuestas correctas de " + cantidadPreguntas + ", obtuviste ");
        sistemaPuntos(cantidadPreguntas, puntos);
    }

    //Sistema de puntos - Dependiendo de cuantas preguntas el usuario responda correctamente serán los puntos
    public static void sistemaPuntos(int cantidadPreguntas, int puntos){
        int sistemaPuntos;
        sistemaPuntos = ((puntos * 100) / cantidadPreguntas);
        System.out.println(sistemaPuntos + " puntos.");
    }
    public static void limpiarPantalla(){ //Limpiador de pantalla - Colocará 50 líneas en blanco
        for(int i = 1; i <= 50; i ++){
            System.out.println(" ");
        }
    }
}
