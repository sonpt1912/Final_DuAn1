/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.ChiTietComBo;
import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.MonAn;
import com.mycompany.repository.IChiTietComBoRepository;
import com.mycompany.repository.impl.ChiTietComBoRepository;
import com.mycompany.service.IChiTietComBoService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietComBoService implements IChiTietComBoService<ChiTietComBo, String, Integer, ComBo, MonAn, Boolean> {

    private IChiTietComBoRepository ctcbr = new ChiTietComBoRepository();

    @Override
    public List<ChiTietComBo> getAll() {
        return ctcbr.getAll();
    }

    @Override
    public String add(ChiTietComBo ctcb) {
        if ((Boolean) ctcbr.add(ctcb)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChiTietComBo chiTietComBo, ComBo comBo, MonAn monAn) {
        if ((Boolean) ctcbr.update(chiTietComBo, comBo, monAn)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(ChiTietComBo ctcb, ComBo comBo, MonAn monAn) {
        if ((Boolean) ctcbr.remove(ctcb, comBo, monAn)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

    public static void main(String[] args) {
        MonAn ma = new MonAn();
        ma.setId("CFCA2AD6-A346-4C54-A3A8-279D6D782BA7");
        ComBo comBo = new ComBo();
        comBo.setId("761D26FA-AE41-42EB-996F-362679A2513A");
        ChiTietComBo ctcb = new ChiTietComBo(null, comBo, ma, 20);
        String test = new ChiTietComBoService().add(ctcb);
        System.out.println(test);
        List<ChiTietComBo> chiTietComBos = new ChiTietComBoService().getAll();
        for (ChiTietComBo chiTietComBo : chiTietComBos) {
            System.out.println(chiTietComBo);
        }
    }

    @Override
    public List<ChiTietComBo> getAllByComBo(ComBo id) {
        return ctcbr.getAllByComBo(id);
    }

    @Override
    public ChiTietComBo getOneById(ChiTietComBo chiTietComBo) {
        ChiTietComBo cb = (ChiTietComBo) ctcbr.getOneById(chiTietComBo);
        return cb;
    }

    @Override
    public String updateSoLuong(ChiTietComBo chiTietComBo, ComBo comBo, int soLuong) {
        if ((boolean) ctcbr.updateSoLuong(chiTietComBo, comBo, soLuong) == true) {
            return "sửa thành công";
        } else {
            return "sửa không thành công";
        }
    }

    public ChiTietComBo checkCTComBo(ComBo comBo, MonAn monAn) {
        List<ChiTietComBo> ctCB = getAllByComBo(comBo);
        for (ChiTietComBo ct : ctCB) {
            if (monAn.getId().equals(ct.getMonAn().getId())) {
                return ct;
            }
        }
        return null;
    }

    public String saveOrUpdate(ComBo comBo, MonAn monAn, ChiTietComBo chiTietComBo) {
        if (checkCTComBo(comBo, monAn) == null) {
            // add
            return add(chiTietComBo);
        } else {
            // update
            // chi tiết có sẵn;
            ChiTietComBo c = checkCTComBo(comBo, monAn);
            int soLuong = c.getSoLuongMonAn() + chiTietComBo.getSoLuongMonAn();
            return updateSoLuong(c, comBo, soLuong);
        }
    }

    @Override
    public String deleteCTCombo(String id) {
        if ((boolean) ctcbr.delete(id)) {
            return "xóa thành công";
        } else {
            return "xóa không thành công";
        }
    }

}
