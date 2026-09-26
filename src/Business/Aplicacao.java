package Business;

public class Aplicacao implements IAplicacao {

    private float resultado;

    public float getResultado() {
        return resultado;
    }

    @Override
    public void calcularRendimento(float valorAplicado, int prazo, float taxa) {

        // Fórmula: M = C * (1 + i)^t
        resultado = valorAplicado *
                (float) Math.pow(1 + (taxa / 100), prazo);
    }
}