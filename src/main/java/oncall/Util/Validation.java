package oncall.Util;

import java.util.Arrays;
import java.util.List;
import oncall.Domain.Workers;

public class Validation {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ERROR_MSG = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final List<String> dayNames
            = Arrays.asList("일", "월", "화", "수", "목", "금", "토");

    private static final int MAX_WORKER_NAME_LEN = 5;
    private static final int MIN_WORKERS_LEN = 5;
    private static final int MAX_WORKERS_LEN = 35;

    public static void validateStartInfo(String[] startInfo) {
        int month = Integer.parseInt(startInfo[0]);
        String dayName = startInfo[1];
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException(LINE_SEPARATOR + ERROR_MSG + LINE_SEPARATOR);
        }
        if (!dayNames.contains(dayName)) {
            throw new IllegalArgumentException(LINE_SEPARATOR + ERROR_MSG + LINE_SEPARATOR);
        }
    }

    private static void validateWorkerNameLength(String workerName) {
        if (workerName.length() > MAX_WORKER_NAME_LEN) {
            throw new IllegalArgumentException(LINE_SEPARATOR + ERROR_MSG + LINE_SEPARATOR);
        }
    }

    public static void validateWorkers(String[] workerNames) {
        int length = workerNames.length;
        if (length < MIN_WORKERS_LEN || length > MAX_WORKERS_LEN) {
            throw new IllegalArgumentException(LINE_SEPARATOR + ERROR_MSG + LINE_SEPARATOR);
        }
        for (String workerName : workerNames) {
            validateWorkerNameLength(workerName);
        }
    }

    public static void validateWorkersExistence(List<String> weekDayWorkers, List<String> offDayWorkers) {
        for(String workerName : weekDayWorkers) {
            if (!offDayWorkers.contains(workerName)) {
                throw new IllegalArgumentException(LINE_SEPARATOR + ERROR_MSG + LINE_SEPARATOR);
            }
        }
        for(String workerName : offDayWorkers) {
            if(!weekDayWorkers.contains(workerName)) {
                throw new IllegalArgumentException(LINE_SEPARATOR + ERROR_MSG + LINE_SEPARATOR);
            }
        }
    }
}
