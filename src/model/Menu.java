package model;

public enum Menu {
    NEW_DOCUMENT(1, "Add document"),
    DOCUMENT_PERSON(1, "D"),
    DOCUMENT_DATE(5, "Document from ... to"),
    SAVE(6, "Save"),
    LOAD(7, "Load"),
    EXIT(8, "Exit");

    private int id;
    private String item;

    Menu(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public static void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i].id + ": " + menu[i].item + " | ");
        }
        System.out.println();
        System.out.println("Enter the number of the menu item: ");
    }
}
