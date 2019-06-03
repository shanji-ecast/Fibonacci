package android.interview.fibonacci;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FiboItemAdapter extends RecyclerView.Adapter<FiboItemAdapter.FiboItemViewHolder> {

    class FiboItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textIndex;
        private TextView textResult;

        public FiboItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textIndex = itemView.findViewById(R.id.textIndex);
            textResult = itemView.findViewById(R.id.textResult);
        }
    }

    private Context mContext;
    private List<Integer> mList;

    public FiboItemAdapter(Context context, List<Integer> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public FiboItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new FiboItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FiboItemViewHolder holder, int position) {

        holder.textIndex.setText(mContext.getString(R.string.string_index, position));
        holder.textResult.setText(mContext.getString(R.string.string_result, mList.get(position)));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
