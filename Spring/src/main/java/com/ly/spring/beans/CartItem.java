package com.ly.spring.beans;

public class CartItem {

	private Book book;
	private int count;
	private double amount;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", amount=" + amount + "]";
	}

}
