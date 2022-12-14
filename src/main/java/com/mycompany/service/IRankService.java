/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;


import com.mycompany.domainModel.RankKhachHang;
import java.util.List;

/**
 *
 * @author PTS
 */
public interface IRankService {

    List<RankKhachHang> getAll();

    RankKhachHang getOne(String ma);

    RankKhachHang getOneById(String id);

    String add(RankKhachHang kh);

    String update(RankKhachHang kh, String ma);

    String remove(String ma);

    String rank(String idKH);

}
