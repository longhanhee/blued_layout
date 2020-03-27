package com.example.blued_layout;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.List;

public class PlayingRTCManager {
    public static final int AGREE_INVITE = 1;
    public static final int REFUSE_INVITATION = 2;
    public static boolean isRtcManagerInit = false;
    public RTCMediaStreamingManager a;
    public GLSurfaceView b;
    public PlayingOnliveFragment c;
    public String d;
    public String e;
    public RTCConferenceState f;
    public StreamingStateChangedListener g = new StreamingStateChangedListener() {
        /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass3 */

        public void onStateChanged(StreamingState streamingState, Object obj) {
            "mStreamingStateChangedListener state = " + streamingState;
            int i = AnonymousClass7.b[streamingState.ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 || i == 4 || i == 5) {
                    PlayingRTCManager.this.c.postSafeRunOnUiThread(new Runnable() {
                        /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass3.AnonymousClass1 */

                        public void run() {
                            PlayingRTCManager.this.c.closeConnectionMode();
                            PlayingRTCManager.this.stopCapture();
                            PlayingRTCManager.this.c.dismissRTCWindow();
                        }
                    });
                }
            }
        }
    };
    public RTCConferenceStateChangedListener h = new RTCConferenceStateChangedListener() {
        /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass4 */

        public void onConferenceStateChanged(RTCConferenceState rTCConferenceState, int i) {
            "mRTCStreamingStateChangedListener state = " + rTCConferenceState;
            RTCConferenceState unused = PlayingRTCManager.this.f = rTCConferenceState;
            int i2 = AnonymousClass7.c[rTCConferenceState.ordinal()];
            if (i2 == 1) {
                PlayingRTCManager playingRTCManager = PlayingRTCManager.this;
                boolean unused2 = playingRTCManager.a(playingRTCManager.d, PlayingRTCManager.this.e);
            } else if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                AppMethods.showToast((int) R.string.host_cancelled_connection);
                PlayingRTCManager.this.c.closeConnectionMode();
                PlayingRTCManager.this.c.dismissRTCWindow();
                PlayingRTCManager.this.stopConference();
                PlayingRTCManager.this.stopCapture();
            }
        }
    };
    public RTCRemoteWindowEventListener i = new RTCRemoteWindowEventListener() {
        /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass5 */

        public void onFirstRemoteFrameArrived(String str) {
        }

        public void onRemoteWindowAttached(final RTCVideoWindow rTCVideoWindow, final String str) {
            PlayingRTCManager.this.c.postSafeRunOnUiThread(new Runnable() {
                /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass5.AnonymousClass1 */

                public void run() {
                    PlayingRTCManager.this.c.dismissRTCLoading();
                    if (!PlayingRTCManager.this.c.isRTCModel) {
                        PlayingRTCManager.this.c.closeConnectionMode();
                        PlayingRTCManager.this.c.dismissRTCWindow();
                        PlayingRTCManager.this.stopConference();
                        PlayingRTCManager.this.stopCapture();
                    }
                    if (rTCVideoWindow.getRTCSurfaceView().getId() == R.id.RemoteGLSurfaceViewA) {
                        PlayingRTCManager.setUserInfoName(PlayingRTCManager.this.c.getContext(), PlayingRTCManager.this.c.mRemoteNameA, str, PlayingRTCManager.this.c.mSessionType, PlayingRTCManager.this.c.mSessionId, PlayingRTCManager.this.c.getFragmentActive());
                        PlayingRTCManager.this.c.changeRemoteWindow();
                        if (PlayingRTCManager.this.c.mLiveAnchorModel == null || PlayingRTCManager.this.c.mLiveAnchorModel.uid == null || !PlayingRTCManager.this.c.mLiveAnchorModel.uid.equals(str)) {
                            PlayingRTCManager.this.c.mOutUserA.setVisibility(8);
                        } else {
                            PlayingRTCManager.this.c.mOutUserA.setVisibility(0);
                        }
                    } else {
                        PlayingRTCManager.setUserInfoName(PlayingRTCManager.this.c.getContext(), PlayingRTCManager.this.c.mRemoteNameB, str, PlayingRTCManager.this.c.mSessionType, PlayingRTCManager.this.c.mSessionId, PlayingRTCManager.this.c.getFragmentActive());
                        if (PlayingRTCManager.this.c.mLiveAnchorModel == null || PlayingRTCManager.this.c.mLiveAnchorModel.uid == null || !PlayingRTCManager.this.c.mLiveAnchorModel.uid.equals(str)) {
                            PlayingRTCManager.this.c.mOutUserB.setVisibility(8);
                        } else {
                            PlayingRTCManager.this.c.mOutUserB.setVisibility(0);
                        }
                    }
                }
            });
        }

        public void onRemoteWindowDetached(RTCVideoWindow rTCVideoWindow, final String str) {
            PlayingRTCManager.this.c.postSafeRunOnUiThread(new Runnable() {
                /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass5.AnonymousClass2 */

                public void run() {
                    if (PlayingRTCManager.this.c.mLiveAnchorModel != null && PlayingRTCManager.this.c.mLiveAnchorModel.uid != null && PlayingRTCManager.this.c.mLiveAnchorModel.uid.equals(str)) {
                        PlayingRTCManager.this.c.closeConnectionMode();
                        PlayingRTCManager.this.stopConference();
                        PlayingRTCManager.this.stopCapture();
                        if (PlayingRTCManager.this.f == RTCConferenceState.USER_KICKOUT_BY_HOST) {
                            AppMethods.showToast((int) R.string.host_cancelled_connection);
                        } else {
                            AppMethods.showToast((int) R.string.live_connection_ended);
                        }
                    }
                }
            });
        }
    };
    public boolean mIsActivityPaused = true;

    /* renamed from: com.blued.international.ui.live.manager.PlayingRTCManager$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] a = new int[JoinLiveResult.values().length];
        public static final /* synthetic */ int[] b = new int[StreamingState.values().length];
        public static final /* synthetic */ int[] c = new int[RTCConferenceState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ac */
        static {
            /*
                com.qiniu.pili.droid.rtcstreaming.RTCConferenceState[] r0 = com.qiniu.pili.droid.rtcstreaming.RTCConferenceState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.c = r0
                r0 = 1
                int[] r1 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.qiniu.pili.droid.rtcstreaming.RTCConferenceState r2 = com.qiniu.pili.droid.rtcstreaming.RTCConferenceState.READY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.qiniu.pili.droid.rtcstreaming.RTCConferenceState r3 = com.qiniu.pili.droid.rtcstreaming.RTCConferenceState.VIDEO_PUBLISH_FAILED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.c     // Catch:{ NoSuchFieldError -> 0x002a }
                com.qiniu.pili.droid.rtcstreaming.RTCConferenceState r4 = com.qiniu.pili.droid.rtcstreaming.RTCConferenceState.AUDIO_PUBLISH_FAILED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.c     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.qiniu.pili.droid.rtcstreaming.RTCConferenceState r5 = com.qiniu.pili.droid.rtcstreaming.RTCConferenceState.USER_JOINED_AGAIN     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.c     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.qiniu.pili.droid.rtcstreaming.RTCConferenceState r6 = com.qiniu.pili.droid.rtcstreaming.RTCConferenceState.USER_KICKOUT_BY_HOST     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                com.qiniu.pili.droid.streaming.StreamingState[] r5 = com.qiniu.pili.droid.streaming.StreamingState.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.b = r5
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.b     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.qiniu.pili.droid.streaming.StreamingState r6 = com.qiniu.pili.droid.streaming.StreamingState.PREPARING     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.b     // Catch:{ NoSuchFieldError -> 0x005d }
                com.qiniu.pili.droid.streaming.StreamingState r6 = com.qiniu.pili.droid.streaming.StreamingState.READY     // Catch:{ NoSuchFieldError -> 0x005d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.b     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.qiniu.pili.droid.streaming.StreamingState r6 = com.qiniu.pili.droid.streaming.StreamingState.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.b     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.qiniu.pili.droid.streaming.StreamingState r6 = com.qiniu.pili.droid.streaming.StreamingState.AUDIO_RECORDING_FAIL     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.b     // Catch:{ NoSuchFieldError -> 0x007b }
                com.qiniu.pili.droid.streaming.StreamingState r6 = com.qiniu.pili.droid.streaming.StreamingState.OPEN_CAMERA_FAIL     // Catch:{ NoSuchFieldError -> 0x007b }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                com.blued.android.chat.data.JoinLiveResult[] r5 = com.blued.android.chat.data.JoinLiveResult.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.a = r5
                int[] r5 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.a     // Catch:{ NoSuchFieldError -> 0x008e }
                com.blued.android.chat.data.JoinLiveResult r6 = com.blued.android.chat.data.JoinLiveResult.SUCCESS     // Catch:{ NoSuchFieldError -> 0x008e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                int[] r0 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.a     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.blued.android.chat.data.JoinLiveResult r5 = com.blued.android.chat.data.JoinLiveResult.FAILED_UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                int[] r0 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.a     // Catch:{ NoSuchFieldError -> 0x00a2 }
                com.blued.android.chat.data.JoinLiveResult r1 = com.blued.android.chat.data.JoinLiveResult.FAILED_JOINLIVE_CLOSE     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                int[] r0 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.a     // Catch:{ NoSuchFieldError -> 0x00ac }
                com.blued.android.chat.data.JoinLiveResult r1 = com.blued.android.chat.data.JoinLiveResult.FAILED_JOINLIVE_FULL     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00ac }
            L_0x00ac:
                int[] r0 = com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.a     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.blued.android.chat.data.JoinLiveResult r1 = com.blued.android.chat.data.JoinLiveResult.FAILED_JOINLIVE_INVITE_OVERDUE     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass7.<clinit>():void");
        }
    }

    public PlayingRTCManager(PlayingOnliveFragment playingOnliveFragment, GLSurfaceView gLSurfaceView) {
        this.c = playingOnliveFragment;
        this.b = gLSurfaceView;
        b();
    }

    public static boolean initRTCManager() {
        if (!isRtcManagerInit) {
            try {
                RTCMediaStreamingManager.init(AppInfo.getAppContext(), 10002);
                isRtcManagerInit = true;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            }
        }
        return isRtcManagerInit;
    }

    public static void setUserInfoName(Context context, final TextView textView, String str, short s, long j, IRequestHost iRequestHost) {
        LiveHttpUtils.getUserInfoForCard(context, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(iRequestHost) {
            /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass6 */

            public /* bridge */ /* synthetic */ void onUIUpdate(BluedEntity bluedEntity) {
                onUIUpdate((BluedEntityA<UserInfoEntity>) ((BluedEntityA) bluedEntity));
            }

            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                UserInfoEntity userInfoEntity;
                List<T> list = bluedEntityA.data;
                if (list != null && list.size() > 0 && (userInfoEntity = (UserInfoEntity) bluedEntityA.data.get(0)) != null && !TextUtils.isEmpty(userInfoEntity.name)) {
                    textView.setText(userInfoEntity.name);
                }
            }
        }, str, "", Long.valueOf(j), Short.valueOf(s), iRequestHost);
    }

    public void applyJoinLive(short s, long j, int i2) {
        ChatManager.getInstance().applyJoinLive(s, j, (long) i2);
    }

    public void onDestroy() {
        RTCMediaStreamingManager rTCMediaStreamingManager = this.a;
        if (rTCMediaStreamingManager != null) {
            rTCMediaStreamingManager.destroy();
        }
    }

    public void onJoinLive(JoinLiveResult joinLiveResult, final String str, final String str2) {
        "onJoinLive result = " + joinLiveResult.toString() + "--joinLiveId = " + str + "--joinLiveToken = " + str2;
        int i2 = AnonymousClass7.a[joinLiveResult.ordinal()];
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                if (i2 == 4) {
                    AppMethods.showToast((int) R.string.no_extra_quota);
                } else if (i2 == 5) {
                    AppMethods.showToast((int) R.string.audio_request_expired);
                }
            }
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PlayingOnliveFragment playingOnliveFragment = this.c;
            if (playingOnliveFragment.isRefuse) {
                playingOnliveFragment.isRefuse = false;
            } else {
                PermissionHelper.checkCameraAndMIC(playingOnliveFragment.getActivity(), new PermissionHelper.PermissionCallbacks() {
                    /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass1 */

                    public void onPermissionsDenied(int i, List<String> list) {
                    }

                    public void onPermissionsGranted(int i, List<String> list) {
                        String unused = PlayingRTCManager.this.d = str;
                        String unused2 = PlayingRTCManager.this.e = str2;
                        PlayingRTCManager.this.startCapture();
                        PlayingRTCManager.this.c.openConnectionMode();
                        PlayingRTCManager.this.c.showRTCWindow();
                        PlayingRTCManager.this.c.showRTCLoading();
                    }
                });
            }
        }
    }

    public void startCapture() {
        RTCMediaStreamingManager rTCMediaStreamingManager = this.a;
        if (rTCMediaStreamingManager != null) {
            rTCMediaStreamingManager.startCapture();
        }
    }

    public void stopCapture() {
        RTCMediaStreamingManager rTCMediaStreamingManager = this.a;
        if (rTCMediaStreamingManager != null) {
            rTCMediaStreamingManager.stopCapture();
        }
    }

    public void stopConference() {
        RTCMediaStreamingManager rTCMediaStreamingManager = this.a;
        if (rTCMediaStreamingManager != null) {
            rTCMediaStreamingManager.stopConference();
        }
    }

    public final void b() {
        if (initRTCManager()) {
            CameraStreamingSetting.CAMERA_FACING_ID a2 = a();
            a2.ordinal();
            CameraStreamingSetting cameraStreamingSetting = new CameraStreamingSetting();
            cameraStreamingSetting.setCameraFacingId(a2).setContinuousFocusModeEnabled(true).setRecordingHint(false).setBuiltInFaceBeautyEnabled(false).setResetTouchFocusDelayInMs(3000).setCameraPrvSizeLevel(CameraStreamingSetting.PREVIEW_SIZE_LEVEL.MEDIUM).setCameraPrvSizeRatio(CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9).setFaceBeautySetting(new CameraStreamingSetting.FaceBeautySetting(0.6f, 0.6f, 0.5f)).setVideoFilter(CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_BEAUTY);
            LiveFloatManager.getInstance();
            if (LiveFloatManager.isXiaomiPhone()) {
                cameraStreamingSetting.setCameraPrvSizeLevel(CameraStreamingSetting.PREVIEW_SIZE_LEVEL.LARGE);
            } else {
                cameraStreamingSetting.setCameraPrvSizeLevel(CameraStreamingSetting.PREVIEW_SIZE_LEVEL.MEDIUM);
            }
            MicrophoneStreamingSetting microphoneStreamingSetting = new MicrophoneStreamingSetting();
            microphoneStreamingSetting.setAudioSource(7);
            this.a = new RTCMediaStreamingManager(AppInfo.getAppContext(), this.b);
            this.a.setConferenceStateListener(this.h);
            this.a.setStreamingStateListener(this.g);
            this.a.setRemoteWindowEventListener(this.i);
            this.a.setDebugLoggingEnabled(false);
            RTCConferenceOptions rTCConferenceOptions = new RTCConferenceOptions();
            rTCConferenceOptions.setVideoEncodingSizeRatio(RTCConferenceOptions.VIDEO_ENCODING_SIZE_RATIO.RATIO_16_9);
            rTCConferenceOptions.setVideoEncodingSizeLevel(0);
            rTCConferenceOptions.setVideoBitrateRange(307200, 819200);
            rTCConferenceOptions.setVideoEncodingFps(15);
            rTCConferenceOptions.setHWCodecEnabled(false);
            this.a.setConferenceOptions(rTCConferenceOptions);
            PlayingOnliveFragment playingOnliveFragment = this.c;
            RTCVideoWindow rTCVideoWindow = new RTCVideoWindow(playingOnliveFragment.mRemoteWindowA, playingOnliveFragment.mRemoteGLSurfaceViewA);
            PlayingOnliveFragment playingOnliveFragment2 = this.c;
            RTCVideoWindow rTCVideoWindow2 = new RTCVideoWindow(playingOnliveFragment2.mRemoteWindowB, playingOnliveFragment2.mRemoteGLSurfaceViewB);
            rTCVideoWindow.setRelativeMixOverlayRect(0.5f, 0.2f, 1.0f, 1.0f);
            rTCVideoWindow2.setRelativeMixOverlayRect(0.0f, 0.24f, 0.3f, 0.3f);
            this.a.addRemoteWindow(rTCVideoWindow2);
            this.a.addRemoteWindow(rTCVideoWindow);
            this.a.prepare(cameraStreamingSetting, microphoneStreamingSetting);
            this.a.setEncodingMirror(false);
        }
    }

    public final CameraStreamingSetting.CAMERA_FACING_ID a() {
        return CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT;
    }

    public final boolean a(String str, String str2) {
        if (this.a == null) {
            return false;
        }
        this.a.startConference(UserInfo.getInstance().getUserId(), str, str2, new RTCStartConferenceCallback() {
            /* class com.blued.international.ui.live.manager.PlayingRTCManager.AnonymousClass2 */

            public void onStartConferenceFailed(int i) {
                PlayingRTCManager.this.c.closeConnectionMode();
                PlayingRTCManager.this.stopCapture();
                PlayingRTCManager.this.c.dismissRTCWindow();
                "onStartConferenceFailed ＝ " + i;
                AppMethods.showToast(PlayingRTCManager.this.c.getString(R.string.connection_failed) + i);
            }

            public void onStartConferenceSuccess() {
                PlayingRTCManager playingRTCManager = PlayingRTCManager.this;
                if (playingRTCManager.mIsActivityPaused) {
                    playingRTCManager.stopConference();
                }
            }
        });
        return true;
    }
}

