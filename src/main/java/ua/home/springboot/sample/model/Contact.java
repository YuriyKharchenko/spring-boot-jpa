package ua.home.springboot.sample.model;

import org.hibernate.validator.constraints.Email;
import ua.home.springboot.sample.validator.Phone;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 4, message = "First name must contain not less than 4 characters")
    private String firstname;
    @Size(min = 4, message = "Second name must contain not less than 4 characters")
    private String lastname;
    @Size(min = 4, message = "Middle name must contain not less than 4 characters")
    private String middlename;
    @Phone
    private String mobile;
    @Phone
    private String telephone;
    private String address;
    @Email
    private String email;
    private Long userId;

    public Contact() {
        super();
    }

    public Contact(String firstname, String lastname, String middlename, String mobile, String telephone, String address, String email, Long userId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.mobile = mobile;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.userId = userId;
    }


    public boolean isNew() {
        return (this.id == null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    @ManyToOne
    @JoinTable(name = "contact_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (getFirstname() != null ? !getFirstname().equals(contact.getFirstname()) : contact.getFirstname() != null)
            return false;
        if (getLastname() != null ? !getLastname().equals(contact.getLastname()) : contact.getLastname() != null)
            return false;
        if (getMiddlename() != null ? !getMiddlename().equals(contact.getMiddlename()) : contact.getMiddlename() != null)
            return false;
        if (getMobile() != null ? !getMobile().equals(contact.getMobile()) : contact.getMobile() != null) return false;
        if (getTelephone() != null ? !getTelephone().equals(contact.getTelephone()) : contact.getTelephone() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(contact.getAddress()) : contact.getAddress() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(contact.getEmail()) : contact.getEmail() != null) return false;
        return getUserId() != null ? getUserId().equals(contact.getUserId()) : contact.getUserId() == null;

    }

    @Override
    public int hashCode() {
        int result = getFirstname() != null ? getFirstname().hashCode() : 0;
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getMiddlename() != null ? getMiddlename().hashCode() : 0);
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getTelephone() != null ? getTelephone().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        return result;
    }
}
