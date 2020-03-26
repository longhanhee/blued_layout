package com.example.blued_layout.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.blued_layout.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LiveMainAnchorListAdapter extends BaseMultiItemQuickAdapter<BluedLiveListData, BaseViewHolder> {
    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_NO_LIVE = 6;
    public static final int ITEM_TYPE_OFFICE = 1;
    public static final int ITEM_TYPE_OFFLINE = 3;
    public static final int ITEM_TYPE_PRIVATE_INVITATION = 4;
    public static final int ITEM_TYPE_RECOMMEND = 5;
    public static final int ITEM_TYPE_TITLE = 2;
    public LoadOptions a;
    public LoadOptions b;
    public Map<String, String> c = new HashMap();
    public Context d;
    public int e = 0;
    public boolean f = false;
    public String g;
    public Set<String> h = new HashSet();

    public interface COME_CODE {
        public static final int followedList = 1;
        public static final int mainList = 0;
        public static final int nationalList = 2;
        public static final int privateList = 3;
    }

    public interface LOCAL_TYPE {
        public static final int country = 2;
        public static final int local = 0;
        public static final int recommend = 1;
    }

    public interface TITLE_TYPE {
        public static final int country = 2;
        public static final int no_local = 0;
        public static final int recommend = 1;
    }

    public LiveMainAnchorListAdapter(Context context, int i) {
        super(new ArrayList());
        this.d = context;
        this.e = i;
        addItemType(0, R.layout.item_live_anchor);
        addItemType(1, R.layout.item_live_anchor);
        addItemType(2, R.layout.item_offline_anchor_header);
        addItemType(3, R.layout.item_offline_anchor_list);
        addItemType(4, R.layout.item_invitation_anchor_list);
        addItemType(5, R.layout.item_live_recommed_hint);
        addItemType(6, R.layout.item_no_live_data_layout);
        this.a = new LoadOptions();
        LoadOptions loadOptions = this.a;
        loadOptions.isProcessTransfer = true;
        loadOptions.animationForAsync = false;
        loadOptions.imageOnFail = R.drawable.default_live_picture;
        loadOptions.defaultImageResId = R.drawable.default_live_picture;
        this.b = new LoadOptions();
        LoadOptions loadOptions2 = this.b;
        loadOptions2.animationForAsync = false;
        loadOptions2.imageOnFail = R.drawable.user_bg_round_black;
        loadOptions2.defaultImageResId = R.drawable.user_bg_round_black;
        setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            public int getSpanSize(GridLayoutManager gridLayoutManager, int i) {
                int i2 = ((BluedLiveListData) LiveMainAnchorListAdapter.this.mData.get(i)).itemType;
                if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6) {
                    return gridLayoutManager.getSpanCount();
                }
                return ((BluedLiveListData) LiveMainAnchorListAdapter.this.mData.get(i)).spanSize;
            }
        });
    }

    public final int a(int i) {
        return i >= 26 ? R.drawable.lv_26_30 : i >= 20 ? R.drawable.lv_21_21 : i >= 16 ? R.drawable.lv_16_20 : R.drawable.lv_11_15;
    }

    public final void d(BluedLiveListData bluedLiveListData, BaseViewHolder baseViewHolder, int i) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.item_offline_anchor_header);
        textView.setText(bluedLiveListData.title);
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = i == 0 ? 0 : UiUtils.dip2px(a(), 5.0f);
    }

    public void pastLeep(List<BluedLiveListData> list) {
        List data = getData();
        for (int i = 0; i < data.size(); i++) {
            BluedLiveListData bluedLiveListData = (BluedLiveListData) data.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                BluedLiveListData bluedLiveListData2 = list.get(i2);
                String str = bluedLiveListData2.uid;
                if (str != null && str.equals(bluedLiveListData.uid)) {
                    list.remove(bluedLiveListData2);
                }
            }
        }
    }

    public void removeData(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < getData().size(); i++) {
                if (str.equals(((BluedLiveListData) getData().get(i)).lid)) {
                    remove(i);
                    if (getData().size() >= 2 && ((BluedLiveListData) getData().get(1)).itemType == 2) {
                        remove(0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void setAnchorView(Context context, BluedLiveListData bluedLiveListData, RoundedImageView roundedImageView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        if (context != null) {
            roundedImageView.loadImage(bluedLiveListData.pic_url, this.a, (ImageLoadingListener) null);
            imageView2.setVisibility(bluedLiveListData.pk == 1 ? 0 : 8);
            imageView.setVisibility(8);
            textView.setText(bluedLiveListData.realtime_count + "");
            textView5.setText(bluedLiveListData.description);
            textView3.setText(bluedLiveListData.anchor.name);
            String str = this.c.get(bluedLiveListData.city_code);
            if (TextUtils.isEmpty(str)) {
                str = AreaUtils.getCountryName(bluedLiveListData.city_code);
                this.c.put(bluedLiveListData.city_code, str);
            }
            textView4.setText(str);
            if (bluedLiveListData.anchor.anchor_level < 11) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setBackgroundResource(a(bluedLiveListData.anchor.anchor_level));
                textView2.setText(b(bluedLiveListData.anchor.anchor_level));
            }
            if (bluedLiveListData.isBigHeader) {
                textView3.setTextSize(2, 11.0f);
                textView3.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_live_anchor_name_big), (Drawable) null, (Drawable) null, (Drawable) null);
                textView4.setTextSize(2, 11.0f);
                textView4.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_live_anchor_location_big), (Drawable) null, (Drawable) null, (Drawable) null);
                textView5.setTextSize(2, 14.0f);
            } else {
                textView3.setTextSize(2, 9.0f);
                textView3.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_live_anchor_name_small), (Drawable) null, (Drawable) null, (Drawable) null);
                textView4.setTextSize(2, 9.0f);
                textView4.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_live_anchor_location_small), (Drawable) null, (Drawable) null, (Drawable) null);
                textView5.setTextSize(2, 12.0f);
            }
            int i = bluedLiveListData.live_type;
            if (i == 2) {
                textView4.setVisibility(8);
                ((ViewGroup) textView2.getParent()).setVisibility(8);
            } else if (i == 3) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.ic_live_list_voice);
            }
        }
    }

    public void setNationalData(boolean z, String str) {
        this.f = z;
        this.g = str;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
        int layoutPosition = baseViewHolder.getLayoutPosition() - getHeaderLayoutCount();
        int itemType = bluedLiveListData.getItemType();
        if (itemType == 0 || itemType == 1) {
            a(bluedLiveListData, baseViewHolder);
        } else if (itemType == 2) {
            d(bluedLiveListData, baseViewHolder, layoutPosition);
        } else if (itemType == 3) {
            b(bluedLiveListData, baseViewHolder, layoutPosition);
        } else if (itemType == 4) {
            c(bluedLiveListData, baseViewHolder, layoutPosition);
        } else if (itemType == 5) {
            a(bluedLiveListData, baseViewHolder, layoutPosition);
        }
        if (!TextUtils.isEmpty(bluedLiveListData.lid) && !this.h.contains(bluedLiveListData.lid)) {
            this.h.add(bluedLiveListData.lid);
        }
    }

    public final void b(BluedLiveListData bluedLiveListData, BaseViewHolder baseViewHolder, int i) {
        AutoAttachRecyclingImageView autoAttachRecyclingImageView = (AutoAttachRecyclingImageView) baseViewHolder.getView(R.id.item_offline_anchor_list_headimg);
        TextView textView = (TextView) baseViewHolder.getView(R.id.item_offline_anchor_list_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.item_offline_anchor_list_max_watchers);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.item_offline_anchor_list_last_time);
        View view = baseViewHolder.getView(R.id.item_offline_anchor_list_divider);
        BluedLiveListAnchor bluedLiveListAnchor = bluedLiveListData.anchor;
        if (bluedLiveListAnchor == null) {
            autoAttachRecyclingImageView.setImageResource(R.drawable.default_square_head);
            textView.setText("");
        } else {
            autoAttachRecyclingImageView.loadImage(bluedLiveListAnchor.avatar, this.b, (ImageLoadingListener) null);
            textView.setText(bluedLiveListData.anchor.name);
        }
        textView2.setText(a().getString(R.string.followed_anchors_max_watchers) + ServerProtocol.AUTHORIZATION_HEADER_DELIMITER + bluedLiveListData.top_count);
        String format = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(StringUtils.StringToLong(bluedLiveListData.live_starttime, 0) * 1000));
        textView3.setText(a().getString(R.string.followed_anchors_last_time) + ": " + format);
        if (baseViewHolder.getLayoutPosition() - getHeaderLayoutCount() == getData().size() - 1) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        if (!this.h.contains(bluedLiveListData.lid)) {
            LiveServiceLogTool.secondToUserPage(LiveServiceInfo.SHOW_LIVE_FOLLOWED, bluedLiveListData);
        }
    }

    public final void c(final BluedLiveListData bluedLiveListData, BaseViewHolder baseViewHolder, int i) {
        AutoAttachRecyclingImageView autoAttachRecyclingImageView = (AutoAttachRecyclingImageView) baseViewHolder.getView(R.id.iv_header);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_time);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_title);
        BluedLiveListAnchor bluedLiveListAnchor = bluedLiveListData.anchor;
        if (bluedLiveListAnchor == null) {
            autoAttachRecyclingImageView.setImageResource(R.drawable.default_square_head);
            textView.setText("");
        } else {
            autoAttachRecyclingImageView.loadImage(bluedLiveListAnchor.avatar, this.b, (ImageLoadingListener) null);
            textView.setText(bluedLiveListData.anchor.name);
        }
        textView2.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(bluedLiveListData.invitation_time)));
        textView3.setText(bluedLiveListData.title);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.showFromUid(LiveMainAnchorListAdapter.this.a(), bluedLiveListData.uid, 41);
            }
        });
    }

    public final void a(BluedLiveListData bluedLiveListData, BaseViewHolder baseViewHolder, int i) {
        View view = baseViewHolder.getView(R.id.ll_hint);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_hint);
        ObliqueLinearLayout obliqueLinearLayout = (ObliqueLinearLayout) baseViewHolder.getView(R.id.ll_title);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_title);
        int i2 = bluedLiveListData.titleType;
        if (i2 == 0) {
            view.setVisibility(0);
            obliqueLinearLayout.setVisibility(8);
            textView.setText(bluedLiveListData.titleText);
        } else if (i2 == 1) {
            view.setVisibility(8);
            obliqueLinearLayout.setVisibility(0);
            obliqueLinearLayout.setColor(a().getResources().getColor(R.color.live_main_recommed_start), a().getResources().getColor(R.color.live_main_recommed_end));
            textView2.setText(bluedLiveListData.titleText);
        } else if (i2 == 2) {
            view.setVisibility(8);
            obliqueLinearLayout.setVisibility(0);
            obliqueLinearLayout.setColor(a().getResources().getColor(R.color.live_main_global_start), a().getResources().getColor(R.color.live_main_global_end));
            textView2.setText(bluedLiveListData.titleText);
        }
    }

    public final String b(int i) {
        if (i < 10) {
            return "LV 0" + i;
        }
        return "LV " + i;
    }

    public final Context a() {
        Context context = this.d;
        return context != null ? context : AppInfo.getAppContext();
    }

    public final void a(BluedLiveListData bluedLiveListData, BaseViewHolder baseViewHolder) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_country);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_pk);
        setAnchorView(a(), bluedLiveListData, (RoundedImageView) baseViewHolder.getView(R.id.iv_avatar), (ImageView) baseViewHolder.getView(R.id.iv_orientation), imageView, (TextView) baseViewHolder.getView(R.id.tv_viewer_count), (TextView) baseViewHolder.getView(R.id.tv_level), (TextView) baseViewHolder.getView(R.id.tv_anchor_name), textView, (TextView) baseViewHolder.getView(R.id.tv_title));
        if (!this.h.contains(bluedLiveListData.lid)) {
            int i = this.e;
            if (i == 0) {
                LiveServiceLogTool.firstToLive(LiveServiceInfo.SHOW_FIRST_LIVE_LIST, bluedLiveListData, OnliveConstant.LIVE_COME_CODE.LIVE_POPULAR);
            } else if (i == 1) {
                LiveServiceLogTool.secondToLive(LiveServiceInfo.SHOW_SECOND_LIVE_LIST, bluedLiveListData, "followed", (String) null);
            } else if (i == 2) {
                if (this.f) {
                    LiveServiceLogTool.secondToLive(LiveServiceInfo.SHOW_SECOND_LIVE_LIST, bluedLiveListData, "country", this.g);
                } else {
                    LiveServiceLogTool.thirdToLive(LiveServiceInfo.SHOW_THIRD_LIVE_LIST, bluedLiveListData, this.g);
                }
            }
        }
    }
}
