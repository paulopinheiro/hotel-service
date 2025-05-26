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
import java.io.Serializable;

/**
 *
 * @author 2360
 */
@Entity
@Table(name = "ROOM")
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id"),
    @NamedQuery(name = "Room.findByRoomno", query = "SELECT r FROM Room r WHERE r.roomno = :roomno"),
    @NamedQuery(name = "Room.findByFloor", query = "SELECT r FROM Room r WHERE r.floor = :floor"),
    @NamedQuery(name = "Room.findByBalcony", query = "SELECT r FROM Room r WHERE r.balcony = :balcony"),
    @NamedQuery(name = "Room.findByHeading", query = "SELECT r FROM Room r WHERE r.heading = :heading"),
    @NamedQuery(name = "Room.findByLockFlag", query = "SELECT r FROM Room r WHERE r.lockFlag = :lockFlag")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ROOMNO")
    private Integer roomno;
    @Column(name = "FLOOR")
    private Integer floor;
    @Column(name = "BALCONY")
    private Short balcony;
    @Column(name = "HEADING")
    private Integer heading;
    @Column(name = "LOCK_FLAG")
    private Integer lockFlag;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotel hotel;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RoomCategory roomcategory;

    public Room() {
    }

    public Room(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Short getBalcony() {
        return balcony;
    }

    public void setBalcony(Short balcony) {
        this.balcony = balcony;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
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
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.paulopinheiro.hotel.service.model.entity.Room[ id=" + id + " ]";
    }
    
}
