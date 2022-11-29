/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.repository.*;
import com.mycompany.domainModel.NhanVien;
import java.util.List;

/**
 *
 * @author son45
 */
public interface INhanVienService {

    NhanVien getUserAndPass(String user, String pass);

    NhanVien getMaLogin(String user);

    List<NhanVien> searchByNameAndMa(String name, String ma);

    List<NhanVien> getAllByTrangThai(int trangThai);
}
