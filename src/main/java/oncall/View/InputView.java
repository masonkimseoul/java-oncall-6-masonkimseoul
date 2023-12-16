package oncall.View;

import camp.nextstep.edu.missionutils.Console;
import oncall.Util.Validation;

public class InputView {
    private static final String SEPARATOR = ",";

    public static String[] getStartInfo() {
        String[] startInfo = Console.readLine().split(SEPARATOR);

        try {
            Validation.validateStartInfo(startInfo);
            return startInfo;
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return getStartInfo();
        }
    }

    private static String[] getWeekDayWorkersNames() {
        String[] weekDayWorkersNames = Console.readLine().split(SEPARATOR);
        //Validation
        return weekDayWorkersNames;
    }

    private static String[] getOffDayWorkersNames() {
        String[] offDayWorkersNames = Console.readLine().split(SEPARATOR);
        //Validation
        return offDayWorkersNames;
    }
}
