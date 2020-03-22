package entities;


import java.time.LocalDate;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;










@Entity
public class Hoadon {

   @Id
  @GeneratedValue(generator = "my_generator")  
  @GenericGenerator(name = "my_generator", strategy = "generalID.MyGenerator")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "IDKHACHHANG")
	private Khachhang khachhang;
	
	@ManyToOne
	@JoinColumn(name = "IDNHANVIEN")
	private Nhanvien nhanvien;
	
	@OneToMany(mappedBy = "hoadon" )
	private List<CT_hoadon> dsCthd ;
	
	
	private String luuy;
	private LocalDate ngaylap;
	private double tienkhachhangdua;
        @Transient
	private double thue;

    public Hoadon(Khachhang khachhang, Nhanvien nhanvien, LocalDate ngaylap) {
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        this.ngaylap = ngaylap;
    }
	

	

	public Hoadon(String id, Khachhang khachhang, Nhanvien nhanvien, String luuy, LocalDate ngaylap,
			double tienkhachhangdua) {
		super();
		this.id = id;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.luuy = luuy;
		this.ngaylap = ngaylap;
		this.tienkhachhangdua = tienkhachhangdua;
		this.thue=tinhthue();
	}
        


	public Hoadon(String id) {
		super();
		this.id = id;
	}

	public Hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CT_hoadon> getDsCthd() {
		return dsCthd;
	}

	public void setDsCthd(List<CT_hoadon> dsCthd) {
		this.dsCthd = dsCthd;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public String getLuuy() {
		return luuy;
	}

	public void setLuuy(String luuy) {
		this.luuy = luuy;
	}

	public LocalDate getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(LocalDate ngaylap) {
		this.ngaylap = ngaylap;
	}

	public double getTienkhachhangdua() {
		return tienkhachhangdua;
	}

	public void setTienkhachhangdua(double tienkhachhangdua) {
		this.tienkhachhangdua = tienkhachhangdua;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}
        
        public Double tinhthue()
        {
              double tongtien = 0 ;
		for (CT_hoadon ct_hoadon : dsCthd) {
			int soluong = ct_hoadon.getSoluong();
			double dongia= ct_hoadon.getLinhkien().getDongiaban();
			double tienban = soluong*dongia;// + soluong*dongiagoc*0.05;

                        
                        
			tongtien+= tienban ;
					
		}
		return tongtien *0.01;
        }
        public Double tinhlai()
        {
              double tongtien = 0 ;
		for (CT_hoadon ct_hoadon : dsCthd) {
			int soluong = ct_hoadon.getSoluong();
			double dongia= ct_hoadon.getLinhkien().getDongiaban();
			double tienban = soluong*dongia;// + soluong*dongiagoc*0.05;

                        double dongiagoc=ct_hoadon.getLinhkien().getDongiagoc();
                        double tiengoc =soluong*dongiagoc;
			tongtien+= tienban -tiengoc ;
					
		}
		return tongtien  ;
        }
	public Double Tinhtien()
	{
		//      System.out.println(dsCthd);
                double tongtien = 0 ;
		for (CT_hoadon ct_hoadon : dsCthd) {
			int soluong = ct_hoadon.getSoluong();
			double dongia= ct_hoadon.getLinhkien().getDongiaban();
			double tienban = soluong*dongia;// + soluong*dongiagoc*0.05;

                        
                        
			tongtien+= tienban ;
					
		}
		return tongtien  + tinhthue();
	}


    @Override
    public String toString() {
        return "Hoadon{" + "id=" + id + ", khachhang=" + khachhang + ", nhanvien=" + nhanvien + ", dsCthd=" + dsCthd + ", luuy=" + luuy + ", ngaylap=" + ngaylap + ", tienkhachhangdua=" + tienkhachhangdua + ", thue=" + thue + '}';
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
        final Hoadon other = (Hoadon) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
	
}
