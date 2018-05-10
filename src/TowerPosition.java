public enum TowerPosition {
    LEFT_TOWER, MIDDLE_TOWER, RIGHT_TOWER;

    public String toString() {
        switch (this.ordinal()) {
            case 0:
                return "tour de gauche";
            case 1:
                return "tour du milieu";
            case 2:
                return "tour de droite";
            default:
                return "";
        }
    }
}
