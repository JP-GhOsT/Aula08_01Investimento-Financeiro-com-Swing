package Business;

public abstract class Calculo implements IAplicacao{

    private float lblValor1, lblValor2,lblValor3, lblResultado;

    public float getResultado() { return lblResultado; }

    public Calculo(float lblValor1, float lblValor2, float lblValor3, float lblResultado) {
        this.lblValor1 = lblValor1;
        this.lblValor2 = lblValor2;
        this.lblValor3 = lblValor3;
        this.lblResultado = lblResultado;
    }
}
