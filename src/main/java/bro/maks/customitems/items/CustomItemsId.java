package bro.maks.customitems.items;

public enum CustomItemsId {
    VAMPIRE_SWORD("клинок_алого_ордена");

    private final String id;

    CustomItemsId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
