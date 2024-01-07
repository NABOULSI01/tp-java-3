import java.util.Arrays;
import java.util.Comparator;

public class ApplicationBancaire {

    public static void main(String[] args) {
        // a) Create a single bank agency.
        Agence agence = new Agence("001", "Agence principale");

        // b) Create an array of 4 clients
        Client[] clients = new Client[4];

        clients[0] = new Client(agence, "Client1", "Nom1", "Adresse1");
        CompteEpargne compteEpargne1 = new CompteEpargne();
        compteEpargne1.deposer(1000);
        clients[0].addCompte(compteEpargne1);

        clients[1] = new Client(agence, "Client2", "Nom2", "Adresse2");
        ComptePayant comptePayant1 = new ComptePayant("CP001", 2500);
        clients[1].addCompte(comptePayant1);

        clients[2] = new Client(agence, "Client3", "Nom3", "Adresse3");
        ComptePayant comptePayant2a = new ComptePayant("CP002", 0);
        ComptePayant comptePayant2b = new ComptePayant("CP003", 3000);
        clients[2].addCompte(comptePayant2a);
        clients[2].addCompte(comptePayant2b);

        clients[3] = new Client(agence, "Client4", "Nom4", "Adresse4");
        CompteEpargne compteEpargne4 = new CompteEpargne();
        ComptePayant comptePayant4 = new ComptePayant("CP004", 0);
        compteEpargne4.deposer(2300);
        clients[3].addCompte(compteEpargne4);
        clients[3].addCompte(comptePayant4);

        // e) Add all created clients to the agency
        for (Client client : clients) {
            addClientToAgence(client, agence);
        }

        // c) Allow a client to deposit any amount into his/her account(s)
        clients[0].deposer(0, 500);
        clients[2].deposer(1, 800);

        // d) Allow a client to withdraw any amount from his/her account(s)
        clients[1].retirer(0, 1000);
        clients[3].retirer(0, 200);

        // f) Apply the CalculIntérêt(...) method to all savings accounts in the agency
        for (int i = 0; i < agence.getNbComptes(); i++) {
            Compte compte = agence.getCompte(i);
            if (compte instanceof CompteEpargne) {
                ((CompteEpargne) compte).calculInteret();
            }
        }

        // g) Display the requested information
        System.out.println("Liste des clients avec leurs comptes:");
        for (int i = 0; i < agence.getNbClients(); i++) {
            Client client = agence.getClient(i);
            System.out.println(client.toString());
            for (int j = 0; j < client.getNbComptes(); j++) {
                System.out.println("  " + client.getCompte(j).toString());
            }
        }

        System.out.println("\nListe des comptes d'épargne de l'agence:");
        for (int i = 0; i < agence.getNbComptes(); i++) {
            Compte compte = agence.getCompte(i);
            if (compte instanceof CompteEpargne) {
                System.out.println(compte.toString());
            }
        }

        System.out.println("\nListe des comptes payants de l'agence:");
        for (int i = 0; i < agence.getNbComptes(); i++) {
            Compte compte = agence.getCompte(i);
            if (compte instanceof ComptePayant) {
                System.out.println(compte.toString());
            }
        }

        System.out.println("\nSolde total des comptes d'un client (client4):");
        double soldeTotalClient4 = getSoldeTotal(clients[3]);
        System.out.println("Solde total: " + soldeTotalClient4);

        // Ranking of different clients based on their total balance
        Arrays.sort(
                clients,
                Comparator.comparingDouble(client -> getSoldeTotal(client))
        );

        System.out.println("\nClassement des clients selon le solde total:");
        for (int i = clients.length - 1; i >= 0; i--) {
            Client client = clients[i];
            System.out.println(
                    client.toString() + " - Solde total: " + getSoldeTotal(client)
            );
        }
    }

    private static void addClientToAgence(Client client, Agence agence) {
        agence.addClient(client);
    }

    private static double getSoldeTotal(Client client) {
        double soldeTotal = 0.0;
        for (int i = 0; i < client.getNbComptes(); i++) {
            soldeTotal += client.getCompte(i).getSolde();
        }
        return soldeTotal;
    }
}
