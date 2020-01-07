package online.billard35.caveavin;

import androidx.recyclerview.widget.RecyclerView;



        import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VinAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "VinAdapter";
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mCallback;
    private ArrayList<Vin> mVinList;
    public VinAdapter(ArrayList<Vin> vinList) {
        mVinList = vinList;
    }
    public void setCallback(Callback callback) {
        mCallback = callback;
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_vin, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.listitem_vin, parent, false));
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (mVinList != null && mVinList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }
    @Override
    public int getItemCount() {
        if (mVinList != null && mVinList.size() > 0) {
            return mVinList.size();
        } else {
            return 1;
        }
    }
    public void addItems(ArrayList<Vin> vinList) {
        mVinList.addAll(vinList);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onEmptyViewRetryClick();
    }
    public class ViewHolder extends BaseViewHolder {
        public TextView nomTextView;
        public TextView anneeTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nomTextView= (TextView) itemView.findViewById((R.id.listItemVin_nom));
            anneeTextView= (TextView) itemView.findViewById((R.id.listItemVin_annee));
        }
        protected void clear() {
            nomTextView.setText("");
            anneeTextView.setText("");
        }
        public void onBind(int position) {
            super.onBind(position);
            final Vin mVin = mVinList.get(position);
            if (mVin.getNom() != null) {
                nomTextView.setText(mVin.getNom());
            }
            if (Integer.toString(mVin.getAnnee()) != null) {
                anneeTextView.setText(Integer.toString(mVin.getAnnee()));
            }
        }
    }
    public class EmptyViewHolder extends BaseViewHolder {
        TextView nomTextView;
        EmptyViewHolder(View itemView) {
            super(itemView);
            nomTextView.setText("Pas de vin");
        }
        @Override
        protected void clear() {
        }
    }
}
