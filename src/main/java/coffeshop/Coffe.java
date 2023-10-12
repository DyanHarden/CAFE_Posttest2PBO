package coffeshop;

public class Coffe extends CafeMenu {
    private String type;

//    Konstruktor Coffe
    public Coffe(String id, String name, int price, String type) {
        super(id, name, price);
        this.type = type;
    }

    // Getter untuk mendapatkan tipe Coffe
    public final String getType() {
        return type;
    }

    // Setter untuk mengatur tipe Coffe
    public final void setType(String type) {
        this.type = type;
    }

    // Metode overridden untuk menampilkan menu Coffe
    @Override
    public final void getMenu() {
        System.out.println("Coffe Menu");
        System.out.println("Coffe Id: " + getId());
        System.out.println("Coffe Name: " + getName());
        System.out.println("Coffe Price: " + getPrice());
        System.out.println("Coffe Type: " + getType());
        System.out.println();
    }
}
