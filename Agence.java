class Agence {
    public static final int nbmax = 100;
    public static int nbComptes = 0;
    public static int nbClients = 0;
    private String numero;
    private String adresse;
    private Client[] lesClients;
    private Compte[] lesComptes;

    public Agence(String numero, String adresse) {
        this.numero = numero;
        this.adresse = adresse;
        this.lesClients = new Client[nbmax];
        this.lesComptes = new Compte[nbmax];
    }

    public Compte getCompte(int c) {
        if (c >= 0 && c < nbComptes) {
            return lesComptes[c];
        }
        return null; // Add this line to handle the case when the index is out of bounds
    }

    public Client getClient(int clt) {
        if (clt >= 0 && clt < nbClients) {
            return lesClients[clt];
        }
        return null; // Add this line to handle the case when the index is out of bounds
    }

    public void addCompte(Compte c) {
        if (nbComptes < nbmax) {
            lesComptes[nbComptes++] = c;
        }
    }

    public void addClient(Client clt) {
        if (nbClients < nbmax) {
            lesClients[nbClients++] = clt;
        }
    }

    public int getNbClients() {
        return nbClients;
    }

    public int getNbComptes() {
        return nbComptes;
    }

    @Override
    public String toString() {
        return "Agence [numero=" + numero + ", adresse=" + adresse + "]";
    }
}
