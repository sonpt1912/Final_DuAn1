/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.ChucVu;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.INhanVienRepository;

/**
 *
 * @author Duongntt
 */
public class NhanVienRepository implements ICommonRepository<NhanVien, Boolean, String>, INhanVienRepository {

    @Override
    public List<NhanVien> getAll() {
        //tajo lisst
        List<NhanVien> lisstNV = new ArrayList<>();
        //mowr ss
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien");
            lisstNV = query.getResultList();
        }
        return lisstNV;
    }

    public List<NhanVien> getAllByTrangThai(int trangThai) {
        //tajo lisst
        List<NhanVien> lisstNV = new ArrayList<>();
        //mowr ss
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE trangThai = :TrangThai");
            query.setParameter("TrangThai", trangThai);
            lisstNV = query.getResultList();
        }
        return lisstNV;
    }

    @Override
    public NhanVien getOne(String ma) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE ma = :maNV");
            query.setParameter("maNV", ma);
            NhanVien nv = (NhanVien) query.getSingleResult();
            return nv;
        }
    }

    @Override
    public Boolean add(NhanVien nv) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(nv);
                transaction.commit();
                isAdd = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public Boolean update(NhanVien nv, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE NhanVien SET chucVu = :chucVuNV,"
                        + " ho = :hoNV, tenDem = :tenDemNV, ten = :tenNV,"
                        + "gioiTinh = :gioiTinhNV, soDienThoai = :sdtNV, email = :Email , ngaySinh = :ngaySinhNV,"
                        + "diaChi = :diaChiNV, matKhau = :matKhauNV, trangThai = :trangThaiNV"
                        + " WHERE ma = :maNV");
                query.setParameter("chucVuNV", nv.getChucVu());
                query.setParameter("hoNV", nv.getHo());
                query.setParameter("tenDemNV", nv.getTenDem());
                query.setParameter("tenNV", nv.getTen());
                query.setParameter("gioiTinhNV", nv.getGioiTinh());
                query.setParameter("sdtNV", nv.getSoDienThoai());
                query.setParameter("Email", nv.getEmail());
                query.setParameter("ngaySinhNV", nv.getNgaySinh());
                query.setParameter("diaChiNV", nv.getDiaChi());
                query.setParameter("matKhauNV", nv.getMatKhau());
                query.setParameter("trangThaiNV", nv.getTrangThai());
                query.setParameter("maNV", ma);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    public Boolean updateMatKhau(NhanVien nv, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE NhanVien SET matKhau = :matKhauNV"
                        + " WHERE ma = :maNV");
                query.setParameter("matKhauNV", nv.getMatKhau());
                query.setParameter("maNV", ma);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public Boolean remove(String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE NhanVien SET trangThai = 1 WHERE ma = :maNV");
                query.setParameter("maNV", ma);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public NhanVien getUserAndPass(String user, String pass) {
        NhanVien nv = new NhanVien();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE ma = :maNV and matKhau = :MatKhau AND trangThai = 0");
            query.setParameter("maNV", user);
            query.setParameter("MatKhau", pass);
            nv = (NhanVien) query.getSingleResult();
            return nv;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public NhanVien getMaLogin(String user) {
        NhanVien nv = new NhanVien();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE ma = :maNV");
            query.setParameter("maNV", user);
            nv = (NhanVien) query.getSingleResult();
            return nv;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NhanVien> searchByNameAndMa(String name, String ma) {
        List<NhanVien> lisstNV = new ArrayList<>();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE ma LIKE :Ma OR ten LIKE :Ten");
            query.setParameter("Ma", "%" + ma + "%");
            query.setParameter("Ten", "%" + name + "%");
            lisstNV = query.getResultList();
        }
        return lisstNV;
    }

    public static void main(String[] args) {
        NhanVien nv = new NhanVienRepository().getOne("NV2");
        System.out.println(nv.toString());
    }

}
