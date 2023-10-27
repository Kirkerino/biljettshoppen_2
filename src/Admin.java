class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        // Här kan du implementera en enkel inloggningslogik
        String AdminUsername = "admin"; // Ange det rätta användarnamnet
        String AdminPassword = "admin"; // Ange det rätta lösenordet

        if (username.equals(AdminUsername) && password.equals(AdminPassword)) {
            System.out.println("Admin inloggad.");
            return true;
        } else {
            System.out.println("Inloggning misslyckades.");
            return false;
        }
    }
    // Andra admin-specifika metoder
}