package oncall.View;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String GET_START_INFO_MSG
            = "비상 근무를 배정할 월과 시작 요일을 입력하세요>";
    private static final String GET_WEEK_DAY_WORKER_MSG
            = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private static final String GET_OFF_DAY_WORKER_MSG
            = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private static final String PRINT_EMERGENCY_WORKERS_MSG
            = "%d월 %d일 %s %s";

    public static void printGetStartInfoMsg() {
        System.out.print(GET_START_INFO_MSG);
    }

    public static void printGetWeekDayWorkerMsg() {
        System.out.print(GET_WEEK_DAY_WORKER_MSG);
    }

    public static void printGetOffDayWorkerMsg() {
        System.out.print(GET_OFF_DAY_WORKER_MSG);
    }

    public static void printEmergencyWorkersMsg(int month, int day, String dayName, String workerName) {
        String formattedString = String.format(PRINT_EMERGENCY_WORKERS_MSG,
                month,
                day,
                dayName,
                workerName);

        System.out.print(formattedString + LINE_SEPARATOR);
    }
}
