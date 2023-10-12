package coffeshop;

//  Deklarasi kelas abstrak CafeMenu
abstract class CafeMenu {
    private final String id;
    private String name;
    private int price;

    // Konstruktor kelas CafeMenu
    public CafeMenu(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    // Getter untuk mendapatkan ID, Nama, dan Harga item menu
    public final String getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final int getPrice() {
        return price;
    }

    // Metode abstrak yang harus diimplementasikan oleh kelas turunan
    public abstract void getMenu();

    // Setter untuk mengubah Nama dan Harga item menu
    public final void setName(String name) {
        this.name = name;
    }

    public final void setPrice(int price) {
        this.price = price;
    }
}
