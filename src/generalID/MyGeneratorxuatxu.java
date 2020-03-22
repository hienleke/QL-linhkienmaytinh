package generalID;
import DAO.HoadonDAO;
import DAO.NhacungcapDAO;
import DAO.XuatxuDAO;

import entities.Hoadon;
import entities.Nhacungcap;
import entities.Xuatxu;
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
public class MyGeneratorxuatxu implements IdentifierGenerator {
  private String prefix = "XX";
  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
      
      
      
      
      XuatxuDAO hddao = new XuatxuDAO(Xuatxu.class);

    
      List<String> ds = new  ArrayList<>();
    List<Xuatxu> dshoadon=  hddao.findAll() ;
      for (Xuatxu dshoadon1 : dshoadon) {
          ds.add(dshoadon1.getId());
      }
  
  


 
    Stream<String> ids =  ds.stream();
    Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
    return prefix + (String.format("%04d", max + 1));

  }
}