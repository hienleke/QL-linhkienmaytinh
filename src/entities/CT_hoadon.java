package entities;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(CT_hoadon_PK.class)
public class CT_hoadon {
	
	@Id
	 @ManyToOne
	@JoinColumn(name = "mshd", foreignKey = @ForeignKey())
	private Hoadon hoadon;

	@Id
	@ManyToOne
	@JoinColumn(name="mslk",foreignKey = @ForeignKey())
	private Linhkien linhkien;
	
	private int soluong;


	public CT_hoadon() {
	}
	public CT_hoadon(Hoadon hoadon, Linhkien linhkien, int soluong  ) {
		super();
		this.hoadon = hoadon;
		this.linhkien = linhkien;
		this.soluong = soluong;

	}
	public Hoadon getHoadon() {
		return hoadon;
	}
	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}
	public Linhkien getLinhkien() {
		return linhkien;
	}
	public void setLinhkien(Linhkien linhkien) {
		this.linhkien = linhkien;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CT_hoadon other = (CT_hoadon) obj;
        if (!Objects.equals(this.hoadon, other.hoadon)) {
            return false;
        }
        if (!Objects.equals(this.linhkien, other.linhkien)) {
            return false;
        }
        return true;
    }

    public double tinhtien_chitiet() {
        double dongiaban = linhkien.getDongiaban();
        double tienban = soluong * dongiaban;
        return tienban;
    }

        
	
	
}
