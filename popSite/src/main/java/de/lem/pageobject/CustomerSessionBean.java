package de.lem.pageobject;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CustomerSessionBean implements Serializable {

  private static final long serialVersionUID = 1L;
  private final List<Name> names = new ArrayList<>();
  private Name selectedElement;
  private String firstName;
  private String lastName;

  public CustomerSessionBean() {
    names.add(new Name(1, "Penny", "TBBT"));
    names.add(new Name(2, "Sheldon", "TBBT"));
    names.add(new Name(3, "Amy", "TBBT"));
    names.add(new Name(4, "Leonard", "TBBT"));
    names.add(new Name(5, "Bernadette", "TBBT"));
    names.add(new Name(6, "Raj", "TBBT"));
    names.add(new Name(7, "Priya", "TBBT"));
    names.add(new Name(8, "Howard", "TBBT"));
  }

  public List<Name> getCustomerNames() {
    return names;
  }

  public Name getSelectedElement() {
    return selectedElement;
  }

  public void setSelectedElement(final Name selectedElement) {
    this.selectedElement = selectedElement;
  }

  public void onRowSelect(final SelectEvent event) {
    selectedElement = (Name) event.getObject();
  }

  public void onRowUnselect(final UnselectEvent event) {
    selectedElement = null;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public void save() {
    names.add(new Name(names.size() + 1, firstName, lastName));
  }
}
