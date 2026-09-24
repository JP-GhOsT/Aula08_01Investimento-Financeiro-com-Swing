package View;

import javax.swing.*;
import java.awt.*;

public class Formulario {

    private JFrame form;
    private JLabel lblValor1, lblValor2,lblValor3, lblResultado;
    private JTextField txtValor1, txtValor2, txtValor3;
    private JButton btnCalcular;
    private JComboBox cbDropDown;

    public Formulario() {


        inicializarComponentes();
    }
    private void inicializarComponentes(){

        form = new JFrame("Calculadora com Swing");
        form.setBounds(600, 250, 500, 300);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);
        Container painelDeConteudo = form.getContentPane();

        //labels
        lblValor1 = new JLabel("Valor Inicial:");
        lblValor1.setBounds(50, 30, 80, 25);
        form.add(lblValor1);

        lblValor2 = new JLabel("Prazo:");
        lblValor2.setBounds(50, 70, 80, 25);
        form.add(lblValor2);

        lblValor3 = new JLabel("Investimento");
        lblValor3.setBounds(50, 110, 80, 25);
        form.add(lblValor3);

        lblResultado = new JLabel("Resultado ");
        lblResultado.setBounds(50, 150, 80, 25);
        form.add(lblResultado);




    }
}
