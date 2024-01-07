import java.util.ArrayList;

public class Client {

    private String code;
    private String nom;
    private String prenom;
    private String adresse;
    private Agence monAgence;
    private ArrayList<Compte> mesComptes; // Change from array to ArrayList
    public static final int nb_max_compte = 100;
    private static int nbClients = 0;

    public Client(Agence agence) {
        code = this.getClass().getName() + ":" + ++nbClients;
        monAgence = agence;
        mesComptes = new ArrayList<>();
    }

    public Client(Agence agence, String nom, String prenom, String adresse) {
        code = this.getClass().getName() + ":" + ++nbClients;
        monAgence = agence;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        mesComptes = new ArrayList<>();
    }

    public Compte getCompte(int nCompte) {
        if (nCompte >= 0 && nCompte < mesComptes.size()) {
            return mesComptes.get(nCompte);
        }
        return null;
    }

    public void addCompte(Compte newCompte) {
        if (mesComptes.size() < nb_max_compte) {
            mesComptes.add(newCompte);
        }
    }

    public void deposer(int compteIndex, double montant) {
        Compte compte = getCompte(compteIndex);
        if (compte != null) {
            compte.deposer(montant);
            System.out.println("depot completed");
        } else {
            System.out.println("depot failed");
        }
    }

    public void retirer(int compteIndex, double montant) {
        Compte compte = getCompte(compteIndex);
        if (compte != null) {
            compte.retirer(montant);
            System.out.println("retrait completed");
        } else {
            System.out.println("retrait failed");
        }
    }

    public int getNbComptes() {
        return mesComptes.size();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return (
                "Client [code=" +
                        code +
                        ", nom=" +
                        nom +
                        ", prenom=" +
                        prenom +
                        ", adresse=" +
                        adresse +
                        "]"
        );
    }
}
