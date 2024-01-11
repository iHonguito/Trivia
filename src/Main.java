//Trivia

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    //funcion que retornará el número de preguntas que va a tener la trivia
    public static int numPreguntas(){
        Scanner inNumPreguntas = new Scanner(System.in); //Creando objeto tipo Scanner para la función
        int inputNumPreguntas = 0;
        Boolean flagNumPreguntas;
        //Mirará si el número ingresado es mayor o negativo al número de preguntas que hay
        do {
            limpiarPantalla();
            System.out.println("\n" + "-----Trivia-----" + "\n");
            System.out.println("Escribe la cantidad de preguntas que quiere que tenga la trivia: (Entre 1 - 5 Preguntas)");
            inputNumPreguntas = inNumPreguntas.nextInt();
            if(inputNumPreguntas >= 1 && inputNumPreguntas <= 5){
                flagNumPreguntas = false;
            }else {
                flagNumPreguntas = true;
            }
        }while(flagNumPreguntas);
        return inputNumPreguntas;
    }
    public static void main(String[] args) {

        Scanner inMain = new Scanner(System.in); //Creando objeto tipo Scanner para el main
        int cantidadPreguntas;
        //Comenzar o Salir de la trivia
        System.out.println("\n" + "-----Trivia-----" + "\n");
        System.out.println("1. Para Comenzar" + "\n" + "2. Para cerrar");
        int inputCC = inMain.nextInt(); //Input para comenzar o cerrar
        switch (inputCC){
            case 1:
                cantidadPreguntas = numPreguntas();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    //limpiador de pantalla - Colocará 50 líneas en blanco
    public static void limpiarPantalla(){
        for(int i = 1; i <= 50; i ++){
            System.out.println(" ");
        }
    }
}