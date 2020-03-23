package org.karmakurier.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.math.BigDecimal;

import org.karmakurier.backend.domain.enumeration.PriceCategory;

import org.karmakurier.backend.domain.enumeration.PaymentMethod;

/**
 * A Mission.
 */
@Entity
@Table(name = "mission")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Mission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull
    @Size(min = 5, max = 5)
    @Column(name = "zip", length = 5, nullable = false)
    private String zip;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * What should be bought?
     */
    
    @ApiModelProperty(value = "What should be bought?", required = true)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "jhi_order", nullable = false)
    private String order;

    /**
     * Preferred price category
     */
    @NotNull
    @ApiModelProperty(value = "Preferred price category", required = true)
    @Enumerated(EnumType.STRING)
    @Column(name = "price_category", nullable = false)
    private PriceCategory priceCategory;

    /**
     * Maximum accepted price
     */
    @ApiModelProperty(value = "Maximum accepted price")
    @Column(name = "max_price", precision = 21, scale = 2)
    private BigDecimal maxPrice;

    /**
     * How to pay the helper
     */
    @NotNull
    @ApiModelProperty(value = "How to pay the helper", required = true)
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    /**
     * Which helper has been assigned to the mission
     */
    @ApiModelProperty(value = "Which helper has been assigned to the mission")
    @ManyToOne
    @JsonIgnoreProperties("missions")
    private User assignedHelper;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Mission firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Mission lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public Mission street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public Mission zip(String zip) {
        this.zip = zip;
        return this;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public Mission city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public Mission email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Mission phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrder() {
        return order;
    }

    public Mission order(String order) {
        this.order = order;
        return this;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public Mission priceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
        return this;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public Mission maxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Mission paymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getAssignedHelper() {
        return assignedHelper;
    }

    public Mission assignedHelper(User user) {
        this.assignedHelper = user;
        return this;
    }

    public void setAssignedHelper(User user) {
        this.assignedHelper = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mission)) {
            return false;
        }
        return id != null && id.equals(((Mission) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Mission{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", street='" + getStreet() + "'" +
            ", zip='" + getZip() + "'" +
            ", city='" + getCity() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", order='" + getOrder() + "'" +
            ", priceCategory='" + getPriceCategory() + "'" +
            ", maxPrice=" + getMaxPrice() +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            "}";
    }
}
