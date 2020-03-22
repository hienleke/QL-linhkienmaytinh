package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Khachhang {
@Id
 @GeneratedValue(generator = "my_generator")  
 @GenericGenerator(name = "my_generator", strategy = "generalID.MyGeneratorkhachhang")
private String id;
private String ten;
private String diachi;
private String sdt;
private String email;


@OneToMany(mappedBy="khachhang")
private List<Hoadon> dshd;

    public Khachhang(String id) {
        this.id = id;
    }


public Khachhang(String id, String ten, String diachi, String sdt, String email) {
	super();
	this.id = id;
	this.ten = ten;
	this.diachi = diachi;
	this.sdt = sdt;
	this.email = email;
}
public Khachhang() {
	super();
	// TODO Auto-generated constructor stub
}

public List<Hoadon> getDshd() {
	return dshd;
}
public void setDshd(List<Hoadon> dshd) {
	this.dshd = dshd;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Khachhang [id=" + id + ", ten=" + ten + ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email + "]";
}


}
