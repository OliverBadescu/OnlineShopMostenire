package appearance.model;

import appearance.command.AppearanceCommand;
import appearance.service.AppearanceService;

public class LightMode implements AppearanceCommand {

    private AppearanceService appearanceService;

    public LightMode(AppearanceService appearanceService) {
        this.appearanceService = appearanceService;
    }

    @Override
    public void execute() {
        appearanceService.setLightMode();
    }

}
