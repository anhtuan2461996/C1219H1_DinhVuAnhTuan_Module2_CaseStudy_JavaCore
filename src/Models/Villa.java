package Models;

public class Villa extends Services {
    private String roomStandard;
    private String convenientDescription;
    private double areaPool;
    private int maxNumberOfPloors;

    public Villa() {
    }

    public Villa(String servicesName, String id, double areaUsed, double rentCosts, int maxNumberOfPeople, String rentType, String roomStandard, String convenientDescription, double areaPool, int maxNumberOfPloors) {
        super(servicesName, id, areaUsed, rentCosts, maxNumberOfPeople, rentType);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.areaPool = areaPool;
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

    public void setConvenientDescription(String convenlentDescription) {
        this.convenientDescription = convenlentDescription;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
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
                        "\nArea Pool: " + this.getAreaPool() +
                        "\nMax Number Of Pools: " + this.getMaxNumberOfPloors()
        );
    }
}
