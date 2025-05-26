/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.paulopinheiro.hotel.service.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 2360
 */
@Entity
@Table(name = "BOOKING")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id"),
    @NamedQuery(name = "Booking.findByFromdate", query = "SELECT b FROM Booking b WHERE b.fromdate = :fromdate"),
    @NamedQuery(name = "Booking.findByTodate", query = "SELECT b FROM Booking b WHERE b.todate = :todate"),
    @NamedQuery(name = "Booking.findByBookingcreated", query = "SELECT b FROM Booking b WHERE b.bookingcreated = :bookingcreated"),
    @NamedQuery(name = "Booking.findByEarliestcheckintime", query = "SELECT b FROM Booking b WHERE b.earliestcheckintime = :earliestcheckintime"),
    @NamedQuery(name = "Booking.findByLockFlag", query = "SELECT b FROM Booking b WHERE b.lockFlag = :lockFlag")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FROMDATE")
    @Temporal(TemporalType.DATE)
    private Date fromdate;
    @Column(name = "TODATE")
    @Temporal(TemporalType.DATE)
    private Date todate;
    @Column(name = "BOOKINGCREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingcreated;
    @Column(name = "EARLIESTCHECKINTIME")
    @Temporal(TemporalType.TIME)
    private Date earliestcheckintime;
    @Column(name = "LOCK_FLAG")
    private Integer lockFlag;
    @JoinColumn(name = "CUSTOMER_CUSTOMERNO", referencedColumnName = "CUSTOMERNO")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotel hotel;
    @JoinColumn(name = "ROOMCATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RoomCategory roomcategory;

    public Booking() {
    }

    public Booking(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Date getBookingcreated() {
        return bookingcreated;
    }

    public void setBookingcreated(Date bookingcreated) {
        this.bookingcreated = bookingcreated;
    }

    public Date getEarliestcheckintime() {
        return earliestcheckintime;
    }

    public void setEarliestcheckintime(Date earliestcheckintime) {
        this.earliestcheckintime = earliestcheckintime;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomCategory getRoomcategory() {
        return roomcategory;
    }

    public void setRoomcategory(RoomCategory roomcategory) {
        this.roomcategory = roomcategory;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.paulopinheiro.hotel.service.model.entity.Booking[ id=" + id + " ]";
    }
    
}
