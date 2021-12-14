package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Bot {



    //Estado del jugador
    private State state;
    //80%
    private ArrayList<String> rangoPassive =new ArrayList<String>(Arrays.asList("AA","KK", "QQ", "JJ", "TT", "99", "88", "77", "66", "55", "44", "33", "22","AKs", "AQs","AJs",
            "ATs", "A9s","A8s","A7s","A6s","A5s","A4s", "A3s", "A2s","KQs","KJs","KTs","K9s","K8s", "K7s","K6s", "K5s", "K4s", "K3s", "K2s",
            "QJs", "QTs","Q9s", "Q8s", "Q7s","Q6s","Q5s", "Q4s", "Q3s", "Q2s", "JTs", "J9s", "J8s", "J7s", "J6s", "J5s", "J4s", "J3s", "J2s",
            "T9s", "T8s", "T7s", "T6s", "T5s", "T4s", "T3s", "T2s", "98s", "97s", "96s","95s", "94s", "93s", "92s", "87s", "86s", "85s", "84s",
            "76s", "75s", "74s", "65s", "AKo", "AQo", "AJo","ATo","A9o","A8o","A7o","A6o","A5o","A4o","A3o","A2o","KQo","KJo","KTo","K9o","K8o","K7o","K6o",
            "K5o","K4o","K3o","K2o","QJo","QTo","Q9o","Q8o","Q7o","Q6o","Q5o","Q4o","Q3o","Q2o","JTo","J9o","J8o","J7o","J6o","J5o","J4o","J3o","J2o",
            "T9s","T9o","T8o","T7o","T6o","T5o","T4o","T3o","98o","97o","96o","95o","87o","86o","87o","86o","85o","76o"));
    //40%
    private ArrayList<String> rangoMedio = new ArrayList<String>(Arrays.asList( "AA","KK","QQ","JJ","TT","99","88","77","66","55","44","33","22","AKs","AQs","AJs","ATs","A9s","A8s","A7s","A6s","A5s","A4s","A3s","A2s","KQs","KJs","KTs","K9s","K8s"
            ,"K7s","K6s","K5s","K4s","K3s","K2s","QJs","QTs","Q9s","Q8s","JTs","J9s","Ako","AQo","AJo","ATo","A9o","A8o","A7o","A6o","A5o","A4o","A3o","A2o","KQo","KJ0",
            "KQo","KJo","KTo","K9o","K8o","K7o","K6o","K5o","K4o","AJo","QTo","Q9o","JTo"));

    //10%
    private ArrayList<String> rangoCerrado = new ArrayList<String>(Arrays.asList("AA","KK","QQ","JJ","TT","99","88","77","66","AKs","AQs","AJs","ATs","AKo","AQo","AJo"));


    //Una lista de las cartas del jugador en formato procesable
    private ArrayList<String> s_cards;

    private Strat level;

    private String rango;

    //Una lista para guardar las cartas del jugador
    private ArrayList<Carta> cards;

    public boolean CiegaPequeña() {
        return ciegaPequeña;
    }
//El equity del jugador
    //JJ dice: Por ahora no se sabe donde se calcula esto asi que se deja sin usar


    private ArrayList<Mano> manos;

    private Mano bestHand;

    boolean ciegaPequeña;

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



    public Bot(int fichas,Strat level,boolean ciegaPequeña){

        cards = new ArrayList<>();
        this.level=level;
        manos = new ArrayList<>();
        this.fichas =fichas;
        state = State.NOT_PLAYING;
        this.ciegaPequeña=ciegaPequeña;
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

    //Primera estrategia Preflop
    public boolean rango() {
        String aux="";
        boolean result=false;

        if(cards.get(0).getValor()==cards.get(1).getValor()){
            //llamar a la practica2 el primer apartado.(con la pareja)
            aux=cards.get(0).getRepresentacion()+cards.get(1).getRepresentacion();
        }
        else if (cards.get(0).getPalo().equals(cards.get(1).getPalo())){
            //llamar a la practica2 el primer apartado.(con el suited)
            aux=cards.get(0).getRepresentacion()+cards.get(1).getRepresentacion()+"s";
        }
        else {
            aux = cards.get(0).getRepresentacion() + cards.get(1).getRepresentacion()+"o";
            //llamar a la practica2 el primer apartado.(con el offsuited)
        }
        // return arraysDeRangos.contains(RangoCreado)

        if(level==Strat.AGRESSIVE){
            result= rangoPassive.contains(aux);
        }
        else if(level==Strat.INTERMIDE){
            result= rangoMedio.contains(aux);
        }
        else if(level==Strat.PASSIVE)
            result= rangoCerrado.contains(aux);

        this.rango=aux;

        return  result;
    }


    public double preflopAgressive(double bet){
        double porcentaje = rangoPassive.size()*0.8;
        boolean encontrado = false;
        int i=0;
        
        if (rango()){
            while (i<porcentaje && !encontrado){

            if(rango.equals(rangoPassive.get(i)))
                encontrado=true;

            i++;
            }

            if(ciegaPequeña){

                if(encontrado) {
                    if(this.fichas>2.5)
                        return 2.5;
                    else
                        return this.fichas;
                }
                else{
                    if(this.fichas>0.5)
                        return 0.5;
                    else
                        return this.fichas;
                }



            }
            else{

                if(encontrado){

                    if(this.fichas>2*bet)
                        return 2*bet;
                    else
                        return this.fichas;

                }
                else if (bet==0.5)
                    return 0;
                else
                    return -1;


            }
        }else{
            return -1;
        }
        
}

    public double postFlopAgressive(double bet, double pot, Juego.estadoPartida state){
        if(ciegaPequeña){
            if(bet==0){
                if(bestHand.getBesthand().getNumVal()>=Ranking.PAIR.getNumVal()) {

                    if(state== Juego.estadoPartida.RIVER)
                        return this.fichas;

                    if (this.fichas > pot * 0.5)
                        return pot * 0.5;
                    else
                        return this.fichas;

                }
                else
                    return 0;
            }
            else {
                if (this.fichas > bet)
                    return bet;
                else
                    return this.fichas;

            }

        }
        else{
            if(bestHand.getBesthand().getNumVal()>=Ranking.PAIR.getNumVal()){
                if(this.fichas>pot*0.5)
                    return pot*0.5;
                else
                    return this.fichas;
            }
            else{
                return 0;
            }
        }
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

    public void evaluaBot(ArrayList<Carta> board){
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
