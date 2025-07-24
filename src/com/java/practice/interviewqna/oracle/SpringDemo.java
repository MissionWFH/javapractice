/*
package com.java.practice.interviewqna.oracle;

@RestController
public class SpringDemo {

    @Autowired
    CustomerService customerService;

    @GetMapping("/v1/customer/details")
    public ResponseEntity<DefaultResponse> getCustomerData(){
        // validate header -- custom schema we can validate
        // validate the request body  -- custom schema we can validate
        CustomerDetail customerDetail = customerService.getCustomer();
        return new ResponseEntity.ok(customerDetail);

    }

    @PostMapping("/v1/customer/details")
    public ResponseEntity getCustomerData(@RequestBody CustomerDetail CustomerDetail){
        // validate header -- custom schema we can validate
        // validate the request body  -- custom schema we can validate
        customerService.getCustomer();

        customerService.saveCustomer(CustomerDetail);
    }
}

@Service
class CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public CustomerDetail getCustomer(){
        return customerRepository.findByID()
                .orElseThrow(()-> new DataNotFoundException("Data not "));

    }

    @Transactional
    public CustomerDetail saveCustomer(CustomerDetail customerDetail){
        return customerRepository.save(customerDetail);
    }
}

@Repository // optional annotation since JPA it will handle
interface CustomerRepository extends JPARepository{}*/
