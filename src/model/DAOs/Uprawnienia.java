package model.DAOs;

public enum Uprawnienia {
    ADMIN("ADMIN"), LEKARZ("LEKARZ"), PACJENT("PACJENT"), PIELEGNIARKA("PIELEGNIARKA");
    String uprawnienie;
    Uprawnienia(String uprawnienie) {
        this.uprawnienie = uprawnienie;
    }
}
