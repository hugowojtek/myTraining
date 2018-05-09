

import pl.sda.model.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    private static EntityManagerFactory emf;
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("JPA");
        entityManager = emf.createEntityManager();

        Main main = new Main();
        System.out.println();


//        entityManager.getTransaction().begin(); //otwórz
//        entityManager.persist(null); //encja w nawiasach
//        entityManager.getTransaction().commit(); //wyslij do bazy

        //Query query = entityManager.createQuery("select from")
        entityManager.getTransaction().begin(); //otwórz
/*
        Item item = new Item();
        item.setName("hulajnoga");
        item.setPrice(new BigDecimal(123.45));
        item.setVat(new BigDecimal(0.23));
*/
//        Person person = new Person();
//        person.setName("monika");
//        person.setLastName("ozog");
//        person.setPesel("1122334455");

//        entityManager.persist(person);
//
//        person.setName("olek");
//        person.setLastName("ozog");
//        person.setPesel("99887766");
//
//        entityManager.persist(person);


        Set<Sell> sell = ShowItems();

        Customer customer = ShowCustomers();

        System.out.println();

        Bill bill = new Bill();
        bill.setSells(sell);
        bill.setCustomer(customer);
        bill.setStamp("znaczek_wodny");
        
        ShowBill(bill);

        System.out.println();
//
//        Sell sell = new Sell();
//        sell.setItem(list.get(0));
//        sell.setSellDate(new Date());

//
//        entityManager.persist(sell);
//        System.out.println();


        entityManager.getTransaction().commit();


        entityManager.close();
        emf.close();

    }

    private static void ShowBill(Bill bill) {
        System.out.println("info o rachunku");
        System.out.println(bill.getStamp());
        System.out.println("info o kliencie");
        System.out.println(bill.getCustomer());
        System.out.println("info o produkcie");
        System.out.println(bill.getSells());

    }

    private static Customer ShowCustomers() {

        String jpgl = "SELECT c FROM Customer c";
        TypedQuery query = (TypedQuery) entityManager.createQuery(jpgl);
        List<Customer> list = query.getResultList();


        System.out.println("Proszę wybrać osobe kupujaca");
        int j = 0;
        for (Customer c : list) {
            System.out.println(++j + " - " + c.toString());
        }
        scanner = new Scanner(System.in);
        String str = scanner.next();

        Customer customer = new Customer();
        switch (str) {
            case "1":
                customer = list.get(0);
                break;
            case "2":
                customer = list.get(1);
                break;
            case "3":
                customer = list.get(2);
                break;
            default:
                System.out.println("nie ma takiego klienta");
                System.exit(0);

        }
        return customer;

    }

    private static Set<Sell> ShowItems() {


        String jpgl = "SELECT i FROM Item i";
//        String jpgl2 = "SELECT COUNT(i) FROM Item i";

        TypedQuery query = (TypedQuery) entityManager.createQuery(jpgl);
        List<Item> list = query.getResultList();
        Set<Sell> set = new LinkedHashSet<>();

        System.out.println("Proszę wybrać pozycję do zakupu 0-przejdz do zapłaty");
        int j = 0;
        for (Item i : list) {
            System.out.println(++j + " - " + i.toString());
        }

        scanner = new Scanner(System.in);
        String str = scanner.next();

        Item item;
        Sell sell;


        while(true) {
            item = new Item();
            sell = new Sell();
            Boolean mark = false;
            switch (str) {

                case "1":
                    item = list.get(0);

                    break;
                case "2":
                    item = list.get(1);
                    break;

                case "3":
                    item = list.get(2);
                    break;

                    default: mark  = true;
            }

            if (str.equals("0")) break;

            if (!(mark)) {
                sell.setItem(item);
                sell.setSellDate(new Date());
                sell.setDocument(new Document());

                set.add(sell);
            }
            System.out.println("Proszę wybrać pozycję do zakupu 0-przejdz do zapłaty");
            j = 0;
            for (Item i : list) {
                System.out.println(++j + " - " + i.toString());
            }

            scanner = new Scanner(System.in);
            str = scanner.next();
            if (str.equals("0")) break;
        }
        return set;
    }
}
