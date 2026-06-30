package main;

import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import service.CustomerService;
import model.Customer;

public class Main {
    public static void main(String[] args) {

        // Dependency creation
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Injecting dependency into service
        CustomerService service = new CustomerService(repository);

        // Using service
        Customer customer = service.getCustomer(2);

        System.out.println("Fetched Customer: " + customer);
    }
}