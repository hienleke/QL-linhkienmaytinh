package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
@Entity
public class Xuatxu {
@Id
@GeneratedValue(generator = "my_generator")  
  @GenericGenerator(name = "my_generator", strategy = "generalID.MyGeneratorxuatxu")
private String id;
private String quocgia;
@OneToMany(mappedBy="xuatxu")
private List<Linhkien> dslk;
public Xuatxu(String id, String quocgia) {
	super();
	this.id = id;
	this.quocgia = quocgia;
}
public Xuatxu() {
	super();
	// TODO Auto-generated constructor stub
}

public Xuatxu(String id) {
	super();
	this.id = id;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getQuocgia() {
	return quocgia;
}
public void setQuocgia(String quocgia) {
	this.quocgia = quocgia;
}


}
