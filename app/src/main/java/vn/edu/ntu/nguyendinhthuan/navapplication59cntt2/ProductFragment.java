package vn.edu.ntu.nguyendinhthuan.navapplication59cntt2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.fragment.NavHostFragment;

import vn.edu.ntu.nguyendinhthuan.navapplication59cntt2.controller.ICartController;
import vn.edu.ntu.nguyendinhthuan.navapplication59cntt2.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {
    EditText txtPriceNew, txtNameProductNew, txtDescNew;
    Button btnAddProduct;
    public ProductFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtPriceNew = (EditText) getActivity().findViewById(R.id.txtPriceNew);
        txtNameProductNew = (EditText) getActivity().findViewById(R.id.txtNameProductNew);
        txtDescNew = (EditText) getActivity().findViewById(R.id.txtDescNew);
        btnAddProduct = (Button) getActivity().findViewById(R.id.btnAddProduct);
        final ICartController cartController = (ICartController) getActivity().getApplication();
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(txtNameProductNew.getText().toString(), Integer.parseInt(String.valueOf(txtPriceNew.getText())), txtDescNew.getText().toString());
                cartController.addProduct(product);
                NavHostFragment.findNavController(ProductFragment.this)
                        .navigate(R.id.action_productFragment_to_listProductFragment);
            }
        });
    }
}
