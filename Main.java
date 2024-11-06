import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produit> produits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Magasin magasin = new Magasin(1, "Main Street");

    public static void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Produit produit : produits) {
            System.out.println(produit.getLibelle() + " - Price: " + produit.getPrix());
        }
    }

    public static void ajouterProduit(Produit produit) {
        produits.add(produit);
        System.out.println("Product added: " + produit.getLibelle());
        magasin.ajouterProduit(produit);
    }

    public static void supprimerProduit(Produit produit) {
        if (produits.remove(produit)) {
            System.out.println("Product removed: " + produit.getLibelle());
            magasin.supprimerProduit(produit);
        } else {
            System.out.println("Product not found: " + produit.getLibelle());
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter product details:");

            System.out.print("Identifiant: ");
            int identifiant = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Libelle: ");
            String libelle = scanner.nextLine();

            System.out.print("Marque: ");
            String marque = scanner.nextLine();

            System.out.print("Prix: ");
            float prix = scanner.nextFloat();

            Produit newProduct = new Produit(identifiant, libelle, marque, prix);
            ajouterProduit(newProduct);

            System.out.print("Do you want to add another product? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nAll products in store:");
        magasin.getEnsemble_produits();
        for (Produit p : magasin.getEnsemble_produits()) {
            if (p != null) {
                System.out.println(p.getLibelle() + " - Price: " + p.getPrix());
            }
        }


        scanner.close();
    }
}