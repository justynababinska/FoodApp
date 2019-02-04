package pl.justynababinska.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pl.justynababinska.item.Item;

@Entity
@Table(name = "client_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 2753536910887690743L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToMany
	@JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), 
									inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
	private List<Item> items = new ArrayList<>();
	private String address;
	private String telephone;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
