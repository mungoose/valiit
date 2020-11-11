package ee.bcs.valiit.tasks;

public class Bikes {
    private String bikeBrand;
    private String bikeModel;
    private boolean anyGood;

    public Bikes(String bikeBrand, String bikeModel, boolean anyGood) {
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.anyGood = anyGood;
    }

    public String getBikeBrand() {
        return bikeBrand;
    }

    public void setBikeBrand(String bikeBrand) {
        this.bikeBrand = bikeBrand;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public boolean isAnyGood() {
        return anyGood;
    }

    public void setAnyGood(boolean anyGood) {
        this.anyGood = anyGood;
    }
}
