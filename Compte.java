class Compte {

  private String code;
  protected double solde;
  protected Agence lAgence;
  protected Client proprietaire;

  public String getCode() {
    return code;
  }
  public Compte(String code) {
    this.code = code;
    
}
 
  public void setCode(String code) {
    this.code = code;
  }

  public void deposer(double montant) {
    if (montant >= 0) {
      solde += montant;
    }
  }

  public void retirer(double montant) {
    if (montant >= 0) {
      if (montant <= solde) {
        solde -= montant;
      }
    }
  }
  public Compte(String code, double solde) {
    this.code = code;
    this.solde = solde;
}
public double getSolde() {
    return solde;
}

  @Override
  public String toString() {
    return "Compte [code=" + code + ", solde=" + solde + "]";
  }
}
