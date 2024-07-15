package appearance.service;

public class AppearanceServiceImpl implements AppearanceService{
    private boolean darkMode = false;

    @Override
    public void setLightMode() {
        darkMode = false;
        System.out.println("Switched to Light Mode");
        // Additional code to change the appearance to light mode
    }

    @Override
    public void setDarkMode() {
        darkMode = true;
        System.out.println("Switched to Dark Mode");
        // Additional code to change the appearance to dark mode
    }

    @Override
    public boolean isDarkMode() {
        return darkMode;
    }

}
