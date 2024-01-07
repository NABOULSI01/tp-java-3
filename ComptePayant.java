public class ComptePayant extends Compte {
    ComptePayant comptePayant1 = new ComptePayant("CP001", 2500);

    public ComptePayant(String code, double solde) {
        super(code, solde);
    }
}
