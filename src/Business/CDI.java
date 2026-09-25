package Business;

public class CDI extends Calculo{
    public CDI(float lblValor1, float lblValor2, float lblValor3) {
        super(lblValor1, lblValor2, lblValor3);
    }
    @Override
    public void calcularRendimento() {
        lblValor2 = 0.53F;
        lblResultado = lblValor1 * ((1+lblValor3) * lblValor2);

    }
}
