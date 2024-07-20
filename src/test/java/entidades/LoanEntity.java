package entidades;

public class LoanEntity {
    public String userId;
    public ISBN[] collectionOfIsbns; // Lista com codigos dos livtos

    public String isbn; //codigo do livro

    public static class ISBN{
        private final String isbn; //Classe Filha
        public ISBN(String isbn) { //Construtor
            this.isbn = isbn; //isbn da class recebe o que vem de fora isbn

        }

}

}