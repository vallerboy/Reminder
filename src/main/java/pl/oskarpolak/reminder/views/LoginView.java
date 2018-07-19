package pl.oskarpolak.reminder.views;

public class LoginView {
    public void showWelcomeMessage(){
        System.out.println("Witaj w reminderze!");
    }

    public void showGetLoginText() {
        System.out.print("Podaj login: ");
    }

    public void showGetPasswordText() {
        System.out.print("Podaj hasło: ");
    }

    public void showGetPasswordRepeat() {
        System.out.print("Powtórz hasło: ");
    }

    public void showPasswordRepeatIncorrect() {
        System.out.print("Hasła się nie zgadzają");
    }

    public void showErrorWithFileOnLoginPage() {
        System.out.println("Niestety, wystąpił nieznany błąd z plikiem");
    }

    public void printMenu() {
        System.out.println("1. Zaloguj się");
        System.out.println("2. Zarejestruj sie");
    }

    public void getMenuChoose() {
        System.out.print("Podaj wybór z menu: ");
    }

    public void showNotFoundCommand() {
        System.out.println("Nie znaleziono takiej komendy!");
    }

    public void showLoginBusyOrPasswordRepeatIncorrect() {
        System.out.println("Login jest juz zajety, albo zle powtorzyles haslo");
    }
}
