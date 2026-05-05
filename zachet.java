import java.util.Scanner;

// Суперкласс
abstract class Metals {
    public abstract void calculateTeploemk(double m, double t1, double t2);
}

// Подкласс Aurum
class Aurum extends Metals {
    private final double Q = 1064; // Предопределенное значение Q для золота

    public Aurum() {
        System.out.println("Создан объект Aurum");
    }

    @Override
    public void calculateTeploemk(double m, double t1, double t2) {
        double Udel_gold = Q / Math.abs(m * (t2 - t1));
        System.out.println("Теплоемкость золота: " + Udel_gold + " Дж/(кг·°C)");
    }
}

// Подкласс Argentum
class Argentum extends Metals {
    private final double Q = 961; // Предопределенное значение Q для серебра

    public Argentum() {
        System.out.println("Создан объект Argentum");
    }

    @Override
    public void calculateTeploemk(double m, double t1, double t2) {
        double Udel_silver = Q / Math.abs(m * (t2 - t1));
        System.out.println("Теплоемкость серебра: " + Udel_silver + " Дж/(кг·°C)");
    }
}

// Подкласс Platinum
class Platinum extends Metals {
    private final double Q = 1768; // Предопределенное значение Q для платины

    public Platinum() {
        System.out.println("Создан объект Platinum");
    }

    @Override
    public void calculateTeploemk(double m, double t1, double t2) {
        double Udel_plat = Q / Math.abs(m * (t2 - t1));
        System.out.println("Теплоемкость платины: " + Udel_plat + " Дж/(кг·°C)");
    }
}

public class ZACHET {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя металла (Aurum, Argentum, Platinum):");
        String metalName = scanner.nextLine();

        System.out.println("Введите тип объекта (слиток, руда, цепочка):");
        String objectType = scanner.nextLine();

        double m = 0;
        switch (objectType.toLowerCase()) {
            case "слиток":
                m = 1000;
                break;
            case "руда":
                m = 120;
                break;
            case "цепочка":
                m = 20;
                break;
            default:
                System.out.println("Неизвестный тип объекта");
                scanner.close();
                return;
        }

        System.out.println("Введите начальную температуру (t1):");
        double t1 = scanner.nextDouble();

        System.out.println("Введите конечную температуру (t2):");
        double t2 = scanner.nextDouble();

        Metals metal = null;

        switch (metalName.toLowerCase()) {
            case "aurum":
                metal = new Aurum();
                break;
            case "argentum":
                metal = new Argentum();
                break;
            case "platinum":
                metal = new Platinum();
                break;
            default:
                System.out.println("Неизвестный металл");
                scanner.close();
                return;
        }

        metal.calculateTeploemk(m, t1, t2);
        scanner.close();
    }
}
