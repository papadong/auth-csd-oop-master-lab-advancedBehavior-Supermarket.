import java.util.ArrayList;
import java.util.HashSet;

/**
 * Η κλάση αυτή αποθηκεύει στη μνήμη τις συναλλαγές σε ένα σούπερ μάρκετ.
 * This class saves in memory all the transactions of a supermarket.
 */
public class Supermarket {

    ArrayList<Transaction> transactions;

    public Supermarket() {
        transactions = new ArrayList<>();
    }

    /**
     * Αυτή η μέθοδος αποθηκεύει μια συναλλαγή
     * This method saves a transaction
     *
     * @param t μια συναλλαγή , a transaction
     */
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    /**
     * Αυτή η μέθοδος επιστρέφει το πλήθος όλων των πωλήσεων ενός προϊόντος σε
     * όλες τις αποθηκευμένες συναλλαγές.
     * This method returns the total number of sales of a product from all saved transactions.
     *
     * @param product ένα προϊόν , a product
     * @return το πλήθος των πωλήσεων του προϊόντος, the total sales number
     */
    public int getTotalSalesOfProduct(String product) {
        int counter = 0;
        for (Transaction transaction : transactions) {
            for (String productIn : transaction.products) {
                if (productIn.equals(product))
                    counter++;
            }
        }
        return counter;
    }

    /**
     * Η μέθοδος αυτή επιστρέφει το πλήθος των μοναδικών προϊόντων που έχουν
     * βρεθεί σε συναλλαγές.
     * This method returns the number of unique products that have been found
     * in the transactions.
     *
     * @return Το πλήθος των μοναδικών προϊόντων, the total number of unique products
     */
    public int uniqueProducts() {
        ArrayList<String> uniqueProducts = new ArrayList<>();
        for (Transaction transaction : transactions) {
            int length = transaction.getProducts().length;
            for (int k = 0; k < length; k++) {
                String product = transaction.getProducts()[k];
                if (!uniqueProducts.contains(product))
                    uniqueProducts.add(product);
            }
        }
        return uniqueProducts.size();
    }

}
