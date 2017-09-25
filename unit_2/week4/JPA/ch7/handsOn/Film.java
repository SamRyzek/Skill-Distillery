package entities;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@Column(name = "release_year")
	private int releaseYear;
	@Column(name = "rental_rate")
	private double rentalRate;
	private int length;
	@Column(name = "replacement_cost")
	private double replacementCost;
	@Enumerated(EnumType.STRING)
	private Rating rating;

	@ManyToOne
	@JoinColumn(name = "language_id")
	@JsonManagedReference
	private Language language;

	@ManyToMany(mappedBy = "films", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Actor> actors;

	@ManyToMany(mappedBy = "films")
	@JsonIgnore
	private List<Category> categories;

	@ManyToMany(mappedBy = "films")
	@JsonIgnore
	private List<Store> stores;

	@OneToMany(mappedBy = "film")
	@JsonIgnore
	private List<InventoryItem> inventoryItems;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public int getId() {
		return id;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public void addActor(Actor actor) {
		if (actors == null) {
			actors = new ArrayList<>();
		}
		if (!actors.contains(actor)) {
			actors.add(actor);
			actor.addFilm(this);
		}
	}

	public void removeActor(Actor actor) {
		if (actors != null && actors.contains(actor)) {
			actors.remove(actor);
			actor.removeFilm(this);
		}
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addCategory(Category category) {
		if (categories == null) {
			categories = new ArrayList<>();
		}
		if (!categories.contains(category)) {
			categories.add(category);
			category.addFilm(this);
		}
	}

	public void removeCategory(Category category) {
		if (categories != null && categories.contains(category)) {
			categories.remove(category);
			category.removeFilm(this);
		}
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public void addStore(Store store) {
		if (stores == null) {
			stores = new ArrayList<>();
		}
		if (!stores.contains(store)) {
			stores.add(store);
			store.addFilm(this);
		}
	}

	public void removeStore(Store store) {
		if (stores != null && categories.contains(store)) {
			stores.remove(store);
			store.removeFilm(this);
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
			if (inventoryItem.getFilm() != null) {
				inventoryItem.getFilm().getInventoryItems().remove(inventoryItem);
			}
			inventoryItem.setFilm(this);
		}
	}

	public void removeInventoryItem(InventoryItem inventoryItem) {
		inventoryItem.setFilm(null);
		if (inventoryItems != null) {
			inventoryItems.remove(inventoryItem);
		}
	}
}
