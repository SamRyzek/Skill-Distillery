package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class StateDAOImpl implements StateDAO {
  private static final String FILE_NAME="/WEB-INF/states.csv";
  private List<State> states = new ArrayList<>();
  /*
   * Use Autowired to have Spring inject an instance
   * of a WebApplicationContext into this object after
   * creation.  We will use the WebApplicationContext to
   * retrieve an ServletContext so we can read from a 
   * file.
   */
  @Autowired 
  private WebApplicationContext wac;

  /*
   * The @PostConstruct method is called by Spring after 
   * object creation and dependency injection
   */
  @PostConstruct
  public void init() {
    // Retrieve an input stream from the servlet context
    // rather than directly from the file system
    try (
        InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
      ) {
      String line = buf.readLine();
      while ((line = buf.readLine()) != null) {
        String[] tokens = line.split(",");
        String abbrev = tokens[1];
        String name = tokens[2];
        String capital = tokens[3];
        String latitude = tokens[4];
        String longitude = tokens[5];
        states.add(new State(abbrev, name, capital, latitude, longitude));
      }
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  @Override
  public State getStateByName(String name) {
    // TODO : Implement method
    State s = null;
      // Find the state by it's name in the 'states' array
      // If found, assign the state to 's'
    return s;
  }
  @Override
  public State getStateByAbbreviation(String abbrev) {
    // TODO : Implement method
    State s = null;
      // Find the state by it's abbreviation in the 'states' array
      // If found, assign the state to 's'
    return s;
  }
  @Override
  public void addState(State state) {
    // TODO : Implement method
      // This method should add a state to the 'states' array
  }
}

