package controllers;

@RestController
public class FilmController {

	@Autowired
	FilmDAO filmDAO;

	@RequestMapping(path="films", method=RequestMethod.GET)
	public List<Film> index(){
	  return filmDAO.index();
	}
}
