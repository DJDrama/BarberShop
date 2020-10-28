package com.barbershop.www.ui.main.goods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.barbershop.www.R;
import com.barbershop.www.databinding.FragmentGoodsBinding;
import com.barbershop.www.model.Brand;
import com.barbershop.www.model.Item;

import java.util.ArrayList;
import java.util.List;

public class GoodsFragment extends Fragment implements OnGoodClickedListener {
    private FragmentGoodsBinding binding;
    private GoodsRecyclerViewAdapter adapter;
    private List<Brand> brandList = new ArrayList();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGoodsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
        addItems();
    }

    private void addItems() {
        //팁탑
        brandList.add(new Brand("Tip Top", R.drawable.tiptop, "TIPTOP 바버샵 포마드 4종 오리지널/매트/스트롱홀드 팁탑 수성포마드.", 0,
                new ArrayList<Item>() {{
                    add(new Item("팁탑 오리지널 포마드", R.drawable.tiptop_original, "향도 광도 자극적이지 않아 인기가 많은 제품. 미국내 바버들에게 검증되어 개발 된 완벽한 포마드", 4, 5, 4, 3));
                    add(new Item("팁탑 매트", R.drawable.tiptop_mat, "수성 제품으로써 광택이 없어 자연스러운 스타일링에 최적화된 워터베이스의 포마드", 4, 5, 4, 3));
                    add(new Item("팁탑 스트롱홀드", R.drawable.tiptop_strong, "하루종일 강력한 세팅력을 유지하면서 팁탑 특유의 부드러운 향기와 탁월한 광택을 제공하는 포마드", 4, 5, 4, 3));
                    add(new Item("팁탑 스트롱홀드 매트", R.drawable.tiptop_strong_mat, "수성 제품으로써 광택이 없어 자연스러운 스타일링에 클레이타입 질감의 포마드", 4, 5, 4, 3));

                }}));

        //리우젤
        brandList.add(new Brand("Reuzel", R.drawable.reuzel, "매혹적인 향기와 우수한 세정력, No1.포마드", 0,
                new ArrayList<Item>() {{
                    add(new Item("리우젤 블루 수성 하드 포마드", R.drawable.reuzel_blue, "리우젤의 시그니쳐 수성 포마드", 4, 5, 4, 3));
                    add(new Item("리우젤 레드 수성 포마드", R.drawable.reuzel_red, "바닐라 코코향의 품격있는 달콤한 잔향", 4, 5, 4, 3));
                    add(new Item("리우젤 핑크 수성 포마드", R.drawable.reuzel_pink, "하루종일 고급스러운 광택, 강한 고정력의 정통 포마드", 4, 5, 4, 3));
                }}));


        adapter.submitList(brandList);
    }

    private void setRecyclerView() {
        adapter = new GoodsRecyclerViewAdapter(this);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onGoodClicked(Brand brand) {

    }
}
