/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.ComboResponse;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonResponseRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ComboResponseRepository implements ICommonResponseRepository<ComboResponse> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM ComBo CB ";

    @Override
    public List<ComboResponse> getAll() {
        String hql = "SELECT new com.mycompany.customModel.ComboResponse(CB.maCB,CB.tenCB,CB.donGia)" + fromTable + " WHERE trangThai = 0";
        Query query = session.createQuery(hql);
        List<ComboResponse> comboResponses = query.getResultList();
        return comboResponses;
    }

    public List<ComboResponse> getByTenComBo(String tenCB) {
        String hql = "SELECT new com.mycompany.customModel.ComboResponse(CB.maCB,CB.tenCB,CB.donGia)" + fromTable
                + "WHERE CB.tenCB like :tenCB OR CB.maCB LIKE :tenCB AND CB.trangThai = 0";
        Query query = session.createQuery(hql);
        query.setParameter("tenCB", "%" + tenCB + "%");
        List<ComboResponse> comboResponses = query.getResultList();
        return comboResponses;
    }

    public List<ComboResponse> getByDonGia(BigDecimal donGia) {
        String hql = "SELECT new com.mycompany.customModel.ComboResponse(CB.maCB,CB.tenCB,CB.donGia)" + fromTable
                + "WHERE CB.donGia = :donGia AND CB.trangThai = 0";
        Query query = session.createQuery(hql);
        query.setParameter("donGia", donGia);
        List<ComboResponse> comboResponses = query.getResultList();
        return comboResponses;
    }

    public static void main(String[] args) {
        List<ComboResponse> search = new ComboResponseRepository().getByTenComBo("Combo 255");
        for (ComboResponse comboResponse : search) {
            System.out.println(comboResponse.toString());
        }
    }

}
