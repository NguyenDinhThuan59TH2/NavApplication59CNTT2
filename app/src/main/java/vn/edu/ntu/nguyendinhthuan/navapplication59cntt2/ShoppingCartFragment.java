package vn.edu.ntu.nguyendinhthuan.navapplication59cntt2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import vn.edu.ntu.nguyendinhthuan.navapplication59cntt2.controller.ICartController;
import vn.edu.ntu.nguyendinhthuan.navapplication59cntt2.model.Product;

public class ShoppingCartFragment extends Fragment {
    TextView txtShoppingCart;
    ICartController controller;
    Button btnOK, btnDelete;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = (ICartController) getActivity().getApplication();
        addViews();
    }

    private void addViews() {
        txtShoppingCart = getActivity().findViewById(R.id.txtCart);
        displayShoppingCart();
    }

    private void displayShoppingCart() {
        StringBuilder builder = new StringBuilder();
        for (Product p: controller.getShoppingCart()){
            builder.append(p.getName())
                    .append("\t\t\t")
                    .append(p.getPrice())
                    .append("VND\n");
        }

        if (builder.toString().length() > 0)
        {
            txtShoppingCart.setText(builder.toString());
            btnOK = getActivity().findViewById(R.id.btnOK);
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    controller.clearShoppingCart();
                    Toast toast = Toast.makeText(getActivity(), "Chung toi se gui hang cho ban trong vong 4 ngay", Toast.LENGTH_SHORT);
                    toast.show();
                    displayShoppingCart();
                }
            });
            btnDelete = getActivity().findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    controller.clearShoppingCart();
                    displayShoppingCart();
                }
            });
        }
        else
            txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng.");
    }
}
