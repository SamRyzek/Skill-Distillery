@Entity
public class Actor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

  @ManyToMany
  @JoinTable(name="film_actor",
   joinColumns=@JoinColumn(name="actor_id"),
   inverseJoinColumns=@JoinColumn(name="film_id")
  )
  private List<Film> films;

  public String getFirstName() {
  		return firstName;
  	}

  	public void setFirstName(String firstName) {
  		this.firstName = firstName;
  	}

  	public String getLastName() {
  		return lastName;
  	}

  	public void setLastName(String lastName) {
  		this.lastName = lastName;
  	}

  	public int getId() {
  		return id;
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
  			film.addActor(this);
  		}
  	}

  	public void removeFilm(Film film) {
  		if (films != null && films.contains(film)) {
  			films.remove(film);
  			film.removeActor(this);
  		}
  	}
}
