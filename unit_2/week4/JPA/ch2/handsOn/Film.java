package entities;

import javax.persistence.*;

@Entity
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private String description;

  @Enumerated(EnumType.STRING)
  private Rating rating;

  public Rating getRating() {
    return rating;
  }
  public void setRating(Rating rating) {
    this.rating = rating;
  }

  // ...
}