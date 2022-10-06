package ufersa.edu.br.model.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ufersa.edu.br.model.dao.AdicionaisDao;

public class AdicionaisService {
    BaseInterDAO<Adicionais> dao = new AdicionaisDAO();

    public boolean insertAdditionais(Adicionais adicionais){
        ResultSet rs = dao.findAdicional(adicionais);
        try{
            if(rs == null || !(rs.next())){
                if(dao.insertAdicional(adicionais) == true){
                    return true;
                }else{
                    return false;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
			return false;
        }
    }
}
