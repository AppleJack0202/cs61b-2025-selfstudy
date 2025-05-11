public class Dessert {
    int flavor;
    int price;
    int numDesserts;
    Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numDesserts++;
    }
    public void printDessert() {
        System.out.println(flavor + " " + price + " " + numDesserts);
    }
    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }

}
