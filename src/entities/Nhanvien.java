package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Nhanvien {
@Id
 @GeneratedValue(generator = "my_generator")  
  @GenericGenerator(name = "my_generator", strategy = "generalID.MyGeneratonhanvien")
private String id;
private String ten;
private String diachi;
private String sdt;
private String taikhoan;

@ManyToOne
@JoinColumn(name="IDNGUOIQUANLY")
private Nhanvien Nguoiquanli;

@OneToMany(mappedBy = "nhanvien")
private List<Hoadon> dshd;

public Nhanvien(String id)
{
    this.id =id;
}
public Nhanvien() {
	super();
	// TODO Auto-generated constructor stub
}

    public Nhanvien(String id, String ten, String diachi, String sdt, String taikhoan, Nhanvien Nguoiquanli) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.taikhoan = taikhoan;
        this.Nguoiquanli = Nguoiquanli;
    }


public Nhanvien(String id, String ten, String diachi, String sdt) {
	super();
	this.id = id;
	this.ten = ten;
	this.diachi = diachi;
	this.sdt = sdt;
}

    public void setDshd(List<Hoadon> dshd) {
        this.dshd = dshd;
    }

    public List<Hoadon> getDshd() {
        return dshd;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
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
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}

    public void setNguoiquanli(Nhanvien Nguoiquanli) {
        this.Nguoiquanli = Nguoiquanli;
    }

    public Nhanvien getNguoiquanli() {
        return Nguoiquanli;
    }

@Override
public String toString() {
	return "Nhanvien [id=" + id + ", ten=" + ten + ", diachi=" + diachi + ", sdt=" + sdt + "]";
}


}
