/*
package com.java.practice.interviewqna.oracle;

// controller pkg
@RestController
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @GetMapping("/v1/laptop/details/{laptopName}")
    public ResponseEntity<LaptopDto> getLaptopDetails(@PathVariable String laptopName ){
        // validate header -- custom header validation
        LaptopDto laptopDto = laptopService.getlaptop(laptopName);
        return new ResponseEntity.ok(laptopDto);
    }
}

// service pkg
@Service
class LaptopService {
    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    LaptopMapper laptopMapper;


    public LaptopDto getLaptopDetails(String laptopName){
        LaptopDto laptopDto = laptopRepository.findByName(laptopName);
        Laptop laptop = laptopMapper.mapLaptopDTOTOLaptop(laptopDto);
        if("HP".equals(laptop.getName())){
            return laptopDto;
        }

    }
}

@Repository // optional annoatation as JPA will handle it
interface LaptopRepository extends JPARepository<Laptop, Integer> {
        @Query("SELECT 1 FROM Laptop l where l.laptopName =:laptopName")
        LaptopDto findByName(@Param("laptopName") String laptopName);
}

@Mapper // optional annoatation as JPA will handle it
interface LaptopMapper {
    Laptop mapLaptopDTOTOLaptop(LaptopDto laptopDto);
}


// dto pkg
class LaptopDto{

    private int laptopId;
    private String name;
    private String CPU;
    private int ramCapacity;

    // getters setters

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }
}

// model pkg
class Laptop{

    private int laptopId;
    private String name;
    private String CPU;
    private int ramCapacity;

    // getters setters

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }
}*/
