package logic;

public class Carta implements Comparable<Object> {
    private int valor;
    private String palo;
    private String representacion;

    public Carta(String valor, String palo) {

        switch(valor) {
            case"A":
                this.valor = 14;
                break;
            case"K":
                this.valor = 13;
                break;
            case"Q":
                this.valor = 12;
                break;
            case"J":
                this.valor = 11;
                break;
            case"T":
                this.valor = 10;
                break;
            default:
                this.valor = Integer.parseInt(valor);
        }

        this.palo = palo;
        this.representacion=valor;

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }



    public String getPalo() {
        return palo;
    }

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return representacion + palo;
    }

    @Override
    public int compareTo(Object o) {
        try {
            if (o.getClass() == Carta.class) {

                if (((Carta) o).valor > this.valor)
                    return -1;

                else if (((Carta) o).valor < this.valor)
                    return 1;

                else
                    return 0;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2;
    }
}
