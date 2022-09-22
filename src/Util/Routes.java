package Util;

import java.util.Stack;

public class Routes {
    private static Stack<String> History = new Stack();
    private static String actual_page = "";

    public static void addToHistory(String route) {
        History.push(route);
        actual_page = route;
    }

    public static Stack<String> getHistory() {
        return History;
    }

    public static String getActual_page() {
        return actual_page;
    }

    public static final class Page {
        public final static class InicialPage{
            public final static String LOGIN="/login/login.fxml";
        }
        public final static class Main {
            public final static String MAIN = "/menus/menu.fxml";
        }
        public final static class LandingPage {
            public final static String MAIN = "/menuPage/landingPage.fxml";
        }

        public final static class Pacient{
            public final static String MENUPACIENT="/pacient/menuPacient.fxml";
        }
    }


}
