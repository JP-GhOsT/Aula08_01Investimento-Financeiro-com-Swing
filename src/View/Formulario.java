package View;

import Business.Aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {

    private JFrame form;

    private JLabel lblValor1;
    private JLabel lblValor2;
    private JLabel lblValor3;
    private JLabel lblResultado;

    private JTextField txtValor1;
    private JTextField txtValor2;

    private JComboBox<String> cbDropDown;

    private JButton btnCalcular;


    public Formulario() {
        inicializarComponentes();
    }


    private void inicializarComponentes() {

        // =====================================================
        // JANELA
        // =====================================================

        form = new JFrame("Calculadora com Swing");

        form.setSize(650, 500);

        form.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        // Centraliza a janela
        form.setLocationRelativeTo(null);

        // Impede redimensionamento
        form.setResizable(false);

        // Layout principal
        form.setLayout(new BorderLayout());


        // =====================================================
        // CORES
        // =====================================================

        Color fundo = new Color(245, 248, 252);

        Color azul = new Color(45, 115, 190);

        Color azulBotao = new Color(35, 120, 210);

        Color texto = new Color(45, 65, 90);

        form.getContentPane().setBackground(fundo);


        // =====================================================
        // CABEÇALHO
        // =====================================================

        JPanel painelTitulo = new JPanel();

        painelTitulo.setBackground(azul);

        painelTitulo.setPreferredSize(
                new Dimension(650, 80)
        );


        JLabel titulo =
                new JLabel("Calculadora de Rendimento");

        titulo.setForeground(Color.WHITE);

        titulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26
                )
        );


        painelTitulo.add(titulo);

        form.add(
                painelTitulo,
                BorderLayout.NORTH
        );


        // =====================================================
        // PAINEL DO FORMULÁRIO
        // =====================================================

        JPanel painelFormulario =
                new JPanel(new GridBagLayout());

        painelFormulario.setBackground(fundo);

        painelFormulario.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(10, 10, 10, 10);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        // =====================================================
        // VALOR INICIAL
        // =====================================================

        lblValor1 =
                criarLabel(
                        "Valor Inicial:",
                        texto
                );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;

        painelFormulario.add(
                lblValor1,
                gbc
        );


        txtValor1 = criarTextField();

        txtValor1.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });

        txtValor1.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                limparResultado();
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;

        painelFormulario.add(
                txtValor1,
                gbc
        );


        // =====================================================
        // PRAZO
        // =====================================================

        lblValor2 =
                criarLabel(
                        "Prazo:",
                        texto
                );

        gbc.gridx = 0;
        gbc.gridy = 1;

        painelFormulario.add(
                lblValor2,
                gbc
        );


        txtValor2 = criarTextField();

        txtValor2.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        txtValor2.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                limparResultado();
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 1;

        painelFormulario.add(
                txtValor2,
                gbc
        );


        // =====================================================
        // TAXA
        // =====================================================

        lblValor3 =
                criarLabel(
                        "Taxa:",
                        texto
                );

        gbc.gridx = 0;
        gbc.gridy = 2;

        painelFormulario.add(
                lblValor3,
                gbc
        );


        cbDropDown =
                new JComboBox<>();

        cbDropDown.addItem("Poupança");
        cbDropDown.addItem("CDI");
        cbDropDown.addItem("Tesouro Direto");

        cbDropDown.addActionListener(e -> {
            limparResultado();
        });


        cbDropDown.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        cbDropDown.setPreferredSize(
                new Dimension(350, 40)
        );


        gbc.gridx = 1;
        gbc.gridy = 2;

        painelFormulario.add(
                cbDropDown,
                gbc
        );


        // =====================================================
        // RESULTADO
        // =====================================================

        lblResultado =
                criarLabel(
                        "Resultado:",
                        texto
                );

        gbc.gridx = 0;
        gbc.gridy = 3;

        painelFormulario.add(
                lblResultado,
                gbc
        );

        // =====================================================
        // BOTÃO
        // =====================================================

        btnCalcular =
                new JButton(
                        "Calcular Rendimento"
                );


        btnCalcular.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );


        btnCalcular.setForeground(Color.WHITE);

        btnCalcular.setBackground(azulBotao);

        btnCalcular.setFocusPainted(false);

        btnCalcular.setBorderPainted(false);

        btnCalcular.setPreferredSize(
                new Dimension(350, 45)
        );


        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.gridwidth = 2;

        gbc.insets =
                new Insets(
                        25,
                        10,
                        10,
                        10
                );


        painelFormulario.add(
                btnCalcular,
                gbc
        );


        // =====================================================
        // PAINEL NA JANELA
        // =====================================================

        form.add(
                painelFormulario,
                BorderLayout.CENTER
        );


        // =====================================================
        // EVENTO DO BOTÃO
        // =====================================================

        btnCalcular.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        calcular();

                    }
                }
        );


        // =====================================================
        // MOSTRAR
        // =====================================================

        form.setVisible(true);
    }


    // =========================================================
    // MÉTODO RESPONSÁVEL POR CONVERSAR COM O BUSINESS
    // =========================================================

    private void calcular() {

        // Verifica se os campos estão preenchidos
        if (txtValor1.getText().trim().isEmpty()
                || txtValor2.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    form,
                    "Preencha todos os campos antes de calcular.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            // Valor aplicado
            float valorAplicado = Float.parseFloat(
                    txtValor1.getText().replace(",", ".")
            );

            // Prazo em meses
            int prazo = Integer.parseInt(
                    txtValor2.getText()
            );

            // Pega a opção escolhida
            String opcao =
                    (String) cbDropDown.getSelectedItem();

            float taxa;

            if (opcao.equals("Poupança")) {

                taxa = 0.38F;

            } else if (opcao.equals("CDI")) {

                taxa = 0.53F;

            } else {

                taxa = 0.65F;
            }

            // Cria a aplicação
            Aplicacao aplicacao = new Aplicacao();

            // Realiza o cálculo
            aplicacao.calcularRendimento(
                    valorAplicado,
                    prazo,
                    taxa
            );

            // Pega o resultado
            float resultado = aplicacao.getResultado();

            // Mostra o resultado
            lblResultado.setText(
                    String.format(
                            "Rendimento: R$ %.2f",
                            resultado
                    )
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    form,
                    "Digite valores numéricos válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =========================================================
    // CRIA LABEL
    // =========================================================

    private void limparResultado() {
        lblResultado.setText("Resultado:");
    }

    private JLabel criarLabel(
            String texto,
            Color cor
    ) {

        JLabel label =
                new JLabel(texto);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );

        label.setForeground(cor);

        return label;
    }


    // =========================================================
    // CRIA TEXTFIELD
    // =========================================================

    private JTextField criarTextField() {

        JTextField campo =
                new JTextField();


        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        campo.setPreferredSize(
                new Dimension(350, 40)
        );


        campo.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        190,
                                        205,
                                        220
                                )
                        ),

                        BorderFactory.createEmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );


        return campo;
    }
}