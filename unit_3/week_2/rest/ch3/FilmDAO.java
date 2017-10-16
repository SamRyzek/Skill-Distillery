package data;

@Transactional
@Repository
public class FilmDAO {

	@PersistenceContext
	EntityManager em;

	public List<Film> index() {
		String query = "Select f from Film f";
		return em.createQuery(query, Film.class).getResultList();
	}
}
