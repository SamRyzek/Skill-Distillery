package entities;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "media_condition")
	private MediaCondition mediaCondition;

	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@OneToMany(mappedBy = "inventoryItem")
	private List<Rental> rentals;

	public MediaCondition getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(MediaCondition mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	public int getId() {
		return id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		if (rentals == null) {
			rentals = new ArrayList<>();
		}
		if (!rentals.contains(rental)) {
			rentals.add(rental);
			if (rental.getInventoryItem() != null) {
				rental.getInventoryItem().getRentals().remove(rental);
			}
			rental.setInventoryItem(this);
		}
	}

	public void removeRental(Rental rental) {
		rental.setInventoryItem(null);
		if (rentals != null) {
			rentals.remove(rental);
		}
	}

}
