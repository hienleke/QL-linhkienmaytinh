package entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Linhkien {
	  @Id
  @GeneratedValue(generator = "my_generator")  
  @GenericGenerator(name = "my_generator", strategy = "generalID.MyGeneratoLinhkien")
	private String id;
	private String ten;
	private int soluong;

	private double dongiagoc;
        private double dongiaban;
	private String mota;

	@ManyToOne
	@JoinColumn (name = "IDNHACUNGCAP")
	private Nhacungcap nhacungcap;
	@ManyToOne
	@JoinColumn(name="IDXUATXU")
	private Xuatxu xuatxu;
	@ManyToOne
	@JoinColumn(name="IDDANHMUCLINHKIEN")
	private Danhmuclinhkien danhmuclinhkien;
	
	@OneToMany(mappedBy="linhkien")
	private List<CT_hoadon> dsCthd;
        
	private String hinhanh;
	
	

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

    public Linhkien(String id ,String ten, int soluong, double dongiagoc, String mota, Nhacungcap nhacungcap, Xuatxu xuatxu, Danhmuclinhkien danhmuclinhkien,  String hinhanh) {
        this.id=id;
        this.ten = ten;
        this.soluong = soluong;
        this.dongiagoc = dongiagoc;
        this.mota = mota;
        this.nhacungcap = nhacungcap;
        this.xuatxu = xuatxu;
        this.danhmuclinhkien = danhmuclinhkien;
    
        this.hinhanh = hinhanh;
    }

    public Linhkien(String id, String ten, int soluong, double dongiagoc, double dongiaban, String mota, Nhacungcap nhacungcap, Xuatxu xuatxu, Danhmuclinhkien danhmuclinhkien, List<CT_hoadon> dsCthd, String hinhanh) {
        this.id = id;
        this.ten = ten;
        this.soluong = soluong;
        this.dongiagoc = dongiagoc;
        this.dongiaban = dongiaban;
        this.mota = mota;
        this.nhacungcap = nhacungcap;
        this.xuatxu = xuatxu;
        this.danhmuclinhkien = danhmuclinhkien;
        this.dsCthd = dsCthd;
        this.hinhanh = hinhanh;
    }



   
        
	public Linhkien(String id, String ten, int soluong, double dongiagoc, String mota, Nhacungcap nhacungcap,
			Xuatxu xuatxu, Danhmuclinhkien danhmuclinhkien, List<CT_hoadon> dsCthd) {
		super();
		this.id = id;
		this.ten = ten;
		this.soluong = soluong;
		this.dongiagoc = dongiagoc;
		this.mota = mota;
		this.nhacungcap = nhacungcap;
		this.xuatxu = xuatxu;
		this.danhmuclinhkien = danhmuclinhkien;
		this.dsCthd = dsCthd;
	}

	public Linhkien(String id, String ten, int soluong, double dongiagoc, String mota, Nhacungcap nhacungcap,
			Xuatxu xuatxu, Danhmuclinhkien danhmuclinhkien) {
		super();
		this.id = id;
		this.ten = ten;
		this.soluong = soluong;
		this.dongiagoc = dongiagoc;
		this.mota = mota;
		this.nhacungcap = nhacungcap;
		this.xuatxu = xuatxu;
		this.danhmuclinhkien = danhmuclinhkien;
	}

    public Linhkien( String ten, double dongiagoc, Nhacungcap nhacungcap, Xuatxu xuatxu, Danhmuclinhkien danhmuclinhkien, String hinhanh) {
        
        this.ten = ten;
        this.dongiagoc = dongiagoc;
        this.nhacungcap = nhacungcap;
        this.xuatxu = xuatxu;
        this.danhmuclinhkien = danhmuclinhkien;
        this.hinhanh = hinhanh;
    }

    

    public Linhkien(String id) {
        this.id = id;
    }
        

	public List<CT_hoadon> getDsCthd() {
		return dsCthd;
	}

	public void setDsCthd(List<CT_hoadon> dsCthd) {
		this.dsCthd = dsCthd;
	}

	public Linhkien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getDongiagoc() {
		return dongiagoc;
	}

	public void setDongiagoc(double dongiagoc) {
		this.dongiagoc = dongiagoc;
	}

    public double getDongiaban() {
        return dongiaban;
    }

    public void setDongiaban(double dongiaban) {
        this.dongiaban = dongiaban;
    }
        
	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}


	public Nhacungcap getNhacungcap() {
		return nhacungcap;
	}

	public void setNhacungcap(Nhacungcap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	public Xuatxu getXuatxu() {
		return xuatxu;
	}

	public void setXuatxu(Xuatxu xuatxu) {
		this.xuatxu = xuatxu;
	}

	public Danhmuclinhkien getDanhmuclinhkien() {
		return danhmuclinhkien;
	}

	public void setDanhmuclinhkien(Danhmuclinhkien danhmuclinhkien) {
		this.danhmuclinhkien = danhmuclinhkien;
	}

    @Override
    public String toString() {
        return "Linhkien{" + "id=" + id + ", ten=" + ten + ", soluong=" + soluong + ", dongiagoc=" + dongiagoc + ", dongiaban=" + dongiaban + ", mota=" + mota + ", nhacungcap=" + nhacungcap + ", xuatxu=" + xuatxu + ", danhmuclinhkien=" + danhmuclinhkien + ", dsCthd=" + dsCthd + ", hinhanh=" + hinhanh + '}';
    }
        
        
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Linhkien other = (Linhkien) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

	

}
