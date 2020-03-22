package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CT_hoadon_PK implements Serializable{
	
	
	private String hoadon;
	
	private String linhkien;
	

	public CT_hoadon_PK() {
	}
	
	public CT_hoadon_PK(String sinhvien, String monhoc) {
		this.hoadon = sinhvien;
		this.linhkien = monhoc;
	}
	
	
	public String getHoadon() {
		return hoadon;
	}
	public void setHoadon(String hoadon) {
		this.hoadon = hoadon;
	}
	public String getLinhkien() {
		return linhkien;
	}
	public void setLinhkien(String linhkien) {
		this.linhkien = linhkien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linhkien == null) ? 0 : linhkien.hashCode());
		result = prime * result + ((hoadon == null) ? 0 : hoadon.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CT_hoadon_PK other = (CT_hoadon_PK) obj;
		if (linhkien == null) {
			if (other.linhkien != null)
				return false;
		} else if (!linhkien.equals(other.linhkien))
			return false;
		if (hoadon == null) {
			if (other.hoadon != null)
				return false;
		} else if (!hoadon.equals(other.hoadon))
			return false;
		return true;
	}
	
	
}
