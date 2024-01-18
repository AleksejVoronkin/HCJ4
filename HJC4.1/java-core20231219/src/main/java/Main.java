
import Tools.Customer;
import Tools.Product;
import Tools.Shop;
import Tools.Customer.Gender;
import Tools.AmountException;
import Tools.CustomerException;
import Tools.ProductException;


import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;
import java.util.Objects;


public class Main {

    public static void main(String[] args) {
            Customer ivan = new Customer("Иван", 23, 1523, Gender.MALE, LocalDate.of(2023,2,23));
            Customer nina = new Customer("Нина", 45, 4878,Gender.FEMALE, LocalDate.of(2023, 3, 8));
            Customer dmitry = new Customer("Дмитрий", 20, 1235, Gender.MALE, LocalDate.of(2023, 5, 17));
            Shop.customers.addAll(List.of(ivan, nina, dmitry));

            Product toy1 = new Product("Игрушка", 3000);
            Shop.products.add(toy1);
            Product toy2 = new Product("Игрушка", 3000);
            Shop.products.add(toy2);
            Product toy3 = new Product("Игрушка", 3000);
            Shop.products.add(toy3);
            Product toy4 = new Product("Игрушка", 3000);
            Shop.products.add(toy4);
            Product toy5 = new Product("Игрушка", 3000);
            Shop.products.add(toy5);
            Product puzzle = new Product("Пазл", 6000);

            
            try {
                Shop.orders.add(Shop.getProduct(ivan, toy1, 3));
                Shop.orders.add(Shop.getProduct(dmitry, puzzle, 2));
                Shop.orders.add(Shop.getProduct(ivan, toy2, 1));
                Shop.orders.add(Shop.getProduct(nina, toy3, 5));
                Shop.orders.add(Shop.getProduct(ivan, puzzle, 4));
                Shop.orders.add(Shop.getProduct(dmitry, toy5, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }

            Shop.orders.removeIf(Objects::isNull);
        
            System.out.println("Итоговое кол-во заказов = " + Shop.orders.size());
            
            long maleCount = Shop.customers.stream().filter(c -> c.getGender() == Gender.MALE).count();
            long femaleCount = Shop.customers.stream().filter(c -> c.getGender() == Gender.FEMALE).count();
            System.out.println("Из них мужчин: " + maleCount);
            System.out.println("И женщин: " + femaleCount);
            congratulateCustomers(Shop.customers);
        }
        private static void congratulateCustomers(List<Customer> customers) {
            LocalDate today = LocalDate.now();
            MonthDay todayMonthDay = MonthDay.from(today);
            MonthDay newYear = MonthDay.of(1, 1);
            MonthDay womensDay = MonthDay.of(3, 8);
            MonthDay mensDay = MonthDay.of(2, 23);
            
            boolean isHoliday = false;
            
            for (Customer customer : customers) {
                if (todayMonthDay.equals(newYear)) {
                    System.out.println("С Новым Годом, " + customer.getName() + "!");
                    isHoliday = true;
                } else if (customer.getGender() == Gender.FEMALE && todayMonthDay.equals(womensDay)) {
                    System.out.println("С 8 Марта, " + customer.getName() + "!");
                    isHoliday = true;
                } else if (customer.getGender() == Gender.MALE && todayMonthDay.equals(mensDay)) {
                    System.out.println("С 23 Февраля, " + customer.getName() + "!");
                    isHoliday = true;
                }
            }
            
            if (!isHoliday) {
                System.out.println("Сегодня нет праздников.");
            }
        }
}
