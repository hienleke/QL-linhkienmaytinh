package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Danhmuclinhkien {
	@Id
        @GeneratedValue(generator = "my_generator")  
  @GenericGenerator(name = "my_generator", strategy = "generalID.MyGeneratordanhmuc")
	private String id;
	private String ten;
	private String mota;
	@OneToMany(mappedBy = "danhmuclinhkien")
	private List<Linhkien> dslk;

	public Danhmuclinhkien(String id, String ten, String mota) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
	}

	public Danhmuclinhkien(String id) {
		super();
		this.id = id;
	}

	public Danhmuclinhkien() {
		super();

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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Override
	public String toString() {
		return "Danhmuclinhkien [id=" + id + ", ten=" + ten + ", mota=" + mota + "]";
	}

}
