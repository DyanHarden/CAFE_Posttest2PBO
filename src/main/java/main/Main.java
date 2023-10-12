package main;

import coffeshop.*;

import java.util.Scanner;

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
                case 3:
                    System.out.println("\n=========================");
                    System.out.println("| Update Data Menu Cafe |");
                    System.out.println("| 1. Update Coffe       |");
                    System.out.println("| 2. Update Bakery      |");
                    System.out.println("=========================");
                    System.out.print("Pilih: ");
                    pilih = scanner.nextInt();
                    scanner.nextLine();
                    if (pilih == 1) {
                        System.out.print("Coffe id: ");
                        String id = scanner.nextLine();
                        if (!Coffeshop.getIdCoffe(id)) {
                            System.out.println("Item with id " + id + " not found");
                            break;
                        } else if (Coffeshop.getIdCoffe(id)) {
                            System.out.print("Coffe name: ");
                            String name = scanner.nextLine();
                            System.out.print("Coffe price: ");
                            int price = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Coffe type: ");
                            String type = scanner.nextLine();
                            Coffeshop.updateCoffe(id, name, price, type);
                            System.out.println("Update with id " + id + " success");
                        } else {
                            System.out.println("Pilihan tidak ditemukan");
                        }
                    } else if (pilih == 2) {
                        System.out.print("Bakery id: ");
                        String id = scanner.nextLine();
                        if (!Coffeshop.getIdBakery(id)) {
                            System.out.println("Item with id " + id + " not found");
                            break;
                        } else if (Coffeshop.getIdBakery(id)) {
                            System.out.print("Bakery name: ");
                            String name = scanner.nextLine();
                            System.out.print("Bakery price: ");
                            int price = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Bakery type: ");
                            String type = scanner.nextLine();
                            Coffeshop.updateBakery(id, name, price, type);
                            System.out.println("Update with id " + id + " success");
                        } else {
                            System.out.println("Pilihan tidak ditemukan!");
                        }
                    } else {
                        System.out.println("Pilihan tidak ditemukan!");
                    }

                    break;
                case 4:
                    System.out.println("\n====================================");
                    System.out.println("| Hapus Data Menu Coffe dan Bakery |");
                    System.out.println("| 1. Coffe                         |");
                    System.out.println("| 2. Bakery                        |");
                    System.out.println("====================================");
                    System.out.print("Pilih: ");
                    int pilihDelete = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihDelete) {
                        case 1:
                            System.out.print("Coffe Id: ");
                            String coffeId = scanner.nextLine();
                            Coffeshop.deleteCoffe(coffeId);
                            System.out.println("Coffe berhasil dihapus");
                            break;
                        case 2:
                            System.out.print("Bakery Id: ");
                            String bakeryId = scanner.nextLine();
                            Coffeshop.deleteBakery(bakeryId);
                            System.out.println("Bakery berhasil dihapus");
                            break;
                        default:
                            System.out.println("Pilihan tidak ditemukan!");
                            break;
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ditemukan!");
                    break;
            }
        } while (pilih != 5);
    }
}
