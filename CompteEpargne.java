public class CompteEpargne extends Compte {

    public double taux;

    public CompteEpargne(String code) {
        super(code); // Call the parameterized constructor of the superclass
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void calculInteret() {
        double interet = taux * getSolde(); // Use getSolde() to access the solde property
        System.out.println("les interets sont:" + interet);
    }

    @Override
    public String toString() {
        return (
                "CompteEpargne [code=" +
                        getCode() + // Use getCode() to access the code property
                        ", solde=" +
                        getSolde() + // Use getSolde() to access the solde property
                        ", taux=" +
                        taux +
                        "]"
        );
    }
}
