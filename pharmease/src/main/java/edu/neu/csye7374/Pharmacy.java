package edu.neu.csye7374;

import edu.neu.csye7374.State.PharmacyStateAPI;
import edu.neu.csye7374.Strategy.*;

import java.util.*;

public class Pharmacy implements PharmacyAPI, PharmacyStateAPI {
    String name;
    public List<Medicine> itemList = new ArrayList<>();
    public List<Person> personList = new ArrayList<>();
    public static DiscountStrategy strategy=DiscountStrategy.NONE;
    public Pharmacy(String name) {
        super();
        this.name = name;
    }
    private static Map<DiscountStrategy, DiscountAPI> strategyAPIMap= new HashMap<>();
    {
        strategyAPIMap.put(DiscountStrategy.EMPLOYEE_DISCOUNT, new EmployeeDiscount());
        strategyAPIMap.put(DiscountStrategy.MEMBERSHIP_DISCOUNT, new MembershipDiscount());
        strategyAPIMap.put(DiscountStrategy.STUDENT_DISCOUNT, new StudentDiscount());
    }

    public static Map<DiscountStrategy, DiscountAPI> getStrategyAPIMap() {
        return strategyAPIMap;
    }

    public static DiscountStrategy getStrategy() {
        return strategy;
    }

    public static void setStrategy(DiscountStrategy strategy) {
        Pharmacy.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medicine> getItemList() {
        return itemList;
    }

    public void setItemList(List<Medicine> itemList) {
        this.itemList = itemList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public static void setStrategyAPIMap(Map<DiscountStrategy, DiscountAPI> strategyAPIMap) {
        Pharmacy.strategyAPIMap = strategyAPIMap;
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void stock_status() {

    }
    @Override
    public void addMedicines() {
    }
    @Override
    public void addEmployees() {
    }
    @Override
    public void sortMedicines() {
        Collections.sort(itemList, new Comparator<Medicine>() {
            @Override
            public int compare(Medicine m1, Medicine m2) {
                return m1.getMedicineName().compareTo(m2.getMedicineName());
            }
        });
        System.out.println("Sorted medicine list");
        for(Medicine medicine: itemList){
            System.out.println(medicine.medicineName);
        }
    }
    @Override
    public void sortEmployees() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                //Compare the employees based on their names
                return CharSequence.compare(p1.getFirstName(), p2.getFirstName());
            }
        });
        System.out.println("Sorted pharmacist list");
        for(Person person: personList){
            System.out.println(person.getFirstName());
        }
    }
}
