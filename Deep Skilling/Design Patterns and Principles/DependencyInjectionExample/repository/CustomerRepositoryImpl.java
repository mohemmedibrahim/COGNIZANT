package repository;

import java.util.HashMap;
import java.util.Map;
import model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<Integer, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        database.put(1, new Customer(1, "Arun"));
        database.put(2, new Customer(2, "Bala"));
        database.put(3, new Customer(3, "Charan"));
    }

    @Override
    public Customer findCustomerById(int id) {
        return database.get(id);
    }
}