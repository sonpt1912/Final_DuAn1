/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.domainModel.ComBo;
import java.util.List;

/**
 *
 * @author son45
 */
public interface IComBoRepository {

    List<ComBo> getAllByTrangThai(int trangThai);

    List<ComBo> getAlls();
}
