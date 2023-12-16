package oncall.Domain;

public class EmergencyWorks {
    private int month;
    private int day;
    private String dayName;
    private String workerName;

    public EmergencyWorks(int month, int day, String dayName) {
        this.month = month;
        this.day = day;
        this.dayName = dayName;
        workerName = null;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String getDayName() {
        return this.dayName;
    }

    public String getWorkerName() {
        return this.workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
}
