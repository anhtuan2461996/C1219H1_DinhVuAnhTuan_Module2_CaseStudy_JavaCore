package Models;

public abstract class Services {
    private String servicesName;
    private String id;
    private double areaUsed;
    private double rentCosts;
    private int maxNumberOfPeople;
    private String rentType;

    public Services() {
    }

    public Services(String servicesName, String id, double areaUsed, double rentCosts, int maxNumberOfPeople, String rentType) {
        this.servicesName = servicesName;
        this.id = id;
        this.areaUsed = areaUsed;
        this.rentCosts = rentCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentType = rentType;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentCosts() {
        return rentCosts;
    }

    public void setRentCosts(double rentCosts) {
        this.rentCosts = rentCosts;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public abstract void showInfor();

}
