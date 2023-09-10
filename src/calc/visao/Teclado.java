package calc.visao;

import calc.modelo.Memoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teclado extends JPanel implements ActionListener {

    private final Color COR_CINZA_ESCUTO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
    private final Color COR_LARANJA = new Color(242, 163, 60);


    public Teclado() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        //Linha1
        adicionarBotao("AC", COR_CINZA_ESCUTO, constraints, 0, 0);
        adicionarBotao("+/-", COR_CINZA_ESCUTO, constraints, 1, 0);
        adicionarBotao("%", COR_CINZA_ESCUTO, constraints, 2, 0);
        adicionarBotao("/", COR_LARANJA, constraints, 3, 0);

        //Linha 2
        adicionarBotao("7", COR_CINZA_CLARO, constraints, 0, 1);
        adicionarBotao("8", COR_CINZA_CLARO, constraints, 1, 1);
        adicionarBotao("9", COR_CINZA_CLARO, constraints, 2, 1);
        adicionarBotao("*", COR_LARANJA, constraints, 3, 1);

        //Linha 3
        adicionarBotao("4", COR_CINZA_CLARO, constraints, 0, 2);
        adicionarBotao("5", COR_CINZA_CLARO, constraints, 1, 2);
        adicionarBotao("6", COR_CINZA_CLARO, constraints, 2, 2);
        adicionarBotao("-", COR_LARANJA, constraints, 3, 2);

        //Linha 4
        adicionarBotao("1", COR_CINZA_CLARO, constraints, 0, 3);
        adicionarBotao("2", COR_CINZA_CLARO, constraints, 1, 3);
        adicionarBotao("3", COR_CINZA_CLARO, constraints, 2, 3);
        adicionarBotao("+", COR_LARANJA, constraints, 3, 3);

        //Linha 5
        constraints.gridwidth = 2;
        adicionarBotao("0", COR_CINZA_CLARO, constraints, 0, 4);
        constraints.gridwidth = 1;
        adicionarBotao(",", COR_CINZA_CLARO, constraints, 2, 4);
        adicionarBotao("=", COR_LARANJA, constraints, 3, 4);

    }

    private void adicionarBotao (String texto, Color cor, GridBagConstraints constraint, int x, int y){
        constraint.gridx = x;
        constraint.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);
        add(botao, constraint);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() instanceof JButton){
            JButton botao = (JButton) event.getSource();
            Memoria.getInstance().processarComando(botao.getText());
        }
    }
}