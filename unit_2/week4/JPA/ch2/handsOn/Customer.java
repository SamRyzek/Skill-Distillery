@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  @GeneratedValue(strateg = GenerationType.IDENTITY)
  private int id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  private String email;

  @Column(name="create_date")
  @Temporal(TemporalType.DATE)
  private Date createDate;

  public int getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }  

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  @Override
  public String toString() {
    return "Customer [id=" + id + ", firstName=" + firstName +
      ", lastName=" + lastName + ", email=" + email + "]";
  }
}