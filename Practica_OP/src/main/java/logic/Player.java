package logic;

import java.util.ArrayList;

public class Player {


    //Posibles estados del jugador


    //Estado del jugador
    private State state;

    //Una lista de las cartas del jugador en formato procesable
    private ArrayList<String> s_cards;

    //Una lista para guardar las cartas del jugador
    private ArrayList<Carta> cards;

    private Ranking ranking;

    //El equity del jugador
    //JJ dice: Por ahora no se sabe donde se calcula esto asi que se deja sin usar


    private ArrayList<Mano> manos;

    private Mano bestHand;

    public double getFichas() {
        return fichas;
    }

    public void setFichas(double fichas) {
        this.fichas = fichas;
    }

    private double fichas;

    public Mano getBestHand() {
        return bestHand;
    }

    public void setBestHand(Mano bestHand) {
        this.bestHand = bestHand;
    }

    private int pareja, trio, poker;


    public ArrayList<Mano> getManos() {
        return manos;
    }

    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }



    public Player(int fichas){

        s_cards = new ArrayList<>();
        cards = new ArrayList<>();
        manos = new ArrayList<>();
        this.fichas =fichas;
        state = State.NOT_PLAYING;
    }


    /**
     * Reparte cartas al jugador
     * @param card1: La primera carta
     * @param card2: La segunda carta
     */
    public void dealNLHECards(Carta card1, Carta card2){
        cards.add(card1);
        cards.add(card2);

//        s_cards.add(card1.getCardText());
//        s_cards.add(card2.getCardText());

    }



    public ArrayList<Carta> getCartas(){
        return cards;
    }

    public void setCartas(ArrayList<Carta> cartas){
        this.cards = cartas;
    }


    public void removeCards(){
        cards.clear();
        s_cards.clear();
    }


    public State getState(){
        return state;
    }


    public void setState(State state){
        this.state = state;
    }


    public Ranking getRanking(){
        return ranking;
    }



    public void setRanking(Ranking ranking){
        this.ranking = ranking;
    }


    public int getPareja(){
        return pareja;
    }



    public void setPareja(int pareja){
        this.pareja = pareja;
    }


    public int getTrio(){
        return trio;
    }

    public void setTrio(int trio){
        this.trio = trio;
    }


    public int getPoker(){
        return poker;
    }


    public void setPoker(int poker){
        this.poker = poker;
    }


    public void addCartas(ArrayList<Carta> toAdd){
        cards.addAll(toAdd);
    }

    public boolean tieneFichas(double fichas){
        return this.fichas > fichas;
    }
    public void restarFichas(double fichas){
        this.fichas-= fichas;
    }
    public void sumarFichas(double fichas){
        this.fichas+= fichas;
    }

    public void evaluaJugador(ArrayList<Carta> board){
        combinaciones(cards,board,0, board.size()-1,0,manos);
        this.bestHand=evaluaCombinaciones(manos);
    }

    public void combinaciones(ArrayList<Carta> cartas, ArrayList<Carta> manoAct,
                              int ini, int fin, int i, ArrayList<Mano> combs) {

        if (i == 5) {
            Mano aux= new Mano();

            for(int k=0;k<manoAct.size();k++){
                aux.addCarta(manoAct.get(k));
            }

            combs.add(aux);
        }
        else
            for (int j = ini; j <= fin && fin - j + 1 >= 5 - i; j++) {
                manoAct.set(i, cartas.get(j));
                combinaciones(cartas, manoAct, j + 1, fin, i + 1, combs);
            }
    }

    public Mano evaluaCombinaciones(ArrayList<Mano> combs){
        Mano max = null;

        for (Mano x : combs){
            evalua(x);
            if(max == null)
                max= x;

            else if (x.getBesthand().biggerThan(max.getBesthand()))
                max = x;
            else if(x.getBesthand()==max.getBesthand()){

                max=max.compareMano(x);

            }
        }
        return max;
    }

    public void evalua(Mano mano) {

        mano.getCartas().sort(Carta::compareTo);
        int i=0;
        int j=0;
        int par1=0;

        int almacenaI=0;
        int trebol=0;
        int corazones=0;

        int diamantes=0;
        int picas=0;
        boolean straight=true,color=true;
        ArrayList<Ranking> comb = new ArrayList<>();


        while(i<mano.getCartas().size()-1){
            //miramos segun sea pareja y vamos mirando hacia delante si es trio o poker y lo guardamso en el string para mostrarlo y adelantamos la i
            if(i+1<mano.getCartas().size() &&mano.getCartas().get(i).getValor()==mano.getCartas().get(i+1).getValor()  ) {
                //me guardo si hay pareja y con par1 veo si hay mas de 1 para poner doble pareja

                if(i+2<mano.getCartas().size() && mano.getCartas().get(i).getValor()==mano.getCartas().get(i+2).getValor()  ){

                    if(i+3<mano.getCartas().size() && mano.getCartas().get(i).getValor()==mano.getCartas().get(i+3).getValor()  ){

                        comb.add(Ranking.FOUROFAKIND);
                        mano.setPoker(mano.getCartas().get(i).getValor());

                        i=i+3;

                    }
                    else {
                        comb.add(Ranking.THREEOFAKIND);

                        mano.setTrio(mano.getCartas().get(i).getValor());



                        i=i+2;
                    }

                }
                else{

                    if(mano.getCartas().get(i).getValor() > mano.getPareja()) mano.setPareja(mano.getCartas().get(i).getValor());
                    comb.add(Ranking.PAIR);

                    par1++;
                    i++;

                }


            }

            i++;
        }



        while(j<mano.getCartas().size()) {
            //miramos si el tienen el mismo color o no
            //
            if(j+1 < mano.getCartas().size() && !mano.getCartas().get(j).getPalo().equals(mano.getCartas().get(j+1).getPalo())){
                color=false;
            }

            if(mano.getCartas().get(j).getPalo().equals("d")){
                diamantes++;
            }
            else if(mano.getCartas().get(j).getPalo().equals("c")){
                trebol++;
            }
            else if(mano.getCartas().get(j).getPalo().equals("s")){
                picas++;
            }
            else if(mano.getCartas().get(j).getPalo().equals("h")){
                corazones++;
            }


            if (j+1 < mano.getCartas().size() && mano.getCartas().get(j).getValor() != mano.getCartas().get(j + 1).getValor() - 1) {

                straight = false;


                if(j+2 < mano.getCartas().size() && mano.getCartas().get(j).getValor() == 5 && mano.getCartas().get(j + 1).getValor() == 14 && j == 3) {

                    straight = true;

                }


            }
            j++;
        }



        //best mano miro al final que mano es mejor comprobando por orden de mejor a peor
        if (straight && color) {
            mano.setBesthand(Ranking.STRAIGHTFLUSH);

            //mano.setCartasG(mano.cartas);
        }

        else if (comb.contains(Ranking.FOUROFAKIND)){
            mano.setBesthand(Ranking.FOUROFAKIND);
        }


        else if (comb.contains(Ranking.THREEOFAKIND) && comb.contains(Ranking.PAIR)) {
            mano.setBesthand(Ranking.FULLHOUSE);
        }

        else if (color) {
            mano.setBesthand(Ranking.FLUSH);
            //mano.setCartasG(mano.cartas);

        }
        else if (straight) {
            mano.setBesthand(Ranking.STRAIGHT);

            //mano.setCartasG(mano.cartas);
        }
        else if (comb.contains(Ranking.THREEOFAKIND)) {

            mano.setBesthand(Ranking.THREEOFAKIND);
        }


        else if (par1 == 2) {
            mano.setBesthand(Ranking.TWOPAIR);
        }

        else if (comb.contains(Ranking.PAIR)) {
            mano.setBesthand(Ranking.PAIR);
        }

        else {
            mano.setBesthand(Ranking.HIGHCARD);
            //mano.setCartasG (mano.cartas.get(4));
        }

    }


}
