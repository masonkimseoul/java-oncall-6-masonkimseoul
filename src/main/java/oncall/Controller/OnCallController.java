package oncall.Controller;

import java.util.ArrayList;
import java.util.List;
import oncall.Domain.Days;
import oncall.Domain.EmergencyWorks;
import oncall.Domain.Holidays;
import oncall.Domain.Month;
import oncall.Domain.Workers;
import oncall.Util.Validation;
import oncall.View.InputView;
import oncall.View.OutputView;

public class OnCallController {
    private static final Workers workers = new Workers();
    private static int month;
    private static String dayName;
    private static final List<EmergencyWorks> emergencys = new ArrayList<>();
    private static final String weekDayButHoliday = "(휴일)";

    public void run() {
        OutputView.printGetStartInfoMsg();
        getStartInfo();
        getWorkers();
        initEmergency();
        pushWorker();
        printEmergencys();
        workers.clearWeekDayWorker();
        workers.clearOffDayWorker();
        emergencys.clear();
    }

    public void getStartInfo() {
        String[] startInfo = InputView.getStartInfo();
        month = Integer.parseInt(startInfo[0]);
        dayName = startInfo[1];
    }

    public void getWorkers() {
        try {
            OutputView.printGetWeekDayWorkerMsg();
            String[] weekDayWorkers = InputView.getWeekDayWorkersNames();
            Validation.validateWorkers(weekDayWorkers);
            OutputView.printGetOffDayWorkerMsg();
            String[] offDayWorkers = InputView.getOffDayWorkersNames();
            Validation.validateWorkers(offDayWorkers);
            Validation.validateWorkersExistence(List.of(weekDayWorkers), List.of(offDayWorkers));
            for (String worker : weekDayWorkers) {
                workers.addWeekDayWorkers(worker);
            }
            for(String worker : offDayWorkers) {
                workers.addOffDayWorkers(worker);
            }
        } catch(IllegalArgumentException e) {
            getWorkers();
        }
    }

    public void initEmergency() {
        for(int i = 1; i <= Month.getDays(month);i++) {
            String dayNameToday = Days.fromDayIndex((Days.getIndexByName(dayName) + i - 1) % 7);
            EmergencyWorks emergency = new EmergencyWorks(month, i, dayNameToday);
            emergencys.add(emergency);
        }
    }

    public void pushWorker() {
        for(int i = 0; i < emergencys.size(); i++) {
            String workerName = null;
            if (Days.isDayTypeWeekday(emergencys.get(i).getDayName())
                    && !Holidays.isSpecialHoliday(emergencys.get(i).getMonth(), emergencys.get(i).getDay())) {
                workerName = workers.getWeekDayWorker();
                if (i > 0 && emergencys.get(i - 1).getWorkerName().equals(workerName)) {
                    workers.swapWeekDayWorker();
                    workerName = workers.getWeekDayWorker();
                }
                emergencys.get(i).setWorkerName(workerName);
                workerName = workers.popWeekDayWorker();
                workers.addWeekDayWorkers(workerName);
            }
            if (!Days.isDayTypeWeekday(emergencys.get(i).getDayName()) || Holidays.isSpecialHoliday(emergencys.get(i).getMonth(), emergencys.get(i).getDay())) {
                workerName = workers.getOffDayWorker();
                if (i > 0 && emergencys.get(i - 1).getWorkerName().equals(workerName)) {
                    workers.swapOffDayWorker();
                    workerName = workers.getWeekDayWorker();
                }
                emergencys.get(i).setWorkerName(workerName);
                workerName = workers.popOffDayWorker();
                workers.addOffDayWorkers(workerName);
            }
        }
    }

    public void printEmergencys() {
        for (EmergencyWorks emergency : emergencys) {
            String newDayName = emergency.getDayName();
            if (Holidays.isSpecialHoliday(emergency.getMonth(), emergency.getDay())
                    &&Days.isDayTypeWeekday(emergency.getDayName())) {
                newDayName = newDayName + weekDayButHoliday;
            }
            OutputView.printEmergencyWorkersMsg(
                    emergency.getMonth(),
                    emergency.getDay(),
                    newDayName,
                    emergency.getWorkerName());
        }
    }
}
