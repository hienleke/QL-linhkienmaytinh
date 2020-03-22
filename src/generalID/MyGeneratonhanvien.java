package generalID;
import DAO.HoadonDAO;
import DAO.LinhkienDAO;
import DAO.NhacungcapDAO;
import DAO.NhanvienDAO;
import entities.Hoadon;
import entities.Linhkien;
import entities.Nhacungcap;
import entities.Nhanvien;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class MyGeneratonhanvien implements IdentifierGenerator {
  private String prefix = "NV";
  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
      
      
      
      
      NhanvienDAO hddao =  new NhanvienDAO(Nhanvien.class);

    
      List<String> ds = new  ArrayList<>();
    List<Nhanvien> dshoadon=  hddao.findAll() ;
      for (Nhanvien dshoadon1 : dshoadon) {
          ds.add(dshoadon1.getId());
      }
  
  


 
    Stream<String> ids =  ds.stream();
    Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
    return prefix + (String.format("%04d", max + 1));

  }
}