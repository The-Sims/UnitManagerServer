package models;

public class Unit {
    String unitId;
    String unitName;
    boolean unitAvailability;

    public Unit(String unitId, String unitName, boolean unitAvailability) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitAvailability = unitAvailability;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public boolean isUnitAvailability() {
        return unitAvailability;
    }

    public void setUnitAvailability(boolean unitAvailability) {
        this.unitAvailability = unitAvailability;
    }
}
