package com.example.blued_layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.GestureDetector;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class PlayingOnliveFragment extends KeyBoardFragment implements View.OnClickListener, Chronometer.OnChronometerTickListener, ZanRefreshObserver.IZanRefreshObserver, PlayGifObserver.IPlayGifObserver, BeansRefreshObserver.IBeansRefreshObserver, View.OnTouchListener, LiveRankDialogFragment.LiveRankDialogListener, LiveRankAdapter.UserHeadClickedCallback, OnBluedSharedListener {
    public static final int LIVE_NORMAL = 0;
    public static final int LIVE_PK = 2;
    public static final int LIVE_PK_PREPARE = 1;
    public static final int LIVE_PK_RESULT = 3;
    public static boolean isShowKeyboard = false;
    public static boolean mIsLoaded = false;
    public TextView A;
    public TextView A0;
    public AutoAttachRecyclingImageView A1;
    public Timer A2;
    public TextView B;
    public Button B0;
    public ViewPager B1;
    public Timer B2;
    public ImageView C;
    public TextView C0;
    public ViewPagerAdapter C1;
    public ImageView D;
    public RelativeLayout D0;
    public ImageView D1;
    public ImageView E;
    public AutoAttachRecyclingImageView E0;
    public FrameLayout E1;
    public ImageView F;
    public AutoAttachRecyclingImageView F0;
    public PopLiveCenterWebView F1;
    public FrameLayout G;
    public LevelProgressBar G0;
    public View G1;
    public AutoAttachRecyclingImageView H;
    public LevelProgressBar H0;
    public LinearLayout H1;
    public RelativeLayout I;
    public TextView I0;
    public ProtectionCoverView I1;
    public TextView J;
    public TextView J0;
    public AutoAttachRecyclingImageView J1;
    public ImageView K;
    public TextView K0;
    public AutoAttachRecyclingImageView K1;
    public FrameLayout L;
    public TextView L0;
    public FrameLayout L1;
    public AutoAttachRecyclingImageView M;
    public Button M0;
    public LinearLayout M1;
    public TextView N;
    public LiveShareView N0;
    public ShapeTextView N1;
    public PlayingOnlineManager O;
    public LiveRankDialogFragment O0;
    public ShapeTextView O1;
    public PlayingRTCManager P;
    public Dialog P0;
    public ProtectionCoverView P1;
    public BubbleLayout Q;
    public ObliqueLinearLayout Q0;
    public AutoAttachRecyclingImageView Q1;
    public BubbleLayout R;
    public ObliqueLinearLayout R0;
    public AutoAttachRecyclingImageView R1;
    public TextView S;
    public TextView S0;
    public FrameLayout S1;
    public TextView T;
    public TextView T0;
    public LinearLayout T1;
    public View U;
    public View U0;
    public ShapeTextView U1;
    public TextView V;
    public TipView V0;
    public ShapeTextView V1;
    public View W;
    public String[] W0;
    public LiveGiftPullNoticeView W1;
    public View X;
    public String[] X0;
    public ShapeFrameLayout X1;
    public LiveSelfFanClubUpLevelNoticeDialogFragment Y;
    public boolean Y0;
    public LiveShareManager Y1;
    public LiveFanClubUpLevelNoticeView Z;
    public boolean Z0;
    public LinearLayout Z1;
    public View a0;
    public long a1;
    public LinearLayout a2;
    public View b0;
    public int b1;
    public TextView b2;
    public View c0;
    public int c1;
    public TextView c2;
    public GiftCardView d0;
    public long d1;
    public FanClubUpLevelManagerImpl d2;
    public KeyboardListenLinearLayout e0;
    public String e1;
    public BluedUIHttpResponse e2 = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(getFragmentActive()) {
        public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
            String unused = PlayingOnliveFragment.this.i1 = ((UserInfoEntity) bluedEntityA.data.get(0)).relationship;
            PlayingOnliveFragment.this.D();
            PlayingOnliveFragment.this.mLiveAnchorModel.name = ((UserInfoEntity) bluedEntityA.data.get(0)).name;
            PlayingOnliveFragment.this.mLiveAnchorModel.vbadge = ((UserInfoEntity) bluedEntityA.data.get(0)).vbadge;
            PlayingOnliveFragment.this.mLiveAnchorModel.avatar = ((UserInfoEntity) bluedEntityA.data.get(0)).avatar;
            if (((UserInfoEntity) bluedEntityA.data.get(0)).liveshow != null) {
                PlayingOnliveFragment.this.mLiveAnchorModel.live_type = ((UserInfoEntity) bluedEntityA.data.get(0)).liveshow.live_type;
            }
            PlayingOnliveFragment.this.setAnchorData();
        }
    };
    public boolean f = false;
    public View f0;
    public boolean f1 = false;
    public boolean f2;
    public int fanLevel = 0;
    public int fan_club_badge_hidden;
    public LiveEmbedmentDialogFragment g;
    public LiveChatLeftRelativeLayout g0;
    public GestureDetector g1;
    public TextWatcher g2 = new TextWatcher() {
        public int a;
        public int b;

        public void afterTextChanged(Editable editable) {
            this.a = PlayingOnliveFragment.this.k0.getSelectionStart();
            this.b = PlayingOnliveFragment.this.k0.getSelectionEnd();
            PlayingOnliveFragment.this.k0.removeTextChangedListener(PlayingOnliveFragment.this.g2);
            while (editable.length() > PlayingOnlineManager.chatMaxNum) {
                if (this.a == 0) {
                    break;
                }
                editable.delete(r0 - 1, this.b);
                this.a--;
                this.b--;
            }
            PlayingOnliveFragment.this.k0.setSelection(this.a);
            PlayingOnliveFragment.this.k0.addTextChangedListener(PlayingOnliveFragment.this.g2);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public LiveFansPlayingDialogFragment h;
    public LiveChatMiddleRelativeLayout h0;
    public boolean h1;
    public ValueAnimator h2;
    public LiveNoticeAddFansDialogFragment i;
    public LiveChatRightLinearLayout i0;
    public String i1 = null;
    public EntranceEffectManager i2;
    public boolean isRTCModel;
    public boolean isRefuse;
    public boolean isSimpleModel;
    public int is_enable;
    public int is_member;
    public LiveActionRankDialogFragment j;
    public View j0;
    public int j1 = 0;
    public EntranceEffectManager j2;
    public FrameLayout k;
    public EditText k0;
    public GLSurfaceView k1;
    public LiveActionRankMsgModel k2;
    public Context l;
    public ImageView l0;
    public FrameLayout l1;
    public boolean l2 = true;
    public LiveMsgManager liveMsgManager;
    public RoundedImageView m;
    public ImageView m0;
    public FrameLayout m1;
    public RecyclerView m2;
    public LiveAnimationView mAnimationView;
    public AutoAttachRecyclingImageView mHeaderBgView;
    public boolean mIsFirstOnResume = true;
    public List<View> mList;
    public LiveAnchorModel mLiveAnchorModel;
    public LivePkingView mLivePkingView;
    public int mLiveState;
    public LoadOptions mOptions;
    public ImageView mOutUserA;
    public ImageView mOutUserB;
    public String mPicUrl;
    public RTCSurfaceView mRemoteGLSurfaceViewA;
    public RTCSurfaceView mRemoteGLSurfaceViewB;
    public FrameLayout mRemoteLoadingLayoutB;
    public AVLoadingIndicatorView mRemoteLoadingViewB;
    public TextView mRemoteNameA;
    public TextView mRemoteNameB;
    public FrameLayout mRemoteWindowA;
    public FrameLayout mRemoteWindowB;
    public View mRootView;
    public long mSessionId;
    public short mSessionType;
    public long mTimer = 0;
    public RoundedImageView n;
    public ImageView n0;
    public long n1;
    public TranslateAnimation n2;
    public View o;
    public ImageView o0;
    public RTCUserInfoLayout o1;
    public int o2 = 1;
    public View p;
    public ImageView p0;
    public TicketPayFrameLayout p1;
    public BluedUIHttpResponse p2 = new BluedUIHttpResponse<BluedEntityA<RecommendedPrivateLive>>() {
        public boolean a = false;

        public void onUIFinish() {
            super.onUIFinish();
            if (this.a) {
                PlayingOnliveFragment.q0(PlayingOnliveFragment.this);
            } else {
                int unused = PlayingOnliveFragment.this.o2 = PlayingOnliveFragment.this.o2 + 1;
            }
            this.a = false;
        }

        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            this.a = true;
        }

        public void onUIUpdate(BluedEntityA<RecommendedPrivateLive> bluedEntityA) {
            BluedEntityA<RecommendedPrivateLive> bluedEntityA2 = bluedEntityA;
            if (bluedEntityA2.data.size() != 0) {
                if (PlayingOnliveFragment.this.m2 == null) {
                    TrackEventTool.getInstance().trackOther("private_live", "load_recommend_list");
                    final TextView textView = (TextView) PlayingOnliveFragment.this.t0.findViewById(R.id.live_end_label);
                    final View findViewById = PlayingOnliveFragment.this.t0.findViewById(R.id.live_end_time_layout);
                    TextView textView2 = (TextView) PlayingOnliveFragment.this.t0.findViewById(R.id.anchor_name);
                    View findViewById2 = PlayingOnliveFragment.this.t0.findViewById(R.id.live_end_des_header_layout);
                    final RoundedImageView roundedImageView = (RoundedImageView) findViewById2.findViewById(R.id.anchor_header);
                    View findViewById3 = PlayingOnliveFragment.this.t0.findViewById(R.id.live_end_private_lives);
                    final int dip2px = UiUtils.dip2px(PlayingOnliveFragment.this.l, 115.0f);
                    final int i = roundedImageView.getLayoutParams().width;
                    final int i2 = ((LinearLayout.LayoutParams) PlayingOnliveFragment.this.u0.getLayoutParams()).bottomMargin;
                    final int i3 = ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin;
                    int i4 = ((LinearLayout.LayoutParams) findViewById.getLayoutParams()).topMargin;
                    int i5 = ((LinearLayout.LayoutParams) findViewById.getLayoutParams()).bottomMargin;
                    int i6 = ((LinearLayout.LayoutParams) findViewById2.getLayoutParams()).topMargin;
                    int i7 = ((LinearLayout.LayoutParams) textView2.getLayoutParams()).topMargin;
                    int i8 = ((LinearLayout.LayoutParams) textView2.getLayoutParams()).bottomMargin;
                    int i9 = ((LinearLayout.LayoutParams) PlayingOnliveFragment.this.x0.getLayoutParams()).bottomMargin;
                    findViewById3.setVisibility(0);
                    int i10 = i9;
                    int i11 = i5;
                    boolean z = ((((float) AppInfo.screenHeightForPortrait) * 0.8f) - ((float) StatusBarHelper.getStatusBarHeight(PlayingOnliveFragment.this.l))) - ((float) (((PlayingOnliveFragment.this.a(textView) + PlayingOnliveFragment.this.a((TextView) PlayingOnliveFragment.this.t0.findViewById(R.id.live_end_duration))) + PlayingOnliveFragment.this.a(textView2)) + UiUtils.dip2px(PlayingOnliveFragment.this.l, 388.0f))) < ((float) UiUtils.dip2px(PlayingOnliveFragment.this.l, 100.0f));
                    ValueAnimator unused = PlayingOnliveFragment.this.h2 = ValueAnimator.ofInt(new int[]{0, dip2px});
                    PlayingOnliveFragment.this.h2.setDuration(500);
                    AnonymousClass1 r23 = r0;
                    int i12 = i7;
                    int i13 = i8;
                    ValueAnimator l0 = PlayingOnliveFragment.this.h2;
                    final View view = findViewById3;
                    int i14 = i4;
                    final boolean z2 = z;
                    View view2 = findViewById3;
                    final int i15 = i14;
                    View view3 = findViewById2;
                    final int i16 = i11;
                    TextView textView3 = textView2;
                    final View view4 = view3;
                    View view5 = view2;
                    final int i17 = i6;
                    final TextView textView4 = textView3;
                    final int i18 = i12;
                    final int i19 = i13;
                    final int i20 = i10;
                    AnonymousClass1 r0 = new ValueAnimator.AnimatorUpdateListener(this) {
                        public final /* synthetic */ AnonymousClass50 r;

                        {
                            this.r = r3;
                        }

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                            layoutParams.height = intValue;
                            view.setLayoutParams(layoutParams);
                            float f2 = 1.0f - ((((float) intValue) * 0.2f) / ((float) dip2px));
                            ViewGroup.LayoutParams layoutParams2 = roundedImageView.getLayoutParams();
                            layoutParams2.width = (int) (((float) i) * f2);
                            layoutParams2.height = layoutParams2.width;
                            roundedImageView.setLayoutParams(layoutParams2);
                            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) PlayingOnliveFragment.this.u0.getLayoutParams();
                            layoutParams3.bottomMargin = (int) (((float) i2) * f2);
                            PlayingOnliveFragment.this.u0.setLayoutParams(layoutParams3);
                            if (z2) {
                                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                                layoutParams4.topMargin = (int) (((float) i3) * f2);
                                textView.setLayoutParams(layoutParams4);
                                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                                layoutParams5.topMargin = (int) (((float) i15) * f2);
                                layoutParams5.bottomMargin = (int) (((float) i16) * f2);
                                findViewById.setLayoutParams(layoutParams5);
                                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                                layoutParams6.topMargin = (int) (((float) i17) * f2);
                                view4.setLayoutParams(layoutParams6);
                                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView4.getLayoutParams();
                                layoutParams7.topMargin = (int) (((float) i18) * f2);
                                layoutParams7.bottomMargin = (int) (((float) i19) * f2);
                                textView4.setLayoutParams(layoutParams7);
                                LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) PlayingOnliveFragment.this.x0.getLayoutParams();
                                layoutParams8.bottomMargin = (int) (((float) i20) * f2);
                                PlayingOnliveFragment.this.x0.setLayoutParams(layoutParams8);
                            }
                        }
                    };
                    l0.addUpdateListener(r23);
                    final View view6 = view5;
                    PlayingOnliveFragment.this.h2.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            ValueAnimator unused = PlayingOnliveFragment.this.h2 = null;
                            final View findViewById = PlayingOnliveFragment.this.mRootView.findViewById(R.id.live_end_private_bling);
                            findViewById.setVisibility(0);
                            TranslateAnimation unused2 = PlayingOnliveFragment.this.n2 = new TranslateAnimation(0.0f, (float) view6.getWidth(), 0.0f, 0.0f);
                            PlayingOnliveFragment.this.n2.setDuration(1000);
                            PlayingOnliveFragment.this.n2.setRepeatCount(Integer.MAX_VALUE);
                            PlayingOnliveFragment.this.n2.setRepeatMode(1);
                            PlayingOnliveFragment.this.n2.setAnimationListener(new Animation.AnimationListener(this) {
                                public void onAnimationEnd(Animation animation) {
                                    findViewById.setVisibility(8);
                                }

                                public void onAnimationRepeat(Animation animation) {
                                }

                                public void onAnimationStart(Animation animation) {
                                }
                            });
                            findViewById.startAnimation(PlayingOnliveFragment.this.n2);
                        }
                    });
                    PlayingOnliveFragment.this.h2.start();
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    RecyclerView unused2 = playingOnliveFragment.m2 = (RecyclerView) playingOnliveFragment.mRootView.findViewById(R.id.live_end_private_lives_list);
                    PlayingOnliveFragment.this.m2.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        public final boolean a(RecyclerView recyclerView) {
                            return recyclerView.computeHorizontalScrollExtent() + recyclerView.computeHorizontalScrollOffset() >= recyclerView.computeHorizontalScrollRange();
                        }

                        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                            super.onScrollStateChanged(recyclerView, i);
                            if (i == 1 && PlayingOnliveFragment.this.o2 <= 5 && a(recyclerView)) {
                                LiveHttpUtils.getRecommendedPrivateLives(PlayingOnliveFragment.this.o2, PlayingOnliveFragment.this.p2, PlayingOnliveFragment.this.getFragmentActive());
                            }
                        }
                    });
                    PlayingOnliveFragment.this.m2.setLayoutManager(new LinearLayoutManager(PlayingOnliveFragment.this.getContext(), 0, false));
                    RecommendedPrivateLiveAdapter recommendedPrivateLiveAdapter = new RecommendedPrivateLiveAdapter(PlayingOnliveFragment.this.l, bluedEntityA.data);
                    recommendedPrivateLiveAdapter.setOnItemClickedListener(new RecommendedPrivateLiveAdapter.OnItemClickedListener() {
                        public void onItemClicked(RecommendedPrivateLive recommendedPrivateLive) {
                            TrackEventTool.getInstance().trackOther("private_live", "click_profile_picture");
                            LiveFloatManager.getInstance().setLiveRoomShowing(false);
                            String str = recommendedPrivateLive.uid;
                            BluedLiveListAnchor bluedLiveListAnchor = recommendedPrivateLive.anchor;
                            LiveAnchorModel liveAnchorModel = new LiveAnchorModel(str, bluedLiveListAnchor.avatar, bluedLiveListAnchor.name, bluedLiveListAnchor.vbadge, 2);
                            PlayingOnliveFragment.show(PlayingOnliveFragment.this.l, 5, Long.parseLong(recommendedPrivateLive.lid), liveAnchorModel, "msg", recommendedPrivateLive.pic_url);
                        }
                    });
                    PlayingOnliveFragment.this.m2.setAdapter(recommendedPrivateLiveAdapter);
                    return;
                }
                ((RecommendedPrivateLiveAdapter) PlayingOnliveFragment.this.m2.getAdapter()).appendData(bluedEntityA2.data);
            }
        }
    };
    public int pkMode;
    public ImageView q;
    public LiveLoadingProgress q0;
    public int q1 = 0;
    public Animation q2;
    public ImageView r;
    public View r0;
    public BoxDescriptionDialogFragment r1;
    public ValueAnimator r2;
    public BluedUIHttpResponse rankListCB = new BluedUIHttpResponse<BluedEntity<BluedLiveRankListData, LiveRankExtra>>(getFragmentActive()) {
        public void onUIUpdate(BluedEntity<BluedLiveRankListData, LiveRankExtra> bluedEntity) {
            if (bluedEntity.extra != null) {
                ((TextView) PlayingOnliveFragment.this.t0.findViewById(R.id.tv_card_total_gained)).setText(FormatUtils.formatPrice(((LiveRankExtra) bluedEntity.extra).beans));
            }
        }
    };
    public BadgeView s;
    public View s0;
    public BoxOpenDialogFragment s1;
    public Map<String, String> s2 = new HashMap();
    public ImageView t;
    public View t0;
    public LinearLayout t1;
    public CountDownTimer t2;
    public ImageView u;
    public View u0;
    public BoxProgressView u1;
    public boolean u2 = false;
    public ImageView v;
    public ImageView v0;
    public BoxProgressView v1;
    public PropCardModel v2;
    public ImageView w;
    public TextView w0;
    public BoxView w1;
    public Timer w2;
    public ImageView x;
    public Button x0;
    public float[][] x1;
    public int x2;
    public ImageView y;
    public View y0;
    public BoxView y1;
    public int y2 = 2;
    public ImageView z;
    public Button z0;
    public float[][] z1;
    public CountDownTimer z2;

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return super.onDoubleTap(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent.getX() - motionEvent2.getX() > 100.0f && Math.abs(f) > 200.0f) {
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                if (playingOnliveFragment.isSimpleModel) {
                    return false;
                }
                boolean E0 = playingOnliveFragment.h1;
                return false;
            } else if (motionEvent2.getX() - motionEvent.getX() <= 100.0f || Math.abs(f) <= 200.0f) {
                return false;
            } else {
                PlayingOnliveFragment playingOnliveFragment2 = PlayingOnliveFragment.this;
                if (!playingOnliveFragment2.isSimpleModel) {
                    return false;
                }
                boolean unused = playingOnliveFragment2.h1;
                return false;
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (PlayingOnliveFragment.this.Q != null) {
                PlayingOnliveFragment.this.Q.addHeart(true);
            }
            if (PlayingOnliveFragment.this.R != null) {
                PlayingOnliveFragment.this.R.addHeart(true);
            }
            PlayingOnliveFragment.this.liveMsgManager.sendLiveDynamic(51);
            Context M = PlayingOnliveFragment.this.l;
            PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
            LiveMsgTools.sendMsgForSupport(M, playingOnliveFragment.mSessionId, playingOnliveFragment.mSessionType);
            return super.onSingleTapUp(motionEvent);
        }
    }

    public static /* synthetic */ int M0(PlayingOnliveFragment playingOnliveFragment) {
        int i3 = playingOnliveFragment.x2;
        playingOnliveFragment.x2 = i3 - 1;
        return i3;
    }

    public static /* synthetic */ int q0(PlayingOnliveFragment playingOnliveFragment) {
        int i3 = playingOnliveFragment.o2;
        playingOnliveFragment.o2 = i3 - 1;
        return i3;
    }

    public static synchronized void show(Fragment fragment, short s3, long j3, LiveAnchorModel liveAnchorModel, String str, String str2, int i3) {
        synchronized (PlayingOnliveFragment.class) {
            if (!LiveFloatManager.getInstance().isLiveRoomShowing()) {
                if (j3 != LiveFloatManager.getInstance().getSessionId()) {
                    LiveFloatManager.getInstance().close();
                }
                LoadOptions loadOptions = new LoadOptions();
                loadOptions.imageOnFail = R.drawable.default_square_head;
                loadOptions.defaultImageResId = R.drawable.default_square_head;
                LiveFloatManager.getInstance().displayFullScreenView();
                Bundle bundle = new Bundle();
                bundle.putShort("session_type", s3);
                bundle.putLong("session_id", j3);
                bundle.putSerializable(OnliveConstant.LIVE_PARAMETER.LIVE_ANCHOR_MODEL, liveAnchorModel);
                bundle.putString("code", str);
                bundle.putString(OnliveConstant.LIVE_PARAMETER.LIVE_PIC_URL, str2);
                bundle.putSerializable(OnliveConstant.LIVE_PARAMETER.LIVE_HEADER_OPTIONS, loadOptions);
                TerminalActivity.addWithoutFituiArgs(bundle);
                TerminalActivity.showFragmentForResult(fragment, (Class<? extends Fragment>) PlayingOnliveFragment.class, bundle, i3);
            }
        }
    }

    public void addDanmaku(ChattingModel chattingModel) {
        this.liveMsgManager.addDanmaku(chattingModel);
    }

    public void addFanClubUpLevelTast(FanClubUpLevelModel fanClubUpLevelModel) {
        if (fanClubUpLevelModel != null && this.d2 != null) {
            if (fanClubUpLevelModel.fans_id.equals(UserInfo.getInstance().getUserId())) {
                this.d2.addLastSelfTask(fanClubUpLevelModel);
                LiveSelfFanClubUpLevelNoticeDialogFragment liveSelfFanClubUpLevelNoticeDialogFragment = this.Y;
                if (liveSelfFanClubUpLevelNoticeDialogFragment == null) {
                    this.d2.runSelf();
                    return;
                }
                Dialog dialog = liveSelfFanClubUpLevelNoticeDialogFragment.dialog;
                if (dialog != null && !dialog.isShowing()) {
                    this.d2.runSelf();
                    return;
                }
                return;
            }
            this.d2.addLastTask(fanClubUpLevelModel);
            this.d2.run();
        }
    }

    public void addNormalDanmaku(ChattingModel chattingModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("in_fan_club", this.is_member + "");
        hashMap.put("fan_club_level", this.fanLevel + "");
        hashMap.put("fan_club_badge_hidden", this.fan_club_badge_hidden + "");
        Map<String, Object> map = chattingModel.msgMapExtra;
        if (map != null) {
            map.putAll(hashMap);
        } else {
            chattingModel.msgMapExtra = hashMap;
        }
        this.liveMsgManager.addNormalDanmaku(chattingModel);
    }

    public void animEntranceEffect(final EntranceData entranceData, final int i3) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.i2.addEntranceEffect(entranceData);
                PlayingOnliveFragment.this.j2.addEntranceEffect(entranceData);
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                if (playingOnliveFragment.is_member == 1 && i3 == 0) {
                    ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(playingOnliveFragment.mSessionId, 27, playingOnliveFragment.l.getString(R.string.live_enter_hint), (SessionProfileModel) null, "", PlayingOnliveFragment.this.mSessionType);
                    chattingModelForSendmsg.fromId = Long.valueOf(UserInfo.getInstance().getUserId()).longValue();
                    chattingModelForSendmsg.fromNickName = UserInfo.getInstance().getLoginUserInfo().getName();
                    PlayingOnliveFragment.this.addNormalDanmaku(chattingModelForSendmsg);
                }
            }
        });
    }

    public void changeRemoteWindow() {
        this.mOutUserB.setVisibility(8);
        this.mRemoteNameB.setVisibility(8);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.startColor = getResources().getColor(R.color.live_pk_bg_start);
        shapeModel.endColor = getResources().getColor(R.color.live_pk_bg_end);
        shapeModel.gradientAngle = 270;
        this.X1.setShapeModel(shapeModel);
        LiveFloatManager.getInstance().resetSurfaceParamsPkStart();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.width = AppInfo.screenWidthForPortrait;
        float f3 = ((float) (AppInfo.screenWidthForPortrait / 2)) * 1.5f;
        int i3 = (int) f3;
        layoutParams.height = i3;
        layoutParams.topMargin = UiUtils.dip2px(getContext(), 135.0f);
        layoutParams.gravity = 48;
        this.k.setLayoutParams(layoutParams);
        if (this.pkMode == 2) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.H1.getLayoutParams();
            layoutParams2.height = i3;
            layoutParams2.topMargin = UiUtils.dip2px(getContext(), 135.0f);
            layoutParams2.gravity = 48;
            this.H1.setLayoutParams(layoutParams);
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.D1.getLayoutParams();
        layoutParams3.topMargin = (int) (((float) UiUtils.dip2px(this.l, 170.0f)) + f3);
        this.D1.setLayoutParams(layoutParams3);
    }

    public void closeConnectionMode() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.k1.setVisibility(4);
                LiveFloatManager.getInstance().mSurfaceView.setVisibility(0);
                LiveFloatManager.getInstance().startConnecting();
                PlayingOnliveFragment.this.dismissRTCWindow();
                PlayingOnliveFragment.this.isRTCModel = false;
            }
        });
    }

    public void dismissFirstCharge() {
        this.U.setVisibility(8);
        LivePreferencesUtils.putFirstCharge(true);
    }

    public void dismissRTCLoading() {
        this.mRemoteLoadingLayoutB.setVisibility(8);
    }

    public void dismissRTCWindow() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.mRemoteWindowB.setVisibility(4);
                PlayingOnliveFragment.this.mRemoteGLSurfaceViewB.setVisibility(4);
            }
        });
    }

    public void exitLive() {
        AnonymousClass44 r02 = new BluedUIHttpResponse<BluedEntityA>(this, getFragmentActive()) {
            public void onUIFinish() {
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
            }

            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }
        };
        LiveHttpUtils.leavePlayingLive(r02, this.mSessionId + "", getFragmentActive());
    }

    public void finish() {
        if (this.q0.getVisibility() == 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.n1;
            PlayingOnlineManager playingOnlineManager = this.O;
            if (playingOnlineManager != null) {
                playingOnlineManager.postLiveLoading(currentTimeMillis / 1000);
            }
        }
        LiveMsgManager liveMsgManager2 = this.liveMsgManager;
        if (liveMsgManager2 != null) {
            liveMsgManager2.clearGiftTask();
        }
        getActivity().finish();
    }

    public int getLiveState() {
        return this.mLiveState;
    }

    public void hidePkingHelper() {
        ImageView imageView = this.D1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void hideTicketView() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.p1.setVisibility(8);
            }
        });
    }

    public void hideView() {
        setBottomLayoutVisible(4);
        this.liveMsgManager.setChatViewVisibility(4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initActionRank(com.blued.international.ui.live.model.LiveActionRankMsgModel r8) {
        /*
            r7 = this;
            com.blued.android.core.imagecache.LoadOptions r0 = new com.blued.android.core.imagecache.LoadOptions
            r0.<init>()
            if (r8 == 0) goto L_0x00ac
            int r1 = r7.q1
            if (r1 != 0) goto L_0x00ac
            int r1 = r8.status
            r2 = 4
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x001e
            com.blued.international.ui.live.model.LiveActionRankMsgModel r1 = r7.k2
            if (r1 == 0) goto L_0x001e
            int r1 = r1.activity_id
            int r2 = r8.activity_id
            if (r1 != r2) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            android.widget.FrameLayout r2 = r7.G
            r5 = 8
            if (r2 == 0) goto L_0x0037
            if (r1 == 0) goto L_0x002a
            r6 = 8
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            r2.setVisibility(r6)
            boolean r2 = r7.u2
            if (r2 == 0) goto L_0x0037
            android.widget.FrameLayout r2 = r7.G
            r2.setVisibility(r5)
        L_0x0037:
            r7.l2 = r1
            if (r1 == 0) goto L_0x003c
            return
        L_0x003c:
            r7.k2 = r8
            int r1 = r8.status
            r2 = 0
            if (r1 != 0) goto L_0x005b
            android.widget.RelativeLayout r1 = r7.I
            if (r1 == 0) goto L_0x004a
            r1.setVisibility(r5)
        L_0x004a:
            r1 = 2131232463(0x7f0806cf, float:1.8081036E38)
            r0.imageOnFail = r1
            r0.defaultImageResId = r1
            com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView r1 = r7.H
            if (r1 == 0) goto L_0x00ac
            java.lang.String r8 = r8.icon
            r1.loadImage((java.lang.String) r8, (com.blued.android.core.imagecache.LoadOptions) r0, (com.blued.android.core.imagecache.ImageLoadingListener) r2)
            goto L_0x00ac
        L_0x005b:
            android.widget.RelativeLayout r1 = r7.I
            if (r1 == 0) goto L_0x0062
            r1.setVisibility(r4)
        L_0x0062:
            r1 = 2131232464(0x7f0806d0, float:1.8081038E38)
            r0.imageOnFail = r1
            r0.defaultImageResId = r1
            com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView r1 = r7.H
            if (r1 == 0) goto L_0x0072
            java.lang.String r6 = r8.icon
            r1.loadImage((java.lang.String) r6, (com.blued.android.core.imagecache.LoadOptions) r0, (com.blued.android.core.imagecache.ImageLoadingListener) r2)
        L_0x0072:
            android.widget.TextView r0 = r7.J
            if (r0 == 0) goto L_0x008c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r8.rank
            r1.append(r2)
            java.lang.String r2 = ""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
        L_0x008c:
            android.widget.ImageView r0 = r7.K
            if (r0 == 0) goto L_0x009a
            int r1 = r8.status
            r2 = 3
            if (r1 != r2) goto L_0x0097
            r4 = 8
        L_0x0097:
            r0.setVisibility(r4)
        L_0x009a:
            android.widget.ImageView r0 = r7.K
            if (r0 == 0) goto L_0x00ac
            int r8 = r8.status
            if (r8 != r3) goto L_0x00a6
            r8 = 2131232466(0x7f0806d2, float:1.8081042E38)
            goto L_0x00a9
        L_0x00a6:
            r8 = 2131232459(0x7f0806cb, float:1.8081028E38)
        L_0x00a9:
            r0.setImageResource(r8)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.international.ui.live.fragment.PlayingOnliveFragment.initActionRank(com.blued.international.ui.live.model.LiveActionRankMsgModel):void");
    }

    public final void initData() {
        this.l = getActivity();
        LiveFloatManager.getInstance().setPlayingOnliveFragment(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mSessionType = arguments.getShort("session_type");
            this.mSessionId = arguments.getLong("session_id");
            if (LiveFloatManager.getInstance().getAnchorModel() != null) {
                this.mLiveAnchorModel = LiveFloatManager.getInstance().getAnchorModel();
            } else {
                this.mLiveAnchorModel = (LiveAnchorModel) arguments.getSerializable(OnliveConstant.LIVE_PARAMETER.LIVE_ANCHOR_MODEL);
            }
            updataLiveInfo(this.mLiveAnchorModel);
            this.e1 = arguments.getString("code");
            this.mPicUrl = arguments.getString(OnliveConstant.LIVE_PARAMETER.LIVE_PIC_URL);
            this.mOptions = (LoadOptions) arguments.getSerializable(OnliveConstant.LIVE_PARAMETER.LIVE_HEADER_OPTIONS);
        }
        int i3 = this.l.getResources().getConfiguration().orientation;
        if (LiveFloatManager.getInstance().isLiveClose()) {
            if (i3 == 2) {
                getActivity().setRequestedOrientation(1);
            }
        } else if (i3 == 2) {
            getActivity().setRequestedOrientation(1);
        }
        PlayingOnlineManager.chatMaxNum = 64;
        getString(R.string.Live_SendPresent_wandou);
        this.j1 = UserInfo.getInstance().getLoginUserInfo().getWealth_level();
    }

    public void initFanClubInfo(PlayingInitModel playingInitModel) {
        if (playingInitModel != null) {
            FanInitModel fanInitModel = playingInitModel.fans_club;
            this.fanLevel = fanInitModel.fans_level;
            this.is_member = fanInitModel.is_member;
            this.is_enable = fanInitModel.is_enable;
            this.fan_club_badge_hidden = fanInitModel.fan_club_badge_hidden;
        }
    }

    public boolean isPKing() {
        return getLiveState() == 2 || getLiveState() == 3;
    }

    public void notifyDismiss() {
        if (getActivity() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) getActivity()).setOnBackPressedListener(this);
            ((BaseFragmentActivity) getActivity()).setOnKeyListener(this);
        }
        if (UserCard.isShowing()) {
            UserCard.getInstance().dismissMenu();
        }
        setBottomLayoutVisible(0);
        this.liveMsgManager.setChatViewVisibility(0);
        if (!this.isSimpleModel) {
            this.liveMsgManager.setSimpleModelGift(true);
        } else {
            this.liveMsgManager.setSimpleModelGift(false);
        }
    }

    public void notifyPlayGif() {
        if (!this.Y0) {
            AppInfo.getUIHandler().post(new Runnable() {
                public void run() {
                    PlayingOnliveFragment.this.playFullScreenAnim();
                }
            });
        }
    }

    public void notifyShow() {
        setBottomLayoutVisible(4);
        this.liveMsgManager.setChatViewVisibility(4);
        this.liveMsgManager.setSimpleModelGift(true);
    }

    public void notifyUpdate(String str, String str2) {
        BubbleLayout bubbleLayout = this.Q;
        if (bubbleLayout != null) {
            bubbleLayout.updateBubbleImage(str, str2);
        }
        BubbleLayout bubbleLayout2 = this.R;
        if (bubbleLayout2 != null) {
            bubbleLayout2.updateBubbleImage(str, str2);
        }
    }

    public void notifyUpdateBeans(double d, double d3) {
        LiveAnchorModel liveAnchorModel = this.mLiveAnchorModel;
        if (liveAnchorModel != null) {
            if (liveAnchorModel.beansCount < d) {
                liveAnchorModel.beansCount = d;
                liveAnchorModel.beans_current_count = d3;
            } else {
                return;
            }
        }
        this.S0.setText(FormatUtils.formatPrice(String.valueOf(d)));
        TextView textView = this.T0;
        if (textView != null) {
            textView.setText(FormatUtils.formatPrice(String.valueOf(d)));
        }
    }

    public void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i4 == -1 && i3 == 10111) {
            this.W0 = intent.getStringArrayExtra(ShareWithContactFragment.CHOOSED_IDS);
            this.X0 = intent.getStringArrayExtra(ShareWithContactFragment.CHOOSED_TYPES);
            if (this.mLiveAnchorModel != null) {
                String[] strArr = this.W0;
                if (strArr != null && strArr.length > 0) {
                    String[] strArr2 = this.X0;
                    if (strArr2 != null && strArr2.length > 0 && strArr.length == strArr2.length) {
                        try {
                            String[] liveShareIDs = TrackEventTool.getInstance().getLiveShareIDs(this.X0, this.W0);
                            if (liveShareIDs != null && liveShareIDs.length == 2) {
                                TrackEventTool instance = TrackEventTool.getInstance();
                                instance.trackLiveShare(TrackEventTool.event_share_value_confirm, this.liveMsgManager.sessionId + "", this.mLiveAnchorModel.uid, liveShareIDs[0], liveShareIDs[1]);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < this.W0.length; i5++) {
                            LiveInvitationRankEntity liveInvitationRankEntity = new LiveInvitationRankEntity();
                            liveInvitationRankEntity.uid = this.W0[i5];
                            liveInvitationRankEntity.session_type = Short.parseShort(this.X0[i5]);
                            arrayList.add(liveInvitationRankEntity);
                        }
                        LiveMsgTools.sendMsgShareLive(this.l, getFragmentActive(), this.mSessionId, arrayList, this.q1);
                        AppMethods.showToast((CharSequence) getString(R.string.liveVideo_message_label_hadShare));
                        LiveHttpUtils.shareComplete(this.mSessionId + "", new BluedUIHttpResponse<BluedEntityA>(this) {
                            public void onUIUpdate(BluedEntityA bluedEntityA) {
                                if (bluedEntityA != null) {
                                    int i = bluedEntityA.code;
                                }
                            }
                        }, getFragmentActive());
                    }
                }
                this.liveMsgManager.sendLiveDynamic(50);
            }
        }
    }

    public boolean onBackPressed() {
        if (this.r0.getVisibility() == 0) {
            this.M0.performClick();
            return true;
        } else if (this.y0.getVisibility() == 0) {
            this.z0.performClick();
            return true;
        } else if (this.s0.getVisibility() == 0) {
            this.B0.performClick();
            return true;
        } else if (this.t0.getVisibility() == 0) {
            this.x0.performClick();
            return true;
        } else if (this.isRTCModel) {
            showExitLive();
            return true;
        } else if (this.d0.isShow()) {
            this.d0.dismiss();
            return true;
        } else {
            if (ChannelManager.getIsFloat()) {
                LiveFloatManager.getInstance().setLiveRoomShowing(false);
                LiveFloatManager.getInstance().close();
                finish();
            } else {
                LiveFloatManager.getInstance().displayFloatView(this.mTimer);
                finish();
            }
            return false;
        }
    }

    public void onBluedShared() {
        ShareWithContactFragment.showForResult(this, StartOnliveFragment.SHARE_REQUEST_CODE, 8, getString(R.string.liveVideo_selectFriends_label_description), this.W0);
    }

    public void onChronometerTick(Chronometer chronometer) {
        this.mTimer++;
        chronometer.setText(DateUtils.formatTimer(this.mTimer, true));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anchor_header /*2131296478*/:
            case R.id.live_end_banned_header /*2131297843*/:
                if (this.mLiveAnchorModel != null) {
                    if (ChannelManager.getIsFloat()) {
                        AppMethods.showToast((int) R.string.channeling_warn);
                        return;
                    } else {
                        ProfileFragment.showFromUid(getContext(), this.mLiveAnchorModel.uid, 32);
                        return;
                    }
                } else {
                    return;
                }
            case R.id.chat_view /*2131296701*/:
                if (getActivity() != null) {
                    this.k0.setFocusableInTouchMode(true);
                    this.k0.setFocusable(true);
                    this.k0.requestFocus();
                    ((InputMethodManager) AppInfo.getAppContext().getSystemService("input_method")).showSoftInput(this.k0, 0);
                    return;
                }
                return;
            case R.id.close_btn /*2131296711*/:
            case R.id.iv_ticket_live_close /*2131297645*/:
                if (this.isRTCModel) {
                    showExitLive();
                    return;
                }
                LiveFloatManager.getInstance().setLiveRoomShowing(false);
                LiveFloatManager.getInstance().close();
                finish();
                return;
            case R.id.error_btn /*2131296920*/:
                LiveFloatManager.getInstance().setLiveRoomShowing(false);
                LiveFloatManager.getInstance().close();
                finish();
                return;
            case R.id.fl_action_rank_layout /*2131296995*/:
                LiveActionRankDialogFragment liveActionRankDialogFragment = this.j;
                if (liveActionRankDialogFragment != null) {
                    if (liveActionRankDialogFragment != null) {
                        Dialog dialog = liveActionRankDialogFragment.dialog;
                        if (dialog == null || dialog.isShowing()) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.j = LiveActionRankDialogFragment.show(getFragmentManager(), false, this.mSessionId + "", this.k2.activity_id + "", new LiveActionRankDialogFragment.OnTitleViewClickListener() {
                    public void onGiftViewClick() {
                        PlayingOnliveFragment.this.d0.show();
                    }

                    public void onHeaderViewClick() {
                        PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                        if (playingOnliveFragment.isRTCModel) {
                            playingOnliveFragment.showExitLive();
                            return;
                        }
                        LiveFloatManager.getInstance().displayFloatView(PlayingOnliveFragment.this.mTimer);
                        PlayingOnliveFragment.this.finish();
                    }

                    public void onTitleViewClick(String str) {
                        PlayingOnliveFragment.this.b(str);
                    }
                }, "");
                return;
            case R.id.fl_happy_time_layout /*2131297012*/:
                if (this.v2 != null) {
                    LiveHappyTimeDialogFragment.show(getFragmentManager(), this.v2.type, this.mSessionId + "");
                    return;
                }
                return;
            case R.id.float_window_view /*2131297037*/:
                LiveFloatManager.getInstance().displayFloatView(this.mTimer);
                finish();
                return;
            case R.id.header_view /*2131297184*/:
                if (this.mLiveAnchorModel != null) {
                    UserCard.getInstance().showMenu(this.mLiveAnchorModel.uid);
                    return;
                }
                return;
            case R.id.interrrupt_btn /*2131297323*/:
                LiveFloatManager.getInstance().setLiveRoomShowing(false);
                LiveFloatManager.getInstance().close();
                finish();
                return;
            case R.id.iv_pk_heler /*2131297603*/:
                b(BluedHttpUrl.getLivePkHelper());
                return;
            case R.id.live_end_banned_ok /*2131297845*/:
                LiveFloatManager.getInstance().setLiveRoomShowing(false);
                LiveFloatManager.getInstance().close();
                finish();
                return;
            case R.id.live_end_follow /*2131297855*/:
                if (this.mLiveAnchorModel != null && !StringUtils.isEmpty(this.i1)) {
                    this.P0.show();
                    if ("0".equals(this.i1) || "2".equals(this.i1)) {
                        MineHttpUtils.addUserFollow(new BluedUIHttpResponse<BluedEntityA<FollowUserModel>>(getFragmentActive()) {
                            public void onUIFinish() {
                                super.onUIFinish();
                                PlayingOnliveFragment.this.P0.dismiss();
                            }

                            public void onUIUpdate(BluedEntityA<FollowUserModel> bluedEntityA) {
                                UserRelationshipUtils.followSuccessHandle(bluedEntityA.getSingleData());
                                String unused = PlayingOnliveFragment.this.i1 = ((FollowUserModel) bluedEntityA.data.get(0)).relationship;
                                PlayingOnliveFragment.this.C();
                            }
                        }, UserInfo.getInstance().getUserId(), this.mLiveAnchorModel.uid, (String) null, getFragmentActive());
                        return;
                    } else {
                        MineHttpUtils.cancelUserFollow(new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>(getFragmentActive()) {
                            public void onUIFinish() {
                                super.onUIFinish();
                                PlayingOnliveFragment.this.P0.dismiss();
                            }

                            public void onUIUpdate(BluedEntityA<BluedRecommendUsers> bluedEntityA) {
                                String unused = PlayingOnliveFragment.this.i1 = ((BluedRecommendUsers) bluedEntityA.data.get(0)).relationship;
                                PlayingOnliveFragment.this.C();
                            }
                        }, UserInfo.getInstance().getUserId(), this.mLiveAnchorModel.uid, getFragmentActive());
                        return;
                    }
                } else {
                    return;
                }
            case R.id.live_exit_des_sure_btn /*2131297872*/:
                LiveFloatManager.getInstance().setLiveRoomShowing(false);
                LiveFloatManager.getInstance().close();
                PlayingOnlineManager playingOnlineManager = this.O;
                if (playingOnlineManager != null) {
                    playingOnlineManager.leaveLiveChat();
                }
                finish();
                return;
            case R.id.live_fans_view /*2131297875*/:
                H();
                return;
            case R.id.live_follow_anchor /*2131297876*/:
                if (this.mLiveAnchorModel != null) {
                    MineHttpUtils.addUserFollow(new BluedUIHttpResponse<BluedEntityA<FollowUserModel>>(getFragmentActive()) {
                        public void onUIUpdate(BluedEntityA<FollowUserModel> bluedEntityA) {
                            UserRelationshipUtils.followSuccessHandle(bluedEntityA.getSingleData());
                            List<T> list = bluedEntityA.data;
                            if (list != null && list.size() > 0) {
                                String unused = PlayingOnliveFragment.this.i1 = ((FollowUserModel) bluedEntityA.data.get(0)).relationship;
                                PlayingOnliveFragment.this.o.setVisibility(8);
                                if (PlayingOnliveFragment.this.p != null) {
                                    PlayingOnliveFragment.this.p.setVisibility(8);
                                }
                                if ("1".equals(PlayingOnliveFragment.this.i1) || "3".equals(PlayingOnliveFragment.this.i1)) {
                                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                    if (playingOnliveFragment.is_enable == 1) {
                                        if (playingOnliveFragment.Z1 != null && LivePreferencesUtils.getLiveFansAttentionGuideShow() <= 3) {
                                            PlayingOnliveFragment.this.Z1.setVisibility(0);
                                            PlayingOnliveFragment.this.Z1.bringToFront();
                                        }
                                        if (PlayingOnliveFragment.this.a2 != null && LivePreferencesUtils.getLiveFansAttentionGuideShow() <= 3) {
                                            PlayingOnliveFragment.this.a2.setVisibility(0);
                                            PlayingOnliveFragment.this.a2.bringToFront();
                                        }
                                        PlayingOnliveFragment.this.postDelaySafeRunOnUiThread(new Runnable() {
                                            public void run() {
                                                LivePreferencesUtils.setLiveFansAttentionGuideShow(LivePreferencesUtils.getLiveFansAttentionGuideShow() + 1);
                                                if (PlayingOnliveFragment.this.Z1 != null) {
                                                    PlayingOnliveFragment.this.Z1.setVisibility(8);
                                                }
                                                if (PlayingOnliveFragment.this.a2 != null) {
                                                    PlayingOnliveFragment.this.a2.setVisibility(8);
                                                }
                                            }
                                        }, LiveFloatManager.RECONNECT_TIME);
                                    } else {
                                        return;
                                    }
                                }
                                PlayingOnliveFragment.this.liveMsgManager.sendLiveDynamic(49);
                            }
                        }
                    }, UserInfo.getInstance().getUserId(), this.mLiveAnchorModel.uid, (String) null, getFragmentActive());
                    LiveServiceLogTool.liveroomInsideAction(this.mLiveAnchorModel.uid, this.mSessionId, OnliveConstant.LIVE_ACTION.follow, this.e1);
                    return;
                }
                return;
            case R.id.live_gift_view /*2131297881*/:
                ImageView imageView = this.w;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                View view2 = this.j0;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                this.y.setVisibility(4);
                ImageView imageView2 = this.x;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                hidePkingHelper();
                dismissFirstCharge();
                if (this.d0.getApproachCount() <= 0 || LivePreferencesUtils.getApproachGift()) {
                    this.d0.show();
                    return;
                }
                this.d0.show();
                LivePreferencesUtils.putApproachGift(true);
                return;
            case R.id.live_like_view /*2131297893*/:
                if (this.mLiveAnchorModel != null) {
                    BubbleLayout bubbleLayout = this.Q;
                    if (bubbleLayout != null) {
                        bubbleLayout.addHeart(true);
                    }
                    BubbleLayout bubbleLayout2 = this.R;
                    if (bubbleLayout2 != null) {
                        bubbleLayout2.addHeart(true);
                    }
                    this.liveMsgManager.sendLiveDynamic(51);
                    LiveMsgTools.sendMsgForSupport(this.l, this.mSessionId, this.mSessionType);
                    LiveServiceLogTool.liveroomInsideAction(this.mLiveAnchorModel.uid, this.mSessionId, OnliveConstant.LIVE_ACTION.like, this.e1);
                    return;
                }
                return;
            case R.id.live_msg_edit_chat_bg /*2131297903*/:
            case R.id.live_msg_edit_chat_btn /*2131297904*/:
                this.k0.setMaxLines(Integer.MAX_VALUE);
                this.k0.setHint(getString(R.string.live_chat_input_hint));
                this.Z0 = false;
                int i3 = this.j1;
                if (i3 < 16 || i3 > 19) {
                    int i4 = this.j1;
                    if (i4 < 20 || i4 > 25) {
                        int i5 = this.j1;
                        if (i5 < 26 || i5 > 30) {
                            this.o0.setImageResource(R.drawable.live_chat_normal_active);
                            this.g0.setColor(Color.parseColor("#181A3C"), Color.parseColor("#181A3C"));
                            this.p0.setImageResource(R.drawable.live_chat_btn);
                        } else {
                            this.o0.setImageResource(R.drawable.live_chat_26_30);
                            this.g0.setColor(Color.parseColor("#4E1857"), Color.parseColor("#281641"));
                            this.p0.setImageResource(R.drawable.live_chat_btn_26_30);
                        }
                    } else {
                        this.o0.setImageResource(R.drawable.live_chat_20_25);
                        this.g0.setColor(Color.parseColor("#420A43"), Color.parseColor("#2b052D"));
                        this.p0.setImageResource(R.drawable.live_chat_btn_20_25);
                    }
                } else {
                    this.o0.setImageResource(R.drawable.live_chat_16_19);
                    this.p0.setImageResource(R.drawable.live_chat_btn_16_19);
                    this.g0.setColor(Color.parseColor("#2A3375"), Color.parseColor("#160738"));
                }
                this.m0.setImageResource(R.drawable.toggle_danmaku_off);
                this.h0.setColor(Color.parseColor("#8F010818"), Color.parseColor("#8F010818"));
                this.i0.setColor(Color.parseColor("#8F010818"), Color.parseColor("#8F010818"));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i0.getLayoutParams();
                layoutParams.leftMargin = UiUtils.dip2px(this.l, -15.0f);
                this.i0.setLayoutParams(layoutParams);
                PlayingOnlineManager.chatMaxNum = 64;
                return;
            case R.id.live_msg_edit_danmu_bg /*2131297905*/:
            case R.id.live_msg_edit_danmu_btn /*2131297906*/:
                this.k0.setMaxLines(1);
                F();
                this.Z0 = true;
                this.n0.setVisibility(8);
                this.o0.setImageResource(R.drawable.live_chat_normal);
                this.g0.setColor(Color.parseColor("#8F010818"), Color.parseColor("#8F010818"));
                this.m0.setImageResource(R.drawable.toggle_danmaku_on);
                int i6 = this.j1;
                if (i6 < 16 || i6 > 19) {
                    int i7 = this.j1;
                    if (i7 < 20 || i7 > 25) {
                        int i8 = this.j1;
                        if (i8 < 26 || i8 > 30) {
                            this.h0.setColor(Color.parseColor("#C94A54F0"), Color.parseColor("#C94A54F0"));
                            this.i0.setColor(Color.parseColor("#C94A54F0"), Color.parseColor("#C94A54F0"));
                        } else {
                            this.h0.setColor(Color.parseColor("#C9931BF9"), Color.parseColor("#C9931BF9"));
                            this.i0.setColor(Color.parseColor("#C9931BF9"), Color.parseColor("#C9FE1C6D"));
                        }
                    } else {
                        this.h0.setColor(Color.parseColor("#C9FA2B7E"), Color.parseColor("#C9FA2B7E"));
                        this.i0.setColor(Color.parseColor("#C9FA2B7E"), Color.parseColor("#C9F48B20"));
                    }
                } else {
                    this.h0.setColor(Color.parseColor("#C95329EB"), Color.parseColor("#C95329EB"));
                    this.i0.setColor(Color.parseColor("#C95329EB"), Color.parseColor("#C930E8C3"));
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i0.getLayoutParams();
                layoutParams2.leftMargin = UiUtils.dip2px(this.l, -16.5f);
                this.i0.setLayoutParams(layoutParams2);
                PlayingOnlineManager.chatMaxNum = 64;
                return;
            case R.id.live_msg_send_to /*2131297914*/:
                B();
                return;
            case R.id.onlive_current_beans_layout /*2131298524*/:
                if (this.mLiveAnchorModel != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(LiveRankGuestPresenter.UID, this.mLiveAnchorModel.uid);
                    bundle.putLong(LiveRankGuestPresenter.LID, this.mSessionId);
                    this.O0 = new LiveRankDialogFragment();
                    this.O0.setLiveRankDialogListener(this);
                    this.O0.setCallback(this);
                    this.O0.setArguments(bundle);
                    this.O0.show(getFragmentManager(), "EditNameDialog");
                    return;
                }
                return;
            case R.id.out_userA_btn /*2131298533*/:
                showCloseConnection();
                return;
            case R.id.out_userB_btn /*2131298534*/:
                showCloseConnection();
                return;
            case R.id.rtc_user_info_layout /*2131298890*/:
                if (this.o1.getTag() != null) {
                    UserCard.getInstance().showMenu((String) this.o1.getTag());
                    return;
                }
                return;
            case R.id.share_view /*2131299022*/:
                this.N0.showMenu();
                LiveServiceLogTool.liveroomInsideAction(this.mLiveAnchorModel.uid, this.mSessionId, "share", this.e1);
                return;
            case R.id.tv_join_fan_club /*2131299510*/:
                LivePreferencesUtils.setLiveFansAttentionGuideShow(1);
                LinearLayout linearLayout = this.Z1;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = this.a2;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                H();
                return;
            case R.id.tv_ticket_pay /*2131299727*/:
                payTicket();
                return;
            default:
                return;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mIsLoaded = true;
        initData();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(19);
        View view = this.mRootView;
        if (view == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_play_onlive, viewGroup, false);
            if (!LiveFloatManager.getInstance().isFloatWindowInit()) {
                LiveFloatManager.getInstance().initLiveWindow();
            }
            u();
            t();
            setAnchorData();
            setSuperView(this.e0);
            s();
            this.Y1 = new LiveShareManager(this.l);
            this.i2 = new EntranceEffectManager(this.l, this.l1);
            this.j2 = new EntranceEffectManager(this.l, this.m1);
            ZanRefreshObserver.getInstance().registorObserver(this);
            PlayGifObserver.getInstance().registorObserver(this);
            BeansRefreshObserver.getInstance().registorObserver(this);
            LiveEventBus.get(EventBusConstant.KEY_EVENT_REQUEST_FLOAT_PERMISSION, VideoChatMessageEvent.class).observe(this, new Observer<VideoChatMessageEvent>() {
                public void onChanged(@Nullable VideoChatMessageEvent videoChatMessageEvent) {
                    if (videoChatMessageEvent != null && videoChatMessageEvent.status == 4) {
                        try {
                            int unused = PlayingOnliveFragment.this.j1 = UserInfo.getInstance().getLoginUserInfo().getWealth_level();
                            PlayingOnliveFragment.this.o0.performClick();
                            PlayingOnliveFragment.this.d0.getGiftList();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            LiveEventBus.get("stoppk_pkingview", Integer.class).observe(this, new Observer<Integer>() {
                public void onChanged(@Nullable Integer num) {
                    PlayingOnliveFragment.this.stopPK();
                }
            });
            w();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        return this.mRootView;
    }

    public void onDestroy() {
        super.onDestroy();
        mIsLoaded = false;
        Animation animation = this.q2;
        if (animation != null) {
            animation.cancel();
        }
        ValueAnimator valueAnimator = this.r2;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.h2;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        TranslateAnimation translateAnimation = this.n2;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        this.i2.recycle();
        this.j2.recycle();
        if (!TextUtils.equals(BaseFragmentActivity.topFragmentName, getSimpleName())) {
            LiveFloatManager.getInstance().setPlayingOnliveFragment((PlayingOnliveFragment) null);
            LiveFloatManager.getInstance().setLiveRoomShowing(false);
        }
        LiveFloatManager.getInstance().mSurfaceView.setVisibility(0);
        PlayingOnlineManager playingOnlineManager = this.O;
        if (playingOnlineManager != null) {
            playingOnlineManager.unRegisterLiveChatListener();
        }
        LiveMsgManager liveMsgManager2 = this.liveMsgManager;
        if (liveMsgManager2 != null) {
            liveMsgManager2.release();
            LiveMsgControler liveMsgControler = this.liveMsgManager.liveMsgControler;
            if (liveMsgControler != null) {
                liveMsgControler.unLiveChatListener(this.mSessionType, this.mSessionId);
            }
        }
        PlayingRTCManager playingRTCManager = this.P;
        if (playingRTCManager != null) {
            playingRTCManager.onDestroy();
        }
        LiveMsgManager liveMsgManager3 = this.liveMsgManager;
        if (liveMsgManager3 != null) {
            liveMsgManager3.clearGiftTask();
        }
        ZanRefreshObserver.getInstance().unRegistorObserver(this);
        PlayGifObserver.getInstance().unRegistorObserver(this);
        BeansRefreshObserver.getInstance().unRegistorObserver(this);
        RTCSurfaceView rTCSurfaceView = this.mRemoteGLSurfaceViewB;
        if (rTCSurfaceView != null) {
            rTCSurfaceView.release();
        }
        RTCSurfaceView rTCSurfaceView2 = this.mRemoteGLSurfaceViewA;
        if (rTCSurfaceView2 != null) {
            rTCSurfaceView2.release();
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FanClubUpLevelManagerImpl fanClubUpLevelManagerImpl = this.d2;
        if (fanClubUpLevelManagerImpl != null) {
            fanClubUpLevelManagerImpl.onDestroy();
        }
        Timer timer = this.A2;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.B2;
        if (timer2 != null) {
            timer2.cancel();
        }
        CountDownTimer countDownTimer = this.z2;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void onHostLevelProgressUpdate(LiveLevel liveLevel) {
        this.b0.setVisibility(0);
        View view = this.c0;
        if (view != null) {
            view.setVisibility(0);
        }
        this.Q0.setObliqueAngle(1);
        ((LinearLayout.LayoutParams) this.Q0.getLayoutParams()).setMargins(UiUtils.dip2px(getActivity(), -8.0f), 0, 0, 0);
        ObliqueLinearLayout obliqueLinearLayout = this.R0;
        if (obliqueLinearLayout != null) {
            obliqueLinearLayout.setObliqueAngle(1);
            ((LinearLayout.LayoutParams) this.R0.getLayoutParams()).setMargins(UiUtils.dip2px(getActivity(), -8.0f), 0, 0, 0);
        }
        if (liveLevel.level == 0) {
            this.E0.setVisibility(8);
            this.K0.setVisibility(0);
            AutoAttachRecyclingImageView autoAttachRecyclingImageView = this.F0;
            if (autoAttachRecyclingImageView != null) {
                autoAttachRecyclingImageView.setVisibility(8);
            }
            TextView textView = this.L0;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            this.E0.setVisibility(0);
            this.K0.setVisibility(8);
            TextView textView2 = this.L0;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.E0.setImageResource(UserLiveUtil.getUserLiveLevelIconId(liveLevel.level));
            AutoAttachRecyclingImageView autoAttachRecyclingImageView2 = this.F0;
            if (autoAttachRecyclingImageView2 != null) {
                autoAttachRecyclingImageView2.setVisibility(0);
                this.F0.setImageResource(UserLiveUtil.getUserLiveLevelIconId(liveLevel.level));
            }
        }
        this.G0.setLevel(liveLevel.level, liveLevel.progress, true, getResources().getColor(R.color.live_level_bar_bg_for_live_room));
        LevelProgressBar levelProgressBar = this.H0;
        if (levelProgressBar != null) {
            levelProgressBar.setLevel(liveLevel.level, liveLevel.progress, true, getResources().getColor(R.color.live_level_bar_bg_for_live_room));
        }
        if (liveLevel.level >= 30) {
            this.G0.setProgress(100);
            LevelProgressBar levelProgressBar2 = this.H0;
            if (levelProgressBar2 != null) {
                levelProgressBar2.setProgress(100);
            }
            this.I0.setVisibility(8);
            TextView textView3 = this.J0;
            if (textView3 != null) {
                textView3.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView4 = this.I0;
        textView4.setText("LV." + LiveUtils.getLevelStr(liveLevel.level));
        TextView textView5 = this.J0;
        if (textView5 != null) {
            textView5.setText("LV." + LiveUtils.getLevelStr(liveLevel.level));
        }
    }

    public void onHostLevelUpdate(final LiveLevel liveLevel) {
        if (this.mLiveAnchorModel != null) {
            postSafeRunOnUiThread(new Runnable() {
                public void run() {
                    new LevelUpgradeDialog(PlayingOnliveFragment.this.getContext(), liveLevel.level, false, PlayingOnliveFragment.this.mLiveAnchorModel.name).show();
                    PlayingOnliveFragment.this.onHostLevelProgressUpdate(liveLevel);
                }
            });
        }
    }

    public void onJoinLive(JoinLiveResult joinLiveResult, String str, String str2) {
        PlayingRTCManager playingRTCManager = this.P;
        if (playingRTCManager != null) {
            playingRTCManager.onJoinLive(joinLiveResult, str, str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onKeyboardChanged(int r5) {
        /*
            r4 = this;
            com.blued.international.ui.live.util.LiveGiftPayTools r0 = com.blued.international.ui.live.util.LiveGiftPayTools.getInstance()
            com.blued.international.view.tip.model.DialogWith6PW r0 = r0.dialogWith6PW
            r1 = -3
            r2 = 8
            r3 = 0
            if (r5 == r1) goto L_0x001b
            r0 = -2
            if (r5 == r0) goto L_0x0010
            goto L_0x004b
        L_0x0010:
            isShowKeyboard = r3
            r4.I()
            android.view.View r5 = r4.f0
            r5.setVisibility(r2)
            goto L_0x004b
        L_0x001b:
            r5 = 1
            isShowKeyboard = r5
            if (r0 == 0) goto L_0x002c
            androidx.appcompat.app.AlertDialog r0 = r0.dialog
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x002c
            r0 = 0
            goto L_0x002d
        L_0x002c:
            r0 = 1
        L_0x002d:
            if (r0 == 0) goto L_0x0039
            android.widget.EditText r0 = r4.k0
            r0.setFocusableInTouchMode(r5)
            android.widget.EditText r5 = r4.k0
            r5.requestFocus()
        L_0x0039:
            android.widget.ImageView r5 = r4.w
            r5.setVisibility(r3)
            android.widget.ImageView r5 = r4.y
            r5.setVisibility(r3)
            com.blued.international.ui.live.liveForMsg.controler.LiveMsgManager r5 = r4.liveMsgManager
            r5.setGiftVisibility(r2)
            r4.r()
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.international.ui.live.fragment.PlayingOnliveFragment.onKeyboardChanged(int):void");
    }

    public void onPageChangedActionRank(LiveActionRankMsgModel liveActionRankMsgModel) {
        int i3;
        new LoadOptions();
        if (liveActionRankMsgModel != null && this.q1 == 0) {
            RelativeLayout relativeLayout = this.I;
            if (relativeLayout != null) {
                if (liveActionRankMsgModel.status == 0) {
                    ViewPager viewPager = this.B1;
                    if (viewPager != null && viewPager.getCurrentItem() == 1) {
                        i3 = 8;
                        relativeLayout.setVisibility(i3);
                    }
                }
                i3 = 0;
                relativeLayout.setVisibility(i3);
            }
        }
    }

    public void onPause() {
        super.onPause();
        LiveFloatManager.getInstance().setLiveRoomShowing(false);
        this.O.onPause();
        LiveRankDialogFragment liveRankDialogFragment = this.O0;
        if (liveRankDialogFragment != null) {
            Dialog dialog = liveRankDialogFragment.getDialog();
            if (dialog != null && dialog.isShowing()) {
                this.O0.dismiss();
            }
        }
        PlayingRTCManager playingRTCManager = this.P;
        if (playingRTCManager != null) {
            playingRTCManager.mIsActivityPaused = true;
        }
        FanClubUpLevelManagerImpl fanClubUpLevelManagerImpl = this.d2;
        if (fanClubUpLevelManagerImpl != null) {
            fanClubUpLevelManagerImpl.onPause();
        }
        PkBoxDetailsDialog.close();
        PkBoxGetGiftDialog.close();
    }

    public void onResume() {
        super.onResume();
        postDelaySafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                playingOnliveFragment.a((ViewGroup) playingOnliveFragment.mRootView);
                int i = PlayingOnliveFragment.this.l.getResources().getConfiguration().orientation;
                if (LiveFloatManager.getInstance().isLiveClose() && i == 2 && PlayingOnliveFragment.this.getActivity() != null) {
                    PlayingOnliveFragment.this.getActivity().setRequestedOrientation(1);
                }
            }
        }, 1000);
        GiftCardView giftCardView = this.d0;
        if (giftCardView != null) {
            giftCardView.getRemainingCount();
        }
        LiveMsgManager liveMsgManager2 = this.liveMsgManager;
        if (liveMsgManager2 != null) {
            liveMsgManager2.setGiftVisibility(0);
        }
        PlayingOnlineManager playingOnlineManager = this.O;
        if (playingOnlineManager != null) {
            playingOnlineManager.onResume();
        }
        PlayingRTCManager playingRTCManager = this.P;
        if (playingRTCManager != null) {
            playingRTCManager.mIsActivityPaused = false;
        }
        LiveFloatManager.getInstance().resetSurfaceParams();
        if (this.mIsFirstOnResume) {
            this.mIsFirstOnResume = false;
            LiveFloatManager.getInstance().delayResetSurfaceView();
        }
        FanClubUpLevelManagerImpl fanClubUpLevelManagerImpl = this.d2;
        if (fanClubUpLevelManagerImpl != null) {
            fanClubUpLevelManagerImpl.onResume();
        }
    }

    public void onShareClicked() {
        this.N0.showMenu();
        hideView();
    }

    public void onStop() {
        super.onStop();
        PlayingRTCManager playingRTCManager = this.P;
        if (playingRTCManager != null) {
            playingRTCManager.stopConference();
            this.P.stopCapture();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.g1.onTouchEvent(motionEvent);
        return true;
    }

    public void onUserHeadClicked(String str) {
        UserCard.getInstance().showMenu(str);
        this.O0.dismiss();
    }

    public void openConnectionMode() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.k1.setVisibility(0);
                LiveFloatManager.getInstance().mSurfaceView.setVisibility(8);
                LiveFloatManager.getInstance().pause();
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                playingOnliveFragment.isRTCModel = true;
                LiveAnchorModel liveAnchorModel = playingOnliveFragment.mLiveAnchorModel;
                if (liveAnchorModel != null) {
                    LiveServiceLogTool.liveroomInsideAction(liveAnchorModel.uid, playingOnliveFragment.mSessionId, OnliveConstant.LIVE_ACTION.rtc, playingOnliveFragment.e1);
                }
            }
        });
    }

    public void payTicket() {
        if (this.liveMsgManager != null) {
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.ops = 5;
            liveGiftModel.goods_id = String.valueOf(LiveFloatManager.getInstance().mLiveTicket.ticket_id);
            if (getFragmentActive().isActive()) {
                DialogUtils.showDialog(this.P0);
                LiveGiftPayTools.getInstance().checkGiftPayStatus(getActivity(), this.mSessionType, this.mSessionId, (IRequestHost) null, liveGiftModel, this.mLiveAnchorModel.uid, "", 1, new LiveGiftPayTools.BackGiftStatusListener() {
                    public void goToPay() {
                        LiveFloatManager.getInstance().displayFloatView(PlayingOnliveFragment.this.mTimer);
                        PlayingOnliveFragment.this.finish();
                    }

                    public void onGiftStatus(LiveGiftModel liveGiftModel, final LiveGiftModel liveGiftModel2, LiveZanExtraModel liveZanExtraModel) {
                        PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                            public void run() {
                                DialogUtils.closeDialog(PlayingOnliveFragment.this.P0);
                                if (liveGiftModel2.sendGiftStatus == 3) {
                                    PlayingOnliveFragment.this.hideTicketView();
                                    LiveFloatManager.getInstance().mLiveTicket.hasPaid = true;
                                    PlayingOnliveFragment.this.d0.refreshRemainingCount(String.valueOf(liveGiftModel2.beans));
                                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                    LiveGiftModel liveGiftModel = liveGiftModel2;
                                    playingOnliveFragment.notifyUpdateBeans((double) liveGiftModel.beans_count, (double) liveGiftModel.beans_current_count);
                                }
                            }
                        });
                    }
                }, this.liveMsgManager);
            }
        }
    }

    public void playBaoZan(String str) {
    }

    public void playFullScreenAnim() {
        List<LiveMsgGiftMsgExtra> gifTaskList = this.liveMsgManager.getGifTaskList();
        "gifTaskList size = " + gifTaskList.size();
        if (gifTaskList.size() > 0) {
            this.Y0 = true;
            final LiveMsgGiftMsgExtra liveMsgGiftMsgExtra = gifTaskList.get(0);
            "gifTask.gift_pic_apng2 = " + liveMsgGiftMsgExtra.gift_pic_apng2;
            this.mAnimationView.start(liveMsgGiftMsgExtra.gift_pic_gif, liveMsgGiftMsgExtra.gift_pic_apng2, liveMsgGiftMsgExtra.anim_code, new AnimationListenerAdapter() {
                public void onAnimationEnd() {
                    boolean unused = PlayingOnliveFragment.this.Y0 = false;
                    PlayingOnliveFragment.this.liveMsgManager.removeGifTask(liveMsgGiftMsgExtra);
                    PlayingOnliveFragment.this.mAnimationView.post(new Runnable() {
                        public void run() {
                            PlayingOnliveFragment.this.playFullScreenAnim();
                        }
                    });
                }
            });
        }
    }

    public void playHornView(final LiveHornModel liveHornModel, boolean z3) {
        if (this.U0.getVisibility() != 0) {
            this.U0.setVisibility(0);
            this.U0.bringToFront();
            if (this.u1 != null) {
                p();
            }
            final ViewGroup.LayoutParams layoutParams = this.U0.getLayoutParams();
            layoutParams.width = AppInfo.screenWidthForPortrait;
            this.U0.setLayoutParams(layoutParams);
            if (this.q2 == null) {
                this.q2 = AnimationUtils.loadAnimation(this.l, R.anim.slide_right_in);
            }
            this.q2.setDuration(1000);
            this.q2.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    PlayingOnliveFragment.this.V0.addText(liveHornModel.content);
                    Animation unused = PlayingOnliveFragment.this.q2 = null;
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            this.U0.startAnimation(this.q2);
            this.V0.setTipViewListener(new TipView.TipViewListener() {
                public void onTipEmpty() {
                    if (PlayingOnliveFragment.this.r2 == null) {
                        ValueAnimator unused = PlayingOnliveFragment.this.r2 = ValueAnimator.ofInt(new int[]{AppInfo.screenWidthForPortrait, 0});
                    }
                    PlayingOnliveFragment.this.r2.setDuration(1000);
                    PlayingOnliveFragment.this.r2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            PlayingOnliveFragment.this.U0.setLayoutParams(layoutParams);
                        }
                    });
                    PlayingOnliveFragment.this.r2.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            PlayingOnliveFragment.this.U0.setVisibility(8);
                            PlayingOnliveFragment.this.p();
                        }
                    });
                    PlayingOnliveFragment.this.r2.start();
                }
            });
        }
    }

    public void preparePK(LivePkInviteModel livePkInviteModel) {
        o();
        setLiveState(1);
        int i3 = livePkInviteModel.delay;
        if (i3 == 0) {
            startPK(livePkInviteModel);
            return;
        }
        final LivePkInviteModel livePkInviteModel2 = livePkInviteModel;
        AnonymousClass74 r12 = new CountDownTimer((long) (i3 * 1000), 500) {
            public void onFinish() {
                PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                    public void run() {
                        AnonymousClass74 r0 = AnonymousClass74.this;
                        PlayingOnliveFragment.this.startPK(livePkInviteModel2);
                    }
                });
            }

            public void onTick(long j) {
            }
        };
        this.t2 = r12.start();
    }

    public void receivedHappyTimeCard(String str, String str2) {
        if (this.mLivePkingView != null) {
            boolean z3 = !StringUtils.isEmail(str) && str.equals(this.mLiveAnchorModel.uid);
            "playing  isSalf = " + z3;
            LivePkingView livePkingView = this.mLivePkingView;
            livePkingView.playFlipAnimator(str2, livePkingView.playPlayingAnimator(), z3, z3 ? this.mRemoteWindowA : this.mRemoteWindowB);
        }
    }

    public void refreshAllCount(long j3) {
        if (getFragmentActive().isActive()) {
            this.S.setText(j3 + "");
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(this.S.getText());
            }
            "live viewer count:" + j3;
        }
    }

    public void refreshContributionInfo(ContributionModel contributionModel) {
        LivePkingView livePkingView = this.mLivePkingView;
        if (livePkingView != null) {
            livePkingView.startContributionAnimator(contributionModel);
        }
    }

    public void refreshFanClubInfo(int i3, int i4) {
        this.fanLevel = i3;
        this.fan_club_badge_hidden = i4;
    }

    public void refreshPK(float f3, float f4) {
        this.mLivePkingView.refreshPKProgress(f3, f4);
    }

    public void refreshProtectionCoverState(LiveProtectionCoverUpdateModel liveProtectionCoverUpdateModel) {
        if (liveProtectionCoverUpdateModel != null) {
            if ((getLiveState() == 1 || getLiveState() == 2) && this.mLivePkingView != null) {
                List<ProtectionCoverModel> list = liveProtectionCoverUpdateModel.records;
                if (list != null && !CollectionUtils.isEmpty(list)) {
                    b(liveProtectionCoverUpdateModel.update);
                    ProtectionCoverModel protectionCoverModel = liveProtectionCoverUpdateModel.records.get(0);
                    if (protectionCoverModel != null && protectionCoverModel.alter == 1) {
                        protectionCoverModel.uid = liveProtectionCoverUpdateModel.uid;
                        protectionCoverModel.timestamp = liveProtectionCoverUpdateModel.timestamp;
                        protectionCoverModel.toString();
                        a(protectionCoverModel, this.I1);
                    }
                    ProtectionCoverModel protectionCoverModel2 = liveProtectionCoverUpdateModel.records.get(1);
                    if (protectionCoverModel2 != null && protectionCoverModel2.alter == 1) {
                        protectionCoverModel2.is_enemy = 1;
                        protectionCoverModel2.uid = liveProtectionCoverUpdateModel.uid;
                        protectionCoverModel2.timestamp = liveProtectionCoverUpdateModel.timestamp;
                        protectionCoverModel2.toString();
                        a(protectionCoverModel2, this.P1);
                    }
                }
            }
        }
    }

    public void refreshRankingList() {
    }

    public void resetTimer(final long j3) {
        AppInfo.getUIHandler().post(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.mTimer = j3;
            }
        });
    }

    public void setAnchorData() {
        if (getFragmentActive().isActive() && this.A != null) {
            if (this.mLiveAnchorModel != null) {
                this.w.setEnabled(true);
                this.q.setEnabled(true);
                String str = this.mLiveAnchorModel.name;
                if (str == null) {
                    str = "";
                }
                if (str.length() > 7) {
                    this.A.setText(str.substring(0, 7) + "...");
                } else {
                    this.A.setText(str);
                }
                if (this.B != null) {
                    if (str.length() > 7) {
                        this.B.setText(str.substring(0, 7) + "...");
                    } else {
                        this.B.setText(str);
                    }
                }
                LoadOptions loadOptions = new LoadOptions();
                loadOptions.imageOnFail = R.drawable.user_bg_round;
                loadOptions.defaultImageResId = R.drawable.user_bg_round;
                this.m.loadImage(this.mLiveAnchorModel.avatar, loadOptions, (ImageLoadingListener) null);
                RoundedImageView roundedImageView = this.n;
                if (roundedImageView != null) {
                    roundedImageView.loadImage(this.mLiveAnchorModel.avatar, loadOptions, (ImageLoadingListener) null);
                }
                "mLiveAnchorModel.vbadge = " + this.mLiveAnchorModel.vbadge;
                ResourceUtils.setVerifyImg(this.C, this.mLiveAnchorModel.vbadge, "", 1);
                ImageView imageView = this.D;
                if (imageView != null) {
                    ResourceUtils.setVerifyImg(imageView, this.mLiveAnchorModel.vbadge, "", 1);
                }
                this.S0.setText(FormatUtils.formatPrice(String.valueOf(this.mLiveAnchorModel.beansCount)));
                TextView textView = this.T0;
                if (textView != null) {
                    textView.setText(FormatUtils.formatPrice(String.valueOf(this.mLiveAnchorModel.beansCount)));
                }
                this.d0.setData(this.mSessionId, this.mSessionType, this.mLiveAnchorModel.uid, this.liveMsgManager, this.e1);
                this.N0 = new LiveShareView(this.l, this.mLiveAnchorModel, this.liveMsgManager, this);
                this.N0.setOnDismissListener(new LiveShareView.OnDismissListener() {
                    public void onDismiss() {
                        PlayingOnliveFragment.this.showView();
                    }
                });
                this.N0.setOnBluedSharedListener(this);
                return;
            }
            this.w.setEnabled(false);
            this.q.setEnabled(false);
        }
    }

    public void setApproachGiftCount(final int i3) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                if (i3 == 0) {
                    PlayingOnliveFragment.this.s.setVisibility(8);
                    return;
                }
                PlayingOnliveFragment.this.s.setVisibility(0);
                BadgeView v0 = PlayingOnliveFragment.this.s;
                v0.setText(i3 + "");
            }
        });
    }

    public void setAvatarPendantView(String str) {
        if (!TextUtils.isEmpty(str)) {
            LiveUtils.setAvatarPendantView(str, (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.header_pendant_view), (ImageView) this.mRootView.findViewById(R.id.header_pendant_circle_view));
        }
    }

    public void setBottomLayoutVisible(int i3) {
        int i4 = 4;
        int i5 = 8;
        this.w.setVisibility(i3 == 8 ? 4 : i3);
        this.y.setVisibility(i3 == 8 ? 4 : i3);
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setVisibility(i3 == 8 ? 4 : i3);
        }
        ImageView imageView2 = this.z;
        if (imageView2 != null) {
            if (i3 != 8) {
                i4 = i3;
            }
            imageView2.setVisibility(i4);
        }
        if (i3 == 0) {
            ImageView imageView3 = this.q;
            if (!this.f1) {
                i5 = 0;
            }
            imageView3.setVisibility(i5);
            this.j0.setVisibility(0);
            showPkingHelper();
            return;
        }
        this.q.setVisibility(i3);
        this.j0.setVisibility(i3);
        hidePkingHelper();
    }

    public void setBoxOnCountDown(final int i3) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                "开始开箱倒计时" + i3;
                if (PlayingOnliveFragment.this.u1 != null) {
                    if (PlayingOnliveFragment.this.u1.getVisibility() != 0) {
                        PlayingOnliveFragment.this.u1.setVisibility(0);
                    }
                    PlayingOnliveFragment.this.u1.setReceiveOrOpen(true);
                    PlayingOnliveFragment.this.u1.setTime((long) i3);
                }
                if (PlayingOnliveFragment.this.v1 != null) {
                    PlayingOnliveFragment.this.v1.setVisibility(0);
                    PlayingOnliveFragment.this.v1.setReceiveOrOpen(true);
                    PlayingOnliveFragment.this.v1.setTime((long) i3);
                }
            }
        });
    }

    public void setBoxOnOpenCountDown(final int i3) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                if (PlayingOnliveFragment.this.u1.getStatus() != 4 && PlayingOnliveFragment.this.u1.getStatus() != 5) {
                    "开始领取倒计时" + i3;
                    if (PlayingOnliveFragment.this.u1 != null) {
                        if (PlayingOnliveFragment.this.u1.getVisibility() != 0) {
                            PlayingOnliveFragment.this.u1.setVisibility(0);
                        }
                        PlayingOnliveFragment.this.u1.setReceiveOrOpen(false);
                        PlayingOnliveFragment.this.u1.setTime((long) i3);
                    }
                    if (PlayingOnliveFragment.this.v1 != null && PlayingOnliveFragment.this.v1.getStatus() != 5) {
                        PlayingOnliveFragment.this.v1.setVisibility(0);
                        PlayingOnliveFragment.this.v1.setReceiveOrOpen(false);
                        PlayingOnliveFragment.this.v1.setTime((long) i3);
                    }
                }
            }
        });
    }

    public void setBoxOnUpdateProgress(final int i3, final int i4) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                "接收到消息2，maps进度为：" + i3 + "   keys进度为：" + i4;
                if (PlayingOnliveFragment.this.u1 != null) {
                    if (PlayingOnliveFragment.this.u1.getVisibility() != 0) {
                        PlayingOnliveFragment.this.u1.setVisibility(0);
                    }
                    PlayingOnliveFragment.this.u1.setStatus(1);
                    PlayingOnliveFragment.this.u1.setMapProgress(i3);
                    PlayingOnliveFragment.this.u1.setKeyProgress(i4);
                }
                if (PlayingOnliveFragment.this.v1 != null) {
                    PlayingOnliveFragment.this.v1.setVisibility(0);
                    PlayingOnliveFragment.this.v1.setStatus(1);
                    PlayingOnliveFragment.this.v1.setMapProgress(i3);
                    PlayingOnliveFragment.this.v1.setKeyProgress(i4);
                }
            }
        });
    }

    public void setBoxOnVisible(final int i3) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                "接收到宝箱显示或隐藏" + i3 + ",0为显示";
                if (PlayingOnliveFragment.this.w1 != null && PlayingOnliveFragment.this.u1 != null) {
                    if (i3 == 0) {
                        PlayingOnliveFragment.this.u1.setStatus(1);
                        if (PlayingOnliveFragment.this.v1 != null) {
                            PlayingOnliveFragment.this.v1.setStatus(1);
                        }
                        BoxViewModel boxViewModel = new BoxViewModel();
                        boxViewModel.liveType = 1;
                        boxViewModel.targetView = new View[]{PlayingOnliveFragment.this.u1.iv_box, PlayingOnliveFragment.this.v1.iv_box};
                        boxViewModel.onAnimatorListener = new BoxView.OnAnimatorListener() {
                            public void onAnimationEnd() {
                                PlayingOnliveFragment.this.setBoxOnUpdateProgress(0, 0);
                                PlayingOnliveFragment.this.u1.setVisibility(0);
                                PlayingOnliveFragment.this.p();
                            }

                            public void onAnimationStart() {
                                PlayingOnliveFragment.this.u1.setVisibility(4);
                            }
                        };
                        boxViewModel.apngPath = "icon_live_box.png";
                        boxViewModel.staticImg = R.drawable.icon_on_live_box;
                        boxViewModel.animatorNumber = null;
                        PlayingOnliveFragment.this.w1.setModel(boxViewModel);
                        PlayingOnliveFragment.this.w1.start();
                        return;
                    }
                    PlayingOnliveFragment.this.u1.setVisibility(4);
                    if (PlayingOnliveFragment.this.v1 != null) {
                        PlayingOnliveFragment.this.v1.setVisibility(4);
                    }
                }
            }
        });
    }

    public void setBoxOnVisibleMax() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                if (PlayingOnliveFragment.this.u1 != null) {
                    if (PlayingOnliveFragment.this.u1.getVisibility() != 0) {
                        PlayingOnliveFragment.this.u1.setVisibility(0);
                    }
                    PlayingOnliveFragment.this.u1.setStatus(2);
                }
                if (PlayingOnliveFragment.this.v1 != null) {
                    PlayingOnliveFragment.this.v1.setVisibility(0);
                    PlayingOnliveFragment.this.v1.setStatus(2);
                }
            }
        });
    }

    public void setBuffVisible(int i3, int i4) {
        this.mLivePkingView.setBuffVisible(i3, i4);
    }

    public void setConnectedUser(final Map<String, Object> map) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                Map map = map;
                if (map == null) {
                    PlayingOnliveFragment.this.o1.hide();
                    PlayingOnliveFragment.this.p();
                    return;
                }
                long longValue = MsgPackHelper.getLongValue(map, "uid");
                String stringValue = MsgPackHelper.getStringValue(map, "avatar");
                String stringValue2 = MsgPackHelper.getStringValue(map, "name");
                RTCUserInfoLayout X = PlayingOnliveFragment.this.o1;
                X.setData(longValue + "", stringValue, stringValue2);
                PlayingOnliveFragment.this.o1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        PlayingOnliveFragment.this.p();
                        if (Build.VERSION.SDK_INT < 16) {
                            PlayingOnliveFragment.this.o1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            PlayingOnliveFragment.this.o1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }
                });
            }
        });
    }

    public void setDanmaku(final LiveZanExtraModel liveZanExtraModel) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                LiveZanExtraModel.Danmaku danmaku = liveZanExtraModel.danmu;
                if (danmaku == null || danmaku.goods_id == 0) {
                    boolean unused = PlayingOnliveFragment.this.Z0 = false;
                    PlayingOnlineManager.chatMaxNum = 64;
                    PlayingOnliveFragment.this.h0.setVisibility(8);
                } else {
                    AutoAttachRecyclingImageView.loadImageWithoutView(ImageUtils.getHeaderUrl(1, UserInfo.getInstance().getLoginUserInfo().getAvatar()), (LoadOptions) null, (ImageLoadingListener) null);
                    long unused2 = PlayingOnliveFragment.this.a1 = liveZanExtraModel.danmu.goods_id;
                    long unused3 = PlayingOnliveFragment.this.d1 = liveZanExtraModel.danmu.beans;
                    PlayingOnliveFragment.this.h0.setVisibility(0);
                    int unused4 = PlayingOnliveFragment.this.b1 = liveZanExtraModel.barrage_total;
                    int unused5 = PlayingOnliveFragment.this.c1 = liveZanExtraModel.barrage_left;
                }
                if (PlayingOnliveFragment.this.Z0) {
                    PlayingOnliveFragment.this.F();
                } else {
                    PlayingOnliveFragment.this.k0.setHint(PlayingOnliveFragment.this.getString(R.string.live_chat_input_hint));
                }
            }
        });
    }

    public void setLiveState(int i3) {
        this.mLiveState = i3;
        UserCard.getInstance().setIsPking(isPKing());
    }

    public void setLoadingVisibility(final int i3, final boolean z3) {
        this.q0.post(new Runnable() {
            public void run() {
                if (i3 == 0) {
                    long unused = PlayingOnliveFragment.this.n1 = System.currentTimeMillis();
                    PlayingOnliveFragment.this.q0.showLoading();
                } else {
                    if (PlayingOnliveFragment.this.mHeaderBgView.getVisibility() == 0) {
                        PlayingOnliveFragment.this.mHeaderBgView.setVisibility(8);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setFillAfter(false);
                        alphaAnimation.setDuration(800);
                        PlayingOnliveFragment.this.mHeaderBgView.setAnimation(alphaAnimation);
                        alphaAnimation.start();
                    }
                    PlayingOnliveFragment.this.q0.dismissLoading();
                }
                if (i3 == 8 && z3) {
                    long currentTimeMillis = System.currentTimeMillis() - PlayingOnliveFragment.this.n1;
                    if (PlayingOnliveFragment.this.O != null) {
                        PlayingOnliveFragment.this.O.postLiveLoading(currentTimeMillis / 1000);
                    }
                }
            }
        });
    }

    public void setMapVisible(final LivePkGiftModel livePkGiftModel) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                LivePkGiftModel livePkGiftModel = livePkGiftModel;
                int i = livePkGiftModel.type;
                if (i != 1) {
                    if (i == 2) {
                        PlayingOnliveFragment.this.d0.setBagNotice();
                    } else if (i == 3) {
                        LiveAnchorModel liveAnchorModel = PlayingOnliveFragment.this.mLiveAnchorModel;
                        if (liveAnchorModel != null && LivePreferencesUtils.getLiveFansNoticeShow(liveAnchorModel.uid) != 1) {
                            if (PlayingOnliveFragment.this.i == null || !(PlayingOnliveFragment.this.i == null || PlayingOnliveFragment.this.i.dialog == null || PlayingOnliveFragment.this.i.dialog.isShowing())) {
                                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                FragmentManager childFragmentManager = playingOnliveFragment.getChildFragmentManager();
                                LiveAnchorModel liveAnchorModel2 = PlayingOnliveFragment.this.mLiveAnchorModel;
                                LiveNoticeAddFansDialogFragment unused = playingOnliveFragment.i = LiveNoticeAddFansDialogFragment.show(childFragmentManager, liveAnchorModel2.uid, liveAnchorModel2.name, new LiveNoticeAddFansDialogFragment.OnClickButtonListener() {
                                    public void onClickLeftButtonListener(View view) {
                                    }

                                    public void onClickRightButtonListener(View view) {
                                        PlayingOnliveFragment.this.m();
                                    }
                                });
                            }
                        }
                    } else if (i == 4) {
                        if (livePkGiftModel.receive_type == 1) {
                            PlayingOnliveFragment.this.W1.setModel(livePkGiftModel);
                            PlayingOnliveFragment.this.W1.start();
                        } else {
                            PlayingOnliveFragment.this.showThiefCardDialog(livePkGiftModel);
                        }
                        PlayingOnliveFragment.this.d0.setBagNotice();
                    }
                } else if (PlayingOnliveFragment.this.y1 != null && PlayingOnliveFragment.this.w != null) {
                    BoxViewModel boxViewModel = new BoxViewModel();
                    boxViewModel.liveType = 2;
                    boxViewModel.targetView = new View[]{PlayingOnliveFragment.this.w, PlayingOnliveFragment.this.x};
                    boxViewModel.onAnimatorListener = null;
                    boxViewModel.apngPath = "icon_live_map_down.png";
                    boxViewModel.staticImg = R.drawable.icon_on_live_maps;
                    boxViewModel.duration = 650;
                    boxViewModel.animatorNumber = PlayingOnliveFragment.this.z1;
                    PlayingOnliveFragment.this.y1.setModel(boxViewModel);
                    PlayingOnliveFragment.this.y1.start();
                    PlayingOnliveFragment.this.d0.setBagNotice();
                }
            }
        });
    }

    public void setPkResult(PkStopModel pkStopModel) {
        if (pkStopModel != null && this.mLivePkingView != null) {
            setLiveState(3);
            this.mLivePkingView.setPerTopInfo(pkStopModel.top_info);
            this.mLivePkingView.setPkResultVisible(pkStopModel.res, pkStopModel.countdown);
            List<PkRecordsModel> list = pkStopModel.records;
            if (list != null && list.size() >= 2) {
                setBuffVisible(pkStopModel.records.get(0).buff, pkStopModel.records.get(1).buff);
                this.mLivePkingView.refreshPKProgress(pkStopModel.records.get(0).score, pkStopModel.records.get(1).score);
            }
            this.mLivePkingView.clearThieCardQueue();
            this.mLivePkingView.clearAdditionAndSubtractionQueue();
            this.I1.clear();
            this.P1.clear();
            this.I1.clearCountDown();
            this.P1.clearCountDown();
        }
    }

    public void setProgress(int i3, int i4, long j3, long j4) {
        LivePkingView livePkingView = this.mLivePkingView;
        if (livePkingView != null) {
            livePkingView.setLivePkBoxProgress(j3, j4);
            this.mLivePkingView.setTreasureStatus(i3, i4);
        }
    }

    public void setReplyClick(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            this.s2.put(str2, EncryptTool.hashidsEncode(str));
            this.k0.setText(this.k0.getText().toString() + "@" + str2 + ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
            this.k0.setSelection(this.k0.getText().length());
            postDelaySafeRunOnUiThread(new Runnable() {
                public void run() {
                    if (PlayingOnliveFragment.this.k0 != null) {
                        PlayingOnliveFragment.this.k0.setFocusableInTouchMode(true);
                        PlayingOnliveFragment.this.k0.requestFocus();
                    }
                    KeyboardTool.openKeyboard(PlayingOnliveFragment.this.getActivity());
                }
            }, 500);
        }
    }

    public void setShowLike() {
        BubbleLayout bubbleLayout = this.Q;
        if (bubbleLayout != null) {
            bubbleLayout.addHeart(false);
        }
        BubbleLayout bubbleLayout2 = this.R;
        if (bubbleLayout2 != null) {
            bubbleLayout2.addHeart(false);
        }
    }

    public final void setSuperView(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.initAllView(keyboardListenLinearLayout);
    }

    public void showCloseConnection() {
        Context context = this.l;
        CommonAlertDialog.showDialogWithTwo(context, (View) null, "", context.getString(R.string.close_current_connection), (String) null, this.l.getString(R.string.filter_off), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PlayingOnliveFragment.this.closeConnectionMode();
                PlayingOnliveFragment.this.dismissRTCWindow();
                if (PlayingOnliveFragment.this.P != null) {
                    PlayingOnliveFragment.this.P.stopConference();
                    PlayingOnliveFragment.this.P.stopCapture();
                }
            }
        }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, false, false);
    }

    public void showCloseLayout(LiveChatStatistics liveChatStatistics) {
        if (this.t0.getVisibility() != 0) {
            hidePkingHelper();
            try {
                if (!(this.h == null || this.h.dialog == null || !this.h.dialog.isShowing())) {
                    this.h.dismiss();
                }
                if (!(this.i == null || this.i.dialog == null || !this.i.dialog.isShowing())) {
                    this.i.dismiss();
                }
                if (!(this.g == null || this.g.dialog == null || !this.g.dialog.isShowing())) {
                    this.g.dismiss();
                }
                LivePkGiftNoticeDialogFragment.close();
                if (UserCard.isShowing()) {
                    UserCard.getInstance().dismissMenu();
                }
                if (!(this.j == null || this.j.dialog == null || !this.j.dialog.isShowing())) {
                    this.j.dismiss();
                }
                if (this.Y != null) {
                    this.Y.dismiss();
                }
            } catch (Exception unused) {
            }
            if (this.mLiveAnchorModel != null) {
                TrackEventTool.getInstance().trackOther("private_live", "private_live_end");
                if (TextUtils.isEmpty(this.i1)) {
                    LiveHttpUtils.getUserInfoForCard(getContext(), this.e2, this.mLiveAnchorModel.uid, "", Long.valueOf(this.mSessionId), Short.valueOf(this.mSessionType), getFragmentActive());
                } else {
                    D();
                }
                Intent intent = new Intent();
                intent.putExtra("session_type", this.mSessionType);
                intent.putExtra("session_id", this.mSessionId);
                getActivity().setResult(-1, intent);
                ((TextView) this.t0.findViewById(R.id.anchor_name)).setText(this.mLiveAnchorModel.name);
                LoadOptions loadOptions = new LoadOptions();
                loadOptions.imageOnFail = R.drawable.user_bg_round;
                loadOptions.defaultImageResId = R.drawable.user_bg_round;
                RoundedImageView roundedImageView = (RoundedImageView) this.t0.findViewById(R.id.anchor_header);
                roundedImageView.loadImage(this.mLiveAnchorModel.avatar, loadOptions, (ImageLoadingListener) null);
                roundedImageView.setOnClickListener(this);
                ResourceUtils.setVerifyImg((ImageView) this.t0.findViewById(R.id.img_verify), this.mLiveAnchorModel.vbadge, "", 1);
                View findViewById = this.t0.findViewById(R.id.live_end_time_layout);
                TextView textView = (TextView) this.t0.findViewById(R.id.live_end_duration);
                if (liveChatStatistics != null) {
                    int i3 = liveChatStatistics.elapseTimeSec;
                    if (i3 == 0) {
                        findViewById.setVisibility(8);
                    } else {
                        textView.setText(DateUtils.formatTimer((long) i3));
                    }
                } else {
                    findViewById.setVisibility(8);
                }
                C();
                this.t0.setVisibility(0);
                BoxProgressView boxProgressView = this.u1;
                if (boxProgressView != null) {
                    boxProgressView.setVisibility(4);
                }
                BoxProgressView boxProgressView2 = this.v1;
                if (boxProgressView2 != null) {
                    boxProgressView2.setVisibility(4);
                }
                CommonAnimationUtils.startLiveErrorAnim(this.t0);
                if (this.f1) {
                    LiveHttpUtils.getRecommendedPrivateLives(this.o2, this.p2, getFragmentActive());
                }
            }
        }
    }

    public void showErrorLayout(final LiveEnterFailedReason liveEnterFailedReason, final LiveChatStatistics liveChatStatistics) {
        "reason = " + liveEnterFailedReason;
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.hidePkingHelper();
                try {
                    if (!(PlayingOnliveFragment.this.h == null || PlayingOnliveFragment.this.h.dialog == null || !PlayingOnliveFragment.this.h.dialog.isShowing())) {
                        PlayingOnliveFragment.this.h.dismiss();
                    }
                    if (!(PlayingOnliveFragment.this.i == null || PlayingOnliveFragment.this.i.dialog == null || !PlayingOnliveFragment.this.i.dialog.isShowing())) {
                        PlayingOnliveFragment.this.i.dismiss();
                    }
                    LivePkGiftNoticeDialogFragment.close();
                    if (!(PlayingOnliveFragment.this.g == null || PlayingOnliveFragment.this.g.dialog == null || !PlayingOnliveFragment.this.g.dialog.isShowing())) {
                        PlayingOnliveFragment.this.g.dismiss();
                    }
                    if (!(PlayingOnliveFragment.this.j == null || PlayingOnliveFragment.this.j.dialog == null || !PlayingOnliveFragment.this.j.dialog.isShowing())) {
                        PlayingOnliveFragment.this.j.dismiss();
                    }
                    PkBoxDetailsDialog.close();
                    PkBoxGetGiftDialog.close();
                } catch (Exception unused) {
                }
                KeyboardTool.closeKeyboard(PlayingOnliveFragment.this.getActivity());
                LiveEnterFailedReason liveEnterFailedReason = liveEnterFailedReason;
                if (liveEnterFailedReason == LiveEnterFailedReason.BLOCKED_BY_PEER) {
                    PlayingOnliveFragment.this.C0.setText(PlayingOnliveFragment.this.getResources().getString(R.string.liveVideo_livingView_tips_youInHostBlacklist));
                } else if (liveEnterFailedReason == LiveEnterFailedReason.BLOCK_PEER) {
                    PlayingOnliveFragment.this.C0.setText(PlayingOnliveFragment.this.getResources().getString(R.string.liveVideo_livingView_tips_hostInBlacklist));
                } else if (liveEnterFailedReason == LiveEnterFailedReason.LIVEROOM_FULL) {
                    PlayingOnliveFragment.this.C0.setText(PlayingOnliveFragment.this.getResources().getString(R.string.liveVideo_livingView_tips_tooManyViewers));
                } else if (liveEnterFailedReason == LiveEnterFailedReason.LIVEROOM_KICKED_OUT) {
                    PlayingOnliveFragment.this.C0.setText(PlayingOnliveFragment.this.getResources().getString(R.string.live_kick_user_for_audience));
                } else if (liveEnterFailedReason == LiveEnterFailedReason.LIVEROOM_CLOSE) {
                    PlayingOnliveFragment.this.showCloseLayout(liveChatStatistics);
                    return;
                } else {
                    if (PlayingOnliveFragment.this.O != null) {
                        PlayingOnliveFragment.this.O.postLiveInterrupt();
                    }
                    PlayingOnliveFragment.this.C0.setText(PlayingOnliveFragment.this.getResources().getString(R.string.liveVideo_livingView_tips_networkUnstable));
                }
                PlayingOnliveFragment.this.r0.setVisibility(0);
                CommonAnimationUtils.startLiveErrorAnim(PlayingOnliveFragment.this.r0);
            }
        });
    }

    public void showExitLive() {
        Context context = this.l;
        CommonAlertDialog.showDialogWithTwo(context, (View) null, "", context.getString(R.string.confirm_exit_from_live_stream), (String) null, (String) null, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                LiveFloatManager.getInstance().close();
                PlayingOnliveFragment.this.finish();
            }
        }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, false, false);
    }

    public void showFirstCharge(String str) {
        this.U.setVisibility(0);
        this.V.setText(str);
    }

    public void showInterrruptLayout(final LiveCloseReason liveCloseReason, final LiveChatStatistics liveChatStatistics) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                KeyboardTool.closeKeyboard(PlayingOnliveFragment.this.getActivity());
                if (!(PlayingOnliveFragment.this.j == null || PlayingOnliveFragment.this.j.dialog == null || !PlayingOnliveFragment.this.j.dialog.isShowing())) {
                    PlayingOnliveFragment.this.j.dismiss();
                }
                if (PlayingOnliveFragment.this.Y != null) {
                    PlayingOnliveFragment.this.Y.dismiss();
                }
                PkBoxDetailsDialog.close();
                PkBoxGetGiftDialog.close();
                LiveCloseReason liveCloseReason = liveCloseReason;
                if (liveCloseReason == LiveCloseReason.CLOSED_BY_LIVER) {
                    PlayingOnliveFragment.this.showCloseLayout(liveChatStatistics);
                } else if (liveCloseReason == LiveCloseReason.CLOSED_BY_MANAGER) {
                    PlayingOnliveFragment.this.J();
                } else {
                    PlayingOnliveFragment.this.A0.setText(PlayingOnliveFragment.this.getString(R.string.liveVideo_livingView_tips_liveIsOver));
                    PlayingOnliveFragment.this.s0.setVisibility(0);
                    if (PlayingOnliveFragment.this.u1 != null) {
                        PlayingOnliveFragment.this.u1.setVisibility(4);
                    }
                    if (PlayingOnliveFragment.this.v1 != null) {
                        PlayingOnliveFragment.this.v1.setVisibility(4);
                    }
                    CommonAnimationUtils.startLiveErrorAnim(PlayingOnliveFragment.this.s0);
                }
            }
        });
    }

    public void showInvite() {
        if (!this.f2 && !this.isRTCModel) {
            if (ChannelManager.getIsFloat()) {
                CommonAlertDialog.showDialogWithTwo(getActivity(), (View) null, "", getString(R.string.live_channeling_warn), getString(R.string.live_channeling_cancel), getString(R.string.live_channeling_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        ChannelManager.getInstance().endVideoCall();
                        DialogUtils.showDialog(PlayingOnliveFragment.this.P0);
                        PlayingOnliveFragment.this.postDelaySafeRunOnUiThread(new Runnable() {
                            public void run() {
                                DialogUtils.closeDialog(PlayingOnliveFragment.this.P0);
                                if (PlayingOnliveFragment.this.P != null) {
                                    PlayingRTCManager Z = PlayingOnliveFragment.this.P;
                                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                    Z.applyJoinLive(playingOnliveFragment.mSessionType, playingOnliveFragment.mSessionId, 1);
                                    PlayingOnliveFragment.this.isRefuse = false;
                                }
                                boolean unused = PlayingOnliveFragment.this.f2 = false;
                            }
                        }, 2000);
                    }
                }, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (PlayingOnliveFragment.this.P != null) {
                            PlayingRTCManager Z = PlayingOnliveFragment.this.P;
                            PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                            Z.applyJoinLive(playingOnliveFragment.mSessionType, playingOnliveFragment.mSessionId, 2);
                            PlayingOnliveFragment.this.isRefuse = true;
                        }
                    }
                }, (DialogInterface.OnCancelListener) null, false);
            } else {
                n();
            }
        }
    }

    public void showPkingHelper() {
        if (this.mLivePkingView.animStatus != -1) {
            ImageView imageView = this.D1;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
    }

    public void showRTCLoading() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.mRemoteLoadingLayoutB.setVisibility(0);
            }
        });
    }

    public void showRTCWindow() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.mRemoteWindowB.setVisibility(0);
                PlayingOnliveFragment.this.mRemoteGLSurfaceViewB.setVisibility(0);
            }
        });
    }

    public void showThiefCardDialog(LivePkGiftModel livePkGiftModel) {
        if (livePkGiftModel != null) {
            LivePkGiftNoticeDialogFragment.show(getFragmentManager(), livePkGiftModel, new LivePkGiftNoticeDialogFragment.OnGoGiftknapsackListener() {
                public void onGoGiftknapsack() {
                    PlayingOnliveFragment.this.d0.show();
                }
            });
        }
    }

    public void showTicketView() {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                if (LiveFloatManager.getInstance().mLiveTicket == null || LiveFloatManager.getInstance().mLiveTicket.hasPaid || LiveFloatManager.getInstance().mLiveTicket.is_private_charge <= 0) {
                    PlayingOnliveFragment.this.p1.setVisibility(8);
                } else {
                    PlayingOnliveFragment.this.p1.showView(LiveFloatManager.getInstance().mLiveTicket.price);
                }
            }
        });
    }

    public void showView() {
        setBottomLayoutVisible(0);
        this.liveMsgManager.setChatViewVisibility(0);
    }

    public void startPK(final LivePkInviteModel livePkInviteModel) {
        this.pkMode = livePkInviteModel.pk_type;
        setLiveState(2);
        changeRemoteWindow();
        dismissRTCWindow();
        dismissRTCLoading();
        this.t1.setVisibility(8);
        this.mOutUserA.setVisibility(8);
        this.mLivePkingView.setPerTopInfo(livePkInviteModel.top_info);
        LivePkingView livePkingView = this.mLivePkingView;
        int i3 = livePkInviteModel.pk_type;
        int i4 = livePkInviteModel.reflesh;
        int i5 = livePkInviteModel.status;
        int i6 = (int) livePkInviteModel.countdown;
        LiveAnchorModel liveAnchorModel = this.mLiveAnchorModel;
        String str = liveAnchorModel == null ? "" : liveAnchorModel.avatar;
        LiveAnchorModel liveAnchorModel2 = this.mLiveAnchorModel;
        livePkingView.startPkAnimator(i3, i4, i5, i6, i3, str, liveAnchorModel2 == null ? "" : liveAnchorModel2.name, livePkInviteModel.avatar, livePkInviteModel.name);
        if (livePkInviteModel.has_protect == 1) {
            postDelaySafeRunOnUiThread(new Runnable() {
                public void run() {
                    List<ProtectionCoverModel> list = livePkInviteModel.protect_info.records;
                    if (list != null && list.size() == 2) {
                        ProtectionCoverModel protectionCoverModel = livePkInviteModel.protect_info.records.get(0);
                        if (protectionCoverModel != null && protectionCoverModel.alter == 1) {
                            LiveProtectionCoverUpdateModel liveProtectionCoverUpdateModel = livePkInviteModel.protect_info;
                            protectionCoverModel.uid = liveProtectionCoverUpdateModel.uid;
                            protectionCoverModel.timestamp = liveProtectionCoverUpdateModel.timestamp;
                            PlayingOnliveFragment.this.I1.refreshProtectionCover(protectionCoverModel);
                        }
                        ProtectionCoverModel protectionCoverModel2 = livePkInviteModel.protect_info.records.get(1);
                        if (protectionCoverModel2 != null && protectionCoverModel2.alter == 1) {
                            protectionCoverModel2.is_enemy = 1;
                            LiveProtectionCoverUpdateModel liveProtectionCoverUpdateModel2 = livePkInviteModel.protect_info;
                            protectionCoverModel2.uid = liveProtectionCoverUpdateModel2.uid;
                            protectionCoverModel2.timestamp = liveProtectionCoverUpdateModel2.timestamp;
                            PlayingOnliveFragment.this.P1.refreshProtectionCover(protectionCoverModel2);
                        }
                    }
                }
            }, 1300);
        }
        if (this.D1.getVisibility() != 4) {
            this.D1.setVisibility(0);
        }
        long j3 = 0;
        List<LivePKPlayerModel> list = livePkInviteModel.records;
        if (list != null && list.size() >= 2) {
            setBuffVisible(livePkInviteModel.records.get(0).buff, livePkInviteModel.records.get(1).buff);
            this.mLivePkingView.refreshPKProgress(livePkInviteModel.records.get(0).score, livePkInviteModel.records.get(1).score);
            j3 = (long) (livePkInviteModel.records.get(0).score + livePkInviteModel.records.get(1).score);
        }
        "pk状态开始 : treasure_status = " + livePkInviteModel.treasure_status + "treasure_repeat = " + livePkInviteModel.treasure_repeat;
        setProgress(livePkInviteModel.treasure_status, livePkInviteModel.treasure_repeat, j3, livePkInviteModel.treasure_score);
        this.f = true;
        View view = this.G1;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (PlayingOnliveFragment.this.f) {
                        int livePKIntentCount = LivePreferencesUtils.getLivePKIntentCount();
                        if (livePKIntentCount < 3) {
                            LivePreferencesUtils.setLivePkIntentCount(livePKIntentCount + 1);
                            LivePkDialogFragment.show(PlayingOnliveFragment.this.getFragmentManager(), PlayingOnliveFragment.this.getResources().getString(R.string.live_pk_center_hint_tips), PlayingOnliveFragment.this.getResources().getString(R.string.live_pk_intent_hint), 1, PlayingOnliveFragment.this.getResources().getString(R.string.live_pk_intent_no_hint), PlayingOnliveFragment.this.getResources().getString(R.string.live_pk_matching_cancel), PlayingOnliveFragment.this.getResources().getString(R.string.live_pk_language_confirm), new LivePkDialogFragment.OnClickButtonListener() {
                                public void onClickLeftButtonListener(View view) {
                                }

                                public void onClickRightButtonListener(View view) {
                                    AnonymousClass76 r2 = AnonymousClass76.this;
                                    PlayingOnliveFragment.this.a(livePkInviteModel);
                                }
                            });
                            return;
                        }
                        PlayingOnliveFragment.this.a(livePkInviteModel);
                    }
                }
            });
        }
    }

    public void startTimer() {
    }

    public void stopPK() {
        LinearLayout linearLayout = this.t1;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        setLiveState(0);
        this.I1.clear();
        this.P1.clear();
        this.I1.clearCountDown();
        this.P1.clearCountDown();
        this.mLivePkingView.clearThieCardQueue();
        this.mLivePkingView.clearAdditionAndSubtractionQueue();
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.startColor = getResources().getColor(R.color.black);
        shapeModel.endColor = getResources().getColor(R.color.black);
        ShapeFrameLayout shapeFrameLayout = this.X1;
        if (shapeFrameLayout != null) {
            shapeFrameLayout.setShapeModel(shapeModel);
        }
        LivePkingView livePkingView = this.mLivePkingView;
        if (livePkingView != null) {
            livePkingView.reset();
            this.mLivePkingView.setVisibility(8);
        }
        ImageView imageView = this.D1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            LiveFloatManager.getInstance().resetSurfaceParamsPkEnd();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = AppInfo.screenWidthForPortrait;
            layoutParams.height = AppInfo.screenHeightForPortrait;
            layoutParams.topMargin = 0;
            this.k.setLayoutParams(layoutParams);
        }
        dismissRTCWindow();
        View view = this.G1;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public void stopTimer() {
    }

    public void updataLiveInfo(LiveAnchorModel liveAnchorModel) {
        this.mLiveAnchorModel = liveAnchorModel;
        LiveAnchorModel liveAnchorModel2 = this.mLiveAnchorModel;
        if (liveAnchorModel2 != null) {
            this.q1 = liveAnchorModel2.live_type;
            if (this.q1 == 2) {
                this.f1 = true;
            }
            UserCard.getInstance().update(this.mLiveAnchorModel.uid, this.q1);
        }
        LiveMsgManager liveMsgManager2 = this.liveMsgManager;
        if (liveMsgManager2 != null) {
            liveMsgManager2.setLiveType(liveAnchorModel.live_type);
        }
        setAnchorData();
        G();
    }

    public void useCardDispatcher(PropCardModel propCardModel) {
        if (propCardModel != null && propCardModel.type == 1) {
            a(propCardModel);
        }
    }

    public void visibleEmbedmentDialog(final LiveEmbedmentModel liveEmbedmentModel) {
        LiveEmbedmentDialogFragment liveEmbedmentDialogFragment = this.g;
        if (liveEmbedmentDialogFragment != null) {
            Dialog dialog = liveEmbedmentDialogFragment.dialog;
            if (dialog != null && dialog.isShowing()) {
                return;
            }
        }
        if (TextUtils.isEmpty(LivePreferencesUtils.getLiveEmbedmentVisible(liveEmbedmentModel.id))) {
            LivePreferencesUtils.setLiveEmbedmentIdVisible(liveEmbedmentModel.id);
            postDelaySafeRunOnUiThread(new Runnable() {
                public void run() {
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    FragmentManager fragmentManager = playingOnliveFragment.getFragmentManager();
                    LiveEmbedmentModel liveEmbedmentModel = liveEmbedmentModel;
                    LiveEmbedmentDialogFragment unused = playingOnliveFragment.g = LiveEmbedmentDialogFragment.show(fragmentManager, liveEmbedmentModel.title, liveEmbedmentModel.content);
                }
            }, 500);
        }
    }

    public final void A() {
        this.k0.post(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.mList.get(0).findViewById(R.id.live_msg_content_pullrefresh).getLayoutParams().width = PlayingOnliveFragment.this.k0.getWidth() + PlayingOnliveFragment.this.m0.getWidth() + PlayingOnliveFragment.this.o0.getWidth();
            }
        });
    }

    public final void B() {
        if (this.liveMsgManager != null && this.mLiveAnchorModel != null) {
            final HashMap hashMap = new HashMap();
            hashMap.put("in_fan_club", this.is_member + "");
            hashMap.put("fan_club_level", this.fanLevel + "");
            hashMap.put("fan_club_badge_hidden", this.fan_club_badge_hidden + "");
            if (!this.Z0) {
                String obj = this.k0.getText().toString();
                this.s2.clear();
                this.liveMsgManager.sendText(obj, hashMap, new LiveMsgControler.SendMsgListener() {
                    public void onSendErrorListener() {
                    }

                    public void onSendOkListener() {
                        PlayingOnliveFragment.this.k0.setText("");
                    }
                });
                LiveServiceLogTool.liveroomInsideAction(this.mLiveAnchorModel.uid, this.mSessionId, OnliveConstant.LIVE_ACTION.comment, this.e1);
            } else if (StringUtils.isEmpty(this.k0.getText().toString())) {
                LogUtils.showToastN((int) R.string.chat_send_alert);
            } else {
                this.l0.setClickable(false);
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.contents = this.k0.getText().toString();
                liveGiftModel.goods_id = String.valueOf(this.a1);
                if (getFragmentActive().isActive()) {
                    LiveGiftPayTools.getInstance().checkGiftPayStatus(getActivity(), this.mSessionType, this.mSessionId, (IRequestHost) null, liveGiftModel, this.mLiveAnchorModel.uid, "", 1, new LiveGiftPayTools.BackGiftStatusListener() {
                        public void goToPay() {
                            LiveFloatManager.getInstance().displayFloatView(PlayingOnliveFragment.this.mTimer);
                            PlayingOnliveFragment.this.finish();
                        }

                        public void onGiftStatus(final LiveGiftModel liveGiftModel, final LiveGiftModel liveGiftModel2, final LiveZanExtraModel liveZanExtraModel) {
                            PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                                public void run() {
                                    PlayingOnliveFragment.this.l0.setClickable(true);
                                    if (liveGiftModel2.sendGiftStatus == 3) {
                                        String userId = UserInfo.getInstance().getUserId();
                                        String vBadge = UserInfo.getInstance().getLoginUserInfo().getVBadge();
                                        ChattingModel chattingModel = new ChattingModel();
                                        chattingModel.fromId = Long.valueOf(userId).longValue();
                                        chattingModel.fromVBadge = Integer.valueOf(vBadge).intValue();
                                        chattingModel.fromAvatar = UserInfo.getInstance().getLoginUserInfo().getAvatar();
                                        chattingModel.fromNickName = UserInfo.getInstance().getLoginUserInfo().getName();
                                        chattingModel.msgContent = liveGiftModel.contents;
                                        chattingModel.msgType = 37;
                                        chattingModel.fromRichLevel = UserInfo.getInstance().getLoginUserInfo().getWealth_level();
                                        chattingModel.avatarPendant = LivePreferencesUtils.getLiveAvatarPendant();
                                        AnonymousClass30 r0 = AnonymousClass30.this;
                                        chattingModel.msgMapExtra = hashMap;
                                        PlayingOnliveFragment.this.addDanmaku(chattingModel);
                                        int unused = PlayingOnliveFragment.this.c1 = liveZanExtraModel.barrage_left;
                                        int unused2 = PlayingOnliveFragment.this.b1 = liveZanExtraModel.barrage_total;
                                        PlayingOnliveFragment.this.F();
                                        PlayingOnliveFragment.this.k0.setText("");
                                        PlayingOnliveFragment.this.d0.refreshRemainingCount(String.valueOf(liveGiftModel2.beans));
                                        PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                        LiveGiftModel liveGiftModel = liveGiftModel2;
                                        playingOnliveFragment.notifyUpdateBeans((double) liveGiftModel.beans_count, (double) liveGiftModel.beans_current_count);
                                    }
                                }
                            });
                        }
                    }, this.liveMsgManager);
                    LiveServiceLogTool.liveroomInsideAction(this.mLiveAnchorModel.uid, this.mSessionId, OnliveConstant.LIVE_ACTION.danmu, this.e1);
                }
            }
        }
    }

    public final void C() {
        if ("0".equals(this.i1) || "2".equals(this.i1)) {
            this.u0.setBackgroundResource(R.drawable.live_end_unfollowed_bg);
            this.v0.setImageResource(R.drawable.ic_live_end_plus);
            this.w0.setTextColor(-1);
            this.w0.setText(R.string.attention_follow);
            return;
        }
        this.u0.setBackgroundResource(R.drawable.live_end_following_bg);
        this.v0.setImageResource(R.drawable.ic_live_end_right);
        this.w0.setTextColor(Color.parseColor("#565FFC"));
        this.w0.setText(R.string.following);
    }

    public final void D() {
        if (!StringUtils.isEmpty(this.i1)) {
            if ("0".equals(this.i1) || "2".equals(this.i1)) {
                this.o.setVisibility(0);
                View view = this.p;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                this.o.setVisibility(8);
                View view2 = this.p;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            this.o0.performClick();
        }
    }

    public final void E() {
        if (this.mLiveAnchorModel != null) {
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.imageOnFail = R.drawable.default_aero;
            loadOptions.defaultImageResId = R.drawable.default_aero;
            this.mHeaderBgView.loadImage(this.mLiveAnchorModel.avatar, loadOptions, (ImageLoadingListener) new BaseImageLoadingListener() {
                /* JADX WARNING: type inference failed for: r1v3, types: [android.graphics.drawable.Drawable] */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onLoadingComplete(String r1, com.blued.android.core.imagecache.view.RecyclingImageView r2, com.blued.android.core.imagecache.LoadOptions r3, android.graphics.drawable.Drawable r4, boolean r5) {
                    /*
                        r0 = this;
                        super.onLoadingComplete(r1, r2, r3, r4, r5)
                        boolean r2 = r4 instanceof android.graphics.drawable.BitmapDrawable
                        if (r2 == 0) goto L_0x000a
                        android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
                        goto L_0x0011
                    L_0x000a:
                        android.graphics.drawable.Drawable r1 = com.blued.android.core.imagecache.RecyclingImageLoader.getMemoryCache(r1, r3)
                        r4 = r1
                        android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
                    L_0x0011:
                        if (r4 == 0) goto L_0x0028
                        android.content.Context r1 = com.blued.android.core.AppInfo.getAppContext()     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        android.graphics.Bitmap r2 = r4.getBitmap()     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        r3 = 20
                        android.graphics.Bitmap r1 = com.blued.android.core.utils.AeroGlassUtils.fastblur(r1, r2, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        com.blued.international.ui.live.fragment.PlayingOnliveFragment r2 = com.blued.international.ui.live.fragment.PlayingOnliveFragment.this     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView r2 = r2.mHeaderBgView     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        r2.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                    L_0x0028:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blued.international.ui.live.fragment.PlayingOnliveFragment.AnonymousClass21.onLoadingComplete(java.lang.String, com.blued.android.core.imagecache.view.RecyclingImageView, com.blued.android.core.imagecache.LoadOptions, android.graphics.drawable.Drawable, boolean):void");
                }
            });
        }
    }

    public final void F() {
        String str;
        if (this.c1 == 0) {
            str = String.format(getResources().getString(R.string.LiveVideo_danmaku_hint), new Object[]{Long.valueOf(this.d1)});
        } else {
            str = String.format(getString(R.string.free_danmu_hint), new Object[]{Integer.valueOf(this.c1), Integer.valueOf(this.b1)});
        }
        this.k0.setHint(str);
    }

    public final void G() {
        if (this.mHeaderBgView != null) {
            LiveAnchorModel liveAnchorModel = this.mLiveAnchorModel;
            if (liveAnchorModel == null || liveAnchorModel.live_type != 3) {
                Bitmap netImageBitmap = ImageUtils.getNetImageBitmap(this.mPicUrl, this.mOptions);
                if (netImageBitmap != null) {
                    try {
                        this.mHeaderBgView.setImageBitmap(AeroGlassUtils.fastblur(AppInfo.getAppContext(), netImageBitmap, 11));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    E();
                }
            } else {
                VoiceLayout voiceLayout = (VoiceLayout) this.mRootView.findViewById(R.id.ll_live_voice_layer);
                if (voiceLayout != null) {
                    voiceLayout.setVisibility(0);
                    voiceLayout.showAnimView();
                    voiceLayout.setBlurLayer(this.mLiveAnchorModel.avatar);
                }
            }
            if (this.f1) {
                this.E.setImageResource(R.drawable.live_watermark_private_icon);
                ImageView imageView = this.F;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.live_watermark_private_icon);
                }
            } else {
                LiveAnchorModel liveAnchorModel2 = this.mLiveAnchorModel;
                if (liveAnchorModel2 != null && liveAnchorModel2.live_type == 3) {
                    this.E.setImageResource(R.drawable.live_watermark_voice_icon);
                    ImageView imageView2 = this.F;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.live_watermark_voice_icon);
                    }
                }
            }
            if (this.q1 == 3 && LivePreferencesUtils.isDisplayVoiceLiveTip()) {
                LivePreferencesUtils.setDisplayVoiceLiveTip(false);
                VoiceLiveTipDialog voiceLiveTipDialog = new VoiceLiveTipDialog(getActivity());
                voiceLiveTipDialog.setCancelable(false);
                voiceLiveTipDialog.showDialog();
            }
        }
    }

    public final void H() {
        LiveFansPlayingDialogFragment liveFansPlayingDialogFragment = this.h;
        if (liveFansPlayingDialogFragment != null) {
            if (liveFansPlayingDialogFragment != null) {
                Dialog dialog = liveFansPlayingDialogFragment.dialog;
                if (dialog == null || dialog.isShowing()) {
                    return;
                }
            } else {
                return;
            }
        }
        this.h = LiveFansPlayingDialogFragment.showDialog(getChildFragmentManager(), this.mLiveAnchorModel.uid + "", this.mSessionId + "", new LiveFansPlayingDialogFragment.OnGiveGiftClickListener() {
            public void onGiveGiftClick(View view, int i) {
                if (i == 2) {
                    if (PlayingOnliveFragment.this.h != null) {
                        PlayingOnliveFragment.this.h.dismiss();
                    }
                    if (PlayingOnliveFragment.this.d0 != null) {
                        PlayingOnliveFragment.this.d0.show(0);
                    }
                } else if (i == 3) {
                    PlayingOnliveFragment.this.m();
                }
            }

            public void onMorePriviegeClick(View view) {
                if (!(PlayingOnliveFragment.this.h == null || PlayingOnliveFragment.this.h.dialog == null || !PlayingOnliveFragment.this.h.dialog.isShowing())) {
                    PlayingOnliveFragment.this.h.dismiss();
                }
                PlayingOnliveFragment.this.b(BluedHttpUrl.getLiveFanClubUrl());
            }
        });
    }

    public final void I() {
        if (!this.isSimpleModel) {
            this.liveMsgManager.showLayout();
            this.a0.setVisibility(0);
        }
        this.f = false;
        this.W.setVisibility(0);
        this.liveMsgManager.setGiftVisibility(0);
        this.w.setVisibility(0);
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.y.setVisibility(0);
        ImageView imageView2 = this.z;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        showPkingHelper();
        this.q.setVisibility(this.f1 ? 8 : 0);
        EditText editText = this.k0;
        if (editText != null && StringUtils.isEmail(editText.getText().toString())) {
            this.k0.clearFocus();
        }
        LivePkingView livePkingView = this.mLivePkingView;
        if (livePkingView != null) {
            livePkingView.getContributionKeyboardView().setVisibility(0);
        }
        if (this.u2) {
            FrameLayout frameLayout = this.L;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }
        this.D0.setVisibility(0);
        this.t1.setVisibility(0);
        ((ViewGroup.MarginLayoutParams) this.B1.getLayoutParams()).topMargin = 0;
    }

    public final void J() {
        Intent intent = new Intent();
        intent.putExtra("session_type", this.mSessionType);
        intent.putExtra("session_id", this.mSessionId);
        getActivity().setResult(-1, intent);
        if (this.mLiveAnchorModel != null) {
            ((TextView) this.y0.findViewById(R.id.live_end_banned_name)).setText(this.mLiveAnchorModel.name);
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.imageOnFail = R.drawable.user_bg_round;
            loadOptions.defaultImageResId = R.drawable.user_bg_round;
            RoundedImageView roundedImageView = (RoundedImageView) this.y0.findViewById(R.id.live_end_banned_header);
            roundedImageView.loadImage(this.mLiveAnchorModel.avatar, loadOptions, (ImageLoadingListener) null);
            roundedImageView.setOnClickListener(this);
            final AutoAttachRecyclingImageView autoAttachRecyclingImageView = (AutoAttachRecyclingImageView) this.y0.findViewById(R.id.live_end_banned_bg);
            autoAttachRecyclingImageView.loadImage(this.mLiveAnchorModel.avatar, (LoadOptions) null, (ImageLoadingListener) new BaseImageLoadingListener() {
                /* JADX WARNING: type inference failed for: r1v3, types: [android.graphics.drawable.Drawable] */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onLoadingComplete(String r1, com.blued.android.core.imagecache.view.RecyclingImageView r2, com.blued.android.core.imagecache.LoadOptions r3, android.graphics.drawable.Drawable r4, boolean r5) {
                    /*
                        r0 = this;
                        super.onLoadingComplete(r1, r2, r3, r4, r5)
                        boolean r2 = r4 instanceof android.graphics.drawable.BitmapDrawable
                        if (r2 == 0) goto L_0x000a
                        android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
                        goto L_0x0011
                    L_0x000a:
                        android.graphics.drawable.Drawable r1 = com.blued.android.core.imagecache.RecyclingImageLoader.getMemoryCache(r1, r3)
                        r4 = r1
                        android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
                    L_0x0011:
                        if (r4 == 0) goto L_0x0028
                        android.graphics.Bitmap r1 = r4.getBitmap()     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        com.blued.international.ui.live.fragment.PlayingOnliveFragment r2 = com.blued.international.ui.live.fragment.PlayingOnliveFragment.this     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        androidx.fragment.app.FragmentActivity r2 = r2.getActivity()     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        r3 = 20
                        android.graphics.Bitmap r1 = com.blued.android.core.utils.AeroGlassUtils.fastblur(r2, r1, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView r2 = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                        r2.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
                    L_0x0028:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blued.international.ui.live.fragment.PlayingOnliveFragment.AnonymousClass53.onLoadingComplete(java.lang.String, com.blued.android.core.imagecache.view.RecyclingImageView, com.blued.android.core.imagecache.LoadOptions, android.graphics.drawable.Drawable, boolean):void");
                }
            });
            BoxProgressView boxProgressView = this.u1;
            if (boxProgressView != null) {
                boxProgressView.setVisibility(4);
            }
            BoxProgressView boxProgressView2 = this.v1;
            if (boxProgressView2 != null) {
                boxProgressView2.setVisibility(4);
            }
            this.y0.setVisibility(0);
            CommonAnimationUtils.startLiveErrorAnim(this.y0);
        }
    }

    public void addDanmaku(EntranceData entranceData) {
        this.liveMsgManager.addDanmaku(entranceData);
    }

    public final void m() {
        LiveHttpUtils.updateFansInfo(this.mLiveAnchorModel.uid + "", 1, new BluedUIHttpResponse<BluedEntityA<LiveJoinFransModel>>(getFragmentActive()) {
            public void onUIFinish() {
                super.onUIFinish();
            }

            public void onUIStart() {
                super.onUIStart();
            }

            public void onUIUpdate(BluedEntityA<LiveJoinFransModel> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.code == 200) {
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    playingOnliveFragment.is_member = 1;
                    playingOnliveFragment.postSafeRunOnUiThread(new Runnable() {
                        public void run() {
                            if (!(PlayingOnliveFragment.this.i == null || PlayingOnliveFragment.this.i.dialog == null || !PlayingOnliveFragment.this.i.dialog.isShowing())) {
                                PlayingOnliveFragment.this.i.dismiss();
                                FragmentManager fragmentManager = PlayingOnliveFragment.this.getFragmentManager();
                                LiveAnchorModel liveAnchorModel = PlayingOnliveFragment.this.mLiveAnchorModel;
                                LiveResultSuccessDialogFragment.show(fragmentManager, liveAnchorModel.uid, liveAnchorModel.name, (LiveResultSuccessDialogFragment.OnClickButtonListener) null);
                            }
                            if (PlayingOnliveFragment.this.h != null && PlayingOnliveFragment.this.h.dialog != null && PlayingOnliveFragment.this.h.dialog.isShowing()) {
                                PlayingOnliveFragment.this.h.refresh();
                            }
                        }
                    });
                }
            }
        }, getFragmentActive());
    }

    public final void n() {
        this.f2 = true;
        Context context = this.l;
        CommonAlertDialog.showDialogWithTwo(context, (View) null, "", context.getString(R.string.invited_you_connect), this.l.getString(R.string.reject), this.l.getString(R.string.accept), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (PlayingOnliveFragment.this.P != null) {
                    PlayingRTCManager Z = PlayingOnliveFragment.this.P;
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    Z.applyJoinLive(playingOnliveFragment.mSessionType, playingOnliveFragment.mSessionId, 1);
                    PlayingOnliveFragment.this.isRefuse = false;
                }
                boolean unused = PlayingOnliveFragment.this.f2 = false;
            }
        }, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (PlayingOnliveFragment.this.P != null) {
                    PlayingRTCManager Z = PlayingOnliveFragment.this.P;
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    Z.applyJoinLive(playingOnliveFragment.mSessionType, playingOnliveFragment.mSessionId, 2);
                    PlayingOnliveFragment.this.isRefuse = true;
                }
                boolean unused = PlayingOnliveFragment.this.f2 = false;
            }
        }, new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                boolean unused = PlayingOnliveFragment.this.f2 = false;
            }
        }, false, false);
    }

    public final void o() {
        CountDownTimer countDownTimer = this.t2;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r1.getVisibility() == 0) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p() {
        /*
            r3 = this;
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.widget.RelativeLayout r0 = r3.D0
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 70
            android.view.View r1 = r3.U0
            if (r1 == 0) goto L_0x0018
            int r1 = r1.getVisibility()
            if (r1 == 0) goto L_0x0022
        L_0x0018:
            com.blued.international.ui.live.bizview.RTCUserInfoLayout r1 = r3.o1
            if (r1 == 0) goto L_0x0024
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0024
        L_0x0022:
            r0 = 100
        L_0x0024:
            android.view.View r1 = r3.U0
            if (r1 == 0) goto L_0x003a
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x003a
            com.blued.international.ui.live.bizview.RTCUserInfoLayout r1 = r3.o1
            if (r1 == 0) goto L_0x003a
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x003a
            r0 = 130(0x82, float:1.82E-43)
        L_0x003a:
            com.blued.international.ui.live.bizview.BoxProgressView r1 = r3.u1
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            android.content.Context r2 = r3.getContext()
            float r0 = (float) r0
            int r0 = com.blued.android.framework.utils.UiUtils.dip2px(r2, r0)
            r1.topMargin = r0
            com.blued.international.ui.live.bizview.BoxProgressView r0 = r3.u1
            r0.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.international.ui.live.fragment.PlayingOnliveFragment.p():void");
    }

    public final void q() {
        LiveHttpUtils.getDanmuCount(getFragmentActive(), new BluedUIHttpResponse<BluedEntity<FollowUserModel, LiveDanmuExtra>>(getFragmentActive()) {
            public void onUIUpdate(BluedEntity<FollowUserModel, LiveDanmuExtra> bluedEntity) {
                int unused = PlayingOnliveFragment.this.b1 = ((LiveDanmuExtra) bluedEntity.extra).barrage_total;
                int unused2 = PlayingOnliveFragment.this.c1 = ((LiveDanmuExtra) bluedEntity.extra).barrage_left;
                if (PlayingOnliveFragment.this.Z0) {
                    PlayingOnliveFragment.this.F();
                }
            }
        });
    }

    public final void r() {
        if (this.isSimpleModel) {
            this.liveMsgManager.setGiftVisibility(0);
        } else {
            this.liveMsgManager.hideLayout();
            this.liveMsgManager.setGiftVisibility(8);
        }
        this.f = true;
        this.W.setVisibility(8);
        this.a0.setVisibility(8);
        this.w.setVisibility(4);
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        this.y.setVisibility(4);
        ImageView imageView2 = this.z;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        hidePkingHelper();
        LivePkingView livePkingView = this.mLivePkingView;
        if (livePkingView != null) {
            livePkingView.getContributionKeyboardView().setVisibility(8);
        }
        if (this.u2) {
            FrameLayout frameLayout = this.L;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        this.l0.setVisibility(0);
        this.q.setVisibility(8);
        this.D0.setVisibility(8);
        this.t1.setVisibility(8);
        this.f0.getHeight() + "";
        if (StatusBarHelper.isSupportTranslucentStatus()) {
            ((FrameLayout.LayoutParams) this.B1.getLayoutParams()).setMargins(0, -StatusBarHelper.getStatusBarHeight(this.l), 0, 0);
        }
    }

    public final void s() {
        this.d2 = new FanClubUpLevelManagerImpl();
        this.d2.setPeriod(2000);
        this.d2.setRunnable(new FanClubUpLevelManagerImpl.Runnable() {
            public void dismiss() {
                if (PlayingOnliveFragment.this.Z != null) {
                    PlayingOnliveFragment.this.Z.dismiss();
                }
            }

            public void run(FanClubUpLevelModel fanClubUpLevelModel) {
                if (PlayingOnliveFragment.this.Z != null) {
                    PlayingOnliveFragment.this.Z.dismiss();
                    PlayingOnliveFragment.this.Z.show(fanClubUpLevelModel.fans_name, fanClubUpLevelModel.fans_level);
                }
            }
        });
        this.d2.setRunnableSelf(new FanClubUpLevelManagerImpl.Runnable() {
            public void dismiss() {
                if (PlayingOnliveFragment.this.Y != null) {
                    PlayingOnliveFragment.this.Y.dismiss();
                }
            }

            public void run(FanClubUpLevelModel fanClubUpLevelModel) {
                if (PlayingOnliveFragment.this.d0 != null) {
                    PlayingOnliveFragment.this.d0.dismiss();
                }
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                LiveSelfFanClubUpLevelNoticeDialogFragment unused = playingOnliveFragment.Y = LiveSelfFanClubUpLevelNoticeDialogFragment.show(playingOnliveFragment.getFragmentManager(), fanClubUpLevelModel, new LiveSelfFanClubUpLevelNoticeDialogFragment.OnClickOkListener() {
                    public void onClickOk() {
                        PlayingOnliveFragment.this.d2.runSelf();
                    }
                });
            }
        });
    }

    public final void t() {
        this.liveMsgManager = LiveMsgTools.getInstance().initLiveMsgDataForLiveShow(this, this.q1);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void u() {
        this.D1 = (ImageView) this.mRootView.findViewById(R.id.iv_pk_heler);
        this.D1.setOnClickListener(this);
        this.E1 = (FrameLayout) this.mRootView.findViewById(R.id.fl_webview);
        this.k1 = (GLSurfaceView) this.mRootView.findViewById(R.id.cameraPreview_surfaceView);
        this.mRemoteWindowA = (FrameLayout) this.mRootView.findViewById(R.id.RemoteWindowA);
        this.mRemoteWindowB = (FrameLayout) this.mRootView.findViewById(R.id.RemoteWindowB);
        this.mRemoteGLSurfaceViewA = (RTCSurfaceView) this.mRootView.findViewById(R.id.RemoteGLSurfaceViewA);
        this.mRemoteGLSurfaceViewB = (RTCSurfaceView) this.mRootView.findViewById(R.id.RemoteGLSurfaceViewB);
        this.mOutUserA = (ImageView) this.mRootView.findViewById(R.id.out_userA_btn);
        this.mOutUserB = (ImageView) this.mRootView.findViewById(R.id.out_userB_btn);
        this.mRemoteNameA = (TextView) this.mRootView.findViewById(R.id.remote_nameA);
        this.mRemoteNameB = (TextView) this.mRootView.findViewById(R.id.remote_nameB);
        this.mRemoteLoadingLayoutB = (FrameLayout) this.mRootView.findViewById(R.id.remote_loading_layoutB);
        this.mRemoteLoadingViewB = (AVLoadingIndicatorView) this.mRootView.findViewById(R.id.remote_loading_viewB);
        this.mOutUserA.setOnClickListener(this);
        this.mOutUserB.setOnClickListener(this);
        this.mLivePkingView = (LivePkingView) this.mRootView.findViewById(R.id.live_pking_view);
        LivePkingView livePkingView = this.mLivePkingView;
        int i3 = 0;
        if (livePkingView != null) {
            livePkingView.changeTopMargin((int) (((float) UiUtils.dip2px(getContext(), 135.0f)) + (((float) (AppInfo.screenWidthForPortrait / 2)) * 1.5f)));
            this.mLivePkingView.setRecoding(false);
            this.mLivePkingView.setOnTreasureClickListener(new LivePkingView.OnPkTreasureClickListener() {
                public void onPkTreasureClick(int i, long j, long j2, int i2) {
                    if (i != 1) {
                        if (i == 2) {
                            Context context = PlayingOnliveFragment.this.getContext();
                            FragmentManager fragmentManager = PlayingOnliveFragment.this.getFragmentManager();
                            PkBoxGetGiftDialog.show(context, fragmentManager, PlayingOnliveFragment.this.mSessionId + "", new PkBoxGetGiftDialog.onBoxListener() {
                                public void goToGiftCard() {
                                    PlayingOnliveFragment.this.d0.show(0);
                                }

                                public void onGiftStatusChange(int i, boolean z) {
                                    if (i == 0 || i == 1) {
                                        PlayingOnliveFragment.this.mLivePkingView.setTreasureStatus(2, 1);
                                    }
                                    if (i != 0) {
                                        return;
                                    }
                                    if (z) {
                                        PlayingOnliveFragment.this.n0.setVisibility(0);
                                        PlayingOnliveFragment.this.q();
                                        return;
                                    }
                                    PlayingOnliveFragment.this.d0.setBagNotice();
                                }
                            });
                            return;
                        } else if (i != 3) {
                            return;
                        }
                    }
                    PkBoxDetailsDialog.show(PlayingOnliveFragment.this.getContext(), PlayingOnliveFragment.this.getFragmentManager(), (int) j, (int) j2, i2);
                }
            });
            this.mLivePkingView.setOnThiefCardAnimationEnd(new LivePkingView.OnThiefCardAnimationEnd() {
                public void onThiefCardAnimationEnd(ProtectionCoverModel protectionCoverModel, ProtectionCoverView protectionCoverView) {
                    if (protectionCoverModel != null && protectionCoverView != null) {
                        if (PlayingOnliveFragment.this.getLiveState() != 1 && PlayingOnliveFragment.this.getLiveState() != 2) {
                            return;
                        }
                        if (protectionCoverModel.protect_last_event == 2) {
                            protectionCoverView.brokenProtectiveCover(protectionCoverModel);
                        } else {
                            protectionCoverView.setCrackCount(protectionCoverModel);
                        }
                    }
                }
            });
        }
        this.H1 = (LinearLayout) this.mRootView.findViewById(R.id.ll_protective_cover);
        this.I1 = (ProtectionCoverView) this.mRootView.findViewById(R.id.left_protectionCoverView);
        this.J1 = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.left_broken_protective_cover);
        this.K1 = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.left_protective_cover_light);
        this.L1 = (FrameLayout) this.mRootView.findViewById(R.id.fl_protective_cover_count_left);
        this.M1 = (LinearLayout) this.mRootView.findViewById(R.id.ll_protective_cover_count_left);
        this.N1 = (ShapeTextView) this.mRootView.findViewById(R.id.tv_protective_cover_count_left);
        this.O1 = (ShapeTextView) this.mRootView.findViewById(R.id.tv_protective_cover_time_left);
        this.P1 = (ProtectionCoverView) this.mRootView.findViewById(R.id.right_protectionCoverView);
        this.Q1 = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.right_broken_protective_cover);
        this.R1 = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.right_protective_cover_light);
        this.S1 = (FrameLayout) this.mRootView.findViewById(R.id.fl_protective_cover_count_right);
        this.T1 = (LinearLayout) this.mRootView.findViewById(R.id.ll_protective_cover_count_right);
        this.U1 = (ShapeTextView) this.mRootView.findViewById(R.id.tv_protective_cover_count_right);
        this.V1 = (ShapeTextView) this.mRootView.findViewById(R.id.tv_protective_cover_time_right);
        this.W1 = (LiveGiftPullNoticeView) this.mRootView.findViewById(R.id.gift_pull_notice_view);
        this.I1.setImageView(this.J1);
        this.P1.setImageView(this.Q1);
        this.I1.setLightView(this.K1);
        this.P1.setLightView(this.R1);
        this.I1.setCountDowViews(this.L1, this.M1, this.N1, this.O1);
        this.P1.setCountDowViews(this.S1, this.T1, this.U1, this.V1);
        AnonymousClass11 r02 = new ProtectionCoverView.OnAnimatorEnd() {
            public void onAnimatorEnd() {
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                LivePkingView livePkingView = playingOnliveFragment.mLivePkingView;
                if (livePkingView != null) {
                    livePkingView.startThiefCardAnim(playingOnliveFragment.d0);
                }
            }
        };
        this.I1.setOnAnimatorEnd(r02);
        this.P1.setOnAnimatorEnd(r02);
        LivePkingView livePkingView2 = this.mLivePkingView;
        if (livePkingView2 != null) {
            livePkingView2.setLeftProtectionCoverView(this.I1);
            this.mLivePkingView.setRightProtectionCoverView(this.P1);
        }
        if (Build.VERSION.SDK_INT > 18) {
            this.k1.setVisibility(4);
        } else {
            this.k1.setVisibility(8);
        }
        this.G1 = this.mRootView.findViewById(R.id.view_intent);
        this.X1 = (ShapeFrameLayout) this.mRootView.findViewById(R.id.shape_layout);
        this.B1 = (ViewPager) this.mRootView.findViewById(R.id.view_pager);
        this.B1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (PlayingOnliveFragment.this.y1 != null) {
                    PlayingOnliveFragment.this.y1.setTargetPosition(i);
                }
                if (PlayingOnliveFragment.this.w1 != null) {
                    PlayingOnliveFragment.this.w1.setTargetPosition(i);
                }
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                playingOnliveFragment.onPageChangedActionRank(playingOnliveFragment.k2);
            }
        });
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (PlayingOnliveFragment.this.r != null) {
                    PlayingOnliveFragment.this.r.performClick();
                }
                if (PlayingOnliveFragment.this.G1 != null) {
                    int width = PlayingOnliveFragment.this.G1.getWidth();
                    int height = PlayingOnliveFragment.this.G1.getHeight();
                    int width2 = PlayingOnliveFragment.this.G.getWidth();
                    int height2 = PlayingOnliveFragment.this.G.getHeight();
                    int i = 2;
                    int[] iArr = new int[2];
                    PlayingOnliveFragment.this.G1.getLocationOnScreen(iArr);
                    int[] iArr2 = new int[2];
                    PlayingOnliveFragment.this.G.getLocationOnScreen(iArr2);
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    int i4 = iArr2[0];
                    int i5 = iArr2[1];
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    PlayingOnliveFragment.this.L.getWidth();
                    PlayingOnliveFragment.this.L.getHeight();
                    PlayingOnliveFragment.this.L.getLocationOnScreen(iArr2);
                    int i6 = iArr2[0];
                    int i7 = iArr2[1];
                    if (x >= ((float) i6) && x <= ((float) (i6 + width2)) && y >= ((float) i7) && y <= ((float) (i7 + height2))) {
                        PlayingOnliveFragment.this.G.performClick();
                        return super.onSingleTapUp(motionEvent);
                    } else if (x < ((float) i4) || x > ((float) (i4 + width2)) || y < ((float) i5) || y > ((float) (i5 + height2))) {
                        ViewGroup contributionLeftView = PlayingOnliveFragment.this.mLivePkingView.getContributionLeftView();
                        int childCount = contributionLeftView.getChildCount();
                        int i8 = 0;
                        while (i8 < childCount) {
                            View childAt = contributionLeftView.getChildAt(i8);
                            int width3 = childAt.getWidth();
                            int height3 = childAt.getHeight();
                            int[] iArr3 = new int[i];
                            int i9 = iArr2[0];
                            ViewGroup viewGroup = contributionLeftView;
                            int i10 = iArr2[1];
                            childAt.getLocationOnScreen(iArr3);
                            if (x < ((float) i9) || x > ((float) (i9 + width3)) || y < ((float) i10) || y > ((float) (i10 + height3))) {
                                i8++;
                                contributionLeftView = viewGroup;
                                i = 2;
                            } else {
                                childAt.performClick();
                                return super.onSingleTapUp(motionEvent);
                            }
                        }
                        if (x >= ((float) i2) && x <= ((float) (i2 + width)) && y >= ((float) i3) && y <= ((float) (i3 + height))) {
                            PlayingOnliveFragment.this.G1.performClick();
                        }
                    } else {
                        PlayingOnliveFragment.this.G.performClick();
                        return super.onSingleTapUp(motionEvent);
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.B1.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.mList = new ArrayList();
        LayoutInflater from = LayoutInflater.from(getContext());
        View inflate = from.inflate(R.layout.fragment_play_onlive_control_portrait, (ViewGroup) null);
        View inflate2 = from.inflate(R.layout.fragment_play_onlive_control_portrait, (ViewGroup) null);
        this.mList.add(inflate);
        this.mList.add(inflate2);
        this.C1 = new ViewPagerAdapter(getContext(), this.mList, 2);
        this.B1.setAdapter(this.C1);
        c(inflate);
        d(inflate2);
        this.w1 = (BoxView) this.mRootView.findViewById(R.id.box_view);
        this.A1 = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.box_open);
        this.u1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                float[][] unused = PlayingOnliveFragment.this.x1 = new float[][]{PlayingOnliveFragment.this.w1.getAnimatorNumber(PlayingOnliveFragment.this.u1), PlayingOnliveFragment.this.v1 != null ? PlayingOnliveFragment.this.w1.getAnimatorNumber(PlayingOnliveFragment.this.v1) : null};
                PlayingOnliveFragment.this.u1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.k = (FrameLayout) this.mRootView.findViewById(R.id.surface_root);
        this.y1 = (BoxView) this.mRootView.findViewById(R.id.map_view);
        BoxView boxView = this.y1;
        boxView.sourceWidth = 1334;
        boxView.sourceHeight = 750;
        boxView.sourcePicWidth = 204;
        boxView.sourcePicHeight = 160;
        this.w.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                float[][] unused = PlayingOnliveFragment.this.z1 = new float[][]{PlayingOnliveFragment.this.y1.getAnimatorNumber(PlayingOnliveFragment.this.w), PlayingOnliveFragment.this.x != null ? PlayingOnliveFragment.this.y1.getAnimatorNumber(PlayingOnliveFragment.this.x) : null};
                PlayingOnliveFragment.this.w.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.k.addView(LiveFloatManager.getInstance().getSurafceView(), layoutParams);
        ImageView imageView = this.q;
        if (this.f1) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.r = (ImageView) this.mRootView.findViewById(R.id.live_like_view);
        this.t = (ImageView) this.mRootView.findViewById(R.id.live_gesture_view);
        this.mHeaderBgView = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.img_header_bg);
        this.P0 = DialogUtils.getLoadingDialog(getActivity());
        this.U = this.mRootView.findViewById(R.id.pop_first_charge_layout);
        this.V = (TextView) this.U.findViewById(R.id.first_charge_view);
        this.e0 = (KeyboardListenLinearLayout) this.mRootView.findViewById(R.id.keyboardLinearLayout);
        this.q0 = (LiveLoadingProgress) this.mRootView.findViewById(R.id.loading_progress);
        this.r0 = this.mRootView.findViewById(R.id.live_create_or_enter_errer_layout);
        this.C0 = (TextView) this.r0.findViewById(R.id.error_view);
        this.M0 = (Button) this.r0.findViewById(R.id.error_btn);
        this.y0 = this.mRootView.findViewById(R.id.live_banned_layout);
        this.z0 = (Button) this.y0.findViewById(R.id.live_end_banned_ok);
        this.s0 = this.mRootView.findViewById(R.id.live_interrupt_layout);
        this.A0 = (TextView) this.s0.findViewById(R.id.interrrupt_view);
        this.B0 = (Button) this.s0.findViewById(R.id.interrrupt_btn);
        this.t0 = this.mRootView.findViewById(R.id.live_closed_layout);
        this.u0 = this.t0.findViewById(R.id.live_end_follow);
        this.v0 = (ImageView) this.t0.findViewById(R.id.live_end_follow_img);
        this.w0 = (TextView) this.t0.findViewById(R.id.live_end_follow_label);
        this.x0 = (Button) this.t0.findViewById(R.id.live_exit_des_sure_btn);
        this.d0 = (GiftCardView) this.mRootView.findViewById(R.id.gift_card_view);
        this.d0.initView(this);
        this.mAnimationView = (LiveAnimationView) this.mRootView.findViewById(R.id.live_animation_layou);
        AutoAttachRecyclingImageView autoAttachRecyclingImageView = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.bao_zan_view);
        this.G = (FrameLayout) this.mRootView.findViewById(R.id.fl_action_rank_layout);
        FrameLayout frameLayout = this.G;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
        this.H = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.iv_action_rank_bg);
        this.I = (RelativeLayout) this.mRootView.findViewById(R.id.ll_action_rank);
        this.J = (TextView) this.mRootView.findViewById(R.id.tv_action_rank);
        this.K = (ImageView) this.mRootView.findViewById(R.id.iv_action_rank_up);
        this.L = (FrameLayout) this.mRootView.findViewById(R.id.fl_happy_time_layout);
        this.M = (AutoAttachRecyclingImageView) this.mRootView.findViewById(R.id.iv_happy_time_bg);
        this.N = (TextView) this.mRootView.findViewById(R.id.tv_happy_time);
        FrameLayout frameLayout2 = this.L;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(this);
        }
        this.p1 = (TicketPayFrameLayout) this.mRootView.findViewById(R.id.iv_ticket_bg_view);
        this.p1.setClickListener(this, this);
        if (this.f1) {
            showTicketView();
        }
        this.Q.updateBubbleImage(CommonPreferencesUtils.getMeZanUrl(), CommonPreferencesUtils.getOtherZanUrl());
        BubbleLayout bubbleLayout = this.R;
        if (bubbleLayout != null) {
            bubbleLayout.updateBubbleImage(CommonPreferencesUtils.getMeZanUrl(), CommonPreferencesUtils.getOtherZanUrl());
        }
        this.X.post(new Runnable() {
            public void run() {
                PlayingOnliveFragment.this.W.getLayoutParams().height = PlayingOnliveFragment.this.X.getHeight();
            }
        });
        this.s.setBackground(9, Color.parseColor("#ffffff"));
        this.g1 = new GestureDetector(this.l, new GestureListener());
        this.Q0.setOnClickListener(this);
        this.t.setOnTouchListener(this);
        this.k0.addTextChangedListener(this.g2);
        this.u0.setOnClickListener(this);
        this.x0.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.l0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
        this.z0.setOnClickListener(this);
        this.B0.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.p0.setOnClickListener(this);
        this.m0.setOnClickListener(this);
        this.o0.setOnClickListener(this);
        this.o0.performClick();
        this.p1.setOnClickListener(this);
        A();
        setAnchorData();
        G();
        v();
        this.P = new PlayingRTCManager(this, this.k1);
        PlayingOnlineManager playingOnlineManager = new PlayingOnlineManager(this, this.f1, this.mSessionType, this.mSessionId, this.e1, this.mPicUrl, this.mOptions);
        this.O = playingOnlineManager;
        if (this.mLiveAnchorModel != null) {
            LiveHttpUtils.getUserInfoForCard(getContext(), this.e2, this.mLiveAnchorModel.uid, "", Long.valueOf(this.mSessionId), Short.valueOf(this.mSessionType), getFragmentActive());
        }
    }

    public final void v() {
        UserCard instance = UserCard.getInstance();
        FragmentActivity activity = getActivity();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveAnchorModel liveAnchorModel = this.mLiveAnchorModel;
        instance.initLiveRoom(activity, fragmentActive, liveAnchorModel == null ? null : liveAnchorModel.uid, Long.valueOf(this.mSessionId), Short.valueOf(this.mSessionType), this.q1, this.e1, new UserCard.UserCardOnclickListner() {
            public void onConnectUser(String str, String str2) {
            }

            public void onDismiss() {
                PlayingOnliveFragment.this.setBottomLayoutVisible(0);
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                if (!playingOnliveFragment.isSimpleModel) {
                    playingOnliveFragment.liveMsgManager.setChatViewVisibility(0);
                }
            }

            public void onFollowingStatusChanged(String str) {
                String unused = PlayingOnliveFragment.this.i1 = str;
                if ("1".equals(str) || "3".equals(str)) {
                    PlayingOnliveFragment.this.liveMsgManager.sendLiveDynamic(49);
                    PlayingOnliveFragment.this.o.setVisibility(8);
                    if (PlayingOnliveFragment.this.p != null) {
                        PlayingOnliveFragment.this.p.setVisibility(8);
                    }
                } else if ("0".equals(str) || "2".equals(str)) {
                    PlayingOnliveFragment.this.o.setVisibility(0);
                    if (PlayingOnliveFragment.this.p != null) {
                        PlayingOnliveFragment.this.p.setVisibility(0);
                    }
                }
            }

            public void onJumpToPages() {
                PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                    public void run() {
                        PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                        if (playingOnliveFragment.isRTCModel) {
                            playingOnliveFragment.showExitLive();
                            return;
                        }
                        LiveFloatManager.getInstance().displayFloatView(PlayingOnliveFragment.this.mTimer);
                        PlayingOnliveFragment.this.finish();
                    }
                });
            }

            public void onReplyClick(String str, String str2) {
                PlayingOnliveFragment.this.setReplyClick(str, str2);
            }

            public void onShow() {
                PlayingOnliveFragment.this.setBottomLayoutVisible(4);
                PlayingOnliveFragment.this.liveMsgManager.setChatViewVisibility(4);
            }
        });
    }

    public final void w() {
        if (!this.f1) {
            CountDownTimer countDownTimer = this.z2;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            AnonymousClass79 r12 = new CountDownTimer(360000, 1000) {
                public void onFinish() {
                    PlayingOnliveFragment.this.x();
                }

                public void onTick(long j) {
                }
            };
            this.z2 = r12;
            this.z2.start();
        }
    }

    public final void x() {
        if (getFragmentActive().isActive() && !CollectionUtils.isEmpty(this.Y1.shareList)) {
            Timer timer = this.A2;
            if (timer != null) {
                timer.cancel();
                this.A2 = null;
            }
            this.A2 = new Timer();
            this.A2.schedule(new TimerTask() {
                public void run() {
                    AppInfo.getUIHandler().post(new Runnable() {
                        public void run() {
                            PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                                public void run() {
                                    if (!CollectionUtils.isEmpty(PlayingOnliveFragment.this.Y1.shareList)) {
                                        final LiveShareModel liveShareModel = PlayingOnliveFragment.this.Y1.shareList.get(PlayingOnliveFragment.this.y2);
                                        PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                        liveShareModel.liveAnchorModel = playingOnliveFragment.mLiveAnchorModel;
                                        playingOnliveFragment.q.setBackgroundResource(liveShareModel.drawable);
                                        PlayingOnliveFragment.this.q.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                LiveShareManager f = PlayingOnliveFragment.this.Y1;
                                                Context M = PlayingOnliveFragment.this.l;
                                                LiveShareModel liveShareModel = liveShareModel;
                                                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                                f.share(M, liveShareModel, playingOnliveFragment.liveMsgManager, playingOnliveFragment);
                                            }
                                        });
                                        int unused = PlayingOnliveFragment.this.y2 = PlayingOnliveFragment.this.y2 + 1;
                                        if (PlayingOnliveFragment.this.y2 >= PlayingOnliveFragment.this.Y1.shareList.size()) {
                                            int unused2 = PlayingOnliveFragment.this.y2 = 2;
                                        }
                                        PlayingOnliveFragment.this.y();
                                    }
                                }
                            });
                        }
                    });
                }
            }, 0, 363000);
        }
    }

    public final void y() {
        if (getFragmentActive().isActive()) {
            Timer timer = this.B2;
            if (timer != null) {
                timer.cancel();
                this.B2 = null;
            }
            this.B2 = new Timer();
            this.B2.schedule(new TimerTask() {
                public void run() {
                    PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                        public void run() {
                            PlayingOnliveFragment.this.q.setBackgroundResource(R.drawable.live_share_btn);
                            PlayingOnliveFragment.this.q.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    PlayingOnliveFragment.this.N0.showMenu();
                                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                    LiveServiceLogTool.liveroomInsideAction(playingOnliveFragment.mLiveAnchorModel.uid, playingOnliveFragment.mSessionId, "share", playingOnliveFragment.e1);
                                }
                            });
                        }
                    });
                }
            }, LiveFloatManager.RECONNECT_TIME);
        }
    }

    public final void z() {
        this.u1.setOnOpenClickable(false);
        BoxProgressView boxProgressView = this.v1;
        if (boxProgressView != null) {
            boxProgressView.setOnOpenClickable(false);
        }
        LiveHttpUtils.getPlayingOpenTreasure(String.valueOf(this.mSessionId), new BluedUIHttpResponse<BluedEntity<LivePrizeModel, LivePrizeUserBaseModel>>() {
            public int a = -1;

            public void onUIFinish() {
                super.onUIFinish();
                if (this.a != -1) {
                    PlayingOnliveFragment.this.u1.setOnOpenClickable(true);
                    if (PlayingOnliveFragment.this.v1 != null) {
                        PlayingOnliveFragment.this.v1.setOnOpenClickable(true);
                    }
                }
            }

            public void onUIUpdate(BluedEntity<LivePrizeModel, LivePrizeUserBaseModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.code != 200) {
                    AppMethods.showToast((CharSequence) "错误码：" + bluedEntity.code + ",错误信息：" + bluedEntity.message);
                    "错误码：" + bluedEntity.code + ",错误信息：" + bluedEntity.message;
                    PlayingOnliveFragment.this.u1.setOnOpenClickable(true);
                    if (PlayingOnliveFragment.this.v1 != null) {
                        PlayingOnliveFragment.this.v1.setOnOpenClickable(true);
                        return;
                    }
                    return;
                }
                List list = bluedEntity.data;
                LivePrizeUserBaseModel livePrizeUserBaseModel = (LivePrizeUserBaseModel) bluedEntity.extra;
                if (list == null) {
                    list = new ArrayList();
                }
                for (int i = 0; i < list.size(); i++) {
                    LivePrizeModel livePrizeModel = (LivePrizeModel) list.get(i);
                    if (livePrizeModel.status != 1) {
                        list.remove(livePrizeModel);
                    }
                }
                if (livePrizeUserBaseModel == null) {
                    livePrizeUserBaseModel = new LivePrizeUserBaseModel();
                }
                PlayingOnliveFragment.this.a((List<LivePrizeModel>) list, livePrizeUserBaseModel);
            }

            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                this.a = i;
            }
        });
    }

    public final void d(View view) {
        a((int) R.id.input_layout);
        a((int) R.id.live_msg_hListView);
        a((int) R.id.audience_background);
        a((int) R.id.live_msg_content_pullrefresh);
        view.findViewById(R.id.simple_model_high).getLayoutParams().height = UiUtils.dip2px(getContext(), 70.0f);
        ((LinearLayout.LayoutParams) view.findViewById(R.id.barrage).getLayoutParams()).bottomMargin = UiUtils.dip2px(getContext(), 110.0f);
        this.R = (BubbleLayout) view.findViewById(R.id.ll_bubble);
        this.v = (ImageView) view.findViewById(R.id.close_btn);
        this.n = (RoundedImageView) view.findViewById(R.id.header_view);
        this.D = (ImageView) view.findViewById(R.id.img_verify);
        this.B = (TextView) view.findViewById(R.id.name_view);
        this.T = (TextView) view.findViewById(R.id.onlive_all_count);
        this.p = view.findViewById(R.id.live_follow_anchor);
        this.T0 = (TextView) view.findViewById(R.id.onlive_current_beans);
        view.findViewById(R.id.ll_level_and_beans_layout);
        this.c0 = view.findViewById(R.id.onlive_level_container);
        this.F = (ImageView) view.findViewById(R.id.play_online_watermark);
        this.R0 = (ObliqueLinearLayout) view.findViewById(R.id.onlive_current_beans_layout);
        this.F0 = (AutoAttachRecyclingImageView) view.findViewById(R.id.live_level_icon);
        this.H0 = (LevelProgressBar) view.findViewById(R.id.live_level_progressbar);
        this.J0 = (TextView) view.findViewById(R.id.live_level_desc);
        this.L0 = (TextView) view.findViewById(R.id.live_level_desc_0);
        this.x = (ImageView) view.findViewById(R.id.live_gift_view);
        this.z = (ImageView) view.findViewById(R.id.live_fans_view);
        this.m1 = (FrameLayout) view.findViewById(R.id.entrance_effect_container);
        this.x.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.R0.setOnClickListener(this);
        this.v.setOnClickListener(this);
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.a2 = (LinearLayout) view.findViewById(R.id.ll_guide_fan_club_add);
        this.c2 = (TextView) view.findViewById(R.id.tv_join_fan_club);
        TextView textView = this.c2;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ((RelativeLayout.LayoutParams) this.x.getLayoutParams()).addRule(12);
        this.v1 = (BoxProgressView) view.findViewById(R.id.box_progressview);
        a(this.v1);
    }

    public final void c(View view) {
        this.W = view.findViewById(R.id.live_top_root);
        this.X = view.findViewById(R.id.live_top_left_area);
        this.m = (RoundedImageView) view.findViewById(R.id.header_view);
        this.C = (ImageView) view.findViewById(R.id.img_verify);
        this.A = (TextView) view.findViewById(R.id.name_view);
        this.S = (TextView) view.findViewById(R.id.onlive_all_count);
        this.o = view.findViewById(R.id.live_follow_anchor);
        this.u = (ImageView) view.findViewById(R.id.close_btn);
        this.D0 = (RelativeLayout) view.findViewById(R.id.onlive_current_level_layout);
        this.a0 = view.findViewById(R.id.ll_level_and_beans_layout);
        this.b0 = view.findViewById(R.id.onlive_level_container);
        this.E0 = (AutoAttachRecyclingImageView) view.findViewById(R.id.live_level_icon);
        this.Q = (BubbleLayout) view.findViewById(R.id.ll_bubble);
        this.G0 = (LevelProgressBar) view.findViewById(R.id.live_level_progressbar);
        this.I0 = (TextView) view.findViewById(R.id.live_level_desc);
        this.K0 = (TextView) view.findViewById(R.id.live_level_desc_0);
        this.Q0 = (ObliqueLinearLayout) view.findViewById(R.id.onlive_current_beans_layout);
        this.S0 = (TextView) view.findViewById(R.id.onlive_current_beans);
        this.E = (ImageView) view.findViewById(R.id.play_online_watermark);
        this.o1 = (RTCUserInfoLayout) view.findViewById(R.id.rtc_user_info_layout);
        this.U0 = view.findViewById(R.id.horn_container);
        this.V0 = (TipView) view.findViewById(R.id.horn_text);
        this.q = (ImageView) view.findViewById(R.id.share_view);
        this.w = (ImageView) view.findViewById(R.id.live_gift_view);
        this.y = (ImageView) view.findViewById(R.id.live_fans_view);
        ImageView imageView = this.y;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.Z1 = (LinearLayout) view.findViewById(R.id.ll_guide_fan_club_add);
        this.b2 = (TextView) view.findViewById(R.id.tv_join_fan_club);
        TextView textView = this.b2;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.s = (BadgeView) view.findViewById(R.id.approach_gift_view);
        this.u1 = (BoxProgressView) view.findViewById(R.id.box_progressview);
        this.t1 = (LinearLayout) view.findViewById(R.id.fl_progressview);
        a(this.u1);
        this.p0 = (ImageView) view.findViewById(R.id.chat_view);
        view.findViewById(R.id.float_window_view).setOnClickListener(this);
        this.g0 = (LiveChatLeftRelativeLayout) view.findViewById(R.id.live_msg_edit_chat_bg);
        this.g0.setOnClickListener(this);
        this.h0 = (LiveChatMiddleRelativeLayout) view.findViewById(R.id.live_msg_edit_danmu_bg);
        this.h0.setOnClickListener(this);
        this.m0 = (ImageView) view.findViewById(R.id.live_msg_edit_danmu_btn);
        this.n0 = (ImageView) view.findViewById(R.id.iv_red_dot);
        this.o0 = (ImageView) view.findViewById(R.id.live_msg_edit_chat_btn);
        this.i0 = (LiveChatRightLinearLayout) view.findViewById(R.id.live_msg_edit_input_bg);
        this.l0 = (ImageView) view.findViewById(R.id.live_msg_send_to);
        this.k0 = (EditText) view.findViewById(R.id.live_msg_send_edit);
        this.j0 = view.findViewById(R.id.input_layout);
        this.f0 = view.findViewById(R.id.keyboard_view);
        this.l1 = (FrameLayout) view.findViewById(R.id.entrance_effect_container);
        this.o1.setOnClickListener(this);
        this.Z = (LiveFanClubUpLevelNoticeView) view.findViewById(R.id.fan_club_up_level);
    }

    public final void b(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                this.F1 = new PopLiveCenterWebView(getContext());
                this.F1.initData(this);
                this.E1.addView(this.F1, new FrameLayout.LayoutParams(-1, -1));
                this.F1.showMenu(str);
            } catch (InflateException unused) {
                AppMethods.showToast((CharSequence) "Please download 'Android System WebView' from App Store.");
            }
        } else if (WebView.getCurrentWebViewPackage() != null) {
            this.F1 = new PopLiveCenterWebView(getContext());
            this.F1.initData(this);
            this.E1.addView(this.F1, new FrameLayout.LayoutParams(-1, -1));
            this.F1.showMenu(str);
        } else {
            AppMethods.showToast((CharSequence) "Please download 'Android System WebView' from App Store.");
        }
    }

    public static synchronized void show(Context context, short s3, long j3, LiveAnchorModel liveAnchorModel, String str, String str2) {
        synchronized (PlayingOnliveFragment.class) {
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.imageOnFail = R.drawable.default_square_head;
            loadOptions.defaultImageResId = R.drawable.default_square_head;
            show(context, s3, j3, liveAnchorModel, str, str2, loadOptions);
        }
    }

    public final void a(final BoxProgressView boxProgressView) {
        boxProgressView.setType(1);
        boxProgressView.reInitView();
        boxProgressView.setListener(new BoxProgressView.OnBoxListener() {
            public void onBoxClickListener() {
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                BoxDescriptionDialogFragment unused = playingOnliveFragment.r1 = BoxDescriptionDialogFragment.show(playingOnliveFragment.getChildFragmentManager(), "", 1);
            }

            public void onClickMaxListener() {
                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                BoxOpenDialogFragment unused = playingOnliveFragment.s1 = BoxOpenDialogFragment.show(playingOnliveFragment.getChildFragmentManager(), "", 1, 1);
            }

            public void onClickOpenListener() {
                PlayingOnliveFragment.this.z();
            }

            public void onProgressSuccess() {
            }

            public void onTimerEndListener(boolean z) {
                BoxProgressView boxProgressView = boxProgressView;
                if (boxProgressView != null && !z) {
                    boxProgressView.setVisibility(4);
                    if (PlayingOnliveFragment.this.v1 != null) {
                        PlayingOnliveFragment.this.v1.setVisibility(4);
                    }
                }
            }
        });
    }

    public final LiveAnchorModel b(LivePkInviteModel livePkInviteModel) {
        LiveAnchorModel liveAnchorModel = new LiveAnchorModel(livePkInviteModel.uid, livePkInviteModel.avatar, livePkInviteModel.name, "");
        liveAnchorModel.live_play = livePkInviteModel.live_play;
        liveAnchorModel.live_type = 0;
        return liveAnchorModel;
    }

    public static synchronized void show(Context context, short s3, long j3, LiveAnchorModel liveAnchorModel, String str, String str2, LoadOptions loadOptions) {
        synchronized (PlayingOnliveFragment.class) {
            if (!LiveFloatManager.getInstance().isLiveRoomShowing()) {
                if (j3 != LiveFloatManager.getInstance().getSessionId()) {
                    LiveFloatManager.getInstance().close();
                }
                LiveFloatManager.getInstance().displayFullScreenView();
                Bundle bundle = new Bundle();
                bundle.putShort("session_type", s3);
                bundle.putLong("session_id", j3);
                bundle.putSerializable(OnliveConstant.LIVE_PARAMETER.LIVE_ANCHOR_MODEL, liveAnchorModel);
                bundle.putString("code", str);
                bundle.putString(OnliveConstant.LIVE_PARAMETER.LIVE_PIC_URL, str2);
                bundle.putSerializable(OnliveConstant.LIVE_PARAMETER.LIVE_HEADER_OPTIONS, loadOptions);
                TerminalActivity.addWithoutFituiArgs(bundle);
                PlayingOnliveActivity.showFragment(context, PlayingOnliveFragment.class, bundle);
            }
        }
    }

    public final void a(final List<LivePrizeModel> list, final LivePrizeUserBaseModel livePrizeUserBaseModel) {
        postSafeRunOnUiThread(new Runnable() {
            public void run() {
                AnonymousClass1 r0 = new BoxProgressView.OnBoxOpenListener() {
                    public void onBoxOpenListener() {
                        PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                            public void run() {
                                if (PlayingOnliveFragment.this.v1 != null) {
                                    PlayingOnliveFragment.this.v1.changeBoxViewOpened();
                                }
                                PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                                FragmentManager childFragmentManager = playingOnliveFragment.getChildFragmentManager();
                                AnonymousClass8 r3 = AnonymousClass8.this;
                                BoxOpenDialogFragment unused = playingOnliveFragment.s1 = BoxOpenDialogFragment.show(childFragmentManager, 1, list, livePrizeUserBaseModel, new BoxOpenDialogFragment.OnClicKnapsackListener() {
                                    public void onClickKnapsackListener(List<LivePrizeModel> list) {
                                        PlayingOnliveFragment.this.d0.setBagNotice();
                                        PlayingOnliveFragment.this.postDelaySafeRunOnUiThread(new Runnable() {
                                            public void run() {
                                                PlayingOnliveFragment.this.d0.show(3);
                                            }
                                        }, 500);
                                    }
                                });
                            }
                        });
                    }
                };
                PlayingOnliveFragment.this.u1.setBoxOpen(PlayingOnliveFragment.this.A1);
                PlayingOnliveFragment.this.u1.setBoxOnOpened(r0);
            }
        });
    }

    public final void a(int i3) {
        View view = this.mList.get(1);
        if (view != null) {
            View findViewById = view.findViewById(i3);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ViewGroup) {
                    childAt.requestLayout();
                    a((ViewGroup) childAt);
                } else {
                    childAt.invalidate();
                }
            }
        }
    }

    public final void b(int i3) {
        LivePkingView livePkingView = this.mLivePkingView;
        if (livePkingView != null) {
            livePkingView.additionAndSubtractionQueue(Integer.valueOf(i3 > 0 ? 1 : -1), Math.abs(i3));
            this.mLivePkingView.startAdditionAndSubtractionAnim();
        }
    }

    public final int a(TextView textView) {
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
    }

    public final void a(LivePkInviteModel livePkInviteModel) {
        exitLive();
        LiveFloatManager.getInstance().setLiveRoomShowing(false);
        dismissRTCWindow();
        LiveAnchorModel b = b(livePkInviteModel);
        show(this.l, 5, livePkInviteModel.lid, b, OnliveConstant.LIVE_COME_CODE.LIVE_POPULAR, b.avatar);
        finish();
    }

    public final void a(final PropCardModel propCardModel) {
        this.v2 = propCardModel;
        this.L.setVisibility(0);
        this.M.loadImage(propCardModel.effect_icon, new LoadOptions(), (ImageLoadingListener) null);
        "使用了一张happytime卡,现在倒计时时间为：" + DateUtils.formatTimer(propCardModel.effect_left_time, false);
        if (!this.l2) {
            this.G.setVisibility(8);
        }
        this.u2 = true;
        Timer timer = this.w2;
        if (timer != null) {
            timer.cancel();
        }
        this.x2 = (int) propCardModel.effect_left_time;
        this.w2 = new Timer();
        this.w2.schedule(new TimerTask() {
            public void run() {
                PlayingOnliveFragment.this.postSafeRunOnUiThread(new Runnable() {
                    public void run() {
                        AnonymousClass78 r0 = AnonymousClass78.this;
                        propCardModel.effect_left_time = (long) PlayingOnliveFragment.this.x2;
                        PlayingOnliveFragment.this.N.setText(DateUtils.formatTimer((long) PlayingOnliveFragment.this.x2, false));
                        if (PlayingOnliveFragment.this.x2 == -1) {
                            PropCardModel unused = PlayingOnliveFragment.this.v2 = null;
                            PlayingOnliveFragment.this.L.setVisibility(8);
                            if (!PlayingOnliveFragment.this.l2) {
                                PlayingOnliveFragment.this.G.setVisibility(0);
                            }
                            boolean unused2 = PlayingOnliveFragment.this.u2 = false;
                        }
                        if (PlayingOnliveFragment.this.x2 < 0) {
                            PlayingOnliveFragment.this.w2.cancel();
                            int unused3 = PlayingOnliveFragment.this.x2 = -1;
                            return;
                        }
                        PlayingOnliveFragment.M0(PlayingOnliveFragment.this);
                    }
                });
            }
        }, 0, 1000);
    }

    public final void a(final ProtectionCoverModel protectionCoverModel, final ProtectionCoverView protectionCoverView) {
        this.d0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                LivePkingView livePkingView = PlayingOnliveFragment.this.mLivePkingView;
                if (livePkingView != null) {
                    ProtectionCoverModel protectionCoverModel = protectionCoverModel;
                    protectionCoverModel.target_view = protectionCoverView;
                    livePkingView.addThiefCard(protectionCoverModel);
                    PlayingOnliveFragment playingOnliveFragment = PlayingOnliveFragment.this;
                    playingOnliveFragment.mLivePkingView.startThiefCardAnim(playingOnliveFragment.d0);
                }
                PlayingOnliveFragment.this.d0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
