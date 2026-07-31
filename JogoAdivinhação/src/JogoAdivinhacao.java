import javax.swing.JOptionPane;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            int numero = (int) (Math.random() * 100) + 1;
            int tentativas = 0;
            boolean acertou = false;

            while (!acertou) {
                String tentativaTexto = JOptionPane.showInputDialog(null, "Digite um número de 1 a 100:");

                if (tentativaTexto == null) {
                    JOptionPane.showMessageDialog(null, "Jogo encerrado.");
                    return;
                }

                try {
                    int palpite = Integer.parseInt(tentativaTexto);
                    tentativas++;

                    if (palpite < 1 || palpite > 100) {
                        JOptionPane.showMessageDialog(null, "Digite um número entre 1 e 100!");
                        continue;
                    }

                    if (palpite < numero) {
                        JOptionPane.showMessageDialog(null, "Muito baixo!");
                    } else if (palpite > numero) {
                        JOptionPane.showMessageDialog(null, "Muito alto!");
                    } else {
                        acertou = true;
                        String classificacao = classificar(tentativas);
                        JOptionPane.showMessageDialog(
                            null,
                            "Acertou!\nVocê acertou em " + tentativas + " tentativas!\n" + classificacao,
                            "Fim de jogo",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Digite apenas números válidos!");
                }
            }

            int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja jogar novamente?",
                "Jogar de novo",
                JOptionPane.YES_NO_OPTION
            );

            jogarNovamente = (resposta == JOptionPane.YES_OPTION);
        }
    }

    static String classificar(int tentativas) {
        if (tentativas <= 3) {
            return "🏆 Incrível!";
        } else if (tentativas <= 6) {
            return "⭐ Muito bom!";
        } else if (tentativas <= 10) {
            return "👍 Bom!";
        } else {
            return "💪 Continue praticando!";
        }
    }
}