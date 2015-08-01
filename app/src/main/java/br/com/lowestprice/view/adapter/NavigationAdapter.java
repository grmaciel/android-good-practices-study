package br.com.lowestprice.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.androidcore.adapter.CustomAdapter;
import br.com.lowestprice.R;
import br.com.lowestprice.view.model.SecaoMenuItem;

/**
 * Created by PlaceFirst on 21/02/2015.
 */
public class NavigationAdapter extends CustomAdapter<SecaoMenuItem> {
    private static final int LAYOUT_TYPE_COUNT = 2;

    public NavigationAdapter(List<SecaoMenuItem> items) {
        super(items);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public SecaoMenuItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutType type = LayoutType.getEnumByPosition(position);

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            switch (type) {
                case CABECALHO:
                    convertView = inflater.inflate(R.layout.navigation_header, null);
                    holder.icon = (ImageView) convertView
                            .findViewById(R.id.sessionNavigationProfilePicture);
                    holder.label = (TextView) convertView
                            .findViewById(R.id.sessionNavigationProfileName);
                    break;
                case ITEM_MENU:
                    convertView = inflater.inflate(R.layout.navigation_item, null);
                    holder.icon = (ImageView) convertView
                            .findViewById(R.id.sessionNavigationMenuIcon);
                    holder.label = (TextView) convertView
                            .findViewById(R.id.sessionNavigationMenuLabel);

                    break;
            }

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SecaoMenuItem item = this.getItem(position);

        holder.label.setText(item.label);
        holder.icon.setImageDrawable(item.icon);

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return LAYOUT_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? LayoutType.CABECALHO.ordinal()
                : LayoutType.ITEM_MENU.ordinal();
    }

    private enum LayoutType {
        CABECALHO,
        ITEM_MENU;

        public static LayoutType getEnumByPosition(int position) {
            switch (position) {
                case 0:
                    return LayoutType.CABECALHO;
                default:
                    return LayoutType.ITEM_MENU;
            }
        }
    }

    private static class ViewHolder {
        public ImageView icon;
        public TextView label;
    }
}
