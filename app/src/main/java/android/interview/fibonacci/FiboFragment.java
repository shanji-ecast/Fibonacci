package android.interview.fibonacci;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FiboFragment extends Fragment {

    private Fibonacci fibonacci;
    private RecyclerView mRecycleView;
    private int screenWidth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fibonacci = new Fibonacci(40);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fibo_layout, container, false);

        mRecycleView = root.findViewById(R.id.recycleView);
        mRecycleView.setLayoutManager(new GridLayoutManager(getActivity(), screenWidth/240));
        mRecycleView.setAdapter(new FiboItemAdapter(getActivity(), fibonacci.getResultList()));

        return root;
    }

}
