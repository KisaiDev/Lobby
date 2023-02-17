package fr.misteryy.lobby.utils;

import org.bukkit.inventory.ItemStack;

public enum Heads {
    VIP("MjQzNDM5ODdiNzg2OTY0ZGE2MGY1NTEwNmE0MzViYTUzY2I3OGVmMDBiMTA2Njk0MzM3MTJhZmU0YjZmYjU0NiJ9fX0=", "vip"),
    LEGEND("YmUwMDJkOTc3MjNiOGNjOTgwMmQzMGZlOGU0Y2VmMzYxZTU2Y2YyZTQ5YWU5MWYyNzRkYTcyZjQ3ODEzNDExOCJ9fX0=", "legend"),
    MASTER("MjE4MTJiNGUwZjAxYmIxOTM3ZGY5Mzg5ZmU2N2UyNWZhNWQ4NzYxMjQ4NTk4MzcwMTZjNDUxNTRiZWQzY2QxZSJ9fX0=", "master"),
    BOSS("MTA2ZWExMDRjYjliZTcwM2NjZWQxYjFmNTY1Mjg2NzUyZTI3MTc1MmM1YWM4NWU4MTEzYjNlMmRjNDM1MmMyMCJ9fX0=", "boss");

    private org.bukkit.inventory.ItemStack item;
    private String idTag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    private Heads(String texture, String id) {
        this.item = HeadsMain.createSkull(this.prefix + texture, id);
        this.idTag = id;
    }

    public ItemStack getItemStack() {
        return this.item;
    }

    public String getName() {
        return this.idTag;
    }
}

