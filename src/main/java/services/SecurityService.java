package services;

import DAO.DAO;
import models.Security;

import java.util.List;
public class SecurityService {
    private DAO dao = new DAO();
    public SecurityService(){
    }
    public Security findById(int id) {
        return dao.findById(id);
    }

    public void saveOrUpdate(Security security) {
        dao.saveOrUpdate(security);
    }

    public void update(Security security) {
        dao.update(security);
    }

    public void delete(Security security) {
        dao.delete(security);
    }

    public void delete(List<Security> list){
        dao.delete(list);
        System.out.println("Удалено " + list.size() + " ценных бумаг в базе данных");
    }


    public List<Security> findAll() {
        return dao.findAll();
    }

    public void saveList(List<Security> securities){
        for (Security security: securities) {
            dao.saveOrUpdate(security);
        }
    }

    public void DeleteAllSecuritiesFromDB(){
        List<Security> listForDeleted= dao.findAll();
        dao.delete(listForDeleted);
        System.out.println("Удалено " + listForDeleted.size() + " ценных бумаг в базе данных");
    }
}
