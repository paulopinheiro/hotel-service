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
import java.util.List;

@Entity
@Table(name = "HotelChain")
@NamedQueries({
    @NamedQuery(name = "Hotelchain.findAll", query = "SELECT h FROM Hotelchain h"),
    @NamedQuery(name = "Hotelchain.findById", query = "SELECT h FROM Hotelchain h WHERE h.id = :id"),
    @NamedQuery(name = "Hotelchain.findByName", query = "SELECT h FROM Hotelchain h WHERE h.name = :name")})
public class HotelChain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String name;
    @Column(name = "LOCK_FLAG")
    private Integer lockFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelchain")
    private List<Hotel> hotelList;

    public HotelChain() {
    }

    public HotelChain(Integer id) {
        this.id = id;
    }

    public HotelChain(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
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
        if (!(object instanceof HotelChain)) {
            return false;
        }
        HotelChain other = (HotelChain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
