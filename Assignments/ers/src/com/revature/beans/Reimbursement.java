package com.revature.beans;

public class Reimbursement {

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", author_id="
				+ author_id + ", resolver_id=" + resolver_id + ", status_id=" + status_id + ", type_id=" + type_id
				+ "]";
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int id, double amount, String description, Employee author_id, Employee resolver_id,
			ReimbStatus status_id, ReimbType type_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.status_id = status_id;
		this.type_id = type_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Employee getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Employee author_id) {
		this.author_id = author_id;
	}
	public Employee getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(Employee resolver_id) {
		this.resolver_id = resolver_id;
	}
	public ReimbStatus getStatus_id() {
		return status_id;
	}
	public void setStatus_id(ReimbStatus status_id) {
		this.status_id = status_id;
	}
	public ReimbType getType_id() {
		return type_id;
	}
	public void setType_id(ReimbType type_id) {
		this.type_id = type_id;
	}
	private int id;
	private double amount;
	private String description;
	private Employee author_id;
	private Employee resolver_id;
	private ReimbStatus status_id;
	private ReimbType type_id;
	
	
}
