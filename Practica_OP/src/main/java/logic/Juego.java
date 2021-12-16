package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import poker.practica_op.hja.GUI.MainFrame;

public class Juego {

    public enum estadoPartida {INFO,PREFLOP,FLOP,TURN,RIVER};

    public enum Actions{RAISE,CALL,CHECK,FOLD};

    private Player jugador;

    private Bot bot;

    private ArrayList<Carta> board;
    
    public boolean showdown;

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

    public static estadoPartida estado;
    
    public Bot getBot(){
        return bot;
    }
    
    public Player getPlayer(){
        return jugador;
    }

    public ArrayList<Carta> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Carta> board) {
        this.board = board;
    }

    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    public double getApuestaBot() {
        return apuestaBot;
    }

    public void setApuestaBot(double apuestaBot) {
        this.apuestaBot = apuestaBot;
    }

    public double getApuestaPlayer() {
        return apuestaPlayer;
    }

    public void setApuestaPlayer(double apuestaPlayer) {
        this.apuestaPlayer = apuestaPlayer;
    }

    public ArrayList<Carta> getCartasJugador() {
        return cartasJugador;
    }

    public void setCartasJugador(ArrayList<Carta> cartasJugador) {
        this.cartasJugador = cartasJugador;
    }

    public ArrayList<Carta> getCartasBot() {
        return cartasBot;
    }

    public void setCartasBot(ArrayList<Carta> cartasBot) {
        this.cartasBot = cartasBot;
    }

    public static estadoPartida getEstado() {
        return estado;
    }

    public static void setEstado(estadoPartida estado) {
        Juego.estado = estado;
    }

    public Juego(Strat level, boolean ciuegaPequeña){
        cartasJugador =new ArrayList<>();
        cartasBot = new ArrayList<>();
        
        barajaBarajada=(ArrayList<Carta>) baraja.clone();
        Collections.shuffle(barajaBarajada);
        this.bote=0;
        estado=estadoPartida.INFO;
        showdown = false;

        //ciegaPequeña true para el bot -> False para el player
        bot=new Bot(100,level,ciuegaPequeña);
        jugador=new Player(100);
        board=new ArrayList<Carta>();

    }

    public void startGame(){

        jugador.dealNLHECards(barajaBarajada.get(0),barajaBarajada.get(1));
        cartasJugador.add(barajaBarajada.get(0));cartasJugador.add(barajaBarajada.get(1));
        barajaBarajada.remove(0); 
        barajaBarajada.remove(0);
        bot.dealNLHECards(barajaBarajada.get(0),barajaBarajada.get(1));
        cartasBot.add(barajaBarajada.get(0));cartasBot.add(barajaBarajada.get(1));
        barajaBarajada.remove(0); 
        barajaBarajada.remove(0);

        if(bot.CiegaPequeña()){
            apuestaBot=0.5;
            bot.restarFichas(apuestaBot);
//            if(bot.tieneFichas(apuestaBot))
//                bot.setFichas(bot.getFichas()-apuestaBot);
            apuestaPlayer=1;
            jugador.restarFichas(apuestaPlayer);
//            if(jugador.tieneFichas(apuestaPlayer))
//                 jugador.setFichas(jugador.getFichas()-apuestaPlayer);



        }
        else{
            apuestaBot=1;
            bot.setFichas(bot.getFichas()-apuestaBot);
            apuestaPlayer=0.5;
            jugador.setFichas(jugador.getFichas()-apuestaPlayer);

        }

        estado=estadoPartida.PREFLOP;

    }
    
   


    public void cambiaEstado(estadoPartida estado){

        switch(estado) {
            case INFO:
                if(showdown){
                    checkWinner();
                }
                bote = 0;
                apuestaBot = 0;
                apuestaPlayer = 0;
                board.clear();
                bot.getCartas().clear();
                jugador.getCartas().clear();
                barajaBarajada.clear();
                barajaBarajada=(ArrayList<Carta>) baraja.clone();
                Collections.shuffle(barajaBarajada);
               this.estado = estado;
                break; 
            case PREFLOP:
                startGame();
                break;

            case FLOP:
                //bote+=apuestaBot+apuestaPlayer;
                apuestaBot = 0;
                apuestaPlayer = 0;
                board.add(barajaBarajada.get(0));
                board.add(barajaBarajada.get(1));
                board.add(barajaBarajada.get(2));
                barajaBarajada.remove(barajaBarajada.get(0));
                barajaBarajada.remove(barajaBarajada.get(0));
                barajaBarajada.remove(barajaBarajada.get(0));
                bot.evaluaBot(board);
                this.estado=estadoPartida.FLOP;
                break;

            case TURN:
                //bote+=apuestaBot+apuestaPlayer;
                apuestaBot = 0;
                apuestaPlayer = 0;
                board.add(barajaBarajada.get(0));
                barajaBarajada.remove(barajaBarajada.get(0));
                bot.evaluaBot(board);
                this.estado=estadoPartida.TURN;
                break;

            case RIVER:

                //bote+=apuestaBot+apuestaPlayer;
                apuestaBot = 0;
                apuestaPlayer = 0;
                board.add(barajaBarajada.get(0));
                barajaBarajada.remove(barajaBarajada.get(0));

                bot.evaluaBot(board);
                this.estado=estadoPartida.RIVER;
                break;
        }
    }

    public boolean checkApuestaJ(double apuesta){
        return jugador.tieneFichas(apuesta);
    }

    public Juego.Actions action(boolean turno,double bet){
        //turno=true -> turno del bot

      if(turno){
          if(bet > apuestaPlayer){
              apuestaBot += bet; 
              bot.restarFichas(bet);
              return Actions.RAISE;
          }
          else if (bet<=apuestaPlayer && bet > 0){
              apuestaBot += bet;
              bot.restarFichas(bet);
              bote += apuestaBot + apuestaPlayer;
              return Actions.CALL;
          }
          else if (bet==0)
              return Actions.CHECK;

          else if(bet < 0){
              jugador.sumarFichas(bote + apuestaPlayer + apuestaBot);
              
              return Actions.FOLD;
          }
              

      }
      else{
          if(bet > apuestaBot){
              apuestaPlayer += bet;
              jugador.restarFichas(bet);
              return Actions.RAISE;
          }
          else if(bet <= apuestaBot && bet > 0){
              apuestaPlayer += bet;
              jugador.restarFichas(bet);
              bote += apuestaBot + apuestaPlayer;
              return Actions.CALL;
          }
          else if(bet == 0)
              return Actions.CHECK;

          else if(bet < 0){
              bot.sumarFichas(bote + apuestaPlayer + apuestaBot);
              return Actions.FOLD;
          }
              


      }
      return null;
    }


    void checkWinner(){
        Mano aux;
        jugador.evaluaJugador(board);
        bot.evaluaBot(board);

       aux= jugador.getBestHand().compareMano(bot.getBestHand());

       if(aux==jugador.getBestHand()){
           jugador.sumarFichas(bote);
       }
       else{
           bot.sumarFichas(bote);
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
