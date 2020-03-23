package Models;

public class House extends Services {
    private String roomStandard;
    private String convenientDescription;
    private int maxNumberOfPloors;

    public House() {
    }

    public House(String servicesName, String id, double areaUsed, double rentCosts, int maxNumberOfPeople, String rentType, String roomStandard, String convenientDescription, int maxNumberOfPloors) {
        super(servicesName, id, areaUsed, rentCosts, maxNumberOfPeople, rentType);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.maxNumberOfPloors = maxNumberOfPloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public int getMaxNumberOfPloors() {
        return maxNumberOfPloors;
    }

    public void setMaxNumberOfPloors(int maxNumberOfPloors) {
        this.maxNumberOfPloors = maxNumberOfPloors;
    }

    @Override
    public void showInfor() {
        System.out.println(
                        "Services Name: " + super.getServicesName() +
                        "\nServices ID: " + super.getId() +
                        "\nArea Used: " + super.getAreaUsed() +
                        "\nRental Cost: " + super.getRentCosts() +
                        "\nMax Number Of People: " + super.getMaxNumberOfPeople() +
                        "\nType Rent: " + super.getRentType() +
                        "\nRoom Standard: " + this.getRoomStandard() +
                        "\nConvenient Description: " + this.getConvenientDescription() +
                        "\nMax Number Of Pools: " + this.getMaxNumberOfPloors()
        );
    }
}
