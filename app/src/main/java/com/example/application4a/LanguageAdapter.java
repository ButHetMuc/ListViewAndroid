package com.example.application4a;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application4a.R;
import com.example.application4a.Language;

import java.util.List;
public class LanguageAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Language> listLanguage;
    private int positionSelect = -1;

    public LanguageAdapter(Context context, int idLayout, List<Language> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
        this.listLanguage = listLanguage;
    }

    @Override
    public int getCount() {
        if (listLanguage.size() != 0 && !listLanguage.isEmpty()) {
            return listLanguage.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvLanguageName = (TextView) convertView.findViewById(R.id.tvLanguegeName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Language language = listLanguage.get(position);

        if (listLanguage != null && !listLanguage.isEmpty()) {
            tvLanguageName.setText(language.getName());
            int idLanguage = language.getId();
            switch (idLanguage) {
                case 1:
                    imageView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ga_bo_toi);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.hieu_long_con_tre);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.do_choi_dang_mo_hinh);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.xa_can_cau);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.xa_can_cau);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.lanh_dao_gian_don);
                    break;
                default:
                    break;
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, language.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}
