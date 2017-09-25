package entities;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;

	@OneToMany(mappedBy = "store")
	private List<Staff> employees;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "store")
	private List<Customer> customers;

	@ManyToMany
	@JoinTable(name = "inventory_item", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
	private List<Film> films;

	@OneToMany(mappedBy = "store")
	private List<InventoryItem> inventoryItems;

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		if (!customers.contains(customer)) {
			customers.add(customer);
			if (customer.getStore() != null) {
				customer.getStore().getCustomers().remove(customer);
			}
			customer.setStore(this);
		}
	}

	public void removeCustomer(Customer customer) {
		customer.setStore(null);
		if (customers != null) {
			customers.remove(customer);
		}
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public List<Staff> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Staff> employees) {
		this.employees = employees;
	}

	public void addEmployee(Staff employee) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		if (!employees.contains(employee)) {
			employees.add(employee);
			if (employee.getStore() != null) {
				employee.getStore().getEmployees().remove(employee);
			}
			employee.setStore(this);
		}
	}

	public void removeEmployee(Staff employee) {
		employee.setStore(null);
		if (employees != null) {
			employees.remove(employee);
		}
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public void addFilm(Film film) {
		if (films == null) {
			films = new ArrayList<>();
		}
		if (!films.contains(film)) {
			films.add(film);
			film.addStore(this);
		}
	}

	public void removeFilm(Film film) {
		if (films != null && films.contains(film)) {
			films.remove(film);
			film.removeStore(this);
		}
	}

	public List<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public void addInventoryItem(InventoryItem inventoryItem) {
		if (inventoryItems == null) {
			inventoryItems = new ArrayList<>();
		}
		if (!inventoryItems.contains(inventoryItem)) {
			inventoryItems.add(inventoryItem);
			if (inventoryItem.getStore() != null) {
				inventoryItem.getStore().getInventoryItems().remove(inventoryItem);
			}
			inventoryItem.setStore(this);
		}
	}

	public void removeInventoryItem(InventoryItem inventoryItem) {
		inventoryItem.setStore(null);
		if (inventoryItems != null) {
			inventoryItems.remove(inventoryItem);
		}
	}
}
