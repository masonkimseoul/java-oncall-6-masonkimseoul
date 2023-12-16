package oncall.Domain;

import java.util.ArrayList;
import java.util.List;

public class Workers {
    private final List<String> weekDayWorkers;
    private final List<String> offDayWorkers;

    public Workers() {
        this.weekDayWorkers = new ArrayList<>();
        this.offDayWorkers = new ArrayList<>();
    }

    public void addWeekDayWorkers(String workerName) {
        this.weekDayWorkers.add(workerName);
    }

    public void addOffDayWorkers(String workerName) {
        this.offDayWorkers.add(workerName);
    }

    public String getWeekDayWorker() {
        return this.weekDayWorkers.get(0);
    }

    public String getOffDayWorker() {
        return this.offDayWorkers.get(0);
    }

    public String popWeekDayWorker() {
        String workerName = getWeekDayWorker();
        this.weekDayWorkers.remove(0);
        return workerName;
    }

    public String popOffDayWorker() {
        String workerName = getOffDayWorker();
        this.offDayWorkers.remove(0);
        return workerName;
    }

    public boolean isContainsWeekDayWorker(String workerName) {
        return this.weekDayWorkers.contains(workerName);
    }

    public boolean isContainsOffDayWorker(String workerName) {
        return this.offDayWorkers.contains(workerName);
    }

    public void swapWeekDayWorker() {
        String workerName1 = popWeekDayWorker();
        String workerName2 = popWeekDayWorker();

        this.weekDayWorkers.add(0, workerName1);
        this.weekDayWorkers.add(0, workerName2);
    }

    public void swapOffDayWorker() {
        String workerName1 = popOffDayWorker();
        String workerName2 = popOffDayWorker();

        this.offDayWorkers.add(0, workerName1);
        this.offDayWorkers.add(0, workerName2);
    }

    public void clearWeekDayWorker() {
        this.weekDayWorkers.clear();
    }

    public void clearOffDayWorker() {
        this.offDayWorkers.clear();
    }
}
