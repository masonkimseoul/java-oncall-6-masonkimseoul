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

    public static String[] getWeekDayWorkersNames() {
        return Console.readLine().split(SEPARATOR);
    }

    public static String[] getOffDayWorkersNames() {
        return Console.readLine().split(SEPARATOR);
    }
}
