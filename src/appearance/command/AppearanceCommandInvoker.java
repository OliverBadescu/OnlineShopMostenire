package appearance.command;

public class AppearanceCommandInvoker {

    private AppearanceCommand command;

    public void setCommand(AppearanceCommand command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

}
