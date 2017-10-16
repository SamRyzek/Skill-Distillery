package data;

@Transactional
@Repository
public class AddressDAO {

	@PersistenceContext
	EntityManager em;

	public List<Address> index() {
		String query = "Select a from Address a";
		return em.createQuery(query, Address.class).getResultList();
	}

	public Address show(int id) {
		return em.find(Address.class, id);
	}

	public Address create(Address address) {
		em.persist(address);
		em.flush();

		return em.find(Address.class, address.getId());
	}
}
