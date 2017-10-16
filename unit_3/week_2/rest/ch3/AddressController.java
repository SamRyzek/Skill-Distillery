package controllers;

@RestController
public class AddressController {

	@Autowired
	AddressDAO addressDAO;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path = "addresses", method = RequestMethod.GET)
	public List<Address> index() {
		return addressDAO.index();
	}

	@RequestMapping(path = "addresses/{id}", method = RequestMethod.GET)
	public Address show(@PathVariable int id) {
		return addressDAO.show(id);
	}

	@RequestMapping(path = "addresses", method = RequestMethod.POST)
	public Address create(@RequestBody String jsonAddress) {
		ObjectMapper mapper = new ObjectMapper();
		Address newAddress = null;
		try {
			newAddress = mapper.readValue(jsonAddress, Address.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressDAO.create(newAddress);
	}
}
