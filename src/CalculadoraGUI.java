import javax.swing.*;
import java.awt.*;

public class CalculadoraGUI {

    private double acumulado = 0;
    private String operacaoPendente = null;
    private boolean iniciarNovoNumero = true;

    private JTextField visor;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraGUI().criarInterface());
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Color corFundo = new Color(30, 30, 35);
        Color corVisor = new Color(20, 20, 24);
        Color corNumero = new Color(58, 58, 66);
        Color corOperador = new Color(255, 149, 0);
        Color corFuncao = new Color(80, 80, 90);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        painelPrincipal.setBackground(corFundo);

        visor = new JTextField("0");
        visor.setEditable(false);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("Segoe UI", Font.BOLD, 32));
        visor.setBackground(corVisor);
        visor.setForeground(Color.WHITE);
        visor.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        painelPrincipal.add(visor, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 8, 8));
        painelBotoes.setBackground(corFundo);

        String[] botoes = {
                "C", "±", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "="
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            botao.setFocusPainted(false);
            botao.setForeground(Color.WHITE);

            if (texto.matches("[0-9.]")) {
                botao.setBackground(corNumero);
            } else if (texto.equals("=")) {
                botao.setBackground(corOperador);
            } else if (texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/")) {
                botao.setBackground(corOperador.darker());
            } else {
                botao.setBackground(corFuncao);
            }

            botao.addActionListener(e -> tratarClique(texto));
            painelBotoes.add(botao);
        }

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        frame.add(painelPrincipal);
        frame.setSize(360, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void tratarClique(String texto) {
        switch (texto) {
            case "C":
                acumulado = 0;
                operacaoPendente = null;
                iniciarNovoNumero = true;
                visor.setText("0");
                break;

            case "±":
                double valorAtual = Double.parseDouble(visor.getText());
                visor.setText(formatar(valorAtual * -1));
                break;

            case "%":
                double valorPercentual = Double.parseDouble(visor.getText());
                visor.setText(formatar(valorPercentual / 100));
                iniciarNovoNumero = true;
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                aplicarOperacaoPendente();
                operacaoPendente = texto;
                acumulado = Double.parseDouble(visor.getText());
                iniciarNovoNumero = true;
                break;

            case "=":
                aplicarOperacaoPendente();
                operacaoPendente = null;
                iniciarNovoNumero = true;
                break;

            case ".":
                if (iniciarNovoNumero) {
                    visor.setText("0.");
                    iniciarNovoNumero = false;
                } else if (!visor.getText().contains(".")) {
                    visor.setText(visor.getText() + ".");
                }
                break;

            default: // dígitos 0-9
                if (iniciarNovoNumero || visor.getText().equals("0")) {
                    visor.setText(texto);
                    iniciarNovoNumero = false;
                } else {
                    visor.setText(visor.getText() + texto);
                }
        }
    }

    private void aplicarOperacaoPendente() {
        if (operacaoPendente == null) {
            acumulado = Double.parseDouble(visor.getText());
            return;
        }

        double num2 = Double.parseDouble(visor.getText());
        double resultado;

        switch (operacaoPendente) {
            case "+":
                resultado = acumulado + num2;
                break;
            case "-":
                resultado = acumulado - num2;
                break;
            case "*":
                resultado = acumulado * num2;
                break;
            case "/":
                if (num2 == 0) {
                    visor.setText("Erro: div. por 0");
                    acumulado = 0;
                    return;
                }
                resultado = acumulado / num2;
                break;
            default:
                resultado = num2;
        }

        acumulado = resultado;
        visor.setText(formatar(resultado));
    }

    private String formatar(double valor) {
        if (valor == Math.floor(valor) && !Double.isInfinite(valor)) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }
}
