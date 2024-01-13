//Trivia

import java.util.Scanner;

public class Main extends PreguntasRespuestas{
    public static int numPreguntas(){ //Funcion que retornará el número de preguntas que va a tener la trivia
        Scanner inNumPreguntas = new Scanner(System.in); //Creando objeto tipo Scanner para la función
        int inputNumPreguntas;
        boolean flagNumPreguntas;
        //Mirará si el número ingresado es mayor o negativo al número de preguntas que hay - Lo realizará por lo menos 1 vez
        do {
            limpiarPantalla();
            System.out.println("""

                    -----Trivia-----
                    """);
            System.out.println("Escribe la cantidad de preguntas que quiere que tenga la trivia: (Entre 1 - 6 Preguntas)");
            inputNumPreguntas = inNumPreguntas.nextInt();
            //Nota: La condicion de flagNumPreguntas se cambia dependiendo de cuantas preguntas haya
            flagNumPreguntas = inputNumPreguntas < 1 || inputNumPreguntas > 6; // Si es mayor o menor al número me marcará como verdadero haciendo que se haga el do while
        }while(flagNumPreguntas);
        return inputNumPreguntas;
    }
    public static void main(String[] args) {

        Scanner inMain = new Scanner(System.in); //Creando objeto tipo Scanner para el main
        int cantidadPreguntas;
        //Comenzar o Salir de la trivia
        limpiarPantalla();
        System.out.println("""

                -----Trivia-----
                """);
        System.out.println("1. Para Comenzar" + "\n" + "2. Para cerrar");
        int inputCC = inMain.nextInt(); //Input para comenzar o cerrar
        switch (inputCC){
            case 1:
                cantidadPreguntas = numPreguntas();
                comenzarTrivia(cantidadPreguntas);
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    public static void limpiarPantalla(){ //Limpiador de pantalla - Colocará 50 líneas en blanco
        for(int i = 1; i <= 50; i ++){
            System.out.println(" ");
        }
    }
}