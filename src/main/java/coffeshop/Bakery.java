package coffeshop;

public class Bakery extends CafeMenu {
    private String type;

//    Konstruktor Bakery
    public Bakery(String id, String name, int price, String type) {
        super(id, name, price);
        this.type = type;
    }

    // Getter untuk mendapatkan tipe Bakery
    public final String getType() {
        return type;
    }

    // Setter untuk mengatur tipe Bakery
    public final void setType(String type) {
        this.type = type;
    }

    // Metode overridden untuk menampilkan menu Bakery
    @Override
    public final void getMenu() {
        System.out.println("Bakery Menu");
        System.out.println("Bakery Id: " + getId());
        System.out.println("Bakery Name: " + getName());
        System.out.println("Bakery Price: " + getPrice());
        System.out.println("Bakery Type: " + getType());
        System.out.println();
    }
}
