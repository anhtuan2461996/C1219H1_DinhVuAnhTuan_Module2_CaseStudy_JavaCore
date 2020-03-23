package Models;

public class Room extends Services {
    private String freeServices;

    public Room() {
    }

    public Room(String servicesName, String id, double areaUsed, double rentCosts, int maxNumberOfPeople, String rentType, String freeServices) {
        super(servicesName, id, areaUsed, rentCosts, maxNumberOfPeople, rentType);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public void showInfor() {
        System.out.println(
                "Services ID: " + super.getId() +
                "\nServices Name: " + super.getServicesName() +
                "\nArea Used: " + super.getAreaUsed() +
                "\nRental Cost: " + super.getRentCosts() +
                "\nMax Number Of People: " + super.getMaxNumberOfPeople() +
                "\nType Rent: " + super.getRentType() +
                "\nFree Services: " + this.freeServices
        );
    }
}
