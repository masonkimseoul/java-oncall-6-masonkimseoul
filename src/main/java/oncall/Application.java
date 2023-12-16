package oncall;

import oncall.Controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        OnCallController onCallController = new OnCallController();
        onCallController.run();
    }
}
