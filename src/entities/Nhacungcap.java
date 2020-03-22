package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
@Entity
public class Nhacungcap {
@Id
  @GeneratedValue(generator = "my_generator")  
  @GenericGenerator(name = "my_generator", strategy = "generalID.MyGeneratorncc")
	private String id;
	private String ten;
	private String diachi;
	private String sdt;
	private String email;
	@OneToMany(mappedBy="nhacungcap" , cascade = CascadeType.ALL , fetch =  FetchType.EAGER)
	private List<Linhkien> dslk;
	
	public List<Linhkien> getDslk() {
		return dslk;
	}

	public void setDslk(List<Linhkien> dslk) {
		this.dslk = dslk;
	}

    public Nhacungcap(String id) {
        this.id = id;
    }

	public Nhacungcap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nhacungcap(String id, String ten, String diachi, String sdt, String email) {
		super();
		this.id = id;
		this.ten = ten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
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
		return "Nhacungcap [id=" + id + ", ten=" + ten + ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email
				+ "]";
	}

}
