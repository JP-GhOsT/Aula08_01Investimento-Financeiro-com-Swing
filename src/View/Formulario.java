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



    }
}
