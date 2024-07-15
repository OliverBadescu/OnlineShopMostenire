package appearance.model;

import appearance.command.AppearanceCommand;
import appearance.service.AppearanceService;

public class DarkMode implements AppearanceCommand {

    private AppearanceService appearanceService;

    public DarkMode(AppearanceService appearanceService) {
        this.appearanceService = appearanceService;
    }

    @Override
    public void execute() {
        appearanceService.setDarkMode();
    }

}
