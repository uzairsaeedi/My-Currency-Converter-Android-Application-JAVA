package com.mycurrencyconverter;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Cursor cursor;
    private Context context;

    private DatabaseHandler databaseHandler;

    public HistoryAdapter(Context context, Cursor cursor, DatabaseHandler databaseHandler) {
        this.context = context;
        this.cursor = cursor;
        this.databaseHandler = databaseHandler;
    }
    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    private OnItemClickListener onItemClickListener;

    // Setter method for the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fromCurrencyView;
        public TextView toCurrencyView;
        public TextView amountView;
        public TextView resultView;
        Button btn_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            fromCurrencyView = itemView.findViewById(R.id.fromCurrencyView);
            toCurrencyView = itemView.findViewById(R.id.toCurrencyView);
            amountView = itemView.findViewById(R.id.amountView);
            resultView = itemView.findViewById(R.id.resultView);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.history_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (cursor.moveToPosition(position)) {
            String fromCurrency = cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_FROM_CURRENCY));
            String toCurrency = cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_TO_CURRENCY));
            double amount = cursor.getDouble(cursor.getColumnIndex(DatabaseHandler.COLUMN_AMOUNT));
            double result = cursor.getDouble(cursor.getColumnIndex(DatabaseHandler.COLUMN_RESULT));
            holder.btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDeleteConfirmationDialog(cursor.getInt(cursor.getColumnIndex(DatabaseHandler.COLUMN_ID)));
                }
            });
            holder.fromCurrencyView.setText(fromCurrency);
            holder.toCurrencyView.setText(toCurrency);
            holder.amountView.setText(String.valueOf(amount));
            holder.resultView.setText(String.valueOf(result));
        }
    }
    public void updateCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged(); // Refresh the adapter
    }
    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
    private void showDeleteConfirmationDialog(final int itemId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Confirmation");
        builder.setMessage("Are you sure you want to delete this history item?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int itemId = cursor.getInt(cursor.getColumnIndex(DatabaseHandler.COLUMN_ID));
                databaseHandler.deleteHistoryItem(itemId);
                Toast.makeText(context.getApplicationContext(), "Visit History Activity again your history has been deleted", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
