class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login() {
        // Här kan man implementera en enkel inloggningslogik
        String AdminUsername = "admin"; // Ange det rätta användarnamnet
        String AdminPassword = "admin"; // Ange det rätta lösenordet

        //Här kollas det om användarnamn och lösenord stämmer
        if (username.equals(AdminUsername) && password.equals(AdminPassword)) {
            System.out.println("Admin inloggad.");
            return true;
        } else {
            System.out.println("Inloggning misslyckades.");
            return false;
        }
    }

}