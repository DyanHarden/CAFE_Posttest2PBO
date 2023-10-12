<h1>LAPORAN POSTTEST2 "Pemrograman Berbasis Objek"</h1>
<h1>"Cafe - Coffeshop"</h>
<h2>Nama:  Dian Nurdiansyah</h2>
<h2>NIM:   2209116022</h2>
<br></br>
<h1>Penjelasan Source Code:</h1>
<h2><b>Package 1 Main: File "Main.java"</b></h2>

``` java
package main;

import coffeshop.*;

import java.util.Scanner;
```
Penjelasan:
- Program dimulai dengan mengimpor paket coffeshop dan java.util.Scanner.

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
Penjelasan:
- Dalam metode main(String[] args), program memulai dengan membuat objek Scanner untuk menerima input dari pengguna.
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

<h2>Package 2 coffeshop: File "Coffeshop.java"</h2>

``` java
package coffeshop;
import java.util.ArrayList;

// ArrayList untuk menyimpan daftar Coffe dan Bakery
public final class Coffeshop {
    private static final ArrayList<Coffe> coffes = new ArrayList<>();
    private static final ArrayList<Bakery> bakeries = new ArrayList<>();
```
Penjelasan:
- Kelas "CoffeShop" adalah kelas yang memiliki metode CRUD (Create, Read, Update, Delete) untuk mengelola daftar Coffe (kopi) dan Bakery (roti). 
- Terdapat dua ArrayList yang digunakan untuk menyimpan daftar Coffe (coffes) dan Bakery (bakeries). Kedua ArrayList ini bersifat statis dan bersifat final, yang berarti mereka tidak dapat diubah setelah diinisialisasi.

``` java
//    METODE CRUD UNTUK DAFTAR COFFE
    public static void addCoffe(Coffe coffe) {
        coffes.add(coffe);
    }

    public static void getMenuCoffe(){
        for (Coffe coffe : coffes) {
            coffe.getMenu();
        }
    }

    public static void updateCoffe(String id, String name, int price, String type) {
        for (Coffe coffe : coffes) {
            if (coffe.getId().equals(id)) {
                coffe.setName(name);
                coffe.setPrice(price);
                coffe.setType(type);
                return;
            }
        }
    }


    public static void deleteCoffe(String id) {
        for (Coffe coffe : coffes) {
            if (coffe.getId().equals(id)) {
                coffes.remove(coffe);
                break;
            }
        }
    }

    public static boolean getIdCoffe(String id) {
        for (Coffe coffe : coffes) {
            if (coffe.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
```

Penjelasan:
- Metode CRUD untuk Coffe (kopi) mencakup:
1. addCoffe: Menambahkan objek Coffe ke dalam daftar.
2. getMenuCoffe: Menampilkan menu daftar Coffe.
3. updateCoffe: Memperbarui informasi Coffe berdasarkan ID yang diberikan.
4. deleteCoffe: Menghapus Coffe dari daftar berdasarkan ID yang diberikan.
5. getIdCoffe: Memeriksa apakah Coffe dengan ID tertentu ada dalam daftar.

``` java
//    METODE CRUD UNTUK DAFTAR BAKERY
    public static void addBakery(Bakery bakery) {
        bakeries.add(bakery);
    }

    public static void getMenuBakery(){
        for (Bakery bakery : bakeries) {
            bakery.getMenu();
        }
    }

    public static void updateBakery(String id, String name, int price, String type) {
        for (Bakery bakery : bakeries) {
            if (bakery.getId().equals(id)) {
                bakery.setName(name);
                bakery.setPrice(price);
                bakery.setType(type);
                return;
            }
        }
    }

    public static void deleteBakery(String id) {
        for (Bakery bakery : bakeries) {
            if (bakery.getId().equals(id)) {
                bakeries.remove(bakery);
                break;
            }
        }
    }

    public static boolean getIdBakery(String id) {
        for (Bakery bakery : bakeries) {
            if (bakery.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
```

Penjelasan:
- Metode CRUD untuk Bakery (roti) mirip dengan metode CRUD untuk Coffe dan mencakup:
1. addBakery: Menambahkan objek Bakery ke dalam daftar.
2. getMenuBakery: Menampilkan menu daftar Bakery.
3. updateBakery: Memperbarui informasi Bakery berdasarkan ID yang diberikan.
4. deleteBakery: Menghapus Bakery dari daftar berdasarkan ID yang diberikan.
5. getIdBakery: Memeriksa apakah Bakery dengan ID tertentu ada dalam daftar.

<h2>Package 2 Coffeshop: File "Coffeshop.java"</h2>

``` java
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
```
Penjelasan:
- Kelas "Coffe" merupakan representasi dari item Coffe (kopi) dalam menu kafe.
- Terdapat atribut type yang menyimpan tipe dari Coffe.
- Konstruktor Coffe digunakan untuk inisialisasi objek Coffe dengan mengambil parameter ID, nama, harga, dan tipe.
- Terdapat getter (getType) dan setter (setType) untuk mengakses dan mengubah nilai atribut "type."
- Metode getMenu di-override dari kelas "CafeMenu" untuk menampilkan informasi menu Coffe. Ini mencakup ID, nama, harga, dan tipe Coffe, yang kemudian ditampilkan ke layar.

<h2>Package 2 Coffeshop: File "Coffeshop.java"</h2>

``` java
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

```

Penjelasan:
- Kelas "Bakery" adalah representasi dari item Bakery (roti) dalam menu kafe.
- Terdapat atribut type yang digunakan untuk menyimpan tipe dari Bakery.
- Konstruktor Bakery digunakan untuk menginisialisasi objek Bakery dengan parameter ID, nama, harga, dan tipe.
- Terdapat getter (getType) dan setter (setType) untuk mengakses dan mengubah nilai atribut "type."
- Metode getMenu di-override dari kelas "CafeMenu" untuk menampilkan informasi menu Bakery. Metode ini mencakup ID, nama, harga, dan tipe Bakery, yang kemudian ditampilkan ke layar.
