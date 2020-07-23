package com.adairpub.poker;

import java.util.HashMap;
import java.util.Map;

public enum PlayType {
    FOLD,
    CHECK,
    CALL,
    RAISE;

    private static final Map<String, PlayType> TYPE_MAP = new HashMap<>();

    static {
        for (PlayType playType : values()) {
            TYPE_MAP.put(playType.toString(), playType);
        }
    }

    public static PlayType fromString(String string) {
        return TYPE_MAP.get(string.toLowerCase());
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}

