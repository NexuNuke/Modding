package com.nexunuke.modone.states;

        import net.minecraft.util.IStringSerializable;

public enum CauldronState implements IStringSerializable {

    OFF("off"),
    WORKING("working"),
    NOPOWER("nopower");

    // Optimization
    public static final CauldronState[] VALUES = CauldronState.values();

    private final String name;

    CauldronState(String name) { this.name = name; }

    @Override
    public String getName() {
        return name;
    }
}
