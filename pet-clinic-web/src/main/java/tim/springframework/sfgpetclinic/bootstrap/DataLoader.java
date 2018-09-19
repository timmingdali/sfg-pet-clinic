package tim.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tim.springframework.sfgpetclinic.model.Owner;
import tim.springframework.sfgpetclinic.model.Pet;
import tim.springframework.sfgpetclinic.model.PetType;
import tim.springframework.sfgpetclinic.model.Vet;
import tim.springframework.sfgpetclinic.services.OwnerService;
import tim.springframework.sfgpetclinic.services.PetTypeService;
import tim.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Russel");
        owner1.setLastName("Westbrook");
        owner1.setAddress("123 Main St");
        owner1.setCity("Toronto");
        owner1.setTelephone("1231231234");

        Pet russelPet = new Pet();
        russelPet.setPetType(savedDogType);
        russelPet.setOwner(owner1);
        russelPet.setBirthDate(LocalDate.now());
        russelPet.setName("Rosco");
        owner1.getPets().add(russelPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Smith");
        owner2.setAddress("325 Main St");
        owner2.setCity("Vancouver");
        owner2.setTelephone("890231234");

        Pet mikesCat = new Pet();
        mikesCat.setPetType(savedCatType);
        mikesCat.setOwner(owner2);
        mikesCat.setBirthDate(LocalDate.now());
        mikesCat.setName("White Snow");
        owner2.getPets().add(mikesCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Lebron");
        vet1.setLastName("James");

        vetService.save(vet1);

        System.out.println("Loaded Vets...");
    }
}
