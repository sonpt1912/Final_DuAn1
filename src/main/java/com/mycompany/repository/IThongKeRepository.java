/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.customModel.SanPhamRepose;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.domainModel.MonAn;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author PTS
 */
public interface IThongKeRepository {

    List<HoaDon> getAllHoaDon(int t);

    List<MonAn> getAllSanPham();

    List<HoaDon> getAllHoaDonTrangThai(int trangThai);

    List<MonAn> getAllSanPhamTrangThai(int trangThai);

    long getHoaDonDaTTDAY();

    long getHoaDonDaTTWEEK();

    long getHoaDonDaTTMONTH();

    long getHoaDonDaTTYEAR();

    long getCountAllDay();

    long getCountAllMonth();

    long getCountAllWeek();

    long getCountAllYear();

    long getHoaDonHuyDAY();

    long getHoaDonHuyWEEK();

    long getHoaDonHuyMONTH();

    long getHoaDonHuyYEAR();

    BigDecimal getDoanhThuDAY();

    BigDecimal getDoanhThuWEEK();

    BigDecimal getDoanhThuMONTH();

    BigDecimal getDoanhThuYEAR();

    BigDecimal getDoanhThuThang1();

    BigDecimal getDoanhThuThang2();

    BigDecimal getDoanhThuThang3();

    BigDecimal getDoanhThuThang4();

    BigDecimal getDoanhThuThang5();

    BigDecimal getDoanhThuThang6();

    BigDecimal getDoanhThuThang7();

    BigDecimal getDoanhThuThang8();

    BigDecimal getDoanhThuThang9();

    BigDecimal getDoanhThuThang10();

    BigDecimal getDoanhThuThang11();

    BigDecimal getDoanhThuThang12();

    long soLuongKhachHangDAY();

    long soLuongKhachHangWEEK();

    long soLuongKhachHangMONTH();

    long soLuongKhachHangYEAR();

}
