import java.util.Date;

public class Produit {
    protected int identifiant;
    protected String libelle;
    protected String marque;
    protected float prix;
    protected Date date_expiration;

    public Produit() {}

    public Produit(int identifiant, String libelle, String marque, float prix) {
        this.identifiant = identifiant;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = Math.max(prix, 0);
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = Math.max(prix, 0);
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public void afficher() {
        System.out.println("Produit{" + "identifiant=" + identifiant + ", libelle=" + libelle + ", marque=" + marque + ", prix=" + prix + '}');
    }

    @Override
    public String toString() {
        return "Produit{" + "identifiant=" + identifiant + ", libelle=" + libelle + ", marque=" + marque + ", prix=" + prix + ", date_expiration=" + date_expiration + '}';
    }

    public int comparer(Produit autreProduit) {
        return Float.compare(this.prix, autreProduit.getPrix());
    }
}
