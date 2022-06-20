package util;

import java.util.LinkedList;

public abstract class Factory {
	public Factory() {
		createProducts();
	}

	public abstract void createProducts();
}