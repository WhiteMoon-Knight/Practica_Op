package logic;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Juego {

    public enum estadoPartida {START,PREFLOP,FLOP,TURN,RIVER};

    private Player jugador;

    private Bot bot;

    private ArrayList<Carta> board;

    private ArrayList<Carta> baraja= new ArrayList<Carta>(Arrays.asList(
            new Carta("A","h"),
            new Carta("A","s"),
            new Carta("A","c"),
            new Carta("A","d"),
            new Carta("K","h"),
            new Carta("K","s"),
            new Carta("K","c"),
            new Carta("K","d"),
            new Carta("Q","h"),
            new Carta("Q","s"),
            new Carta("Q","c"),
            new Carta("Q","d"),
            new Carta("J","h"),
            new Carta("J","s"),
            new Carta("J","c"),
            new Carta("J","d"),
            new Carta("T","h"),
            new Carta("T","s"),
            new Carta("T","c"),
            new Carta("T","d"),
            new Carta("9","h"),
            new Carta("9","s"),
            new Carta("9","c"),
            new Carta("9","d"),
            new Carta("8","h"),
            new Carta("8","s"),
            new Carta("8","c"),
            new Carta("8","d"),
            new Carta("7","h"),
            new Carta("7","s"),
            new Carta("7","c"),
            new Carta("7","d"),
            new Carta("6","h"),
            new Carta("6","s"),
            new Carta("6","c"),
            new Carta("6","d"),
            new Carta("5","h"),
            new Carta("5","s"),
            new Carta("5","c"),
            new Carta("5","d"),
            new Carta("4","h"),
            new Carta("4","s"),
            new Carta("4","c"),
            new Carta("4","d"),
            new Carta("3","h"),
            new Carta("3","s"),
            new Carta("3","c"),
            new Carta("3","d"),
            new Carta("2","h"),
            new Carta("2","s"),
            new Carta("2","c"),
            new Carta("2","d")
    ));

    private ArrayList<Carta> barajaBarajada = new ArrayList<>();

    private double bote;

    private double apuestaBot;

    private double apuestaPlayer;

    private ArrayList<Carta> cartasJugador;

    private ArrayList<Carta> cartasBot;

    private estadoPartida estado;

    public Juego(Strat level,boolean ciuegaPequeña){
        barajaBarajada=(ArrayList<Carta>) baraja.clone();
        Collections.shuffle(barajaBarajada);
        this.bote=0;
        estado=estadoPartida.START;

        //ciegaPequeña true para el bot -> False para el player
        bot=new Bot(100,level,ciuegaPequeña);
        jugador=new Player(100);
        board=new ArrayList<Carta>();

    }

    public void starGame(){

        jugador.dealNLHECards(barajaBarajada.get(0),barajaBarajada.get(1));
        barajaBarajada.remove(0); barajaBarajada.remove(1);
        bot.dealNLHECards(barajaBarajada.get(0),barajaBarajada.get(1));
        barajaBarajada.remove(0); barajaBarajada.remove(1);

        if(bot.CiegaPequeña()){
            apuestaBot=0.5;
            if(bot.tieneFichas(apuestaBot))
                bot.setFichas(bot.getFichas()-apuestaBot);
            apuestaPlayer=1;
            if(jugador.tieneFichas(apuestaPlayer))
                 jugador.setFichas(jugador.getFichas()-apuestaPlayer);



        }
        else{
            apuestaBot=1;
            bot.setFichas(bot.getFichas()-apuestaBot);
            apuestaPlayer=0.5;
            jugador.setFichas(jugador.getFichas()-apuestaPlayer);

        }

        estado=estadoPartida.PREFLOP;

    }


    public void avanzaEstado(){

        switch(estado) {

            case PREFLOP:
                bote=apuestaBot+apuestaPlayer;
                board.add(barajaBarajada.get(0));
                board.add(barajaBarajada.get(1));
                board.add(barajaBarajada.get(2));
                board.remove(barajaBarajada.get(0));
                board.remove(barajaBarajada.get(1));
                board.remove(barajaBarajada.get(2));
                bot.evaluaBot(board);
                estado=estadoPartida.FLOP;
                break;

            case FLOP:
                bote=apuestaBot+apuestaPlayer;
                board.add(barajaBarajada.get(0));
                board.remove(barajaBarajada.get(0));
                bot.evaluaBot(board);
                estado=estadoPartida.TURN;
                break;

            case TURN:
                bote=apuestaBot+apuestaPlayer;
                board.add(barajaBarajada.get(0));
                board.remove(barajaBarajada.get(0));
                bot.evaluaBot(board);
                estado=estadoPartida.RIVER;
                break;

            case RIVER:
                checkWinner();
                board.clear();
                bot.getCartas().clear();
                jugador.getCartas().clear();
                barajaBarajada.clear();
                barajaBarajada=(ArrayList<Carta>) baraja.clone();
                Collections.shuffle(barajaBarajada);
                //llamar sumar bote al stack del ganador
                starGame();
                break;

        }
        apuestaPlayer=0;
        apuestaBot=0;
    }

    public boolean checkApuestaJ(double apuesta){
        return jugador.tieneFichas(apuesta);
    }

    public void callJugador(){

        apuestaPlayer = apuestaBot;
        jugador.restarFichas(apuestaPlayer);
        avanzaEstado();
    }

    public void raiseJugador(double raise){
        double botAction;
        apuestaPlayer=raise;

        jugador.restarFichas(apuestaPlayer);
        if(estado==estadoPartida.PREFLOP){
           botAction= bot.preflopAgressive(apuestaPlayer);

        }
        else{
           botAction = bot.postFlopAgressive(raise,bote,estado);
        }

        if(botAction==apuestaPlayer){
            apuestaBot=botAction;
            avanzaEstado();
        }
        else if (botAction > apuestaPlayer){
            apuestaBot=botAction;
        }

        else{
            ///llamar metodo checkWinner (el bot foldea)
        }

    }

    public void foldJugador(){
        bot.sumarFichas(bote+apuestaBot+apuestaPlayer);
        bote=0;
        apuestaBot=0;
        apuestaPlayer=0;
        estado=estadoPartida.RIVER;
        avanzaEstado();

    }

    void checkWinner(){
        Mano aux;
        jugador.evaluaJugador(board);
        bot.evaluaBot(board);

       aux= jugador.getBestHand().compareMano(bot.getBestHand());

       if(aux==jugador.getBestHand()){
           jugador.sumarFichas(apuestaPlayer+bote+apuestaBot);
       }
       else{
           bot.sumarFichas(apuestaPlayer+bote+apuestaBot);
       }

   }

//    public  void checkCall(){
//        if(estado!=estadoPartida.PREFLOP) {
//            if (apuestaPlayer == apuestaBot) {
//                avanzaEstado();
//            }
//        }
//        else if(estado==estadoPartida.PREFLOP){
//
//        }
//    }



}
