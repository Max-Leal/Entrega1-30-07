import javax.swing.JOptionPane;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            int numero = (int)(Math.random() * 100) + 1;
            int tentativas = 0;

            // TODO: loop de adivinhação
            // TODO: feedback de alto/baixo após cada tentativa
            // TODO: mensagem de conclusão com performance
            // TODO: perguntar se quer jogar de novo com showConfirmDialog

            jogarNovamente = false; // remover quando implementar
        }
    }

    static String classificar(int tentativas) {
        // TODO: retornar classificação baseada no número de tentativas
        return "";
    }
}