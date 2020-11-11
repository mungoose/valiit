package ee.bcs.valiit.tasks;

public class Visits {
    private String date;
    private int visits;


    public Visits(String date, int visits) {
        this.date = date;
        this.visits = visits;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}