package tim.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tim.springframework.sfgpetclinic.model.Owner;
import tim.springframework.sfgpetclinic.model.Vet;
import tim.springframework.sfgpetclinic.services.OwnerService;
import tim.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Russel");
        owner1.setLastName("Westbrook");

        ownerService.save(owner1);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Lebron");
        vet1.setLastName("James");

        vetService.save(vet1);

        System.out.println("Loaded Vets...");
    }
}
