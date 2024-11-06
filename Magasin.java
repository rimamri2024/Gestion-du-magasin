public class Magasin {


    private int identifiant;
    private String adresse;
    private final static int CAPACITE = 2;
    private int quantite = 0;
    private static int quantite_total = 0;
    private Produit ensemble_produits[] = new Produit[CAPACITE];

    public Magasin() {}

    public Magasin(int identifiant, String adresse) {
        this.identifiant = identifiant;
        this.adresse = adresse;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public static int getQuantite_total() {
        return quantite_total;
    }

    public static void setQuantite_total(int quantite_total) {
        Magasin.quantite_total = quantite_total;
    }

    public Produit[] getEnsemble_produits() {
        return ensemble_produits;
    }

    public void setEnsemble_produits(Produit[] ensemble_produits) {
        this.ensemble_produits = ensemble_produits;
    }

    public int chercher_produit(Produit p) {
        for (int i = 0; i < quantite; i++) {
            if (ensemble_produits[i].comparer(p) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void ajouterProduit(Produit p) {
        if (quantite < CAPACITE) {
            ensemble_produits[quantite] = p;
            quantite++;
            quantite_total++;
            System.out.println("Product added: " + p.getLibelle());
        } else {
            System.out.println("Capacity reached, cannot add more products.");
        }
    }

    public void supprimerProduit(Produit p) {
        int index = chercher_produit(p);
        if (index != -1) {
            for (int i = index; i < quantite - 1; i++) {
                ensemble_produits[i] = ensemble_produits[i + 1];
            }
            ensemble_produits[quantite - 1] = null;
            quantite--;
            quantite_total--;
            System.out.println("Product removed: " + p.getLibelle());
        } else {
            System.out.println("Product not found: " + p.getLibelle());
        }
    }
}