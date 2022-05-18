package com.projet.stock.model;

import com.google.gson.annotations.SerializedName;

public class CreatePayment {
	@SerializedName("items")
	Object[] items;

	public Object[] getItems() {
		return items;
	}
}
