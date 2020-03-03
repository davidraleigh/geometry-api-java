package com.esri.core.geometry;

import java.util.Iterator;

public abstract class StringCursor implements Iterator<String> {
	public abstract String next();

	public abstract int getID();

	public abstract String getFeatureID();

	public abstract SimpleStateEnum getSimpleState();

	public abstract boolean hasNext();
}
