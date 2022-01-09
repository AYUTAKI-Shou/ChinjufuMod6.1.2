package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum BlockStateHinge implements IStringSerializable {

	LEFT,
	RIGHT;

	public String toString() {
		return this.getName();
	}

	public String getName() {
		return this == LEFT ? "left" : "right";
	}
}
