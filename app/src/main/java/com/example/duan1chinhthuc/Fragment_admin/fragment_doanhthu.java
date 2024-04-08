package com.example.duan1chinhthuc.Fragment_admin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1chinhthuc.DAO.DAO_thongke;
import com.example.duan1chinhthuc.R;

import java.util.Calendar;

public class fragment_doanhthu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doanhthu, container, false);
        EditText edtbatdau = view.findViewById(R.id.edtbatdau);
        EditText edtketthuc = view.findViewById(R.id.edtketthuc);
        Button btninsert = view.findViewById(R.id.btninsert);
        TextView txtkq= view.findViewById(R.id.ketqua);

        Calendar calendar = Calendar.getInstance();
        edtbatdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                               String ngay ="";
                               String thang ="";
                               if(dayOfMonth < 10){
                                   ngay ="0" + dayOfMonth;
                               }else {
                                   ngay = String.valueOf(dayOfMonth);
                               }
                               if((month + 1) <10){
                                   thang = "0" + dayOfMonth;
                               }else{
                                    thang = String.valueOf((month + 1));
                               }
                                edtbatdau.setText(year +"/" + thang + "/" + ngay);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                    datePickerDialog.show();
            }
        });

        //
        edtketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String ngay ="";
                                String thang ="";
                                if(dayOfMonth < 10){
                                    ngay ="0" + dayOfMonth;
                                }else {
                                    ngay = String.valueOf(dayOfMonth);
                                }
                                if((month + 1) <10){
                                    thang = "0" + (month + 1);
                                }else{
                                    thang = String.valueOf((month + 1));
                                }
                                edtketthuc.setText(year +"/" + thang + "/" + ngay);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        //
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO_thongke dao = new DAO_thongke(getContext());
                String ngaydau =edtbatdau.getText().toString();
                String ngaycuoi =edtketthuc.getText().toString();
                int doanhthu = dao.getDoanhThu(ngaydau, ngaycuoi);
                txtkq.setText(doanhthu + "| VND |");

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Thông báo");
                builder.setMessage("Doanh Thu : "+doanhthu);
                builder.show();
            }
        });
        return view;
    }
}
