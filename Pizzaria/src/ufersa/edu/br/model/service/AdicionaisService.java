package br.edu.ufersa.pizzaria.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ufersa.pizzaria.model.dao.AdicionaisDAO;
import br.edu.ufersa.pizzaria.model.dao.BaseInterDAO;
import br.edu.ufersa.pizzaria.model.entities.Adicionais;

public class AdicionaisService {

    BaseInterDAO<Adicionais> dao = new AdicionaisDAO();

    public boolean insertAdditionais(Adicionais adicionais) {
        ResultSet rs = dao.findAdicional(adicionais);
        try {
            if (rs == null || !(rs.next())) {
                if (dao.insertAdicional(adicionais) == true) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Adicionais> getAllAdicionais() {
        List<Adicionais> addresses = new ArrayList<Adicionais>();
        ResultSet rs = dao.getAll();
        try {
            while (rs.next()) {
                Adicionais adicionais = new Adicionais();
                adicionais.setName(rs.getString("name"));
                adicionais.setValue(rs.getDouble("value"));

                adicionais.add(adicionais);
            }
            return adicionais;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean editAdicionais(Adicionais adicionais) {
        ResultSet rs = dao.findBySpecifiedField(adicionais, "name");
        try {
            if (rs != null && rs.next()) {
                if (dao.edit(adicionais) == true) {
                    return true;
                } else
                    return false;
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAdicionais(Adicionais adicionais) {
        ResultSet rs = dao.findBySpecifiedField(adicionais, "name");
        try {
            if (rs != null && rs.next()) {
                if (dao.delete(adicionais) == true) {
                    return true;
                } else
                    return false;
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}