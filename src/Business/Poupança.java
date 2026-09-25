package Business;

public class Poupança extends Calculo{

    public Poupança(float lblValor1, float lblValor2, float lblValor3) {
        super(lblValor1, lblValor2, lblValor3);
    }

    @Override
    public void calcularRendimento() {
        lblValor2 = 0.38F;
        lblResultado = lblValor1 * ((1+lblValor3) * lblValor2);
    }
}
