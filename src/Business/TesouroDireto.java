package Business;

public class TesouroDireto extends Calculo{
    public TesouroDireto(float lblValor1, float lblValor2, float lblValor3) {
        super(lblValor1, lblValor2, lblValor3);
    }
    @Override
    public void calcularRendimento() {
        //M = C * (1 + i)t
        lblValor2 = 0.65F;
        lblResultado = lblValor1 * ((1+lblValor3) * lblValor2);
    }
}
