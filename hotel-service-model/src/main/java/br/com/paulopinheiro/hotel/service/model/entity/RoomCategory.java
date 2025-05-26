package br.com.paulopinheiro.hotel.service.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ROOMCATEGORY")
@NamedQueries({
    @NamedQuery(name = "Roomcategory.findAll", query = "SELECT r FROM Roomcategory r"),
    @NamedQuery(name = "Roomcategory.findById", query = "SELECT r FROM Roomcategory r WHERE r.id = :id"),
    @NamedQuery(name = "Roomcategory.findByBedtype", query = "SELECT r FROM Roomcategory r WHERE r.bedtype = :bedtype"),
    @NamedQuery(name = "Roomcategory.findByRoomquality", query = "SELECT r FROM Roomcategory r WHERE r.roomquality = :roomquality")})
public class RoomCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer bedtype;
    private Integer guests;
    private BigDecimal initialPrice;
    private Integer maxDiscount;
    private Integer roomQuality;
    @Column(name = "LOCK_FLAG")
    private Integer lockFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomcategory")
    private List<Room> roomList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomcategory")
    private List<Booking> bookingList;

    public RoomCategory() {
    }

    public RoomCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBedtype() {
        return bedtype;
    }

    public void setBedtype(Integer bedtype) {
        this.bedtype = bedtype;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Integer getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Integer maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public Integer getRoomQuality() {
        return roomQuality;
    }

    public void setRoomQuality(Integer roomQuality) {
        this.roomQuality = roomQuality;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomCategory)) {
            return false;
        }
        RoomCategory other = (RoomCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
    
}
