import javax.swing.JOptionPane;

public class CalculadoraIMC {
    public static void main(String[] args) {
        try {
            String nome = JOptionPane.showInputDialog(null, "Digite seu nome:");
            double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite seu peso em kg:"));
            double altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite sua altura em metros:"));

            double imc = peso / (altura * altura);
            String[] categoriaCor = getCategoria(imc);
            String categoria = categoriaCor[0];
            String cor = categoriaCor[1];

            String html = String.format(
                "<html><b>%s</b><br>Seu IMC é <font color='%s'><b>%.2f</b></font><br>Categoria: <font color='%s'><b>%s</b></font></html>",
                nome,
                cor,
                imc,
                cor,
                categoria
            );

            JOptionPane.showMessageDialog(null, html, "Resultado do IMC", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    static String[] getCategoria(double imc) {
        if (imc < 18.5) {
            return new String[]{"Abaixo do peso", "#3b82f6"};
        } else if (imc < 25.0) {
            return new String[]{"Peso normal", "#16a34a"};
        } else if (imc < 30.0) {
            return new String[]{"Sobrepeso", "#f97316"};
        } else {
            return new String[]{"Obesidade", "#dc2626"};
        }
    }
}