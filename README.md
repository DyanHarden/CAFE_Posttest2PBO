<h1>LAPORAN POSTTEST2 "Pemrograman Berbasis Objek"</h1>
<h1>"Cafe - Coffeshop"</h>
<h2>Nama:  Dian Nurdiansyah</h2>
<h2>NIM:   2209116022</h2>
<br></br>
<h1>Penjelasan Source Code:</h1>
<h2><b>Package 1 Main: File "Main.java"</b></h2>

![image](https://github.com/DyanHarden/CAFE_Posttest2PBO/assets/94899238/b3e5afe1-5046-4170-a8a1-4b9253707173)

Program dimulai dengan mengimpor paket coffeshop dan java.util.Scanner.

```java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        TAMPILAN MENU CRUD
        int pilih;
        do {
            System.out.println("\n===============================");
            System.out.println("|   CAFE - Coffe and Bakery   |");
            System.out.println("| 1.Tampilkan Menu CoffeShop  |");
            System.out.println("| 2.Tambah Menu CoffeShop     |");
            System.out.println("| 3.Update Menu CoffeShop     |");
            System.out.println("| 4.Delete Menu CoffeShop     |");
            System.out.println("| 5.Exit                      |");
            System.out.println("===============================");
            System.out.print("Pilih: ");
            pilih = scanner.nextInt();
            scanner.nextLine();
```
Dalam metode main(String[] args), program memulai dengan membuat objek Scanner untuk menerima input dari pengguna.
Terdapat loop do-while yang akan terus berjalan hingga pengguna memilih opsi "Exit" (pilih 5).
Setiap iterasi loop, program menampilkan menu utama, dan pengguna diminta untuk memilih opsi (pilih 1-5).

```java
switch (pilih) {
                case 1:
                    System.out.println("\n==============================");
                    System.out.println("| List Menu Coffe dan Bakery |");
                    System.out.println("| 1. Coffe                   |");
                    System.out.println("| 2. Bakery                  |");
                    System.out.println("==============================");
                    System.out.print("Pilih: ");
                    int pilihMenu = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihMenu) {
                        case 1:
                            Coffeshop.getMenuCoffe();
                            break;
                        case 2:
                            Coffeshop.getMenuBakery();
                            break;
                        default:
                            System.out.println("Pilihan tidak ditemukan!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\n=========================");
                    System.out.println("| Tambah Menu CoffeShop |");
                    System.out.println("| 1. Coffe              |");
                    System.out.println("| 2. Bakery             |");
                    System.out.println("=========================");
                    System.out.print("Pilih: ");
                    int pilihTambah = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihTambah) {
                        case 1:
                            System.out.print("Coffe Id: ");
                            String coffeId = scanner.nextLine();
                            System.out.print("Coffe Name: ");
                            String coffeName = scanner.nextLine();
                            System.out.print("Coffe Price: ");
                            int coffePrice = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Coffe Type: ");
                            String coffeType = scanner.nextLine();
                            Coffe coffe = new Coffe(coffeId, coffeName, coffePrice, coffeType);
                            Coffeshop.addCoffe(coffe);
                            break;
                        case 2:
                            System.out.print("Bakery Id: ");
                            String bakeryId = scanner.nextLine();
                            System.out.print("Bakery Name: ");
                            String bakeryName = scanner.nextLine();
                            System.out.print("Bakery Price: ");
                            int bakeryPrice = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Bakery Type: ");
                            String bakeryType = scanner.nextLine();
                            Bakery bakery = new Bakery(bakeryId, bakeryName, bakeryPrice, bakeryType);
                            Coffeshop.addBakery(bakery);
                            break;
                        default:
                            System.out.println("Pilihan tidak ditemukan!");
                            break;
                    }
                    break;
```
(Untuk SS Metode Switch Casenya hanya 1-2 saja, karena terlalu panjang pada lampiran)

Program menggunakan pernyataan switch untuk menangani setiap opsi yang dipilih oleh pengguna.
- Opsi 1: Menampilkan menu CoffeShop, dengan sub-menu untuk Coffe atau Bakery.
- Opsi 2: Menambahkan menu baru untuk CoffeShop, juga dengan sub-menu untuk Coffe atau Bakery. Pengguna diminta untuk memasukkan data menu (ID, Nama, Harga, Tipe).
- Opsi 3: Mengupdate data menu CoffeShop. Pengguna diminta untuk memasukkan ID menu yang akan diupdate, dan jika ditemukan, mereka dapat memperbarui informasi menu (Nama, Harga, Tipe).
- Opsi 4: Menghapus data menu CoffeShop. Pengguna diminta untuk memasukkan ID menu yang akan dihapus.
- Opsi 5: Keluar dari program.
- Opsi lain: Menampilkan pesan bahwa pilihan tidak ditemukan.

<h2>Package 2 coffeshop: File "CafeMenu.Java"</h2>

``` java
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
```
Penjelasan:
- CafeMenu adalah kelas abstrak, yang berarti Anda tidak dapat membuat objek langsung dari kelas ini, tetapi Anda dapat menggunakan kelas ini sebagai dasar untuk kelas lain yang akan mewarisi sifat-sifat dan metode-metode tertentu.
- Class ini memiliki tiga atribut:
1. id: Sebuah String yang digunakan sebagai ID untuk item menu dan bersifat final, yang berarti nilainya tidak dapat diubah setelah diinisialisasi.
2. name: Sebuah String yang menyimpan nama dari item menu.
3. price: Sebuah bilangan bulat (int) yang menyimpan harga dari item menu.
- Konstruktor CafeMenu digunakan untuk menginisialisasi atribut-atribut kelas ini pada saat objek kelas turunan dibuat. Konstruktor ini menerima tiga parameter: ID, nama, dan harga, dan mengatur nilai atribut sesuai dengan parameter yang diberikan.
- Terdapat getter untuk mengambil nilai dari atribut id, name, dan price.
- Terdapat metode abstrak getMenu(), yang harus diimplementasikan oleh kelas turunan. Metode ini akan digunakan untuk menampilkan detail dari item menu.
- Terdapat setter setName() dan setPrice() yang digunakan untuk mengubah nilai name dan price item menu.
