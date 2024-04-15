package com.example.duan1chinhthuc.Adapter_admin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1chinhthuc.DAO.DonHang_DAO;
import com.example.duan1chinhthuc.Fragment_admin.QL_tk_user;
import com.example.duan1chinhthuc.Frament_user.Fragment_canhan;
import com.example.duan1chinhthuc.R;
import com.example.duan1chinhthuc.mode.Donhang;
import com.example.duan1chinhthuc.mode.nguoidung;

import java.util.ArrayList;
import java.util.List;

public class adapter_QL_donhang extends RecyclerView.Adapter<adapter_QL_donhang.viewholder>{
     ArrayList<Donhang> list;
    private final Context context;
    Spinner spn_soluong;
    adapter_QL_donhang adapter;
    DonHang_DAO dao;
    TextView textView;
    String sodienthoai;
    String diachi;
    String tenKH;



    public adapter_QL_donhang(ArrayList<Donhang> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public adapter_QL_donhang.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_donhang,parent,false);

        return new adapter_QL_donhang.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_QL_donhang.viewholder holder, @SuppressLint("RecyclerView") int position) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Thongtin_tt", Context.MODE_PRIVATE);
        holder.id_DH.setText(Integer.toString(list.get(position).getId()));
        holder.id_SP.setText(Integer.toString(list.get(position).getId_chitietsp()));
        holder.email.setText(Integer.toString(list.get(position).getSoluong_sp()));
        holder.size.setText(Integer.toString(list.get(position).getSize()));
        holder.trangthai.setText(list.get(position).getTrangthaidonhang());
        holder.tongtien1.setText(Integer.toString(list.get(position).getTongtien()));
        holder.tenKH.setText(Integer.toString(list.get(position).getId_user()));



        if (list.get(position).getTrangthaidonhang().equals("chờ xác nhận")){
            holder.trangthai.setTextColor(Color.parseColor("#0A47FD"));
        }
        else if (list.get(position).getTrangthaidonhang().equals("đang giao hàng")){
            holder.trangthai.setTextColor(Color.parseColor("#ff0000"));
        }else if (list.get(position).getTrangthaidonhang().equals("đã giao")){}

        holder.ttkh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                   builder.setTitle("Thông tin khách hàng");
                   builder.setMessage("MÃ KH : "+list.get(position).getId_user()+"\n Số điện thoại : "+list.get(position).getSdt()+"\n Địa chỉ : "+list.get(position).getDiachi());
                   builder.setPositiveButton(" Đóng ", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.dismiss();

                       }
                   });

                   builder.show();



            }
        });

holder.xoa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn muốn từ chối xác nhận đơn hàng ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dao.delete(list.get(holder.getAdapterPosition()).getId())){
                    list.clear();
                    list.addAll(dao.getDS_donhang());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
});
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(context);
                LayoutInflater inflater1 = LayoutInflater.from(context);
                View view1 = inflater1.inflate(R.layout.item_update_donhang, null);
                builder1.setView(view1);
                androidx.appcompat.app.AlertDialog alertDialog = builder1.create();

                Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                Button btnquaylai = view1.findViewById(R.id.btnquaylai);
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (list.get(position).getTrangthaidonhang().equals("chờ xác nhận")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                            builder.setTitle("Thông báo");
                            builder.setMessage("Xác nhận đơn hàng ?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String trangthai = "đang giao hàng";
                                    Donhang ls=list.get(position);
                                    ls.setTrangthaidonhang(trangthai);
                                    boolean kt = dao.capnhatdonhang_admin(ls);
                                    if(kt){
                                        list.clear();
                                        list.addAll(dao.getDS_donhang());
                                        adapter.notifyDataSetChanged();
                                        alertDialog.dismiss();
                                        Toast.makeText(context, "Succesfully", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builder.show();
                        }else if(list.get(position).getTrangthaidonhang().equals("đang giao hàng")){
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                            builder.setTitle("Thông báo");
                            builder.setMessage("Đơn hàng thay đổi trạng thái - đảm bảo đơn hàng đã được thanh toán trước khi xác nhận ?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String trangthai = "đã giao";
                                    Donhang ls=list.get(position);
                                    ls.setTrangthaidonhang(trangthai);
                                    boolean kt = dao.capnhatdonhang_admin(ls);
                                    if(kt){
                                        list.clear();
                                        list.addAll(dao.getDS_donhang());
                                        adapter.notifyDataSetChanged();
                                        alertDialog.dismiss();
                                        Toast.makeText(context, "Succesfully", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builder.show();
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle("Thông báo");
                            builder.setMessage("Không thể thay đổi trạng thái , khi đơn hàng đã được giao !");

                            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    alertDialog.dismiss();
                                }
                            });
                            builder.show();
                        }

                    }
                });

                btnquaylai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });


                alertDialog.show();
            }
        });

        adapter = new adapter_QL_donhang(list, context);
        dao = new DonHang_DAO(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id_DH,id_SP,tenKH,SDT,email,diachi,size,trangthai,tongtien1,ten88,diachi88,sdt88;
        ImageView xoa,ttkh;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            xoa = itemView.findViewById(R.id.delete_donhang);
            ttkh = itemView.findViewById(R.id.ttkh);

            id_DH = itemView.findViewById(R.id.idDonhang22);
            id_SP = itemView.findViewById(R.id.id_sanpham22);
            email = itemView.findViewById(R.id.textinputemail22);

            size = itemView.findViewById(R.id.size22);
            tongtien1 = itemView.findViewById(R.id.tongtien);
            trangthai = itemView.findViewById(R.id.trangthai22);

            ///
            tenKH = itemView.findViewById(R.id.textinputname22);
            ten88 = itemView.findViewById(R.id.ten_88);
            diachi88 = itemView.findViewById(R.id.diachi_88);
            sdt88 = itemView.findViewById(R.id.sdt_88);

        }
    }

    private void Spiner() {
        String[] soluong = new String[]{"đang giao hàng"};
        ArrayAdapter<String> sl= new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, soluong);
        spn_soluong.setAdapter(sl);
    }
}
