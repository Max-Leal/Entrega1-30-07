import javax.swing.JOptionPane;

public class ConversorTemperatura {
    public static void main(String[] args) {
        String[] conversoes = {"°C → °F", "°C → K", "°F → °C", "°F → K", "K → °C", "K → °F", "Sair"};
        boolean continuar = true;

        while (continuar) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma conversão:",
                "Conversor de Temperatura",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                conversoes,
                conversoes[0]
            );

            if (escolha == 6 || escolha == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Até a próxima! 👋");
                continuar = false;
                continue;
            }

            try {
                String valorTexto = JOptionPane.showInputDialog(null, "Digite o valor da temperatura:");
                double valor = Double.parseDouble(valorTexto);

                if ((escolha == 4 || escolha == 5) && valor < 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Valor de Kelvin inválido! O Kelvin não pode ser negativo.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                    );
                    continue;
                }

                double resultado = converter(valor, escolha);
                JOptionPane.showMessageDialog(
                    null,
                    String.format("Resultado: %.2f", resultado),
                    "Conversão",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Digite apenas números válidos!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    static double converter(double valor, int tipo) {
        switch (tipo) {
            case 0: return (valor * 9 / 5) + 32;
            case 1: return valor + 273.15;
            case 2: return (valor - 32) * 5 / 9;
            case 3: return ((valor - 32) * 5 / 9) + 273.15;
            case 4: return valor - 273.15;
            case 5: return ((valor - 273.15) * 9 / 5) + 32;
            default: throw new IllegalArgumentException("Conversão inválida");
        }
    }
}