public class Dessert {
    int flavor;
    int price;
    Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numDesserts++;
    }
    static int numDesserts = 0;
    public void printDessert() {
        System.out.println(flavor + " " + price + " " + numDesserts);
    }
    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }

}
