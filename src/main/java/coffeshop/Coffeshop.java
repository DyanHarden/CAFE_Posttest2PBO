package coffeshop;
import java.util.ArrayList;

// ArrayList untuk menyimpan daftar Coffe dan Bakery
public final class Coffeshop {
    private static final ArrayList<Coffe> coffes = new ArrayList<>();
    private static final ArrayList<Bakery> bakeries = new ArrayList<>();

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
